package com.vet.model.util;

import com.vet.model.Pet;
import com.vet.model.dao.PetDao;

public class PetMapper {

    public static PetDao map(Pet source) {
        PetDao result = new PetDao();
        result.setId(source.getId());
        result.setName(source.getName());
        return result;
    }
}
