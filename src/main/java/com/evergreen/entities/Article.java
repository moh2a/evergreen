package com.evergreen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue
    private Long idArticle;
    @Column(length = 100)
    private String titre;
    @Column(length = 255)
    private String description;
    @Column(length = 500)
    private String texte;
    @Column(nullable = true,length = 100)
    private String image;

    public Article(String titre, String description,String texte, String image){
        this.texte=texte;
        this.titre = titre;
        this.description = description;
        this.image = image;
    }

    public Article() {

    }
    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getImage() {
        return image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
