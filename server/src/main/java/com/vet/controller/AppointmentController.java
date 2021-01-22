package com.vet.controller;

import com.vet.model.dao.AppointmentDao;
import com.vet.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/appointment")
public class AppointmentController {

    private AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping(path = "/getAllByPetsIds", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<AppointmentDao>> getAllByPetsIds(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(service.getAllByPetsIds(ids), HttpStatus.OK);
    }
}
