package com.vet.controller;

import com.vet.model.Pet;
import com.vet.model.dao.PetDao;
import com.vet.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/pet")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(path = "/getAllByUserId/{id}", produces = "application/json")
    public ResponseEntity<List<PetDao>> getAllByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(petService.getAllByUserId(id), HttpStatus.OK);
    }
}
