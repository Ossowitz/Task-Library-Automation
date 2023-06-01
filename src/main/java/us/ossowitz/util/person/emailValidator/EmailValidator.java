package us.ossowitz.util.person.emailValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import us.ossowitz.dao.PersonDAO;
import us.ossowitz.models.person.Person;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    private final PersonDAO personDAO;

    @Autowired
    public EmailValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return personDAO.show(value).isEmpty();
    }
}