package us.ossowitz.models.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;
    private int personId;
    /**
     * TODO: #Ограничение на длину: от 2 до 30 символов, уникальности
     * @Size, @NotEmpty и добавление Валидатора
     */
    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 30, message = "Title should be between 2 and 30 characters")
    private String title;

    /**
     * TODO: #Ограничение на @NotEmpty и использование корректных символов
     */
    private String author;

    /**
     * TODO: #Ограничение на неотрицательность года написания
     */
    private int year;

    /**
     * TODO: #Ограничение на количество символов в коде
     */
    private int vendorCode;

    public Book() {
    }

    public Book(int id, int personId, String title, String author, int year, int vendorCode) {
        this.id = id;
        this.personId = personId;
        this.title = title;
        this.author = author;
        this.year = year;
        this.vendorCode = vendorCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
    }
}
