package com.vinibelo.repository;

import domain.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PostStub {
    private final Map<UUID, Post> posts = new HashMap<>();

    public UUID savePost(Post post) {
        posts.put(post.getId(), post);
        return post.getId();
    }

    public void deletePost(UUID id) {
        posts.remove(id);
    }

    public List<Post> getAll() {
        return posts.values().stream().toList();
    }
}
