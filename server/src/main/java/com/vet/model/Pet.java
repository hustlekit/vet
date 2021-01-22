package com.vet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "pet")
@SequenceGenerator(name = "pet_id", sequenceName = "seq_pet_id")
public class Pet {

    @Id
    @GeneratedValue(generator = "pet_id", strategy = GenerationType.AUTO)
    private Long id;
    private String species;
    private String name;
    private Double weight;
    private Integer age;
    @ManyToOne
    private User owner;
    @OneToMany(mappedBy = "pet")
    private List<Appointment> appointments;

    public Pet() {
    }

    public Pet(Long id, String species, String name, Double weight, Integer age, User owner, List<Appointment> appointments) {
        this.id = id;
        this.species = species;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
