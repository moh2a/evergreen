package com.evergreen.web;

import java.io.IOException;
import java.util.List;

import com.evergreen.Statut;
import com.evergreen.entities.Message;
import com.evergreen.entities.User;
import com.evergreen.entities.UserSession;
import com.evergreen.service.GreenPointService;
import com.evergreen.service.MessageService;
import com.evergreen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.evergreen.dao.GreenPointRepository;
import com.evergreen.entities.GreenPoint;

import util.FileUpload;

@Controller
public class GreenPointController {
    @Autowired
    private GreenPointService greenPointService;
    @Autowired
    private MessageService messageService;

    @Autowired
    private GreenPointRepository greenPointDao;

    @Autowired
    private UserSession userSession;

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        if (!userSession.isConnected()) {
            return "redirect:/login";
        }
        List<GreenPoint> greenPoints = greenPointService.getGreenPoints();
        model.addAttribute("greenPoints", greenPoints);
        return "index";
    }

    @GetMapping("/add-greenpoint")
    public String newGreenPoint(Model model) {
        if (!userSession.isConnected()) {
            return "redirect:/login";
        }
        model.addAttribute("userRole", userSession.getRole());
        model.addAttribute("userId", userSession.getId());
        return "newGreenPoint";
    }


    @RequestMapping(value = "green-point", method = RequestMethod.GET)
    public String viewGreenPoint(Model model, @RequestParam(name = "ref", defaultValue = "")
            Long idGreenPoint) {
        if (!userSession.isConnected()) {
            return "redirect:/login";
        }
        GreenPoint gp = greenPointService.getGreenPoint(idGreenPoint).get();
        model.addAttribute("userRole", userSession.getRole());
        model.addAttribute("userId", userSession.getId());
        model.addAttribute("utilisateur", userService.getUser(gp.getIdPosteur()).get());
        System.out.println(model);
        model.addAttribute("greenPoint", gp);
        return "green-point";
    }
    @RequestMapping(value = "participer", method = RequestMethod.GET)
    public String participer(Model model, @RequestParam(name = "gp", defaultValue = "")
            Long idGreenPoint,@RequestParam(name = "user", defaultValue = "")
            Long idUser
                             ) {
        if (!userSession.isConnected()) {
            return "redirect:/login";
        }
        GreenPoint gp = greenPointService.getGreenPoint(idGreenPoint).get();
        gp.setIdNettoyeur(idUser);
        gp.setStatut(Statut.Réservé.name());
        greenPointService.saveGreenPoint(gp);
        return "redirect:green-point?ref="+gp.getIdGreenPoint();
    }
    @RequestMapping(value = "annuler", method = RequestMethod.GET)
    public String participer(Model model, @RequestParam(name = "gp", defaultValue = "")
            Long idGreenPoint
    ) {
        if (!userSession.isConnected()) {
            return "redirect:/login";
        }
        GreenPoint gp = greenPointService.getGreenPoint(idGreenPoint).get();
        gp.setIdNettoyeur(null);
        gp.setStatut(Statut.Actif.name());
        greenPointService.saveGreenPoint(gp);
        return "redirect:green-point?ref="+gp.getIdGreenPoint();
    }

    @RequestMapping(value = "green-point/delete", method = RequestMethod.GET)
    public String deleteGreenPoint(Model model, @RequestParam(name = "ref", defaultValue = "")
            Long idGreenPoint) {
        String uploadDir = "images/photos_avant/" + idGreenPoint;
        String uploadDir2 = "images/photos_apres/" + idGreenPoint;
        FileUpload.deleteFile(uploadDir);
        FileUpload.deleteFile(uploadDir2);
        greenPointService.deleteGreenPoint((idGreenPoint));
        List<GreenPoint> greenPoints = greenPointService.getGreenPoints();
        model.addAttribute("greenPoints", greenPoints);
        return "redirect:/index";
    }


    @RequestMapping(value = "/add-greenpoint", method = RequestMethod.POST)
    public String add(Model model,
                      @RequestParam(name = "latitude", defaultValue = "0.0") Float latitude,
                      @RequestParam(name = "longitude", defaultValue = "0") Float longitude,
                      @RequestParam(name = "description", defaultValue = "") String description,
                      @RequestParam(name = "idPosteur") Long idPosteur,
                      @RequestParam(name = "points") Integer points,
                      @RequestParam("photo_avant") MultipartFile multipartFile) throws IOException {
        String fileName = null;
        if (multipartFile != null) {
            fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        }
        GreenPoint greenPoint = new GreenPoint(description, Statut.Actif.name(), latitude, longitude, fileName, null, null,idPosteur, points);
        greenPointService.saveGreenPoint(greenPoint);
        if (multipartFile != null) {
            String uploadDir = "images/photos_avant/" + greenPoint.getIdGreenPoint();
            FileUpload.saveFile(uploadDir, fileName, multipartFile);
        }
        return "redirect:/green-point?ref=" + greenPoint.getIdGreenPoint();

    }

    @RequestMapping(value = "/validation", method = RequestMethod.POST)
    public String validation(Model model,
                             @RequestParam(name = "idGreenPoint") Long idGreenPoint,
                       @RequestParam("photo_apres") MultipartFile multipartFile) throws IOException {
        String fileName = null;
        if (multipartFile != null) {
            fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        }
        GreenPoint greenPoint = greenPointService.getGreenPoint(idGreenPoint).get();
        User user = userService.getUser(greenPoint.getIdNettoyeur()).get();
        user.setScore(user.getScore()+greenPoint.getPoints());
        greenPoint.setPhoto_apres(fileName);
        greenPoint.setStatut(Statut.Nettoyé.name());
        System.out.println("laa"+ greenPoint);
        if (multipartFile != null) {
            String uploadDir = "images/photos_apres/" + greenPoint.getIdGreenPoint();
            FileUpload.saveFile(uploadDir, fileName, multipartFile);
        }
        greenPointService.saveGreenPoint(greenPoint);
        return "redirect:/green-point?ref=" + greenPoint.getIdGreenPoint();

    }
    @RequestMapping(value = "/statut", method = RequestMethod.PUT)
    public String validation(Model model,
                             @RequestParam(name = "statut") String statut,
                             @RequestParam(name = "idGreenPoint") Long idGreenPoint,
                             @RequestParam(name = "idNettoyeur") Long idNettoyeur) {
        GreenPoint greenPoint = greenPointService.getGreenPoint(idGreenPoint).get();
        if(statut == Statut.Réservé.name()){
            greenPoint.setIdNettoyeur(idNettoyeur);
        };
        greenPoint.setStatut(statut);
        return "redirect:/green-point?ref=" + greenPoint.getIdGreenPoint();

    }

}