package com.nnz.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnz.manytomany.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
