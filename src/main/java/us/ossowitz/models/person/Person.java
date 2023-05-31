package us.ossowitz.models.person;

import jakarta.validation.constraints.*;
import us.ossowitz.util.person.perkValidator.PerkValidator;
import us.ossowitz.util.person.phoneValidator.ContactNumberConstraint;

import static us.ossowitz.models.person.Perk.*;

public class Person {
    private int id;

    /**
     * TODO «Add pattern for name»
     */
    // @Pattern
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    /**
     * TODO «Add pattern for address»
     */
    // @Pattern
    private String address;

    @NotEmpty(message = "Phone number should not be empty")
    @ContactNumberConstraint
    private String phoneNumber;

    @PerkValidator(anyOf = {READERSHIP, MENTOR, VIP, STAFF})
    private Perk perk;

    public Person(int id, String name, int age, String email, String address, String phoneNumber, Perk perk) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.perk = perk;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Perk getPerk() {
        return perk;
    }

    public void setPerk(Perk perk) {
        this.perk = perk;
    }
}
