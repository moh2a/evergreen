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

    @RequestMapping(value = "green-point/delete", method = RequestMethod.GET)
    public String deleteGreenPoint(Model model, @RequestParam(name = "ref", defaultValue = "")
            Long idGreenPoint) {
        String uploadDir = "images/photos_avant/" + idGreenPoint;
        FileUpload.deleteFile(uploadDir);
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
        GreenPoint greenPoint = new GreenPoint(description, "actif", latitude, longitude, fileName, null, null,idPosteur, points);
        greenPointService.saveGreenPoint(greenPoint);
        if (multipartFile != null) {
            String uploadDir = "images/photos_avant/" + greenPoint.getIdGreenPoint();
            FileUpload.saveFile(uploadDir, fileName, multipartFile);
        }
        return "redirect:/green-point?ref=" + greenPoint.getIdGreenPoint();

    }

    @RequestMapping(value = "/green-point", method = RequestMethod.PUT)
    public String edit(Model model,
                       @RequestParam(name = "latitude", defaultValue = "0.0") Float latitude,
                       @RequestParam(name = "longitude", defaultValue = "0") Float longitude,
                       @RequestParam(name = "idGreenPoint", defaultValue = "0") Long idGreenPoint,
                       @RequestParam(name = "description", defaultValue = "") String description,
                       @RequestParam(name = "statut", defaultValue = "En cours") String statut,
                       @RequestParam(name = "idPosteur") Long idPosteur,
                       @RequestParam(name = "idNettoyeur") Long idNettoyeur,
                       @RequestParam(name = "points") Integer points,
                       @RequestParam("photo_apres") MultipartFile multipartFile) throws IOException {
        String fileName = null;
        if (multipartFile != null) {
            fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        }
        GreenPoint greenPoint = greenPointService.getGreenPoint(idGreenPoint).get();
        greenPoint.setDescription(description);
        greenPoint.setLatitude(latitude);
        greenPoint.setLongitude(longitude);
        greenPoint.setIdNettoyeur(idNettoyeur);
        greenPoint.setIdPosteur(idPosteur);
        greenPoint.setStatut(statut);
        greenPoint.setPhoto_apres(fileName);
        greenPoint.setPoints(points);
        if (multipartFile != null) {
            String uploadDir = "src/main/resources/static/images/photos_apres/" + greenPoint.getIdGreenPoint();
            FileUpload.saveFile(uploadDir, fileName, multipartFile);
        }
        return "redirect:/green-point?ref=" + greenPoint.getIdGreenPoint();

    }
    @RequestMapping(value = "/validation", method = RequestMethod.POST)
    public String validation(Model model,
                       @RequestParam(name = "idNettoyeur") Long idNettoyeur,
                             @RequestParam(name = "idGreenPoint") Long idGreenPoint,
                       @RequestParam("photo_apres") MultipartFile multipartFile) throws IOException {
        String fileName = null;
        String statut = "nettoyé";
        if (multipartFile != null) {
            fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        }
        GreenPoint greenPoint = greenPointService.getGreenPoint(idGreenPoint).get();
        User user = userService.getUser(idNettoyeur).get();
        greenPoint.setIdNettoyeur(idNettoyeur);
        greenPoint.setStatut(statut);
        greenPoint.setPhoto_apres(fileName);
        if (multipartFile != null) {
            String uploadDir = "src/main/resources/static/images/photos_apres/" + greenPoint.getIdGreenPoint();
            FileUpload.saveFile(uploadDir, fileName, multipartFile);
        }
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