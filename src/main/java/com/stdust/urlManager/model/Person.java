package com.stdust.urlManager.model;

import com.stdust.urlManager.constraints.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @Column(name = "username")
    @NotEmpty(message = "Name shouldn't be empty")
    private String username;

    @ValidPassword
    @Column(name = "password")
//    @Size(min = 1, max = 5, message = "Password should contain from 7 to 23 characters")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "collectionOwner")
    private List<Collection> collectionsOfUser;

    public Person() {
    }

    public Person(String username, String password) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int id) {
        this.personId = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Collection> getCollectionsOfUser() {
        return collectionsOfUser;
    }

    public void setCollectionsOfUser(List<Collection> collectionsOfUser) {
        this.collectionsOfUser = collectionsOfUser;
    }

    public boolean isAdmin() {
        return this.getRole().equals("ROLE_ADMIN");
    }
}