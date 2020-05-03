package org.launchcode.muriel_mays.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("gallery")
@ResponseBody
public class GalleryController {

    @GetMapping
    public String galleryPage(){
        return "This will be the gallery...eventually";
    }

}
