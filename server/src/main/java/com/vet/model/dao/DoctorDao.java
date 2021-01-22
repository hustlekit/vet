package com.vet.model.dao;

import lombok.Data;

import java.util.List;

@Data
public class DoctorDao {
    private Long id;
    private String name;
    private List<Long> appointments;
}
