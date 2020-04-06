package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    @RequestMapping("{id}")
    public BookEntity get(@PathVariable Long id) {
        return bookRepository.getOne(id);
    }

    @GetMapping
    public List<BookEntity> list() {
        return bookRepository.findAll();
    }

    @GetMapping
    @RequestMapping("test")
    public String test() {
        return "OK";
    }
}