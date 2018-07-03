package com.example.demo;

import com.example.demo.model.Recipe;
import com.example.demo.repositories.RecipeRepository;
import com.example.demo.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


    @Autowired
    private RecipeRepository recipeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       Recipe myRecipe = Recipe.builder().build();
       myRecipe.setRecipeText("What a nice dish!");
       recipeRepository.save(myRecipe);
       recipeRepository.findAll().stream().forEach(n-> System.out.println(n));
    }
}
