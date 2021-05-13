package com.evergreen.web;

import com.evergreen.entities.GreenPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.evergreen.entities.User;
import com.evergreen.service.UserService;
import util.FileUpload;

import java.io.IOException;
import java.sql.Date;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestParam(name = "lastname") String lastName,
								 @RequestParam(name = "firstname") String firstName,
								 @RequestParam(name = "email") String email,
								 @RequestParam(name = "password") String password,
								 @RequestParam(name = "birthdate") String birthdateStr) {

			Date birthdate = Date.valueOf(birthdateStr);
			if (userService.isUserExisting(email)) {
				return "redirect:/sign-up?error=1";
			}

			User user = new User(lastName, firstName, email, password, birthdate);
			userService.saveUser(user);

			return "redirect:/sign-up-confirmation";
	}
	
	
}
