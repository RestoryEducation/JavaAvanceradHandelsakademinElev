package com.example.springbootproject.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

    private String address;
    private String firstname;
    private String lastname;

    public Person() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
