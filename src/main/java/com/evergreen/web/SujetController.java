package com.evergreen.web;

import com.evergreen.entities.Sujet;
import com.evergreen.service.MessageService;
import com.evergreen.service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SujetController {
    @Autowired
    private SujetService sujetService;
    @Autowired
    private MessageService messageService;
    @RequestMapping(value = "forum", method = RequestMethod.GET)
    public String forum(Model model) {
        model.addAttribute("sujets", sujetService.getSujets());
        return "forum";
    }
    @RequestMapping(value = "sujet", method = RequestMethod.GET)
    public String viewSujet(Model model, @RequestParam(name = "ref", defaultValue = "")
            Long idSujet, @RequestParam(name = "mc", defaultValue = "") String mc) {
        model.addAttribute("sujet", sujetService.getSujet(idSujet).get());
        model.addAttribute("messages", messageService.getMessagesByIdSujet(idSujet));
        return "sujet";
    }
    @PostMapping("sujet")
        public String saveSujet(@RequestParam(name = "titre") String titre,
                              @RequestParam(name = "idUser",defaultValue = "0") Long idUser,
                              @RequestParam(name = "sujet") String sujet, Model model)  {
        sujetService.save(new Sujet(idUser, titre, sujet));
        model.addAttribute("sujets", sujetService.getSujets());
        return "forum";
    }
}
