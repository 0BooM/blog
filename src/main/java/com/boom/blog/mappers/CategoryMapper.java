package com.boom.blog.mappers;

import com.boom.blog.domain.PostStatus;
import com.boom.blog.domain.dtos.CategoryDto;
import com.boom.blog.domain.dtos.CreateCategoryRequest;
import com.boom.blog.domain.entities.Category;
import com.boom.blog.domain.entities.Post;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy =  ReportingPolicy.IGNORE)
public interface CategoryMapper {
    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (null == posts || posts.isEmpty()) {
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus())).
                count();
    }
}
