package com.example.demo.controllers;

import com.example.demo.commands.RecipeCommands;
import com.example.demo.model.Recipe;
import com.example.demo.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {


    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "/recipes")
    public String recipe(Model model) {
        model.addAttribute("recipes", recipeService.findAll());
        model.addAttribute("command",new RecipeCommands());
        return "recipeList";
    }
    @PostMapping("/recipes")
    public String addRecipe(@ModelAttribute RecipeCommands commands){
       recipeService.addRecipe(commands);
       return "redirect:/recipes";

    }
    @PostMapping("/recipes/delete")
    public String deleteRecipe(@ModelAttribute RecipeCommands commands){
        recipeService.deleteRecipe(commands.recipeIdToDelete);
        return "redirect:/recipes";
    }
}
