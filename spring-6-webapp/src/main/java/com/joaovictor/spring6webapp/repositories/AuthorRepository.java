package com.joaovictor.spring6webapp.repositories;

import com.joaovictor.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
