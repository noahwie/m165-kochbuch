package ch.wiss.m165kochbuchbackend.integration.init;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ch.wiss.m165kochbuchbackend.repository.RezeptRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DataLoaderTest {

    @Autowired
    private RezeptRepository rezeptRepository;

    /**
     * Überprüft, ob alle erwarteten Testdaten korrekt geladen wurden.
     */
    @Test
    void testDataIsInitialized() {
        // 50 Rezepte erwartet
        assertThat(rezeptRepository.findAll()).hasSize(21);
     
    }
    
    
}
