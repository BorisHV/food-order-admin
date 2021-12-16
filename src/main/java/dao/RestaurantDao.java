package dao;

import classfiles.Restaurant;

import java.util.List;

public interface RestaurantDao {

    List<Restaurant> showAllRestaurants();
    Restaurant findRestaurantById();
    Restaurant createRestaurant();
    void addRestaurant(Restaurant restaurant);
    void removeRestaurant();
    void updateAdressById();
    void connectExistingRestaurantToExistingDish();
}



