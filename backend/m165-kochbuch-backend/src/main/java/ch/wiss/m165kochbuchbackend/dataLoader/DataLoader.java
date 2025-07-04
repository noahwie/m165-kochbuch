package ch.wiss.m165kochbuchbackend.dataLoader;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import ch.wiss.m165kochbuchbackend.repository.RezeptRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class DataLoader implements CommandLineRunner {

    private final RezeptRepository rezeptRepository;
    private final ObjectMapper objectMapper;

    public DataLoader(RezeptRepository rezeptRepository) {
        this.rezeptRepository = rezeptRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/rezepte.json");
        if (inputStream == null) {
            System.out.println("rezepte.json not found.");
            return;
        }

        Rezept[] rezepte = objectMapper.readValue(inputStream, Rezept[].class);

        int inserted = 0;
        for (Rezept rezept : rezepte) {
            // Check if a recipe with the same ID or Name already exists
            boolean exists = rezeptRepository.existsById(rezept.getId())
                    || rezeptRepository.existsByName(rezept.getName());

            if (!exists) {
                rezeptRepository.save(rezept);
                inserted++;
            }
        }

        System.out.println("Import complete. New recipes added: " + inserted);
    }
}
