package com.evergreen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evergreen.dao.EventRepository;
import com.evergreen.dao.EventUserRepository;
import com.evergreen.entities.Event;
import com.evergreen.entities.EventUser;
import com.evergreen.entities.User;

import lombok.Data;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Data
@Service
public class EventService {
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
    
    

}
