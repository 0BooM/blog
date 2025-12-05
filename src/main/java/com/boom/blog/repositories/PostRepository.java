package com.boom.blog.repositories;

import com.boom.blog.domain.PostStatus;
import com.boom.blog.domain.entities.Category;
import com.boom.blog.domain.entities.Post;
import com.boom.blog.domain.entities.Tag;
import com.boom.blog.domain.entities.User;
import com.boom.blog.services.PostService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus status, Category category, Tag tag);
    List<Post> findAllByStatusAndCategory(PostStatus status, Category category);
    List<Post> findAllByStatusAndTagsContaining(PostStatus postStatus, Tag tag);
    List<Post> findAllByStatus(PostStatus postStatus);
    List<Post> findAllByAuthorAndStatus(User author, PostStatus status);
}
