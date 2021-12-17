package dao;

import classfiles.Dish;

import java.util.List;

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
}


