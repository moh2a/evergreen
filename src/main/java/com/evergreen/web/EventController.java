package com.evergreen.web;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evergreen.entities.Event;
import com.evergreen.entities.UserSession;
import com.evergreen.service.EventService;

@Controller
public class EventController {

	@Autowired
	private UserSession userSession;
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/events")
	public String events(@RequestParam(required = false) Optional<Integer> confirmation, @RequestParam(required = false) boolean errorId, Model model) {
		if(!userSession.isConnected()) {
			return "redirect:/login";
		}
		Iterable<Event> eventsAfter = eventService.getEventsAfter(); 
		model.addAttribute("eventsAfter", eventsAfter );
		
		Iterable<Event> eventsBefore = eventService.getEventsBefore(); 
		model.addAttribute("eventsBefore", eventsBefore );
		
		ArrayList<Long> eventsId = eventService.getParticipatedEvents(userSession.getId());
		model.addAttribute("eventsId", eventsId);
		
		if (confirmation.isPresent()) {
            String confirmationMessage = "";
            if (confirmation.get() == 1) {
				confirmationMessage = "L'évènement a bien été ajouté.";
			}

			else if (confirmation.get() == 2) {
				confirmationMessage = "Vous participation a bien été prise en compte.";
			}
            
            model.addAttribute("confirmationMessage", confirmationMessage);
            model.addAttribute("confirmation", true);
        }
		
		if (errorId) {
            String errorMessage = "Il y a eu une erreur dans votre inscription, réessayez ultérieurement";
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("errorId", errorId);
        }
		
		model.addAttribute("isAdministrator", userSession.isAdministrator());
		return "events";
	}
	
	@PostMapping("/saveEvent")
	public String saveEvent(@RequestParam(name = "nom") String nom,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "date") String dateStr,
            @RequestParam(name = "localisation") String localisation) {
		Date date = Date.valueOf(dateStr);
		Event event = new Event(nom, description, localisation, date);
		eventService.saveEvent(event);
		return "redirect:/events?confirmation=1";
	}
	
	@GetMapping("/create-event")
	public String createEvent(Model model) {
		if(!userSession.isConnected()) {
			return "redirect:/login";
		}
		if(userSession.isAdministrator()) {
			return "createEvent";
		}
		return "redirect:/events";	
    }
	
	@GetMapping("/participate")
	public String participate(@RequestParam(required = false) Optional<Long> eventId) {
		if(!userSession.isConnected()) {
			return "redirect:/login";
		}
		
		if(eventId.isEmpty()) {
			return "redirect:/events?errorId=true";
		}
		
		eventService.saveParticipation(eventId.get(),userSession.getId());
		return "redirect:/events?confirmation=2";
	}
	
	
}