package us.ossowitz.util.person.perkValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import us.ossowitz.models.person.Perk;

import java.util.Arrays;

public class PerkTypeValidator implements ConstraintValidator<PerkValidator, Perk> {
    private Perk[] subset;

    @Override
    public void initialize(PerkValidator constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(Perk value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
