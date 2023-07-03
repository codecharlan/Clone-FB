package com.charlancodes.clonefb.service.implementation;

import com.charlancodes.clonefb.model.Comment;
import com.charlancodes.clonefb.repository.ICommentRepo;
import com.charlancodes.clonefb.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {
    private final ICommentRepo commentRepo;

    @Autowired
    public CommentServiceImpl(ICommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment createComment(Comment comment) {
        commentRepo.save(comment);
        return comment;
    }

    @Override
    public Comment updateComment(Comment comment) {
        commentRepo.save(comment);
        return comment;
    }

    @Override
    public Optional<Comment> deleteComment(Long commentId) {
        commentRepo.deleteById(commentId);
        return Optional.empty();
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepo.findAll();
    }

    @Override
    public Optional<Comment> getCommentsByPostId(Long postId) {
        return commentRepo.findById(postId);
    }

    public Optional<Comment> getCommentsById(Long commentId) {
        return commentRepo.findById(commentId);
    }
}
