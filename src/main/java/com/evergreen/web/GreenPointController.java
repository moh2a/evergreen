package com.evergreen.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
	private GreenPointRepository greenPointDao;
	@RequestMapping(value = "/teams/search")
	public String search() {
	return "myteams";
	}
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
		List<GreenPoint> greenPoints = greenPointDao.findAll();
		model.addAttribute("greenPoints", greenPoints);
        return "index";
    }
	@RequestMapping(value = "/add-greenpoint", method = RequestMethod.GET)
	public String newGreenPoint() {
		System.out.println("ici");
	    return "newGreenPoint";
	}
	@RequestMapping(value = "green-point")
	public String viewGreenPoint(Model model, @RequestParam(name = "ref", defaultValue = "")
	Long idGreenPoint,@RequestParam(name = "mc", defaultValue = "") String mc) {
	Optional<GreenPoint> ogp = greenPointDao.findById(idGreenPoint);
	GreenPoint gp = ogp.get();
	model.addAttribute("greenPoint", gp);
	return "green-point";
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
				model.addAttribute("photo_avant",fileName);
				model.addAttribute("latitude",latitude);
				model.addAttribute("longitude",longitude);
				model.addAttribute("description",description);
				GreenPoint greenPoint = new GreenPoint(description,latitude, longitude, fileName, null);
				greenPointDao.save(greenPoint);
				if(multipartFile!=null) {
					String uploadDir = "photos_avant/" + greenPoint.getIdGreenPoint();
			        FileUpload.saveFile(uploadDir, fileName, multipartFile);
				}
				return "greenPoint/"+greenPoint.getIdGreenPoint();
				
			}
	
}