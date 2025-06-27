package ch.wiss.m165kochbuchbackend.controller;

import ch.wiss.m165kochbuchbackend.model.Kategorie;
import ch.wiss.m165kochbuchbackend.repository.KategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kategorie")
public class KategorieController {

    @Autowired
    private KategorieRepo repo;


    // Adding Kategorie
    @PostMapping("")
    public String saveKategorie(@RequestBody Kategorie kategorie){
        repo.save(kategorie);

        return "Added Successfully";
    }

    // Getting List
    @GetMapping("")
    public List<Kategorie> getKategorie() {

        return repo.findAll();
    }

    // Deleting Kategorie
    @DeleteMapping("/{id}")
    public String deleteKategorie (@PathVariable String id){
        repo.deleteById(id);

        return "Deleted Successfully";
    }

    // Getting Kategorie by ID
    @GetMapping(("/{id}"))
    public Kategorie getKategoriebyId(@PathVariable String id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategorie not found with id: " + id));
    }

    // Updating Kategorie by ID
    @PutMapping
    public String putKategorieById(@RequestBody Kategorie k){
        repo.save(k);
        return "Kategorie Updated";
    }

}

