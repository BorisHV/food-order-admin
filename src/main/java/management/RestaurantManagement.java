package management;

import classfiles.Restaurant;
import dao.RestaurantDao;

import javax.persistence.*;
import java.util.List;

//@Id
//@GeneratedValue
//private Long id;
//@Basic
//private String restaurantName;
//@Basic
//private String adress;
//@Basic
//private String category;
//@OneToMany(mappedBy = "restaurant")
//private List<Dish> dishes;

public class RestaurantManagement implements RestaurantDao {


    public List<Restaurant> showAllRestaurants() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Restaurant> q = em.createQuery("SELECT r FROM Restaurant r", Restaurant.class);
        List<Restaurant> restaurantList = q.getResultList();
        return restaurantList;
        em.close();
    }

    public Restaurant createRestaurant() {

        EntityManager em = emf.createEntityManager();

        Restaurant r = new Restaurant();
        System.out.println("Name of restaurant: ");
        r.setRestaurantName(readString());
        System.out.println("Adress of restaurant: ");
        r.setAdress(readString());
        System.out.println("Category of restaurant: ");
        r.setCategory(readString());
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();

        return r;
    }

    public void addRestaurant(Restaurant restaurant) {
        //Adda till vaddå?
    }

    public void removeRestaurant(Restaurant restaurant) {

        EntityManager em = emf.createEntityManager();

        System.out.println("ID of restaurant to remove: ");
        Restaurant r = em.find(readInt());
        em.remove(em.find(readInt()));
        System.out.println("Restaurant with id " + readint() + " and name " + r.getRestaurantName() + " has been removed");
    }

    public void updateAdressById() {

        EntityManager em = emf.createEntityManager();

        System.out.println("ID of restaurant you want to change adress on: ");
        Restaurant r = em.find(readInt());
        System.out.println("New adress: ");
        em.getTransaction().begin();
        r.setAdress(readString());
        em.getTransaction().commit();
        em.close();
    }
}
