package com.evergreen.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Getter
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String email;

    private String password;
    
    private Date birthdate;
    
    private String role;

    private int score;

    public User() { };
    
    public User(String firstName, String lastName, String email, String password, Date birthdate, Integer score) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.password = password;
    	this.birthdate = birthdate;
    	this.score = score;
    }
    
    public User(String firstName, String lastName, String email, String password, Date birthdate, String role, Integer score) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.password = password;
    	this.birthdate = birthdate;
    	this.role= role;
        this.score = score;
    }

}
