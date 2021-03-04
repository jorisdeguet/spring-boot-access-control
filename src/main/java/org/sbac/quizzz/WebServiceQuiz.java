package org.sbac.quizzz;

import org.sbac.model.MUtilisateur;

import org.sbac.transfert.AjouterQuestionReq;
import org.sbac.transfert.CreerQuizReq;
import org.sbac.transfert.QuizDetail;
import org.sbac.transfert.QuizResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class WebServiceQuiz {

	@Autowired 		private ServiceQuiz service;

	@PostMapping("/api/creer")
	public @ResponseBody String creerQuiz(@RequestBody CreerQuizReq request) throws ServiceQuiz.Existing {
		System.out.println("Quiz : ajouter Quiz");
		service.creerQuiz(request, utilisateurActuel());
		return "";
	}

	@PostMapping("/api/ajouter")
	public @ResponseBody String ajouterQuestion(@RequestBody AjouterQuestionReq request) throws ServiceQuiz.Existing {
		System.out.println("Quiz : ajouter question dans Quiz");
		service.ajouterQuestion(request, utilisateurActuel());
		return "";
	}

	@GetMapping("/api/home")
	public @ResponseBody List<QuizResume> home() {
		System.out.println("WS SOCIAL : HOME REQUEST  with cookie" );
		MUtilisateur user = utilisateurActuel();
		return service.accueil(user.id);
	}

    @GetMapping("/api/detail/{id}")
    public @ResponseBody QuizDetail detail(@PathVariable long id) {
		System.out.println("WS SOCIAL : DETAIL  with cookie " );
		return service.detail(id, utilisateurActuel());
    }

	private MUtilisateur utilisateurActuel() {
		UserDetails ud = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MUtilisateur utilisateur = service.utilisateurParSonNom(ud.getUsername());
		return utilisateur;
	}

}
