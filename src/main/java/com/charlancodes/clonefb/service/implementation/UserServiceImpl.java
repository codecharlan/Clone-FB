package com.charlancodes.clonefb.service.implementation;

import com.charlancodes.clonefb.model.User;
import com.charlancodes.clonefb.repository.IUserRepo;
import com.charlancodes.clonefb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepo userRepo;

    @Autowired
    public UserServiceImpl(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public User getUserById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmailAddress(email);
    }

    @Override
    public User updateUser(User user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
