package com.vet.model.dao;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDao {

    private Long id;
    private Date date;
    private Long petId;
    private String petName;
    private Long doctorId;
    private String doctorName;
    private Long userId;
}
