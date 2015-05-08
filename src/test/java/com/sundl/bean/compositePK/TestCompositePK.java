package com.sundl.bean.compositePK;

import com.sundl.bean.CompositePK.AirLine;
import com.sundl.bean.CompositePK.AirLinePK;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Sun on 2015/5/9.
 */
public class TestCompositePK {

    @Test
    public void testSave() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sun");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        AirLinePK airLinePK = new AirLinePK();
        airLinePK.setStartCity("上海");
        airLinePK.setEndCity("北京");

        AirLine airLine = new AirLine();
        airLine.setId(airLinePK);
        airLine.setName("航线");

        em.persist(airLine);

        em.getTransaction().commit();

        em.close();
        factory.close();
    }
}
