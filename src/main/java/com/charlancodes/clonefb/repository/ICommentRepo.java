package com.charlancodes.clonefb.repository;

import com.charlancodes.clonefb.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment, Long> {
}
