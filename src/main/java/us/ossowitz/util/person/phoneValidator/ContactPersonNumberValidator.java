package us.ossowitz.util.person.phoneValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContactPersonNumberValidator implements
        ConstraintValidator<ContactPersonNumberConstraint, String> {
    @Override
    public void initialize(ContactPersonNumberConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("[0-9]+")
               && (contactField.length() == 11);
    }
}