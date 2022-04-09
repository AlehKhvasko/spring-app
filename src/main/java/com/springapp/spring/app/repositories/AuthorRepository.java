package com.springapp.spring.app.repositories;

import com.springapp.spring.app.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
