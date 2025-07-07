package ch.wiss.m165kochbuchbackend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.*;

import java.util.List;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Represents a cooking recipe (Rezept) stored in the MongoDB collection "rezept".
 * Contains recipe details such as name, categories, description, ingredients, and instructions.
 */
@Document(collection = "rezept")
@Getter
@Setter
public class Rezept {

    /**
     * Unique identifier for the recipe.
     */
    @Id
    private String id;

    /**
     * Name of the recipe.
     */
    @NotNull(message="Name can not be Null")
    @Size(min=3, max=30, message="Name must be between 3-30")
    private String name;

    /**
     * Categories to which the recipe belongs.
     */
    @NotNull(message="category can not be Null")
    @Size(min=1, max=30, message="category must be between 2-30")
    private List<String> category;

    /**
     * Description or summary of the recipe.
     */
    @NotNull(message="description can not be Null")
    @Size(max= 3000, message="description must be smaller then 3000")
    private String description;

    /**
     * List of ingredients required for the recipe.
     */
    @NotNull(message="ingredients can not be Null")
    @Size(min= 2, max=50, message="ingredients must be between 2-50")
    private List<String> ingredients;

    /**
     * Step-by-step instructions to prepare the recipe.
     */
    @NotNull(message="instructions can not be Null")
    @Size(max= 3000, message="description must be smaller then 3000")
    private String instructions;
}
