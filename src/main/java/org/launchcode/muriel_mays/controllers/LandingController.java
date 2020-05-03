package org.launchcode.muriel_mays.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LandingController {

    @GetMapping
    @ResponseBody
    public String welcome() {
        return "Welcome to Muriel Mays!";
    }
}
