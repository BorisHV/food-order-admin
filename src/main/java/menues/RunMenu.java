package menues;

import io.IOUtils;
import management.*;

public class RunMenu {

    IOUtils ioUtils = new IOUtils();

    CourierManagement courierManagement = new CourierManagement();
    DishManagement dishManagement = new DishManagement();
    RestaurantManagement restaurantManagement = new RestaurantManagement();
    CustomerManagement customerManagement = new CustomerManagement();
    FoodOrderManagement orderManagement = new FoodOrderManagement();

    public void runMainMenu() {

        boolean isRunning = true;

        while (isRunning) {
            ioUtils.printMainMenu();

            int menuOption = ioUtils.readInt();
            switch (menuOption) {
                case 1 -> runRestaurantMenu();
                case 2 -> runCourierMenu();
                case 3 -> runDishMenu();
                case 4 -> runCustomerMenu();
                case 5 -> runOrderMenu();
                case 6 -> runStatisticsMenu();
                case 0 -> {
                    System.out.println("Exiting program...");
                    isRunning = false;
                }
                default -> System.out.println("Option " + menuOption + " is not implemented.");
            }
        }
    }

    private void runOrderMenu() {

        boolean isRunning = true;

        while (isRunning) {
            ioUtils.printOrderMenu();

            int menuOption = ioUtils.readInt();

            switch (menuOption) {
                case 1 -> ioUtils.printAllOrders();
                case 2 -> orderManagement.addOrder(orderManagement.createOrder());
                case 3 -> orderManagement.removeOrder();
                case 4 -> orderManagement.updateTip();
                case 5 -> ioUtils.printFoodOrderById();
                case 6 -> orderManagement.connectExistingFoodOrderToExistingDish();
                case 7 -> orderManagement.connectExistingFoodOrderToExistingCourier();
                case 8 -> orderManagement.connectExistingFoodOrderToExistingCustomer();
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + menuOption + " is not implemented.");
            }
        }
    }

    private void runCustomerMenu() {

        boolean isRunning = true;

        while (isRunning) {
            ioUtils.printCustomerMenu();

            int menuOption = ioUtils.readInt();
            switch (menuOption) {
                case 1 -> ioUtils.printAllCustomers();
                case 2 -> customerManagement.addCustomer(customerManagement.createCustomer());
                case 3 -> customerManagement.removeCustomer();
                case 4 -> customerManagement.updatePhoneNumber();
                case 5 -> ioUtils.printCustomerById();
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + menuOption + " is not implemented.");
            }
        }
    }

    private void runDishMenu() {

        boolean isRunning = true;

        while (isRunning) {
            ioUtils.printDishMenu();

            int menuOption = ioUtils.readInt();
            switch (menuOption) {
                case 1 -> ioUtils.printAllDishes();
                case 2 -> dishManagement.addDish(dishManagement.createDish());
                case 3 -> dishManagement.removeDish();
                case 4 -> dishManagement.updatePrice();
                case 5 -> ioUtils.printDishById();
                case 6 -> dishManagement.connectExistingDishToExistingRestaurant();
                case 7 -> dishManagement.connectExistingDishToExistingFoodOrder();
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + menuOption + " is not implemented.");

            }
        }
    }

    public void runCourierMenu() {

        boolean isRunning = true;

        while (isRunning) {
            ioUtils.printCourierMenu();

            int menuOption = ioUtils.readInt();
            switch (menuOption) {
                case 1 -> ioUtils.printAllCouriers();
                case 2 -> courierManagement.addCourier(courierManagement.createCourier());
                case 3 -> courierManagement.removeCourier();
                case 4 -> courierManagement.updateCourierWage();
                case 5 -> ioUtils.printCourierById();
                case 6 -> courierManagement.connectExistingCourierToExistingFoodOrder();
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + menuOption + " is not implemented.");
            }
        }
    }

    public void runRestaurantMenu() {

        boolean isRunning = true;

        while (isRunning) {
            ioUtils.printRestaurantMenu();

            int choice = ioUtils.readInt();

            switch (choice) {

                case 1 -> ioUtils.printAllRestaurants();
                case 2 -> restaurantManagement.addRestaurant(restaurantManagement.createRestaurant());
                case 3 -> restaurantManagement.updateAddressById();
                case 4 -> restaurantManagement.removeRestaurant();
                case 5 -> ioUtils.printRestaurantById();
                case 6 -> restaurantManagement.connectExistingRestaurantToExistingDish();
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + choice + " is not implemented.");
            }
        }
    }

    public void runStatisticsMenu() {
        boolean isRunning = true;
        while (isRunning) {
            ioUtils.printStatisticsMenu();

            int choice = ioUtils.readInt();

            switch (choice) {
                case 1 -> ioUtils.printAverageWage();
                case 2 -> ioUtils.printMaxPrice(dishManagement.getMaxPrice());
                case 3 -> ioUtils.printMostPopularDish();
                case 4 -> ioUtils.printRestaurantNamesInAscOrder();
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + choice + " is not implemented.");
            }
        }
    }
}
