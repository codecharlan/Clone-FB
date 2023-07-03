package com.charlancodes.clonefb.repository;


import com.charlancodes.clonefb.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepo extends JpaRepository<Like, Long> {
}
