package ch.wiss.m165kochbuchbackend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Annotations
@Getter
@Setter
@Document(collection= "kategorie")
public class Kategorie {


    // Attribute
    @Id
    private String id;
    private String kategoriename;

}
