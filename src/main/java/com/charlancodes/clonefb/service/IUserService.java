package com.charlancodes.clonefb.service;

import com.charlancodes.clonefb.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User getUserById(long id);
    User getUserByEmail(String email);
    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUser();
}
