package com.evergreen.web;

import com.evergreen.entities.GreenPoint;
import com.evergreen.entities.UserSession;
import com.evergreen.service.GreenPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.evergreen.entities.User;
import com.evergreen.service.UserService;
import util.FileUpload;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Optional;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private GreenPointService greenPointService;

	@Autowired
	private UserSession userSession;

	@GetMapping("/sign-up")
	public String signUp(@RequestParam(required = false) Optional<Integer> error, Model model) {
		if (userSession.isConnected()) {
			return "redirect:/index";
		}

		if (error.isPresent()) {
			String errorMessage = "Un utilisateur existe déjà pour l'adresse mail spécifiée.";
			model.addAttribute("errorMessage", errorMessage);
		}

		return "sign-up";
	}

	@GetMapping("/login")
	public String login(@RequestParam(required = false) boolean confirmation, @RequestParam(required = false) Optional<Integer> error, Model model) {
		if (userSession.isConnected()) {
			return "redirect:/index";
		}

		if (confirmation) {
			String confirmationMessage = "Votre inscription a bien été prise en compte ! Vous pouvez à présenter vous connecter.";
			model.addAttribute("confirmationMessage", confirmationMessage);
			model.addAttribute("confirmation", confirmation);
		}

		if (error.isPresent()) {
			String errorMessage = "";
			if (error.get() == 1) {
				errorMessage = "Aucun utilisateur n'a été trouvé pour l'adresse mail spécifiée.";
			}

			else if (error.get() == 2) {
				errorMessage = "Le mot de passe saisi est incorect.";
			}

			model.addAttribute("error", true);
			model.addAttribute("errorMessage", errorMessage);
		}



		return "login";
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

			User user = new User(lastName, firstName, email, password, birthdate, 0);
			userService.saveUser(user);

			return "redirect:/login?confirmation=true";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "email") String email,
						@RequestParam(name = "password") String password) {

		Optional<User> user = userService.getUserByEmail(email);

		if (user.isPresent()) {
			if (UserService.checkPassword(password, user.get().getPassword())) {
				userSession.setId(user.get().getId());
				userSession.setRole(user.get().getRole());
				return "redirect:/index";
			}

			else {
				return "redirect:/login?error=2";
			}
		}

		return "redirect:/login?error=1";
	}

	@GetMapping("/logout")
	public String logout() {
		userSession.setId(null);
		userSession.setRole(null);

		return "redirect:/login";
	}
	@GetMapping("/profil")
	public String profil(Model model) {
		if (!userSession.isConnected()) {
			return "redirect:/login";
		}
		Optional<User> user = userService.getUser(userSession.getId());
		model.addAttribute("greenPoints", greenPointService.findGreenPointsByIdNettoyeur(user.get().getId()));
		System.out.println("userrrrr"+ greenPointService.findGreenPointsByIdNettoyeur(user.get().getId()));
		model.addAttribute("firstName", user.get().getFirstName());
		model.addAttribute("lastName", user.get().getLastName());
		model.addAttribute("birthDate", user.get().getBirthdate());
		

		return "profil";
	}

}

