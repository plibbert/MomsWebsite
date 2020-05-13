package org.launchcode.muriel_mays.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("recipes")
public class RecipesController {

    @GetMapping
    @ResponseBody
    public String recipes(){
        return "Recipe list soon...";
    }
    @GetMapping("list")
    public String recipesForTesting(Model model){
        List<String> recipes = new ArrayList<>();
        recipes.add("No Bake Cookies");
        recipes.add("Oatmeal Cream Pies");
        recipes.add("Shitty Saltines");
        model.addAttribute("recipes", recipes);
        return "recipelist";
    }
}
