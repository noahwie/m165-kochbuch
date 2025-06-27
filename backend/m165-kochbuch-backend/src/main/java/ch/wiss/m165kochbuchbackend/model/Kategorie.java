package ch.wiss.m165kochbuchbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection= "kategorie")
public class Kategorie {


    // Attribute
    @Id
    private String id;
    private String kategoriename;

}
