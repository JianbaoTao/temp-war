package com.tao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transaction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/beans-test.xml", "/dataSource-test.xml"})
public class BookTest {

    @PersistenceContext EntityManager entityManager;

    @Transactional
    @Rollback(false)
    @Test
    public void test() {
        Book book = new Book();
        book.setTitle("Hello");

        entityManager.persist(book);

    }
}
