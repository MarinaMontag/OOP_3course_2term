package controller.servlets.util;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import model.Role;

@JsonPropertyOrder({"token", "role"})
public class Token {
    private String token;
    private Role role;

    public Token() {
    }

    public Token(String token, Role role) {
        this.token = token;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
