package us.ossowitz.springcourse.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Music {
    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 30, message = "Title should be between 2 and 30")
    private String title;

    @Min(value = 0, message = "Vendor code should not be greater than 0")
    private int vendorCode;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String feedback;

    public Music() {

    }

    public Music(int id, String title, int vendorCode, String feedback) {
        this.id = id;
        this.title = title;
        this.vendorCode = vendorCode;
        this.feedback = feedback;
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

    public int getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
