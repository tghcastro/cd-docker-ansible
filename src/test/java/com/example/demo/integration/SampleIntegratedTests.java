package com.example.demo.integration;

import com.example.demo.BookEntity;
import com.example.demo.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class SampleIntegratedTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void sampleIntegrated1Test() {
        //given
        BookEntity lor = new BookEntity();
        lor.setTitle("Lord of The Rings");
        lor.setAuthor("Tolkien");

        entityManager.persist(lor);
        entityManager.flush();

        //when
        BookEntity found = bookRepository.getOne(lor.getId());

        //then
        assertThat(found.getTitle(), is(lor.getTitle()));
    }
}
