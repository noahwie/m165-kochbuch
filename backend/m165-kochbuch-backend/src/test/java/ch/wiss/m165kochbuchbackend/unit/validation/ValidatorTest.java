package ch.wiss.m165kochbuchbackend.unit.validation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@ExtendWith(SpringExtension.class)
public class ValidatorTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * Testet, dass positive Werte als gültig erkannt werden.
     */
    @Test
    @DisplayName("Validator akzeptiert positive Werte")
    void rezepteIsCorrect() {

        List<String> category = Arrays.asList("Mahlzeit", "Haluzinogen");
        List<String> ingredients = Arrays.asList("Zucker", "Salz");

        Rezept rezept = new Rezept();
        rezept.setId("1");
        rezept.setName("bolognese");
        rezept.setCategory(category);
        rezept.setDescription("Diese Beschreibung");
        rezept.setIngredients(ingredients);
        rezept.setInstructions("Diese Instruktion");

        Set<ConstraintViolation<Rezept>> violations = validator.validate(rezept);

        assertTrue(violations.isEmpty());  // Es sollen keine Verstöße vorliegen
    }
}
