package com.springapp.spring.app.repositories;

import com.springapp.spring.app.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
