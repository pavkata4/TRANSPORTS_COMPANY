package com.example.transportcompany.DTOS;


import javax.validation.constraints.*;

public class RegisterUserDTO {
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, message = "Too short password")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=[@#$%^&+=]*).*", message = "Password must contain at least one lowercase, uppercase and digit!")
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;

    public RegisterUserDTO(String email, String password, String confirmPassword, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public RegisterUserDTO() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
