package ch.wiss.m165kochbuchbackend.controller;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import ch.wiss.m165kochbuchbackend.service.RezeptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rezept")
@CrossOrigin
public class RezeptController {
    private final RezeptService rezeptService;

    public RezeptController(RezeptService rezeptService) {
        this.rezeptService = rezeptService;
    }

    @GetMapping
    public List<Rezept> getAll() {
        return rezeptService.getAllRezepte();
    }

    @GetMapping("/get-by-category")
    public List<Rezept> getByCategory(@RequestParam List<String> category){
        return rezeptService.findByCategory(category);
    }

    @GetMapping("/contain-name")
    public List<Rezept> getByName(@RequestParam String name){
        return rezeptService.findByName(name);
    }

    @GetMapping("/{id}")
    public Rezept getById(@PathVariable String id) {
        return rezeptService.findRezeptById(id);
    }

    @PostMapping
    public Rezept create(@RequestBody Rezept rezept) {
        return rezeptService.createRezept(rezept);
    }

    @PutMapping("/{id}")
    public Rezept update(@PathVariable String id, @RequestBody Rezept rezept) {
        return rezeptService.updateRezeptById(id, rezept);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        rezeptService.deleteRezeptById(id);
    }
}
