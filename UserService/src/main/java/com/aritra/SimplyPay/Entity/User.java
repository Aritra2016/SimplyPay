package com.aritra.SimplyPay.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="app_user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String mail ;
    private String password;

    //NoArg Constructor
    public User(){

    }

    //AllArg Contructor
    public User(Long id, String name, String mail, String password) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
