package management;

import java.util.List;

public class DishManagement {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public void addADish(Dish dish) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(dish);
        em.getTransaction().commit();

        em.close();
    }

    public List<Dish> showAllDishes() {
        EntityManager em = emf.createEntityManager();

        List<Dish> allDishes = em.createQuery("SELECT dish FROM Dish dish", Dish.class)
                .getResultList();

        em.close();

        return allDishes;
    }

    public void updatePrice(int id, int newPrice) {
        EntityManager em = emf.createEntityManager();

        Dish dish = em.find(Dish.class, id);

        em.getTransaction().begin();
        dish.setPrice(newPrice);
        em.getTransaction().commit();

        em.close();
    }

    public void removeDish(Dish dish) {
        EntityManager em = emf.createEntityManager();

        //TODO remove from lists

        em.getTransaction().begin();
        em.remove(dish);
        em.getTransaction().commit();

        em.close();
    }
}

