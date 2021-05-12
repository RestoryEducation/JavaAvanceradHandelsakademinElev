package com.example.springbootproject.entity;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class User extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="username")
    private String name;
    private String password;
    private String img;

    public User() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
