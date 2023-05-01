package com.example.workbook_31_field_validation.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    @NotBlank(message = "Vorname darf nicht leer sein")
    @Size(min = 2, message = "Vorname ist zu kurz")
    private String firstName;
    @NotBlank(message = "Nachname darf nicht leer sein")
    @Size(min = 2, message = "Nachname ist zu kurz")
    private String lastName;
    @NotBlank(message = "Username darf nicht leer sein")
    @Size(min = 7, message = "Username ist zu kurz")
    private String userName;
    @Email
    private String email;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    public User() {
    }

    public User(String firstName, String lastName, String userName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
