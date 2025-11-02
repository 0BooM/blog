package com.boom.blog.services;

import com.boom.blog.domain.dtos.CategoryDto;
import com.boom.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}
