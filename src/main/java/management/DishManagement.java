package management;

import applicationContext.ApplicationContext;
import applicationContext.ApplicationManagers;
import classfiles.Dish;
import classfiles.FoodOrder;
import classfiles.Restaurant;
import dao.DishDao;
import io.IOUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class DishManagement implements DishDao {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    @Override
    public List<Dish> getAllDishes() {
        EntityManager em = emf.createEntityManager();

        List<Dish> allDishes = em.createNamedQuery("Dish.findAllDishes", Dish.class)
                .getResultList();

        em.close();

        return allDishes;
    }

    @Override
    public Dish createDish() {
        String name = ioUtils.askForName();
        double price = ioUtils.askForPrice();

        return new Dish(name, price);
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
        ioUtils.printAllDishes();

        EntityManager em = emf.createEntityManager();
        int id = ioUtils.askForDishId();

        Dish dish = em.find(Dish.class, id);

        em.close();
        return dish;
    }

    @Override
    public void updatePrice() {
        ioUtils.printAllDishes();

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

        if (restaurant != null) {
            List<Dish> dishes = restaurant.getDishes();

            for (Dish dish2 : dishes
            ) {
                if (dish2.getId() == id) {
                    dish2 = null;
                }
            }
        }

        List<FoodOrder> foodOrders = dish.getOrders();

        for (FoodOrder foodOrder : foodOrders) {
            for (Dish foodOrderDish : foodOrder.getDishes()) {
                if (dish.getId() == id) {
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
        return dish != null;
    }

    public String getMostPopularDish() {
        List<FoodOrder> orders = ApplicationManagers.getInstance().getFoodOrderManagement().getAllOrders();
        List<Dish> allOrderedDishes = new ArrayList<>();
        List<String> namesOfAllOrderedDishes = new ArrayList<>();

        for (FoodOrder order : orders) allOrderedDishes.addAll(order.getDishes());
        for (Dish dish : allOrderedDishes) namesOfAllOrderedDishes.add(dish.getName());

        String mostCommonDish = "";
        int countMostCommonDish = 0;

        for (int i = 0; i < namesOfAllOrderedDishes.size(); i++) {
            int count = Collections.frequency(namesOfAllOrderedDishes, namesOfAllOrderedDishes.get(i));

            if (count > countMostCommonDish) {
                countMostCommonDish = count;
                mostCommonDish = namesOfAllOrderedDishes.get(i);
            }
        }

        return mostCommonDish;
    }

    public Optional<Double> getMaxPrice() {
        EntityManager em = emf.createEntityManager();

        Stream<Dish> allDishes = em.createNamedQuery("Dish.findAllDishes", Dish.class)
                .getResultStream();

        return allDishes
                .map(Dish::getPrice)
                .max(Double::compareTo);
    }
}

