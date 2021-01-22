package com.vet.service;

import com.vet.model.Pet;
import com.vet.model.dao.PetDao;
import com.vet.model.util.PetMapper;
import com.vet.repository.PetRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<PetDao> getAllByUserId(Long id) {
        List<PetDao> result = new ArrayList<>();
        List<Pet> tempPetList = petRepository.findAllByOwnerId(id);
        for (Pet v : tempPetList) {
            result.add(PetMapper.map(v));
        }
        return result;
    }

    public Pet getById(Long id) {
        return petRepository.findById(id).get();
    }
}
