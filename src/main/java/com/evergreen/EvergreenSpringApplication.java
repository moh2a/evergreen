package com.evergreen;

import java.sql.Date;

import com.evergreen.entities.*;
import com.evergreen.service.ArticleService;
import com.evergreen.service.EventService;
import com.evergreen.service.MessageService;
import com.evergreen.service.SujetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.evergreen.dao.GreenPointRepository;
import com.evergreen.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EvergreenSpringApplication {


	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(EvergreenSpringApplication.class, args);
		GreenPointRepository greenPointDao = ctx.getBean(GreenPointRepository.class);



		UserService userService = ctx.getBean(UserService.class);

		String dateStr="1999-11-05";
		Date date = Date.valueOf(dateStr);
		User user = new User("Baptiste", "Alexandre", "mail@mail.com", "mypassword", date, "Administrateur");
		User user2 = new User("Jean", "PASCAL", "jean.pascal@mail.com", "mypassword", date, "Utilisateur");
		userService.saveUser(user);
		userService.saveUser(user2);

		greenPointDao.save(new GreenPoint("J'ai découvert cet endroit en me promenant dans Paris. Vous savez comme il est rare de trouver un espace de verdure dans cette grande ville. J'ai tout de suite été frappé par la tristesse de ce lieu qui avait pourtant beaucoup de potentiel. Les détritus n'en finissaient pas et empechaient la nature de se développer. Aujourd'hui, j'en appelle à cette grande communauté pour tenter de rendre à ce paysage sa grandeur.", "actif", (float) 48.8811, (float) 2.3500,"greenPointAvant.jpg",null, 1L, 1L,20));
		greenPointDao.save(new GreenPoint("Plage très sale", "nettoyé", (float) 48.6651, (float) -1.9919,"plage_avant.jpg","plage_apres.jpg", 2L, 2L, 40));
		ArticleService articleService = ctx.getBean(ArticleService.class);
		SujetService sujetService = ctx.getBean(SujetService.class);
		MessageService messageService = ctx.getBean(MessageService.class);
		Sujet sujet = new Sujet(1L,"Le Jour du dépassement", "Cette année, le jour du dépassement mondial est le 22 août 2020, l'humanité aura dépensé l'ensemble des ressources que la Terre peut régénérer en un an. Nous vivrons quatre mois dans le rouge. A quand une relance verte ?");
		sujetService.save(sujet);
		Message message = new Message(2L, sujet, "C'est triste!");
		messageService.save(message);
		/*Message message = new Message(2L, sujet,"C'est triste!");
		Message message2 = new Message(1L, sujet,"Depuis les années 1970, la date du Jour du dépassement se dégrade.");
		messageService.save(message);
		messageService.save(message2);*/
		Article article = new Article("Le trashtag challenge","Un challenge en adéquation avec EverGreen", "testestestetstetstetstets","image.png");
		articleService.save(article);

		EventService eventService = ctx.getBean(EventService.class);
		
		String dateStr2 = "2022-05-18";
		Date dateEvent = Date.valueOf(dateStr2);
		Event event = new Event("Meeting de bénévolat 2022", "Rencontre entre bénévoles", "Paris", dateEvent);
		eventService.saveEvent(event);
		
		String dateStr3 = "2020-05-18";
		dateEvent = Date.valueOf(dateStr3);
		Event event2 = new Event("Meeting de bénévolat 2020", "Rencontre entre bénévoles", "Paris", dateEvent);
		eventService.saveEvent(event2);
		

	}
}