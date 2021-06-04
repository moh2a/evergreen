package com.evergreen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.evergreen.dao.EventRepository;
import com.evergreen.dao.EventUserRepository;
import com.evergreen.entities.Event;
import com.evergreen.entities.EventUser;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

@Data
@Service
public class EventService {
	@Autowired
    private EventUserRepository eventUserRepository;
	
	@Autowired
    private EventRepository eventRepository;
	public Optional<Event> getEvent(final Long id) {
        return eventRepository.findById(id);
    }

    public Iterable<Event> getEvents() {
        return eventRepository.findAll();
    }

    public void deleteEvent(final Long id) {
        eventRepository.deleteById(id);
        eventUserRepository.deleteAllByEventId(id);
    }
    
    public Event saveEvent(Event event) {
        Event savedEvent = eventRepository.save(event);
        return savedEvent;
    }
    
    public Iterable<Event> getEventsAfter(){
    	java.util.Date currentDate = new java.util.Date();
    	Date currentSqlDate = new Date(currentDate.getTime());
    	Iterable<Event> eventsAfter = eventRepository.findEventByDateAfter(currentSqlDate);
    	return eventsAfter;
    }
    
    public Iterable<Event> getEventsBefore(){
    	java.util.Date currentDate = new java.util.Date();
    	Date currentSqlDate = new Date(currentDate.getTime());
    	Iterable<Event> eventsBefore = eventRepository.findEventByDateBefore(currentSqlDate);
    	return eventsBefore;
    }
    public Date getDate() {
    	java.util.Date currentDate = new java.util.Date();
    	Date currentSqlDate = new Date(currentDate.getTime());
    	return currentSqlDate;
    }
    
    public EventUser saveParticipation(long eventId, long userId) {
	    EventUser eventUser = new EventUser(eventId, userId);
	    eventUserRepository.save(eventUser);
        return eventUser;
	
	}
    
    public boolean deleteParticipation(long eventId, long userId) {
    	Optional<EventUser> eventUser = eventUserRepository.findEventUserByEventIdAndUserId(eventId, userId);
    	if(eventUser.isPresent()) {

        	eventUserRepository.delete(eventUser.get());
        	return true;
    	}
    	
    	return false;    	
    }
    
    public Page<Event> getEventsPaginate(Integer start, Integer end) {
        Pageable firstPageWithTwoElements = PageRequest.of(start, end, Sort.by("date").descending());
        return eventRepository.findAll(firstPageWithTwoElements);
    }
   
    public ArrayList<Long> getParticipatedEvents(long userId) {
    	Iterable<EventUser> eventUsers = eventUserRepository.findEventUsersByUserId(userId);
    	ArrayList<Long> eventsId = new ArrayList<>();
    	for (EventUser eventUser:eventUsers) {
    		eventsId.add(eventUser.getEventId());
    	}
    	return eventsId;
    }
}
