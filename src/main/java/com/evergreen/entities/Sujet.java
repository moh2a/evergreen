package com.evergreen.entities;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Sujet extends Audit{
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy="sujet", cascade={CascadeType.ALL})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Message> messages;

    @Column(name="user_id")
    private Long idUser;

    @OneToOne()
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private User user;

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


    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
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
