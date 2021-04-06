package com.games.online.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank(message = "Email is required.")
    @Size(min = 3, max = 50, message = "Email should be between 3 and 50 characters.")
    @Email(message = "Email should be valid!")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 4, max = 120, message = "Password should be between 4 and 120 characters.")
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(
            @NotBlank(message = "Username is required.") @Size(min = 3, max = 50) String username,
            @NotBlank(message = "Email is required.") @Size(min = 3, max = 50, message = "Email should be between 3 and 50 characters.") @Email(message = "Email should be valid!") String email,
            @NotBlank(message = "Password is required.") @Size(min = 4, max = 120, message = "Password should be between 4 and 120 characters.") String password
    ) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
