package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Recipe{
    @Id
    private String id;
    private String name;
    private String recipeText;

    private String date ;

   private String dateNow() {
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        date = simpleDateFormat.format(new Date());
        return date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (!name.equals(recipe.name)) return false;
         return date.equals(recipe.date);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Name of recipe : ")
                .append(name)
                .append(" . ")
                .append("Contains : ")
                .append(recipeText)
                .append(" . ")
                .append(" Created :").append(dateNow()).toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecipeText(String recipeText) {
        this.recipeText = recipeText;
    }

    public String getName() {
        return name;
    }

    public String getRecipeText() {
        return recipeText;
    }
}
