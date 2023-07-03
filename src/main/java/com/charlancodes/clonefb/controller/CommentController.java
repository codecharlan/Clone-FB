package com.charlancodes.clonefb.controller;

import com.charlancodes.clonefb.model.Comment;
import com.charlancodes.clonefb.model.Post;
import com.charlancodes.clonefb.model.User;
import com.charlancodes.clonefb.service.implementation.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("api/comments")
public class CommentController {
    private final CommentServiceImpl commentService;

    @Autowired
    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/all-posts/comments")
    public String getAllComments(Model model){
        model.addAttribute("comments", commentService.getAllComment());
        return "dashboard";
    }
    @GetMapping("/create-comment")
    public String showCommentForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "createcomment";
    }
    @PostMapping("/create-comment")
    public String createComment(@ModelAttribute("comment") Comment comment, User user) {
        comment.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        commentService.createComment(comment);
        return "redirect:/api/posts/all-posts";
    }
    @GetMapping("/editcomment/{id}")
    public String commentUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("comment", commentService.getCommentsById(id).get());
        return "updatecomment";
    }
    @PostMapping("/editcomment/{id}")
    public String updateComment(@PathVariable Long id,
                             @ModelAttribute("comment") Comment comment,
                             HttpSession session) {
        User user = (User) session.getAttribute("user");
        // get student from database by id
//        post.setUser(user);
        System.out.println(user);
        Comment postById = commentService.getCommentsById(id).get();
        postById.setId(id);
        postById.setContent(comment.getContent());
        postById.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));

        // save updated student object
        commentService.updateComment(postById);
        return "redirect:/api/posts/all-posts";
    }

    @GetMapping("/deletecomment/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return "redirect:/api/posts/all-posts";
    }


}


