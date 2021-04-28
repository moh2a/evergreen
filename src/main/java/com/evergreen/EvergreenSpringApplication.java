package com.evergreen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.evergreen.dao.GreenPointRepository;
import com.evergreen.entities.GreenPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class EvergreenSpringApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(EvergreenSpringApplication.class, args);
		GreenPointRepository greenPointDao = ctx.getBean(GreenPointRepository.class);
		greenPointDao.save(new GreenPoint("premier green point", new Float(48.8811), new  Float(2.3500)));
		greenPointDao.findAll().forEach(t->System.out.println(t.getDescription()));
				
	}

}
