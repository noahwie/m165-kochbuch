package ch.wiss.m165kochbuchbackend.service;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import ch.wiss.m165kochbuchbackend.repository.RezeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Service class for handling business logic related to {@link Rezept} entities.
 * Provides methods for CRUD operations and custom queries.
 */
@Service
public class RezeptService {

    private final RezeptRepository rezeptRepository;

    /**
     * Constructs a new {@code RezeptService} with the given repository.
     *
     * @param rezeptRepository the repository used for database operations
     */
    @Autowired
    public RezeptService(RezeptRepository rezeptRepository) {
        this.rezeptRepository = rezeptRepository;
    }

    /**
     * Retrieves all recipes from the database.
     *
     * @return a list of all recipes
     */
    public List<Rezept> getAllRezepte() {
        return rezeptRepository.findAll();
    }

    /**
     * Finds a recipe by its unique identifier.
     *
     * @param id the ID of the recipe
     * @return the recipe with the specified ID
     * @throws RuntimeException if the recipe is not found
     */
    public Rezept findRezeptById(String id) {
        return rezeptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rezept not found with id: " + id));
    }

    /**
     * Creates a new recipe and saves it to the database.
     *
     * @param rezept the recipe to create
     * @return the created recipe
     */
    public Rezept createRezept(Rezept rezept) {
        return rezeptRepository.save(rezept);
    }

    /**
     * Deletes a recipe by its ID.
     *
     * @param id the ID of the recipe to delete
     */
    public void deleteRezeptById(String id) {
        rezeptRepository.deleteById(id);
    }

    /**
     * Updates an existing recipe by its ID.
     *
     * @param id     the ID of the recipe to update
     * @param rezept the new recipe data
     * @return the updated recipe
     * @throws RuntimeException if the recipe does not exist
     */
    public Rezept updateRezeptById(String id, Rezept rezept) {
        if (!rezeptRepository.existsById(id)) {
            throw new RuntimeException("Rezept not found.");
        }
        rezept.setId(id);
        return rezeptRepository.save(rezept);
    }

    /**
     * Finds recipes that belong to any of the specified categories.
     *
     * @param category a list of category names
     * @return a list of matching recipes
     * @throws RuntimeException if no recipes are found
     */
    public List<Rezept> findByCategory(List<String> category) {
        List<Rezept> rezepte = rezeptRepository.findByCategoryIn(category);
        if (rezepte.isEmpty()) {
            throw new RuntimeException("Rezepte found for categories: " + category);
        }
        return rezepte;
    }

    /**
     * Finds recipes whose names contain the specified substring.
     *
     * @param name the substring to search for
     * @return a list of matching recipes
     * @throws RuntimeException if no recipes are found
     */
    public List<Rezept> findByName(String name) {
        List<Rezept> rezepte = rezeptRepository.findByNameContaining(name);
        if (rezepte.isEmpty()) {
            throw new RuntimeException("No Rezepte found by this input: " + name);
        }
        return rezepte;
    }
}
