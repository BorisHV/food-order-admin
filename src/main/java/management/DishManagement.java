package management;

import java.util.List;

import applicationContext.ApplicationContext;
import classfiles.Dish;
import classfiles.FoodOrder;
import classfiles.Restaurant;
import dao.DishDao;
import io.IOUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class DishManagement implements DishDao {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    @Override
    public List<Dish> getAllDishes() {
        EntityManager em = emf.createEntityManager();

        List<Dish> allDishes = em.createQuery("SELECT dish FROM Dish dish", Dish.class)
                .getResultList();

        em.close();

        return allDishes;
    }

    @Override
    public Dish createDish() {
        String name = ioUtils.askForName();
        double price = ioUtils.askForPrice();

        Dish dish = new Dish(name, price);
        return dish;
    }

    public void addDish(Dish dish) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(dish);
        em.getTransaction().commit();

        em.close();
    }


    @Override
    public Dish findDishById() {
        EntityManager em = emf.createEntityManager();
        int id = ioUtils.askForDishId();

        Dish dish = em.find(Dish.class, id);

        em.close();
        return dish;
    }

    @Override
    public void updatePrice() {
        int id = ioUtils.askForDishId();
        double newPrice = ioUtils.askForPrice();

        EntityManager em = emf.createEntityManager();

        Dish dish = em.find(Dish.class, id);
        em.getTransaction().begin();
        dish.setPrice(newPrice);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void connectExistingDishToExistingRestaurant() {

        ApplicationContext.getInstance().getIOUTILS().printAllDishes();
        int dishId = ioUtils.askForDishId();

        ApplicationContext.getInstance().getIOUTILS().printAllRestaurants();
        int restaurantId = ioUtils.askForRestaurantId();


        EntityManager em = emf.createEntityManager();
        Dish dish = em.find(Dish.class, dishId);
        Restaurant restaurant = em.find(Restaurant.class, restaurantId);

        em.getTransaction().begin();
        dish.addRestaurant(restaurant);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void connectExistingDishToExistingFoodOrder() {
        ApplicationContext.getInstance().getIOUTILS().printAllDishes();
        int dishId = ioUtils.askForDishId();

        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForFoodOrderId();

        EntityManager em = emf.createEntityManager();
        Dish dish = em.find(Dish.class, dishId);
        FoodOrder foodOrder = em.find(FoodOrder.class, orderId);

        em.getTransaction().begin();
        dish.addOrder(foodOrder);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeDish() {
        ioUtils.printAllDishes();
        EntityManager em = emf.createEntityManager();
        int id = ioUtils.askForDishId();

        Dish dish = em.find(Dish.class, id);
        Restaurant restaurant = dish.getRestaurant();

        em.getTransaction().begin();

        if(restaurant != null) {
            List<Dish> dishes = restaurant.getDishes();

            for (Dish dish2 : dishes
            ) {
                if (dish2.getId() == id) {
                    dish2 = null;
                }
            }
        }

        List<FoodOrder> foodOrders = dish.getOrders();

        for (FoodOrder foodOrder: foodOrders) {
            for(Dish foodOrderDish : foodOrder.getDishes()){
                if (dish.getId() == id){
                    foodOrderDish = null;
                }
            }
        }


        em.remove(dish);
        em.getTransaction().commit();
        em.close();
    }

    public boolean checkDishId(int id) {
        EntityManager em = emf.createEntityManager();
        Dish dish = em.find(Dish.class, id);
        if (dish == null) {
            return false;
        } else {
            return true;
        }
    }
}

