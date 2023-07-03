package com.charlancodes.clonefb.repository;


import com.charlancodes.clonefb.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post, Long> {
}
