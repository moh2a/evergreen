package com.evergreen.web;

import com.evergreen.entities.Message;
import com.evergreen.entities.Sujet;
import com.evergreen.service.MessageService;
import com.evergreen.service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SujetService sujetService;

    @PostMapping("message")
    public String saveMessage(@RequestParam(name = "ref", defaultValue = "") Long idSujet,
                            @RequestParam(name = "message") String message,
                            @RequestParam(name = "idUser",defaultValue = "0") Long idUser,
                              Model model)  {
        Sujet sujet = sujetService.getSujet(idSujet).get();
        messageService.save(new Message(idUser, sujet, message));
        model.addAttribute("sujet", sujet);
        return "redirect:/sujet?ref="+sujet.getIdSujet();
    }
}
