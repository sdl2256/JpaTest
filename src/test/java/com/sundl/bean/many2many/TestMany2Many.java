package com.sundl.bean.many2many;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Sun on 2015/5/8.
 */
public class TestMany2Many {

    @Test
    public void testSave() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Student student = new Student("张三");
        Teacher teacher = new Teacher("王老师");
        em.persist(student);
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
        factory.close();

    }

    /**
     * 建立关系
     *
     * @throws Exception
     */

    @Test
    public void testbuildTS() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Student student = em.find(Student.class, 1);
        Teacher teacher = em.find(Teacher.class, 1);
        student.addTeacher(teacher);

        em.getTransaction().commit();
        em.close();
        factory.close();

    }

    /**
     * 解除关系
     *
     * @throws Exception
     */
    @Test
    public void testdeleteTS() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Student student = em.find(Student.class, 1);
        Teacher teacher = em.find(Teacher.class, 1);
        student.removeTeacher(teacher);

        em.getTransaction().commit();
        em.close();
        factory.close();

    }

    /**
     * 删除老师
     *
     * @throws Exception
     */
    @Test
    public void testdeleteTeacher() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();


        Student student = em.find(Student.class, 1);
        Teacher teacher = em.getReference(Teacher.class, 1);
        student.removeTeacher(teacher);

//        em.remove(em.getReference(Teacher.class, 1);

        em.remove(teacher);

        em.getTransaction().commit();
        em.close();
        factory.close();

    }

    /**
     * 删除学生
     *
     * @throws Exception
     */
    @Test
    public void testdeleteStudent() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();


        Student student = em.find(Student.class, 1);

        em.remove(student);

        em.getTransaction().commit();
        em.close();
        factory.close();

    }
}
