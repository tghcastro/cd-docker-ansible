package com.example.demo;

import com.example.demo.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.BookRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class RestService {
    private BookRepository bookRepository;

    @Autowired
    public RestService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String getBookStats(Long id){
        BookEntity book= bookRepository.getOne(id);
        String result="{ID : "+book.getId().toString()+",Title : "+book.getTitle()+",Author :"+ book.getAuthor()+" }";

        return result;
    }
}
