package com.sundl.bean;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Sun on 2015/5/8.
 */
public class TestUser {

    @BeforeClass
    public static void setUpBeforeClass() {

    }

    @Test
    public void testSave() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        User user = new User("王老五");
        em.persist(user);
        em.getTransaction().commit();

        em.close();
        factory.close();
    }

    @Test
    public void testFind() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        User user = em.find(User.class, 1);
        /**
         * 用了一分钟，别人修改数据库
         */
        em.refresh(user);
        System.out.println(user.getName());
        em.close();
        factory.close();

    }

    @Test
    public void testgetReference() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        //延迟加载
        User user = em.getReference(User.class, 1);
        //获取对象，数据不存在则抛异常
        System.out.println(user.getName());
        em.close();
        factory.close();

    }

    @Test
    public void testUpdate() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, 1);
        System.out.println(user.getName());

        user.setName("老王");
        System.out.println(user.getName());
        em.getTransaction().commit();
        System.out.println(user.getName());

        em.close();
        factory.close();

        //更新条件
        // 开启事务，托管状态

        //NEW、托管、游离(脱管)、删除
    }

    @Test
    public void testUpdate2() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, 1);
        System.out.println(user.getName());

        em.clear();//把实体管理器中所有实体变为游离对象
        user.setName("老王");
        em.merge(user); //把游离状态实体同步到数据库
        System.out.println(user.getName());
        em.getTransaction().commit();
        System.out.println(user.getName());

        em.close();
        factory.close();
    }

    @Test
    public void testDelete() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, 1);
        em.remove(user);
        em.getTransaction().commit();
        em.close();
        factory.close();
    }


}
