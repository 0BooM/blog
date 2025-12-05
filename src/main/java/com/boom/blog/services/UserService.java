package com.boom.blog.services;

import com.boom.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
