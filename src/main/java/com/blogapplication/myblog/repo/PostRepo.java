package com.blogapplication.myblog.repo;

import com.blogapplication.myblog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post , Long> {


}
