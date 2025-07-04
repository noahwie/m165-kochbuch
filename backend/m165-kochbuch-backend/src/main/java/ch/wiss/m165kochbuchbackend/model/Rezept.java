package ch.wiss.m165kochbuchbackend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String name;

    /**
     * Categories to which the recipe belongs.
     */
    private List<String> category;

    /**
     * Description or summary of the recipe.
     */
    private String description;

    /**
     * List of ingredients required for the recipe.
     */
    private List<String> ingredients;

    /**
     * Step-by-step instructions to prepare the recipe.
     */
    private String instructions;
}
