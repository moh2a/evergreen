package com.evergreen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping("/contact-us")
    public String contactUs() {
        return "contact";
    }
}
