package menues;

import io.IOUtils;
import management.CourierManagement;
import management.DishManagement;
import management.RestaurantManagement;

import javax.persistence.EntityManagerFactory;

public class RunMenu {


    CourierManagement courierManagement = new CourierManagement();
    DishManagement dishManagement = new DishManagement();
    RestaurantManagement restaurantManagement = new RestaurantManagement();


    public void runCourierMenu(int menuOption) {
        switch (menuOption) {
            case 1 -> courierManagement.showAllCouriers();
            case 2 -> courierManagement.addCourier(courierManagement.createCourier());
            case 3 -> courierManagement.deleteCourier();
            case 4 -> courierManagement.updateCourierWage();
            case 0 -> System.out.println("Exiting program...");
            default -> System.out.println("Option " + menuOption + " is not implemented.");
        }
    }

    public void runRestaurantMenu(){

        int choice = ioUtils.readInt();

        switch(choice){
            case 1 -> System.out.println("Show all restaurants: ");
            case 2 -> System.out.println("Create a new restaurant: ");
            case 4 -> System.out.println("Update adress of a restaurant: ");
            case 5 -> System.out.println("Remove a restaurant: ");
        }
    }
}
