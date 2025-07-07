package ch.wiss.m165kochbuchbackend.dataLoader;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import ch.wiss.m165kochbuchbackend.repository.RezeptRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Component that loads initial recipe data from a JSON file into the database.
 * Implements {@link CommandLineRunner} to execute on application startup.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final RezeptRepository rezeptRepository;
    private final ObjectMapper objectMapper;

    /**
     * Constructs a new {@code DataLoader} with the given repository.
     *
     * @param rezeptRepository the repository to use for inserting data
     */
    public DataLoader(RezeptRepository rezeptRepository) {
        this.rezeptRepository = rezeptRepository;
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Executes data loading logic on application startup.
     *
     * @param args application arguments
     * @throws Exception if an error occurs while loading data
     */
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
