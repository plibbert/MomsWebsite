package org.launchcode.muriel_mays.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GalleryController {

    @GetMapping("Gallery")
    @ResponseBody
    public String galleryPage(){
        return "This will be the gallery...eventually";
    }

}
