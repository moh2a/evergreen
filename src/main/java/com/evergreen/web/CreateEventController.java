package com.evergreen.web;

import org.springframework.web.bind.annotation.GetMapping;

public class CreateEventController {
	@GetMapping("/create-event")
    public String creatEvent() {
        return "create_event";
    }
}
