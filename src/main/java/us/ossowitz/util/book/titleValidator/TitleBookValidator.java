package us.ossowitz.util.book.titleValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import us.ossowitz.dao.BookDAO;

public class TitleBookValidator implements
        ConstraintValidator<TitleBookConstraint, String> {
    private final BookDAO bookDAO;

    @Autowired
    public TitleBookValidator(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void initialize(TitleBookConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return bookDAO.show(value).isEmpty();
    }
}