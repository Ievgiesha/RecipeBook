package com.example.demo.controllers;

import com.example.demo.commands.RecipeCommands;
import com.example.demo.model.Recipe;
import com.example.demo.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipeController {


    @Autowired
    private RecipeService recipeService;

    @Autowired(required = true)
    @Qualifier(value = "recipeService")
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "/recipe")
    public String recipe(Model model) {
        model.addAttribute("recipe", recipeService.findAll());
        model.addAttribute("command",new RecipeCommands());
        return "recipeList";
    }
    @PostMapping("/recipe")
    public String addRecipe(@ModelAttribute RecipeCommands commands){
       recipeService.addRecipe(commands);
       return "redirect:/recipe";

    }
    @PostMapping("/recpe/delete")
    public String deleteRecipe(@ModelAttribute RecipeCommands commands){
        recipeService.deleteRecipe(commands.recipeNameToDelete);
        return "redirect:/notes";
    }
}
/*
@Controller
public class NotesController {
@Autowired
    private NotesService notesService;
@GetMapping("/notes")
    public String notes(Model model) {
        model.addAttribute("notes", notesService.getAllNotes());
        model.addAttribute("command", new NotesCommand());
        return "noteList";
    }
 @PostMapping("/notes")
    public String addNote(@ModelAttribute NotesCommand command){
        notesService.addNote(command);
        return "redirect:/notes";
    }
    @PostMapping("/notes/delete")
    public String deleteNote(@ModelAttribute NotesCommand command){
        notesService.deleteNote(command.getNoteIdToDelete());
        return "redirect:/notes";
*/
