package org.sbac.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MUtilisateur {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id     public Long id;
    @Basic  public String nomUtilisateur;
    @Basic  public String motDePasse;

    // ORM style storage.
    @OneToMany(fetch=FetchType.EAGER)
    public List<MQuiz> quizs = new ArrayList<>();

}