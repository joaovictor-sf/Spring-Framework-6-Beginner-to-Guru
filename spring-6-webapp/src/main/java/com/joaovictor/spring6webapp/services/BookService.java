package com.joaovictor.spring6webapp.services;

import com.joaovictor.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
