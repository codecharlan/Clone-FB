package com.charlancodes.clonefb.controller;

import com.charlancodes.clonefb.model.Post;
import com.charlancodes.clonefb.model.User;
import com.charlancodes.clonefb.service.implementation.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("api/posts")
public class PostController {
    private final PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping("/all-posts")
    public String getAllPost (Model model){
        model.addAttribute("posts", postService.getAllPost());
        return "dashboard";
    }
    @GetMapping("/create-post")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "createpost";
    }
    @PostMapping("/create-post")
    public String createPost(@ModelAttribute("post") Post post, User user) {
        post.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
//        post.setUser_id(user.getId());
        postService.createPost(post);
        return "redirect:/api/posts/all-posts";
    }

    @GetMapping("/editpost/{id}")
    public String postUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "updatepost";
    }
    @PostMapping("/editpost/{id}")
    public String updatePost(@PathVariable Long id,
                             @ModelAttribute("post") Post post,
                             HttpSession session) {
        User user = (User) session.getAttribute("user");
        // get student from database by id
//        post.setUser(user);
        System.out.println(user);
        Post postById = postService.getPostById(id);
        postById.setId(id);
        postById.setTitle(post.getTitle());
        postById.setContent(post.getContent());
        postById.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));

        // save updated student object
        postService.updatePost(postById);
        return "redirect:/api/posts/all-posts";
    }

    @GetMapping("/deletepost/{id}")
    public String deleteUser(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/api/posts/all-posts";
    }

}
