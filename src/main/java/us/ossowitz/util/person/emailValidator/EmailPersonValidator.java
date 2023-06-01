package us.ossowitz.util.person.emailValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import us.ossowitz.dao.PersonDAO;

public class EmailPersonValidator implements ConstraintValidator<EmailPersonConstraint, String> {
    private final PersonDAO personDAO;

    @Autowired
    public EmailPersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public void initialize(EmailPersonConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return personDAO.show(value).isEmpty();
    }
}