package com.boom.blog.services;

import com.boom.blog.domain.dtos.PostDto;
import com.boom.blog.domain.entities.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
}
