package com.vet.controller;

import com.vet.model.dao.DoctorDao;
import com.vet.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/doctor")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<DoctorDao>> getAll() {
        return new ResponseEntity<>(doctorService.getAll(), HttpStatus.OK);
    }
}
