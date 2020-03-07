package dev.mateuszkowalczyk.puncher.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class RegisterData {
    @Email
    private String email;

    @Length(min = 5, max = 100, message = "Minimal length is 5 and max 100")
    private String username;

    @Length(min = 5, message = "Password cannot be shorter than 5 chars")
    private String password;

    public RegisterData() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
