package com.sundl.bean;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

/**
 * Created by Sun on 2015/5/8.
 */
public class TestOneToMany {

    @Test
    public void testSave() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Order order = new Order();
        order.setAmount(34f);
        order.setOrderId("1111");
        OrderItem item = new OrderItem();
        item.setProductName("item1");
        item.setSellPrice(90f);
        OrderItem item2 = new OrderItem();
        item2.setProductName("item2");
        item2.setSellPrice(80f);
        OrderItem item3 = new OrderItem();
        item3.setProductName("橄榄球");
        item3.setSellPrice(70f);

        order.addOrderItem(item);
        order.addOrderItem(item2);
        order.addOrderItem(item3);
        em.persist(order);

        em.getTransaction().commit();
        em.close();
        factory.close();

    }
}
