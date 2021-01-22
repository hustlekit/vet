package com.vet.model.util;

import com.vet.model.Pet;
import com.vet.model.User;
import com.vet.model.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDao map(User user) {
        UserDao result = new UserDao();
        result.setId(user.getId());
        result.setLogin(user.getLogin());
        result.setPin(user.getPin());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setPets(mapPets(user.getPets()));
        return result;
    }

    private static List<Long> mapPets(List<Pet> pets) {
        List<Long> result = new ArrayList<>();
        for (Pet p : pets) {
            result.add(p.getId());
        }
        return result;
    }
}
