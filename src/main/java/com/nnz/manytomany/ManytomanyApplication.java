package com.nnz.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nnz.manytomany.model.Post;
import com.nnz.manytomany.model.Tag;
import com.nnz.manytomany.repository.PostRepository;
import com.nnz.manytomany.repository.TagRepository;

@SpringBootApplication
public class ManytomanyApplication implements CommandLineRunner {

	@Autowired
	private TagRepository tagRepository;

	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cleanup the tables
		
		/*
		 * postRepository.deleteAllInBatch(); tagRepository.deleteAllInBatch();
		 */

		// =======================================

		// Create a Post
		Post post = new Post("Hibernate Many to Many Example with Spring Boot demo1",
				"Learn how to map a many to many relationship using hibernate1",
				"Entire Post content with Sample code1");
		Post post1 = new Post("Hibernate Many to Many Example with Spring Boot1",
				"Learn how to map a many to many relationship using hibernate1",
				"Entire Post content with Sample code1");

		// Create two tags
		Tag tag1 = new Tag("Spring Boot1");
		Tag tag2 = new Tag("Hibernate1");
		Tag tag3 = new Tag("Hibernat2");
		Tag tag4 = new Tag("Hibernat3");


		// Add tag references in the post
		post.getTags().add(tag1);
		post.getTags().add(tag2);
		post1.getTags().add(tag3);
		post1.getTags().add(tag4);

		// Add post reference in the tags
		tag1.getPosts().add(post);
		tag2.getPosts().add(post);
		tag3.getPosts().add(post1);
		tag4.getPosts().add(post1);

		postRepository.save(post);
		postRepository.save(post1);

		// =======================================

	}
}
