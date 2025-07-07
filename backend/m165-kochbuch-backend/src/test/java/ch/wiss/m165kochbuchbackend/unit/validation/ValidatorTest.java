package ch.wiss.m165kochbuchbackend.unit.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ch.wiss.m165kochbuchbackend.model.Rezept;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Size;



@ExtendWith(SpringExtension.class)
public class ValidatorTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator(); {
           /**
     * Testet, dass positive Werte als gültig erkannt werden.
     */
    @Test
    @DisplayName("Validator akzeptiert positive Werte")
    public void recipieNameIsCorrect() {
        List<String> category = Arrays.asList("Mahlzeit", "Haluzinogen");
        Rezept rezept = new Rezept();
        rezept.setId(1);
        rezept.setName("bolognese");
        rezept.setCategory();
        rezept.setDescription("Diese Beschreibung");
        rezept.setIngredients(null);
        

    }

    /**
     * Testet, dass {@code null} als ungültig behandelt wird.
     */
    @Test
    @DisplayName("Validator lehnt null-Wert ab")
    void shouldRejectNull() {
        assertFalse(validator.isValid(null, null));
    }

    /**
     * Testet, dass 0 und negative Werte als ungültig erkannt werden.
     */
    @Test
    @DisplayName("Validator lehnt 0 und negative Werte ab")
    void shouldRejectZeroAndNegativeValues() {
        assertFalse(validator.isValid(0.0, null));
        assertFalse(validator.isValid(-5.0, null));
    } 
    }
    public ValidatorTest() {
    }
    public ValidatorTest() {
    }
    public ValidatorTest() {
    }
    public ValidatorTest() {
    };



}
