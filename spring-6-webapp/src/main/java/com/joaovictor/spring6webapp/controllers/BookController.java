package com.joaovictor.spring6webapp.controllers;

import com.joaovictor.spring6webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
     private final BookService bookService;

     public BookController(BookService bookService) {
         this.bookService = bookService;
     }

     @RequestMapping("/books")
     public String getBooks(Model model) {
         // Model é um objeto que é passado para a view, e a view pode acessar os dados que estão dentro dele.
         model.addAttribute("books", bookService.findAll());
         return "books";
     }
}
