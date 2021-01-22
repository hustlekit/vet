package com.vet.model.dao;

import lombok.Data;

import java.util.List;

@Data
public class UserDao {

    private Long id;
    private Integer login;
    private Integer pin;
    private String firstName;
    private String lastName;
    private List<Long> pets;
}
