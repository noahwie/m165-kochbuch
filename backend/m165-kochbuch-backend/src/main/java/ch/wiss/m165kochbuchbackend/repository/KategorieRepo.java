package ch.wiss.m165kochbuchbackend.repository;

import ch.wiss.m165kochbuchbackend.model.Kategorie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KategorieRepo extends MongoRepository <Kategorie, String>{


}
