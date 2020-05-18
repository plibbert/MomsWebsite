package org.launchcode.muriel_mays.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("order")
public class RequestOrderController {

    @GetMapping
    public String renderOrderForm(){
        return "orders/form";
    }

    @PostMapping
    public String submitOrder(@RequestParam String name, Model model){
    model.addAttribute("formStatus","Your request has been sent. We will get in touch with you shortly!");
        return "orders/form";
    }


}
