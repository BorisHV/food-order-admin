package dao;

import classfiles.Dish;

import java.util.List;

public interface DishDao {

    List<Dish> showAllDishes();
    Dish createDish();
    void addDish(Dish dish);
    void removeDish();
    void updatePrice();
}


