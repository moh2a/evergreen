package com.evergreen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.evergreen.entities.User;
import com.evergreen.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public ModelAndView saveUser(User user) {
		userService.saveUser(user);
		return new ModelAndView("redirect:/");
	}
	
	
}
