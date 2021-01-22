package com.vet.service;

import com.vet.model.User;
import com.vet.model.dao.UserDao;
import com.vet.model.util.UserMapper;
import com.vet.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDao getUserByLogin(Integer login, Integer pin) {
        UserDao result = new UserDao();
        User user = userRepository.getUserByLogin(login);
        if (user.getPin().equals(pin)) {
            result = UserMapper.map(user);
            return result;
        } else {
            return null;
        }
    }
}
