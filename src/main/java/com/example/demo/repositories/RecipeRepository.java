package com.example.demo.repositories;

import com.example.demo.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface RecipeRepository extends MongoRepository<Recipe,String> {
    List<Recipe> findByName(String name);
}
