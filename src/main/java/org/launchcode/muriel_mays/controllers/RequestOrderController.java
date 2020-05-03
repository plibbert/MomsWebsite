package org.launchcode.muriel_mays.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("order")
public class RequestOrderController {
//
//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public String orderFormQueries(@RequestParam String name) {
//        return "you are " + name;
//    }


    @GetMapping("form")
    public String orderForm() {
        return "form";
    }

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "orderSubmit")
    public String orderFormResponse(@RequestParam String name, Model model) {
        String thanks= "Thank you for your interest " + name + ". Your request has been submitted and we will contact you soon!";
        model.addAttribute("thanks", thanks);
        return "orderformsent";
    }

}
