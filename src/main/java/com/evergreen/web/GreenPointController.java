package com.evergreen.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


import com.evergreen.service.GreenPointService;
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
	private GreenPointRepository greenPointDao;
	@GetMapping({ "/", "/index" })
	public String index(Model model) {
		List<GreenPoint> greenPoints = greenPointService.getGreenPoints();
		model.addAttribute("greenPoints", greenPoints);
		return "index";
	}

	@GetMapping("/add-greenpoint")
	public String newGreenPoint() {
		return "newGreenPoint";
	}


	@RequestMapping(value = "green-point", method = RequestMethod.GET)
	public String viewGreenPoint(Model model, @RequestParam(name = "ref", defaultValue = "")
	Long idGreenPoint,@RequestParam(name = "mc", defaultValue = "") String mc) {
	model.addAttribute("greenPoint", greenPointService.getGreenPoint(idGreenPoint).get());
	return "green-point";
	}
	@RequestMapping(value = "green-point", method = RequestMethod.DELETE)
	public String deleteGreenPoint(Model model, @RequestParam(name = "ref", defaultValue = "")
	Long idGreenPoint,@RequestParam(name = "mc", defaultValue = "") String mc) {
		greenPointService.deleteGreenPoint((idGreenPoint));
	return "index";
	}
	@RequestMapping(value = "/add-greenpoint", method = RequestMethod.POST)
	public String add(Model model, 
			@RequestParam(name = "latitude", defaultValue = "0.0") Float latitude,
			@RequestParam(name = "longitude", defaultValue = "0") Float longitude,
			@RequestParam(name = "description", defaultValue = "") String description,
			@RequestParam("photo_avant") MultipartFile multipartFile) throws IOException 
			{
				String fileName = null;
				if(multipartFile!=null) {
					fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				}
				GreenPoint greenPoint = new GreenPoint(description,"actif",latitude, longitude, fileName, null, null);
				greenPointService.saveGreenPoint(greenPoint);
				if(multipartFile!=null) {
					String uploadDir = "images/photos_avant/" + greenPoint.getIdGreenPoint();
			        FileUpload.saveFile(uploadDir, fileName, multipartFile);
				}
				return "redirect:/green-point?ref=" + greenPoint.getIdGreenPoint();
				
			}
	@RequestMapping(value = "/green-point", method = RequestMethod.PUT)
	public String edit(Model model, 
			@RequestParam(name = "latitude", defaultValue = "0.0") Float latitude,
			@RequestParam(name = "longitude", defaultValue = "0") Float longitude,
			@RequestParam(name = "idTeam", defaultValue = "0") Long idTeam,
			@RequestParam(name = "description", defaultValue = "") String description,
			@RequestParam(name = "statut", defaultValue = "En cours") String statut,
			@RequestParam(name = "idUser") Long idUser,
			@RequestParam("photo_apres") MultipartFile multipartFile) throws IOException 
			{
				String fileName = null;
				if(multipartFile!=null) {
					fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				}
				Optional<GreenPoint> ogp = greenPointDao.findById(idTeam);
				GreenPoint greenPoint = ogp.get();
				greenPoint.setDescription(description);
				greenPoint.setLatitude(latitude);
				greenPoint.setLongitude(longitude);
				greenPoint.setIdUser(idUser);
				greenPoint.setStatut(statut);
				greenPoint.setPhoto_apres(fileName);
				if(multipartFile!=null) {
					String uploadDir = "src/main/resources/static/images/photos_apres/" + greenPoint.getIdGreenPoint();
			        FileUpload.saveFile(uploadDir, fileName, multipartFile);
				}
				return "redirect:/green-point?ref=" + greenPoint.getIdGreenPoint();
				
			}
	
}