import classfiles.Restaurant;
import io.IOUtils;
import management.CourierManagement;
import management.DishManagement;
import management.RestaurantManagement;
import menues.RunMenu;

import javax.persistence.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        IOUtils ioUtils = new IOUtils();
        RunMenu runMenu = new RunMenu();
        RestaurantManagement rm = new RestaurantManagement(emf,ioUtils);

       // rm.createRestaurant();

       EntityManager em= emf.createEntityManager();

//        TypedQuery<Restaurant> x = em.createQuery("SELECT r FROM Restaurant r", Restaurant.class);
//        System.out.println(x.getResultList());

       CourierManagement cm = new CourierManagement(emf, ioUtils);
       DishManagement dm = new DishManagement(emf, ioUtils);
       dm.createDish();


        //Här gör vi instanser av management-klasser / Implement-klasser
        //Här loopar vi main-menyn
    }
}
