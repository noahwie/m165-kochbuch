package ch.wiss.m165kochbuchbackend.repository;

import ch.wiss.m165kochbuchbackend.model.Kategorie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategorieRepo extends MongoRepository <Kategorie, String>{


}
