package org.example.movie_theater_2.util;


public class AuthRequest {
    private String username;
    private String password;

    // Конструктор без параметрів
    public AuthRequest() {
    }

    // Конструктор з параметрами
    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Гетери та сетери
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
