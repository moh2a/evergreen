package com.evergreen.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Sujet extends Audit{
    @Id
    @GeneratedValue
    private Long id;
    private Long idUser;
    @Column(length = 500)
    private String sujet;
    @Column(length = 100)
    private String titre;
    public Sujet(Long idUser, String titre, String sujet){
        this.idUser = idUser;
        this.sujet = sujet;
        this.titre = titre;
    }
    public Sujet(){}

    public Long getIdSujet() {
        return id;
    }

    public void setIdSujet(Long idSujet) {
        this.id = idSujet;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }


}
