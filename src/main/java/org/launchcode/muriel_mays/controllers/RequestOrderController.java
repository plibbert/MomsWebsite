package org.launchcode.muriel_mays.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("order")
public class RequestOrderController {


    private static List<String> newOrders = new ArrayList<>();


    @GetMapping
    public String renderOrderForm(){
        return "orders/form";
    }

    @PostMapping
    public String submitOrder(@RequestParam String name){
        newOrders.add(name);
        return "redirect:/order/create";
    }

    @GetMapping("create")
    public String displayOrder(Model model){
        model.addAttribute("order", newOrders);
        return "orders/orderformsent";
    }

}
