package ch.wiss.m165kochbuchbackend.service;

import ch.wiss.m165kochbuchbackend.model.Kategorie;
import ch.wiss.m165kochbuchbackend.model.Rezept;
import ch.wiss.m165kochbuchbackend.repository.KategorieRepo;
import ch.wiss.m165kochbuchbackend.repository.RezeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategorieService {
    private KategorieRepo kategorieRepo;

    @Autowired
    public KategorieService(KategorieRepo kategorieRepo) {
        this.kategorieRepo = kategorieRepo;
    }


    // get all rezepte
    public List<Kategorie> getAllKategorie() {
        return kategorieRepo.findAll();
    }

    // get rezepte by id
    public Kategorie findKategorieById(String id) {
        return kategorieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategorie not found with id: " + id));
    }

    // create new rezept
    public Kategorie createKategorie(Kategorie k) {
        return kategorieRepo.save(k);
    }

    // delete rezept
    public void deleteKategorieById(String id) {
        kategorieRepo.deleteById(id);
    }

    // update rezept
    public Kategorie updateKategorieById(String id, Kategorie k) {
        if (!kategorieRepo.existsById(id)) {
            throw new RuntimeException("Kategorie not found.");
        }
        k.setId(id);
        return kategorieRepo.save(k);
    }
}
