package com.evergreen.web;

import com.evergreen.entities.GreenPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.evergreen.entities.User;
import com.evergreen.service.UserService;
import util.FileUpload;

import java.io.IOException;
import java.sql.Date;
import java.util.Optional;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/sign-up")
	public String signUp() {
		return "sign-up";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/contact-us")
	public String contactUs() {
		return "contact";
	}
	
	@PostMapping("/add-user")
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

			return "redirect:/login?confirmation=true";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "email") String email,
						@RequestParam(name = "password") String password) {

		Optional<User> user = userService.getUserByEmail(email);

		if (user.isPresent()) {
			if (UserService.checkPassword(password, user.get().getPassword())) {
				return "redirect:/index";
			}

			else {
				return "redirect:/login?error=2";
			}
		}

		return "redirect:/login?error=1";
	}
}
