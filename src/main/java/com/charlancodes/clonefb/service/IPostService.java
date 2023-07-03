package com.charlancodes.clonefb.service;
import com.charlancodes.clonefb.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    Post getPostById(long id);

    Post createPost(Post post);

    Post updatePost(Post post);

    Optional<Post> deletePost(long id);

    List<Post> getAllPost();
}
