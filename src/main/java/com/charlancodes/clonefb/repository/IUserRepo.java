package com.charlancodes.clonefb.repository;


import com.charlancodes.clonefb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IUserRepo extends JpaRepository<User, Long> {
    User findByEmailAddress(String email);
}
