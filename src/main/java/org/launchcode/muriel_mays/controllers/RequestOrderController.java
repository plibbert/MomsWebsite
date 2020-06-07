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
    public String emailSender(@RequestParam String name, @RequestParam String emailAddress, @RequestParam String phoneNumber,
                              @RequestParam String dateNeeded, @RequestParam String requestType, @RequestParam String description,
                              @RequestParam String contact){
        String subjectText = "Order Request" + requestType + dateNeeded;
        String bodyText = "Name: " + name + "%0A" + "Email: " + emailAddress + "%0A" + "Phone Number: " + phoneNumber + "%0A" + "Date Needed: " + dateNeeded + "%0A" + "Request Type: " + requestType + "%0A" + "Description: " + description + "%0A" + "Preferred Contact Method: " + contact;
        String mailtoText = "mailto:murielmayssweets@gmail.com?subject=" + subjectText + "&body=" + bodyText;
        return "redirect:" + mailtoText;
    }

//    @PostMapping
//    public String submitOrder(@RequestParam String name, Model model){
//    model.addAttribute("formStatus","Your request has been sent. We will get in touch with you shortly!");
//        return "orders/form";
//    }

}
