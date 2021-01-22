package com.vet.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(min = 4, max = 4)
    private Integer login;
    @Length(min = 4, max = 4)
    private Integer pin;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    public User() {
    }

    public User(Long id, @Length(min = 4, max = 4) Integer login, @Length(min = 4, max = 4) Integer pin, String firstName, String lastName, List<Pet> pets) {
        this.id = id;
        this.login = login;
        this.pin = pin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = pets;
    }

    public Long getId() {
        return id;
    }

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
