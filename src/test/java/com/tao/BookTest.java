package com.tao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transaction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/beans-test.xml"})
public class BookTest {
    @PersistenceUnit( unitName = "tempWarPU" )
    EntityManagerFactory emf;

    @Test
    public void test() {
        Book book = new Book();
        book.setTitle("Hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist( book );
        tx.commit();

        em.close();

    }
}
