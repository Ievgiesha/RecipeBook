package com.example.demo.repositories;

import com.example.demo.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface RecipeRepository extends MongoRepository<Recipe,String> {
    List<Recipe> findByName(String name);


}
//    @Modifying
//    @Query("update User u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
//    void setUserInfoById(Strfing firstname, String lastname, Integer userId);