package com.evergreen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.evergreen.dao.EventUserRepository;
import com.evergreen.entities.EventUser;

public class EventUserService {

	@Autowired
    private EventUserRepository eventUserRepository;
	
	
	public EventUser submitButton(long eventId, long userId) {
	    EventUser eventUser = new EventUser(eventId, userId);
	    eventUserRepository.save(eventUser);
        return eventUser;
	
	    }
}
