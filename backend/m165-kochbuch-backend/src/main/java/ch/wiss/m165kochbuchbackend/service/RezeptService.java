package ch.wiss.m165kochbuchbackend.service;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import ch.wiss.m165kochbuchbackend.repository.RezeptRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RezeptService {
    private RezeptRepository rezeptRepository;

    @Autowired
    public RezeptService(RezeptRepository rezeptRepository) {
        this.rezeptRepository = rezeptRepository;
    }


    // get all rezepte
    public List<Rezept> getAllRezepte() {
        return rezeptRepository.findAll();
    }

    // get rezepte by id
    public Rezept findRezeptById(String id) {
        return rezeptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rezept not found with id: " + id));
    }

    // create new rezept
    public Rezept createRezept(Rezept rezept) {
        return rezeptRepository.save(rezept);
    }

    // delete rezept
    public void deleteRezeptById(String id) {
        rezeptRepository.deleteById(id);
    }

    // update rezept
    public Rezept updateRezeptById(String id, Rezept rezept) {
        if (!rezeptRepository.existsById(id)) {
            throw new RuntimeException("Rezept not found.");
        }
        rezept.setId(id);
        return rezeptRepository.save(rezept);
    }

    // find by category
    public List<Rezept> findByCategory(List<String> category) {
        List<Rezept> rezepte = rezeptRepository.findByCategoryIn(category);
        if (rezepte.isEmpty()) {
            throw new RuntimeException("Rezepte found for categories: " + category);
        }
        return rezepte;
    }
}