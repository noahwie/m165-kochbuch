package ch.wiss.m165kochbuchbackend.integration.init;
 
import ch.wiss.m165kochbuchbackend.model.Rezept;
import ch.wiss.m165kochbuchbackend.repository.RezeptRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 
import java.util.List;
import java.util.Optional;
 
import static org.junit.jupiter.api.Assertions.*;
 
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataTest {
 
    @Autowired
    private RezeptRepository rezeptRepository;
 
    private static final String TEST_NAME = "Test Rezept";
 
    private Rezept createTestRezept() {
        Rezept rezept = new Rezept();
        rezept.setName(TEST_NAME);
        rezept.setCategory(List.of("Dessert"));
        rezept.setDescription("Ein leckeres Testrezept");
        rezept.setIngredients(List.of("Zucker", "Mehl"));
        rezept.setInstructions("Alles vermischen und backen.");
        return rezept;
    }
 
    @BeforeEach
    public void cleanDbBefore() {
        rezeptRepository.deleteAll();
    }
 
    @Test
    @Order(1)
    public void testSaveRezept() {
        Rezept rezept = createTestRezept();
        Rezept saved = rezeptRepository.save(rezept);
 
        assertNotNull(saved.getId());
        assertEquals(TEST_NAME, saved.getName());
    }
 
    @Test
    @Order(2)
    public void testDeleteRezept() {
        Rezept rezept = rezeptRepository.save(createTestRezept());
        rezeptRepository.deleteById(rezept.getId());
 
        Optional<Rezept> result = rezeptRepository.findById(rezept.getId());
        assertFalse(result.isPresent());
    }
 
    @Test
    @Order(3)
    public void testRezeptById() {
        Rezept rezept = rezeptRepository.save(createTestRezept());
 
        Optional<Rezept> found = rezeptRepository.findById(rezept.getId());
        assertTrue(found.isPresent());
        assertEquals(TEST_NAME, found.get().getName());
    }
 
    @Test
    @Order(4)
    public void testRezeptByName() {
        rezeptRepository.save(createTestRezept());
 
        List<Rezept> results = rezeptRepository.findByNameContaining("Test");
        assertFalse(results.isEmpty());
        assertEquals(TEST_NAME, results.get(0).getName());
    }
 
    @Test
    @Order(5)
    public void testFindByCategoryIn() {
        rezeptRepository.save(createTestRezept());
 
        List<Rezept> results = rezeptRepository.findByCategoryIn(List.of("Dessert", "Vegan"));
        assertFalse(results.isEmpty());
        assertEquals(TEST_NAME, results.get(0).getName());
    }
 
}