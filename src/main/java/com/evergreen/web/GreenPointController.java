package com.evergreen.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evergreen.dao.GreenPointRepository;
import com.evergreen.entities.GreenPoint;

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
}