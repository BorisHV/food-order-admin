package management;

import classfiles.Restaurant;
import dao.RestaurantDao;
import instance.ApplicationContext;
import instance.CreateInstance;
import io.IOUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class RestaurantManagement implements RestaurantDao {
    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();
    Scanner scanner = new Scanner(System.in);

    public List<Restaurant> showAllRestaurants() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Restaurant> query = em.createNamedQuery("Restaurant.showAllRestaurants", Restaurant.class);
        em.close();
        return query.getResultList();
    }

    public Restaurant createRestaurant() {
        EntityManager em = emf.createEntityManager();

        Restaurant restaurant = new Restaurant();
        ioUtils.askForName();
        restaurant.setRestaurantName(ioUtils.readString());
        ioUtils.askForAddress();
        restaurant.setAdress(ioUtils.readString());
        ioUtils.askForCategory();

        restaurant.setCategory(ioUtils.readString());

        em.getTransaction().begin();
        em.persist(restaurant);
        em.getTransaction().commit();
        em.close();

        return restaurant;
    }

    public void addRestaurant(Restaurant restaurant) {
        //Adda till vaddå?
    }

    public void removeRestaurant(Restaurant restaurant) {
        EntityManager em = emf.createEntityManager();

        int restaurantId = ioUtils.askForId();
        Restaurant restaurant2 = em.find(Restaurant.class, restaurantId);
        em.remove(em.find(Restaurant.class, restaurantId));
        System.out.println("Restaurant with id " + restaurantId + " and name " + restaurant.getRestaurantName() + " has been removed");
    }

    public void updateAdressById() {
        EntityManager em = emf.createEntityManager();

        int restaurantId = ioUtils.askForId();
        Restaurant restaurant = em.find(Restaurant.class, restaurantId);
        String adress = ioUtils.askForAddress();
        em.getTransaction().begin();
        restaurant.setAdress(adress);
        em.getTransaction().commit();
        em.close();
    }
}
