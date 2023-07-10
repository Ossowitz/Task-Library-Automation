package us.ossowitz.util.person.emailValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import us.ossowitz.dao.PersonDAO;
import us.ossowitz.models.Person;

@Component
public class EmailPersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public EmailPersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (personDAO.getPersonByEmail(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "Email should be unique");
        }
    }
}