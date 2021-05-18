package com.evergreen.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Message extends Audit{
    @Id
    @GeneratedValue
    private Long idMessage;
    private Long idUser;
    @Column(length = 255)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sujet_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Sujet sujet;
    public Message(Long idUser, Sujet sujet,String message){
        this.idUser = idUser;
        this.sujet = sujet;
        this.message = message;
    }
    public Message(){}

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

}