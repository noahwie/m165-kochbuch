package ch.wiss.m165kochbuchbackend.repository;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import jdk.jfr.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RezeptRepository extends MongoRepository<Rezept, String> {
    List<Rezept> findByCategoryIn(List<String> category);
    boolean existsByName(String name);


}
