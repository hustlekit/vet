package com.vet.model.dao;

import lombok.Data;

import java.util.Date;

@Data
public class ListAppointmentItemDao {

    private Date date;
    private Long petId;
    private Long doctorId;
    private Long userId;
}
