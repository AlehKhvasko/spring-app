package com.springapp.spring.app.repositories;

import com.springapp.spring.app.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository <Publisher, Long> {
}
