package com.example.demo;

import com.example.demo.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<BookEntity,Long> {
}
