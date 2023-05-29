package util.person;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import models.person.Perk;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PerkTypeValidator.class)
public @interface PerkValidator {
    Perk[] anyOf();
    String message() default "Perk should be valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
