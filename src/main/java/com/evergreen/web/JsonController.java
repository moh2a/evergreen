package com.evergreen.web;

import com.evergreen.entities.Message;
import com.evergreen.service.MessageService;
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

    @GetMapping("/last-messages")
    List<Message> all() {
        List<Message> messages = messageService.getMessagesPaginate(0, 3).getContent();
        return messages;
    }
}
