package com.example.demogame.user;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;

    public User() {

    }

    public User(String first_name, String last_name, String email, String password_md5) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password_md5;
    }

    public User(Long user_id) {
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public void setPassword(String password_md5) {
        this.password = password_md5;
    }
}
