package us.ossowitz.util.personValidator.perkValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import us.ossowitz.models.Perk;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Constraint(validatedBy = PerkPersonTypeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface PerkPersonConstraint {
    Perk[] anyOf();
    String message() default "Perk should be valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}