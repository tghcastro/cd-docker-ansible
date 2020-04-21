package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity create(@RequestBody final BookEntity session){
        // How should we validate data?
        return bookRepository.saveAndFlush(session);
    }
}