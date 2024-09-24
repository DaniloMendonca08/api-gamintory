package br.com.danilo.gamintory.game.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.Year;

public class ReleaseYearValidator implements ConstraintValidator<ValidReleaseYear, Integer> {
    @Override
    public void initialize(ValidReleaseYear constraintAnnotation) {
        // Inicialização, se necessário
    }

    @Override
    public boolean isValid(Integer releaseYear, ConstraintValidatorContext context) {
        if (releaseYear == null) {
            return true; // Permite valores nulos
        }
        int currentYear = Year.now().getValue();
        return releaseYear >= 1000 && releaseYear <= currentYear; // Validação do intervalo
    }
}