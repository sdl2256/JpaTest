package com.sundl.bean.one2one;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Sun on 2015/5/8.
 */
public class TestOne2One {

    @Test
    public void testSave() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Person person = new Person("老张");
        IDCard idCard = new IDCard("11111111111111111");
//        idCard.setPerson(person);
        person.setCard(idCard);
        em.persist(person);
        em.getTransaction().commit();
        em.close();
        factory.close();

    }
}
