package com.charlancodes.clonefb.service;

import com.charlancodes.clonefb.model.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    Comment createComment(Comment comment);

    Comment updateComment(Comment comment);

    Optional<Comment> deleteComment(Long commentId);

    List<Comment> getAllComment();

    Optional<Comment> getCommentsByPostId(Long postId);
}
