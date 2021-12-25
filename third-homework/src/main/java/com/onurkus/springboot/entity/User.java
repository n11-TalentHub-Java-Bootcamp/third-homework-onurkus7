package com.onurkus.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
public class User implements Serializable {
    @SequenceGenerator(name = "generator",sequenceName = "USER_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID",nullable = false)
    private Long id;

    @Column(length = 50,name = "NAME")
    private String firstName;

    @Column(length = 50,name = "LAST_NAME")
    private String lastName;

    @Column(length = 50,name = "EMAIL")
    private String email;

    @Column(length = 15,name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(length = 20,name = "USER_NAME")
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
