package main;

import classfiles.FoodOrder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class mainTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        FoodOrder foodOrder = new FoodOrder();
        em.getTransaction().commit();
    }
}
