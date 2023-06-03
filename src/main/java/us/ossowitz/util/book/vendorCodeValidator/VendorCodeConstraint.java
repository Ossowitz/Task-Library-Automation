package us.ossowitz.util.book.vendorCodeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VendorCodeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface VendorCodeConstraint {
    String message() default "This vendor code is already taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}