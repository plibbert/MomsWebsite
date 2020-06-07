package org.launchcode.muriel_mays.controllers;

import org.launchcode.muriel_mays.models.Recipe;
import org.launchcode.muriel_mays.models.RecipeData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("gallery")
public class GalleryController {

    static HashMap<String, String> choices = new HashMap<>();

    @GetMapping
    public String gallery() {
        return "gallery";
    }

//    public GalleryController() {
//        choices.put("cookies", "Cookies, Bars, & Brownies");
//        choices.put("cakes", "Cakes & Cupcakes");
//        choices.put("breads", "Breads & Muffins");
//        choices.put("pastry", "Pastry & Desserts");
//        choices.put("savory", "Savory");
//    }

    @RequestMapping(value ="Images")
    public String findImagesToDisplay(Model model, @RequestParam String category) {
        ArrayList<String>images = new ArrayList<>();
        String basePath = "src/main/resources/Static/images/" + category;
            File i = new File(basePath);
            for (String fileName : i.list()) {
                images.add("/images/" + category + "/" + fileName);
            }
        model.addAttribute("title", category);
            model.addAttribute("images", images);

        return "/galleryDisplay";
    }
}