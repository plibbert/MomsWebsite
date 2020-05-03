package org.launchcode.muriel_mays.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("order")
public class RequestOrderController {

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    public String orderFormQueries(@RequestParam String name) {
        return "you are " + name;
    }


    @GetMapping("form")
    public String orderForm() {
        String html =
                "<html>" +
                        "<body>" +
                                "<form method = 'post' action ='/order'>" +
                                        "<input type = 'text' name = 'name' />" +
                                        "<input type = 'Submit' value = 'Deets plix'/>" +
                                "</form>" +
                        "</body>" +
                "</html>";
        return html;
    }
}
