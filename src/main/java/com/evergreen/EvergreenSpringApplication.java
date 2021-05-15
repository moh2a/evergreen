package com.evergreen;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.evergreen.dao.GreenPointRepository;
import com.evergreen.entities.GreenPoint;
import com.evergreen.entities.User;
import com.evergreen.service.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EvergreenSpringApplication {


	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(EvergreenSpringApplication.class, args);
		GreenPointRepository greenPointDao = ctx.getBean(GreenPointRepository.class);
		greenPointDao.save(new GreenPoint("J'ai découvert cet endroit en me promenant dans Paris. Vous savez comme il est rare de trouver un espace de verdure dans cette grande ville. J'ai tout de suite été frappé par la tristesse de ce lieu qui avait pourtant beaucoup de potentiel. Les détritus n'en finissaient pas et empechaient la nature de se développer. Aujourd'hui, j'en appelle à cette grande communauté pour tenter de rendre à ce paysage sa grandeur.", "actif",new Float(48.8811), new  Float(2.3500),"greenPointAvant.jpg",null));
		greenPointDao.findAll().forEach(t->System.out.println(t.getDescription()));

		UserService userService = ctx.getBean(UserService.class);

		String dateStr="1999-11-05";
		Date date = Date.valueOf(dateStr);
		User user = new User("Baptiste", "Alexandre", "mail@mail.com", "mypassword", date);
		userService.saveUser(user);

		System.out.println(userService.isUserExisting("mail@mail.com"));
	}
}