package com.example.demo.services;

import com.example.demo.commands.RecipeCommands;
import com.example.demo.model.Recipe;
import com.example.demo.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public void addRecipe(String nameOfReceipts, String text) {
        recipeRepository.save(Recipe.builder().name(nameOfReceipts).recipeText(text).date(dateNow()).build());

    }

    private String dateNow() {
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    public List<Recipe> findByName(String name) {
        return recipeRepository.findByName(name);
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public void deleteRecipe(String name) {
        if (!recipeRepository.findByName(name).isEmpty()) {
            recipeRepository.findByName(name).remove(name);
        }//TODO
    }

    public void addRecipe(RecipeCommands commands) {
        recipeRepository.save(Recipe.builder().name(commands.addRecipeNameValue).recipeText(commands.getAddRecipeTextValue()).build());
    }
}
