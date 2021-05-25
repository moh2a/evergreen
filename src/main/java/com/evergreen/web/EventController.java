package com.evergreen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.evergreen.entities.Event;
import com.evergreen.service.EventService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/events")
	public String events(Model model) {
		Iterable<Event> eventsAfter = eventService.getEventsAfter(); 
		model.addAttribute("eventsAfter", eventsAfter );
		Iterable<Event> eventsBefore = eventService.getEventsBefore(); 
		model.addAttribute("eventsBefore", eventsBefore );
		return "events";
	}
	
	@PostMapping("/saveEvent")
	public String saveEvent(Event event) {
		eventService.saveEvent(event);
		return "event";
	}
	
	@GetMapping("/ajout-event")
    public String addEvent() {
        return "addevent";
    }

}