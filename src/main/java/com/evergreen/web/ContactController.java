package com.evergreen.web;

import com.evergreen.entities.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {
    @Autowired
    public JavaMailSender emailSender;

    @GetMapping("/contact")
    public String contact(@RequestParam(required = false) boolean confirmation, Model model) {
        if (confirmation) {
            String confirmationMessage = "Votre message a bien été envoyé. Il sera traité dans les plus bref délais.";
            model.addAttribute("confirmationMessage", confirmationMessage);
            model.addAttribute("confirmation", confirmation);
        }

        return "contact";
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam(name = "lastname") String lastName,
                            @RequestParam(name = "firstname") String firstName,
                            @RequestParam(name = "email") String email,
                            @RequestParam(name = "message") String content) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("contact.isepevergreen@gmail.com");
        message.setSubject("Message de : " + firstName + " " + lastName + " - " + email);
        message.setText("De : " + email + "\n\n" + content + "\n\n" + firstName + " " + lastName);

        this.emailSender.send(message);

        return "redirect:/contact?confirmation=true";
    }
}
