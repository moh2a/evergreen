package com.evergreen.web;

import com.evergreen.entities.Message;
import com.evergreen.entities.Sujet;
import com.evergreen.entities.UserSession;
import com.evergreen.service.MessageService;
import com.evergreen.service.SujetService;
import com.evergreen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SujetController {
    @Autowired
    private SujetService sujetService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserSession userSession;

    @Autowired
    private UserService userService;
    @RequestMapping(value = "forum", method = RequestMethod.GET)
    public String forum(Model model) {
        if (!userSession.isConnected()) {
            return "redirect:/login";
        }
        model.addAttribute("sujets", sujetService.getSujets());
        model.addAttribute("userId", userSession.getId());
        return "forum";
    }

    @RequestMapping(value = "sujet", method = RequestMethod.GET)
    public String viewSujet(Model model, @RequestParam(name = "ref", defaultValue = "")
            Long idSujet, @RequestParam(name = "mc", defaultValue = "") String mc) {
        if (!userSession.isConnected()) {
            return "redirect:/login";
        }
        model.addAttribute("userRole", userSession.getRole());
        model.addAttribute("userId", userSession.getId());
        model.addAttribute("sujet", sujetService.getSujet(idSujet).get());
        //model.addAttribute("reponses", messageService.getMessagesByIdSujet(idSujet));
        System.out.println("model"+sujetService.getSujet(idSujet).get());
        return "sujet";
    }

    @PostMapping("sujet")
    public String saveSujet(@RequestParam(name = "titre") String titre,
                            @RequestParam(name = "idUser", defaultValue = "0") Long idUser,
                            @RequestParam(name = "sujet") String sujet, Model model) {
        sujetService.save(new Sujet(idUser, titre, sujet));
        model.addAttribute("sujets", sujetService.getSujets());
        return "redirect:/forum";
    }
    @GetMapping("sujet/delete")
    public String deleteSujet(@RequestParam(name = "ref", defaultValue = "") Long idSujet,
                                Model model) {
        Sujet sujet = sujetService.getSujet(idSujet).get();
        if(sujet.getUser().getId() == userSession.getId() || userSession.isAdministrator()){
            sujetService.delete(idSujet);
        }
        model.addAttribute("sujets", sujetService.getSujets());
        return "redirect:/forum" ;
    }
}
