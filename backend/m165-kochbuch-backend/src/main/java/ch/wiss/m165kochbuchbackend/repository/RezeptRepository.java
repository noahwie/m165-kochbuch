package ch.wiss.m165kochbuchbackend.repository;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link Rezept} entities in MongoDB.
 * Extends {@link MongoRepository} to provide basic CRUD operations and custom queries.
 */
@Repository
public interface RezeptRepository extends MongoRepository<Rezept, String> {

    /**
     * Finds all recipes that belong to any of the specified categories.
     *
     * @param category a list of categories to filter by
     * @return a list of recipes that match the given categories
     */
    List<Rezept> findByCategoryIn(List<String> category);

    /**
     * Checks if a recipe with the specified name already exists.
     *
     * @param name the name of the recipe to check
     * @return true if a recipe with the given name exists, false otherwise
     */
    boolean existsByName(String name);

    /**
     * Finds all recipes where the name contains the given substring (case-sensitive).
     *
     * @param name the substring to search for in recipe names
     * @return a list of matching recipes
     */
    List<Rezept> findByNameContaining(String name);
}
