package us.ossowitz.util.book.vendorCodeValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import us.ossowitz.dao.BookDAO;

public class VendorCodeValidator implements
        ConstraintValidator<VendorCodeConstraint, Integer> {
    private final BookDAO bookDAO;

    @Autowired
    public VendorCodeValidator(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void initialize(VendorCodeConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return bookDAO.show(integer).isEmpty();
    }
}