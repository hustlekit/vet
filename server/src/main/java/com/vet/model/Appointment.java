package com.vet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "appointment")
@SequenceGenerator(name = "appointment_id", sequenceName = "seq_appointment_id")
public class Appointment {

    @Id
    @GeneratedValue(generator = "appointment_id", strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    @ManyToOne
    private Pet pet;
    @ManyToOne
    private Doctor doctor;

    public Appointment() {
    }

    public Appointment(Long id, Date date, Pet pet, Doctor doctor) {
        this.id = id;
        this.date = date;
        this.pet = pet;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return getId().toString() + getDate().toString() + getDoctor().getFirstName() + getPet().getName();
    }
}
