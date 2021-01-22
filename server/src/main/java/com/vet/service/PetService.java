package com.vet.service;

import com.vet.model.Pet;
import com.vet.repository.PetRepository;
import org.springframework.stereotype.Component;

@Component
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet getById(Long id) {
        return petRepository.findById(id).get();
    }
}
