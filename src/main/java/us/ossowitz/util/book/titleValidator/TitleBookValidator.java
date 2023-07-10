package us.ossowitz.util.book.titleValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import us.ossowitz.dao.BookDAO;
import us.ossowitz.models.Book;

@Component
public class TitleBookValidator implements Validator {

    private final BookDAO bookDAO;

    @Autowired
    public TitleBookValidator(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;

        if (bookDAO.show(book.getTitle()).isPresent()) {
            errors.rejectValue("title", "", "Title should be unique");
        }
    }
}