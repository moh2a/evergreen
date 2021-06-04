package com.evergreen.web;

import com.evergreen.entities.Event;
import com.evergreen.entities.Message;
import com.evergreen.entities.User;
import com.evergreen.service.EventService;
import com.evergreen.service.MessageService;
import com.evergreen.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Data
@RestController
public class JsonController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;

    @GetMapping("/last-messages")
    List<Message> lastMessages() {
        List<Message> messages = messageService.getMessagesPaginate(0, 3).getContent();
        return messages;
    }
    @GetMapping("/best-users")
    List<User> bestUsers() {
        List<User> users = userService.getUsersPaginate(0,3).getContent();
        return users;
    }
    
    @GetMapping("/events-a-venir")
    List<Event> eventAfter(){
    	List<Event> events = eventService.getEventsPaginate(0,3).getContent();
    	return events;
    }
}
