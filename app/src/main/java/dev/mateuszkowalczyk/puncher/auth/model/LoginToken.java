package dev.mateuszkowalczyk.puncher.auth.model;

import dev.mateuszkowalczyk.puncher.response.Response;

import java.util.ArrayList;

public class LoginToken extends Response {
    private String username;
    private ArrayList<String> roles = new ArrayList<>();
    private String token;

    public LoginToken() {}

    public LoginToken(String username, ArrayList<String> roles, String token) {
        this.username = username;
        this.roles = roles;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public boolean addRole(String role) {
        role = role.toUpperCase();

        if (this.roles.contains(role)) {
            return false;
        }

        this.roles.add(role);
        return true;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
