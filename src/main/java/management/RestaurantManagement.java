package management;

import applicationContext.ApplicationContext;
import classfiles.Customer;
import classfiles.Dish;
import classfiles.Order;
import classfiles.Restaurant;
import dao.RestaurantDao;
import io.IOUtils;
import main.MainProgram;

import javax.persistence.*;
import java.util.List;

public class RestaurantManagement implements RestaurantDao {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    public List<Restaurant> getAllRestaurants() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Restaurant> query = em.createNamedQuery("Restaurant.showAllRestaurants", Restaurant.class);
        //em.close(); Gick ej att ha denna rad här blir IllegatStateException
        return query.getResultList();
    }

    @Override
    public Restaurant findRestaurantById() {
        EntityManager em = emf.createEntityManager();
        int id = ioUtils.askForId();

        Restaurant restaurant = em.find(Restaurant.class, id);

        em.close();
        return restaurant;
    }

    public Restaurant createRestaurant() {
        EntityManager em = emf.createEntityManager();

        Restaurant restaurant = new Restaurant();
        String name = ioUtils.askForName();
        restaurant.setRestaurantName(name);
        String adress = ioUtils.askForAddress();
        restaurant.setAdress(adress);
        String category = ioUtils.askForCategory();
        restaurant.setCategory(category);

        em.getTransaction().begin();
        em.persist(restaurant);
        em.getTransaction().commit();
        em.close();

        return restaurant;
    }

    public void addRestaurant(Restaurant restaurant) {
        //Adda till vaddå?
    }

    public void removeRestaurant() {
        EntityManager em = emf.createEntityManager();

        int restaurantId = ioUtils.askForId();
        Restaurant restaurant = em.find(Restaurant.class, restaurantId);
        em.getTransaction().begin();
            em.remove(em.find(Restaurant.class, restaurantId));
            em.getTransaction().commit();
            em.close();
    }

    public void updateAdressById() {
        EntityManager em = emf.createEntityManager();

        int restaurantId = ioUtils.askForId();
        Restaurant restaurant = em.find(Restaurant.class, restaurantId);
        if (restaurant != null) {
            String adress = ioUtils.askForAddress();
            em.getTransaction().begin();
            restaurant.setAdress(adress);
            em.getTransaction().commit();
            em.close();
        } else {
            System.out.println("There is no restaurant with id : " + restaurantId);
        }
    }
    public void connectExistingRestaurantToExistingDish(){

        ApplicationContext.getInstance().getIOUTILS().printAllRestaurants();
        int restaurantId = ioUtils.askForId();

        ApplicationContext.getInstance().getIOUTILS().printAllDishes();
        int dishId = ioUtils.askForId();

        EntityManager em = emf.createEntityManager();
        Restaurant restaurant = em.find(Restaurant.class, restaurantId);
        Dish dish = em.find(Dish.class, dishId);

        em.getTransaction().begin();
        restaurant.addDish(dish);
        em.getTransaction().commit();
        em.close();
    }
}
