package com.evergreen.web;

import com.evergreen.entities.Article;
import com.evergreen.entities.Sujet;
import com.evergreen.service.ArticleService;
import com.evergreen.service.MessageService;
import com.evergreen.service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import util.FileUpload;

import java.io.IOException;
@Controller
public class SujetController {
    @Autowired
    private SujetService sujetService;
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "sujet", method = RequestMethod.GET)
    public String viewSujet(Model model, @RequestParam(name = "ref", defaultValue = "")
            Long idSujet, @RequestParam(name = "mc", defaultValue = "") String mc) {
        model.addAttribute("sujet", sujetService.getSujet(idSujet).get());
        model.addAttribute("messages", messageService.getMessagesByIdSujet(idSujet));
        return "sujet";
    }
    @PostMapping("sujet")
        public String saveSujet(@RequestParam(name = "titre") String titre,
                              @RequestParam(name = "idUser") Long idUser,
                              @RequestParam(name = "sujet") String sujet, Model model) throws IOException {

        Sujet sujetO = new Sujet(idUser, titre, sujet);
        sujetO = sujetService.save(sujetO);

        return "redirect:/sujet?ref=" + sujetO.getIdSujet();
    }
}
