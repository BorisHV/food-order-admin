package dao;

import classfiles.Dish;

import java.util.List;
import java.util.Optional;

public interface DishDao {

    List<Dish> getAllDishes();

    Dish findDishById();

    Dish createDish();

    void addDish(Dish dish);

    void removeDish();

    void updatePrice();

    void connectExistingDishToExistingRestaurant();

    void connectExistingDishToExistingFoodOrder();

    boolean checkDishId(int id);

    String getMostPopularDish();

    Optional<Double> getMaxPrice();
}


