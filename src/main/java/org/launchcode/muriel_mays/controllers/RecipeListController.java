package org.launchcode.muriel_mays.controllers;

import org.launchcode.muriel_mays.models.Recipe;
import org.launchcode.muriel_mays.models.RecipeData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "recipes")
public class RecipeListController {


        static HashMap<String, String> columnChoices = new HashMap<>();
        static HashMap<String, Object> tableChoices = new HashMap<>();

        public RecipeListController () {
            columnChoices.put("all", "All");
//            columnChoices.put("name", "Name");
            columnChoices.put("category", "Category");
//            columnChoices.put("servings", "Servings");
//            columnChoices.put("ingredients", "Ingredients");

//            tableChoices.put("name", RecipeData.getAllNames());
            tableChoices.put("category", RecipeData.getAllCategories());
//            tableChoices.put("prepTime", RecipeData.getAllPrepTimes());
//            tableChoices.put("servings", RecipeData.getAllServings());
//            tableChoices.put("ingredients", RecipeData.getAllIngredients());
        }

        @RequestMapping (value = "")
        public String recipeList(Model model) {
            model.addAttribute("columns", columnChoices);
            model.addAttribute("tableChoices", tableChoices);
            model.addAttribute("names", RecipeData.getAllNames());
//            model.addAttribute("prepTime", RecipeData.getAllPrepTimes());
//            model.addAttribute("servings", RecipeData.getAllServings());
//            model.addAttribute("ingredients", RecipeData.getAllIngredients());

            return "recipes";
        }

        @RequestMapping (value = "recipes")
        public String listRecipesByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
            ArrayList<Recipe> recipes;
            if (column.toLowerCase().equals("all")){
                recipes = RecipeData.findAll();
                model.addAttribute("title", "All Recipes");
            } else {
                recipes = RecipeData.findByColumnAndValue(column, value);
                model.addAttribute("title", "Recipes with " + columnChoices.get(column) + ": " + value);
            }
            model.addAttribute("recipes", recipes);

            return "recipelist";
        }
    }
