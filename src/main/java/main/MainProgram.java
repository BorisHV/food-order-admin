package main;

import management.*;

public class MainProgram {


    public static void main(String[] args) {

//        RestaurantManagement restaurantManagement = new RestaurantManagement();
//        restaurantManagement.addRestaurant(restaurantManagement.createRestaurant());
        RestaurantManagement restaurantManagement = new RestaurantManagement();
        restaurantManagement.connectExistingRestaurantToExistingDish();

    }
}
