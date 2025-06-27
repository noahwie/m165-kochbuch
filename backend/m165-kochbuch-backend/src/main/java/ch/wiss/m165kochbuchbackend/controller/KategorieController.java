package ch.wiss.m165kochbuchbackend.controller;

import ch.wiss.m165kochbuchbackend.model.Kategorie;
import ch.wiss.m165kochbuchbackend.repository.KategorieRepo;
import ch.wiss.m165kochbuchbackend.service.KategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kategorie")
@CrossOrigin
public class KategorieController {

    private final KategorieService kategorieService;

    public KategorieController(KategorieService kategorieService){
        this.kategorieService = kategorieService;
    }




    // Adding Kategorie
    @PostMapping
    public String saveKategorie(@RequestBody Kategorie kategorie){
        kategorieService.createKategorie(kategorie);

        return "Added Successfully";
    }

    // Getting List
    @GetMapping
    public List<Kategorie> getKategorie() {

        return kategorieService.getAllKategorie();
    }

    // Deleting Kategorie
    @DeleteMapping("/{id}")
    public String deleteKategorie (@PathVariable String id){
        kategorieService.deleteKategorieById(id);

        return "Deleted Successfully";
    }

    // Getting Kategorie by ID
    @GetMapping(("/{id}"))
    public Kategorie getKategoriebyId(@PathVariable String id){
        return kategorieService.findKategorieById(id);
    }

    // Updating Kategorie by ID
    @PutMapping
    public String putKategorieById(@PathVariable String id,@RequestBody Kategorie k){
        kategorieService.updateKategorieById(id, k);
        return "Kategorie Updated";
    }

}

