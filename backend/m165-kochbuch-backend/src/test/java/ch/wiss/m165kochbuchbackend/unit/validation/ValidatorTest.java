package ch.wiss.m165kochbuchbackend.unit.validation;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    @DisplayName("Validator erkennt leeren Namen")
    void rezeptWithEmptyNameFailsValidation() {

        List<String> category = Arrays.asList("Mahlzeit", "Haluzinogen");
        List<String> ingredients = Arrays.asList("Zucker", "Salz");

        Rezept rezept = new Rezept();
        rezept.setId("1");
        rezept.setName("");  // Invalid input
        rezept.setCategory(category);
        rezept.setDescription("Diese Beschreibung");
        rezept.setIngredients(ingredients);
        rezept.setInstructions("Diese Instruktion");

        Set<ConstraintViolation<Rezept>> violations = validator.validate(rezept);

        assertFalse(violations.isEmpty(), "Validation errors expected due to empty name");

        boolean nameViolationExists = violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("name"));

        assertTrue(nameViolationExists, "Validation error on 'name' field expected");
    }

    @Test
    @DisplayName("Validator erkennt zu langen namen Namen")
    void rezeptWithToLongNameFailsValidation() {

        List<String> category = Arrays.asList("Mahlzeit", "Haluzinogen");
        List<String> ingredients = Arrays.asList("Zucker", "Salz");

        Rezept rezept = new Rezept();
        rezept.setId("1");
        rezept.setName("1234567891011121314151617181920");  // Invalid input
        rezept.setCategory(category);
        rezept.setDescription("Diese Beschreibung");
        rezept.setIngredients(ingredients);
        rezept.setInstructions("Diese Instruktion");

        Set<ConstraintViolation<Rezept>> violations = validator.validate(rezept);

        assertFalse(violations.isEmpty(), "Validation errors expected due to empty name");

        boolean nameViolationExists = violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("name"));

        assertTrue(nameViolationExists, "Validation error on 'name' field expected");
    }

}
