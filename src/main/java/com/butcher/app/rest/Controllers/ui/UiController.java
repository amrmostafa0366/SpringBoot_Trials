package com.butcher.app.rest.Controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {

    @GetMapping(value = {"/home"})
    public String home(){
        return "index.html";
    }

    @GetMapping("/")
    public String redirect() {
        return "redirect:/home";
    }

}
