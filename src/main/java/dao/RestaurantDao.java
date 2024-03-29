package dao;

import classfiles.Restaurant;

import java.util.List;

public interface RestaurantDao {

    List<Restaurant> getAllRestaurants();

    Restaurant findRestaurantById();

    Restaurant createRestaurant();

    void addRestaurant(Restaurant restaurant);

    void removeRestaurant();

    void updateAddressById();

    void connectExistingRestaurantToExistingDish();

    boolean checkRestaurantId(int id);

    List<String> sortRestaurantNameAsc();
}



