package dev.mateuszkowalczyk.puncher.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 5)
    private String password;

    @NotBlank
    private String email;

    public UserDTO() {

    }

    public UserDTO(RegisterData registerData) {
        this.username = registerData.getUsername();
        this.password = registerData.getPassword();
        this.email = registerData.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
