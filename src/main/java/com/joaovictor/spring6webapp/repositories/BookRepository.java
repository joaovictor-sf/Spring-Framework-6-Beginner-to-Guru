package com.joaovictor.spring6webapp.repositories;

import com.joaovictor.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
