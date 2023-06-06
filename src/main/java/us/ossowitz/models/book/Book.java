package us.ossowitz.models.book;

import jakarta.validation.constraints.*;
import us.ossowitz.util.book.titleValidator.TitleBookConstraint;
import us.ossowitz.util.book.vendorCodeValidator.VendorCodeConstraint;

public class Book {
    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 30, message = "Title should be between 2 and 30 characters")
    @TitleBookConstraint
    private String title;

    @NotEmpty(message = "Author name should not be empty")
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String author;

    @Min(value = 0, message = "Publication year should be greater than 0")
    private int year;

    @Digits(integer = 6, message = "«VendorCode» should contain exactly 6 digits", fraction = 0)
    @VendorCodeConstraint
    private int vendorCode;

    public Book() {
    }

    public Book(int id, String title, String author, int year, int vendorCode) {
        this.id = id;
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