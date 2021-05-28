package com.evergreen.entities;

import com.evergreen.entities.Audit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
@Entity
public class Message extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //means autoincrement.
    private Long idMessage;

    @Column(name="user_id")
    private Long idUser;

    @OneToOne()
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private User user;

    @ManyToOne()
    @JoinColumn(name="sujet_id" ,nullable = false)
    private Sujet sujet;

    @Column(length = 255)
    private String message;

    /*@Column(name="sujet_id")
    private Long idSujet;*/

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sujet_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Sujet sujet;*/
    public Message(Long idUser,Sujet sujet,String message){
        this.idUser = idUser;
        this.sujet = sujet;
        this.message = message;
    }
    public Message(){}

    public User getUser() {
        return user;
    }

    public Sujet getSujet() {
        return sujet;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
