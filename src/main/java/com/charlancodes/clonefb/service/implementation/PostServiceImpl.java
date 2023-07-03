package com.charlancodes.clonefb.service.implementation;

import com.charlancodes.clonefb.model.Post;
import com.charlancodes.clonefb.repository.IPostRepo;
import com.charlancodes.clonefb.repository.IUserRepo;
import com.charlancodes.clonefb.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {
    private final IPostRepo postRepo;

    @Autowired
    public PostServiceImpl(IPostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Post getPostById(long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public Post createPost(Post post) {
            postRepo.save(post);
        return post;
    }

    @Override
    public Post updatePost(Post post) {
        postRepo.save(post);
        return post;
    }

    @Override
    public Optional<Post> deletePost(long id) {
        postRepo.deleteById(id);
        return Optional.empty();
    }

    @Override
    public List<Post> getAllPost() {
        return postRepo.findAll();
    }
}
