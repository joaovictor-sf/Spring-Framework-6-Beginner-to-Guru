package com.joaovictor.spring6webapp.services;

import com.joaovictor.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
