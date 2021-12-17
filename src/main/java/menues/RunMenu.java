package menues;

import io.IOUtils;
import management.*;


import javax.persistence.EntityManagerFactory;

public class RunMenu {

    EntityManagerFactory emf;
    IOUtils ioUtils = new IOUtils();

    CourierManagement courierManagement = new CourierManagement();
    DishManagement dishManagement = new DishManagement();
    RestaurantManagement restaurantManagement = new RestaurantManagement();
    CustomerManagement customerManagement = new CustomerManagement();
    FoodOrderManagement orderManagement = new FoodOrderManagement();

    public void printMainMenu() {
        System.out.println("1. Restaurant menu");
        System.out.println("2. Courier menu");
        System.out.println("3. Dish menu");
        System.out.println("4. Customer menu");
        System.out.println("5. Food Order menu");
        System.out.println("0. Exit");
        System.out.print("Enter your your choice: ");
    }

    public void runMainMenu() {

        boolean isRunning = true;

        while (isRunning) {
            printMainMenu();

            int menuOption = ioUtils.readInt();
            switch (menuOption) {
                case 1 -> runRestaurantMenu();
                case 2 -> runCourierMenu();
                case 3 -> runDishMenu();
                case 4 -> runCustomerMenu();
                case 5 -> runOrderMenu();
                case 0 -> {
                    System.out.println("Exiting program...");
                    isRunning = false;
                }
                default -> System.out.println("Option " + menuOption + " is not implemented.");
            }
        }
    }

    public void printOrderMenu() {
        System.out.println("1. Show all food orders");
        System.out.println("2. Create and add order");
        System.out.println("3. Remove order");
        System.out.println("4. Update tip");
        System.out.println("5. Find order by id");
        System.out.println("6. Connect existing food order to existing dish");
        System.out.println("7. Connect existing food order to existing courier");
        System.out.println("8. Connect existing food order to existing customer");
        System.out.println("0. Return to main menu");
        System.out.print("Enter your choice: ");
    }

    private void runOrderMenu() {

        boolean isRunning = true;

        while (isRunning) {
            printOrderMenu();

            int menuOption = ioUtils.readInt();

            switch (menuOption) {
                case 1 -> ioUtils.printAllOrders();
                case 2 -> orderManagement.addOrder(orderManagement.createOrder());
                case 3 -> orderManagement.removeOrder();
                case 4 -> orderManagement.updateTip();
                case 5 -> System.out.println(orderManagement.findOrderById());
                case 6 -> orderManagement.connectExistingFoodOrderToExistingDish();
                case 7 -> orderManagement.connectExistingFoodOrderToExistingCourier();
                case 8 -> orderManagement.connectExistingFoodOrderToExistingCustomer();
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + menuOption + " is not implemented.");
            }
        }

    }

    public void printCustomerMenu() {
        System.out.println("1. Show all customer");
        System.out.println("2. Create and add customer");
        System.out.println("3. Remove customer");
        System.out.println("4. Update phone number");
        System.out.println("5. Find customer by id");
        System.out.println("0. Return to main menu");
        System.out.print("Enter your choice: ");
    }

    private void runCustomerMenu() {

        boolean isRunning = true;

        while (isRunning) {
            printCustomerMenu();

            int menuOption = ioUtils.readInt();
            switch (menuOption) {
                case 1 -> ioUtils.printAllCustomers();
                case 2 -> customerManagement.addCustomer(customerManagement.createCustomer());
                case 3 -> customerManagement.removeCustomer();
                case 4 -> customerManagement.updatePhoneNumber();
                case 5 -> System.out.println(customerManagement.findCustomerById());
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + menuOption + " is not implemented.");
            }
        }
    }


    public void printDishMenu() {
        System.out.println("1. Show all dishes");
        System.out.println("2. Create and add dish");
        System.out.println("3. Remove dish");
        System.out.println("4. Update price");
        System.out.println("5. Find dish by id");
        System.out.println("6. Connect Existing Dish To Existing Restaurant");
        System.out.println("0. Return to main menu");
        System.out.print("Enter your your choice: ");
    }

    private void runDishMenu() {

        boolean isRunning = true;

        while (isRunning) {
            printDishMenu();

            int menuOption = ioUtils.readInt();
            switch (menuOption) {
                case 1 -> ioUtils.printAllDishes();
                case 2 -> dishManagement.addDish(dishManagement.createDish());
                case 3 -> dishManagement.removeDish();
                case 4 -> dishManagement.updatePrice();
                case 5 -> System.out.println(dishManagement.findDishById());
                case 6 -> dishManagement.connectExistingDishToExistingFoodOrder();
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + menuOption + " is not implemented.");

            }
        }
    }

    public void printCourierMenu() {
        System.out.println("1. Show all couriers");
        System.out.println("2. Create and add courier");
        System.out.println("3. Remove courier");
        System.out.println("4. update courier wage");
        System.out.println("5. Find courier by id");
        System.out.println("6. Connect Existing Courier To Existing Order");
        System.out.println("0. Return to main menu");
        System.out.print("Enter your your choice: ");
    }

    public void runCourierMenu() {

        boolean isRunning = true;

        while (isRunning) {
            printCourierMenu();

            int menuOption = ioUtils.readInt();
            switch (menuOption) {
                case 1 -> ioUtils.printAllCouriers();
                case 2 -> courierManagement.addCourier(courierManagement.createCourier());
                case 3 -> courierManagement.removeCourier();
                case 4 -> courierManagement.updateCourierWage();
                case 5 -> System.out.println(courierManagement.findCourierById());
                case 6 -> courierManagement.connectExistingCourierToExistingFoodOrder();
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + menuOption + " is not implemented.");
            }
        }
    }

    public void printRestaurantMenu() {

        System.out.println("1. Show all restaurants: ");
        System.out.println("2. Create a new restaurant: ");
        System.out.println("3. Update adress of a restaurant: ");
        System.out.println("4. Remove a restaurant: ");
        System.out.println("5. Find restaurant by id");
        System.out.println("6. Connect Existing Restaurant To Existing Dish");
        System.out.println("0. Return to main menu");
        System.out.print("Enter your your choice: ");
    }

    public void runRestaurantMenu() {

        boolean isRunning = true;

        while (isRunning) {
            printRestaurantMenu();

            int choice = ioUtils.readInt();

            switch (choice) {

                case 1 -> ioUtils.printAllRestaurants();
                case 2 -> restaurantManagement.addRestaurant(restaurantManagement.createRestaurant());
                case 3 -> restaurantManagement.updateAdressById();
                case 4 -> restaurantManagement.removeRestaurant();
                case 5 -> System.out.println(restaurantManagement.findRestaurantById());
                case 6 -> restaurantManagement.connectExistingRestaurantToExistingDish();
                case 0 -> isRunning = false;
                default -> System.out.println("Option " + choice + " is not implemented.");
            }
        }
    }
}
