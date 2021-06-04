package com.evergreen.entities;

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
@Table(name="event_user")

public class EventUser {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="event_id")
    private Long eventId;

    @Column(name="user_id")
    private Long userId;
    
    public EventUser(long eventId, long userId) {
    	this.eventId = eventId;
    	this.userId = userId;
    }
    
    public EventUser() {
    	
    }
    
}
