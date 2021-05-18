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
@Table(name="events")

public class Event {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="event_name")
    private String eventName;

    @Column(name="description")
    private String description;

    private Date date;
    
    private String localisation;
    
    public Event() {};
    
    public Event(String eventName, String description, String localisation, Date date) {
    	this.eventName = eventName;
    	this.description = description;
    	this.localisation = localisation;
    	this.date = date;
    }

}
