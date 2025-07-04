package ch.wiss.m165kochbuchbackend.controller;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import ch.wiss.m165kochbuchbackend.service.RezeptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing {@link Rezept} resources.
 * Provides endpoints for common CRUD and search operations.
 */
@RestController
@RequestMapping("/rezept")
@CrossOrigin
public class RezeptController {

    private final RezeptService rezeptService;

    /**
     * Constructs a new {@code RezeptController} with the given service.
     *
     * @param rezeptService the service layer used for business logic
     */
    public RezeptController(RezeptService rezeptService) {
        this.rezeptService = rezeptService;
    }

    /**
     * Retrieves all recipes.
     *
     * @return a list of all recipes
     */
    @GetMapping
    public List<Rezept> getAll() {
        return rezeptService.getAllRezepte();
    }

    /**
     * Retrieves recipes that match the given categories.
     *
     * @param category a list of category names
     * @return a list of matching recipes
     */
    @GetMapping("/get-by-category")
    public List<Rezept> getByCategory(@RequestParam List<String> category) {
        return rezeptService.findByCategory(category);
    }

    /**
     * Retrieves recipes whose names contain the given substring.
     *
     * @param name the substring to search for in names
     * @return a list of matching recipes
     */
    @GetMapping("/contain-name")
    public List<Rezept> getByName(@RequestParam String name) {
        return rezeptService.findByName(name);
    }

    /**
     * Retrieves a recipe by its ID.
     *
     * @param id the ID of the recipe
     * @return the recipe with the specified ID
     */
    @GetMapping("/{id}")
    public Rezept getById(@PathVariable String id) {
        return rezeptService.findRezeptById(id);
    }

    /**
     * Creates a new recipe.
     *
     * @param rezept the recipe to create
     * @return the created recipe
     */
    @PostMapping
    public Rezept create(@RequestBody Rezept rezept) {
        return rezeptService.createRezept(rezept);
    }

    /**
     * Updates an existing recipe by its ID.
     *
     * @param id     the ID of the recipe to update
     * @param rezept the updated recipe data
     * @return the updated recipe
     */
    @PutMapping("/{id}")
    public Rezept update(@PathVariable String id, @RequestBody Rezept rezept) {
        return rezeptService.updateRezeptById(id, rezept);
    }

    /**
     * Deletes a recipe by its ID.
     *
     * @param id the ID of the recipe to delete
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        rezeptService.deleteRezeptById(id);
    }
}
