package management;

import applicationContext.ApplicationContext;
import classfiles.Restaurant;
import dao.RestaurantDao;
import io.IOUtils;

import javax.persistence.*;
import java.util.List;

public class RestaurantManagement implements RestaurantDao {
    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    public List<Restaurant> showAllRestaurants() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Restaurant> query = em.createNamedQuery("Restaurant.showAllRestaurants", Restaurant.class);
        em.close();
        return query.getResultList();
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

    public void removeRestaurant(Restaurant restaurant) {
        EntityManager em = emf.createEntityManager();

        int restaurantId = ioUtils.askForId();
        Restaurant restaurant2 = em.find(Restaurant.class, restaurantId);
        if (restaurant2 != null) {
            em.remove(em.find(Restaurant.class, restaurantId));
            System.out.println("Restaurant with id " + restaurantId + " and name " + restaurant.getRestaurantName() + " has been removed");
            //Är det möjligt att ha printouten i IOUtils? Eller ska den tas bort?
        } else {
            System.out.println("There is no restaurant with id: " + restaurantId);
        }
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
}
