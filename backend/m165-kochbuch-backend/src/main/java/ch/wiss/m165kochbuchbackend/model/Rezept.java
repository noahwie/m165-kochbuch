package ch.wiss.m165kochbuchbackend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "rezept")
@Getter
@Setter
public class Rezept {
    @Id
    private String id;
    private String name;
    private List<String> category;
    private String description;

    // Zu list ändern (grund , Beretigestewllte dada von silas)
    private List<String> ingredients;
    private String instructions;
}
