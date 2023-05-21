package us.ossowitz.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import us.ossowitz.springcourse.dao.ChildDAO;
import us.ossowitz.springcourse.models.Children;

@Component("childValidator")
public class ChildValidator implements Validator {

    private final ChildDAO childDAO;

    @Autowired
    public ChildValidator(ChildDAO childDAO) {
        this.childDAO = childDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Children.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Children children = (Children) target;

        if (childDAO.show(children.getEmail()).isPresent())
            errors.rejectValue("email", "", "This email is already taken");
    }
}
