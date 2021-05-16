package com.evergreen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Article implements Serializable {
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

    public void setImage(String image) {
        this.image = image;
    }

    @Id
    @GeneratedValue
    private Long idArticle;

    @Column(length = 500)
    private String texte;
    @Column(nullable = true,length = 100)
    private String image;

    public Article(String texte, String image){
        this.texte=texte;
        this.image = image;
    }

    public Article() {

    }
}
