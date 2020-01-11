package com.nnz.manytomany.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnz.manytomany.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
