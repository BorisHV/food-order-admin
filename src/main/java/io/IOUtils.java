package io;

import applicationContext.ApplicationManagers;
import classfiles.*;

import java.util.Scanner;

public class IOUtils {
    private Scanner scanner = new Scanner(System.in);
    public int readInt() {
        int intInput = 0;
        boolean isInvalid = true;
        while (isInvalid) {
            try {
                intInput = scanner.nextInt();
                scanner.nextLine();
                isInvalid = false;
            } catch (Exception e) {
                System.out.println("Wrong input format!");
                scanner.nextLine();
                System.out.println("Re-enter input:");
            }
        }
        return intInput;
    }

    public double readDouble() {
        double doubleInput = 0.0;
        boolean isInvalid = true;
        while (isInvalid) {
            try {
                doubleInput = scanner.nextDouble();
                scanner.nextLine();
                isInvalid = false;
            } catch (Exception e) {
                System.out.println("Wrong input format!");
                scanner.nextLine();
                System.out.println("Re-enter input:");
            }
        }
        return doubleInput;
    }

    public String readString() {
        String stringInput = "";
        boolean isInvalid = true;
        while (isInvalid) {
            try {
                stringInput = scanner.nextLine();
                isInvalid = false;
            } catch (Exception e) {
                System.out.println("Wrong input format!");
                scanner.nextLine();
                System.out.println("Re-enter input:");
            }
        }
        return stringInput;
    }

    public void printRestaurantMenu() {

        System.out.println("1. Show all restaurants: ");
        System.out.println("2. Create a new restaurant: ");
        System.out.println("3. Update adress of a restaurant: ");
        System.out.println("4. Remove a restaurant: ");
        System.out.println("5. Find restaurant by id");
        System.out.println("6. Connect Existing Restaurant To Existing Dish");
        System.out.println("0. Return to main menu\n");
    }

    public void printCourierMenu() {
        System.out.println("1. Show all couriers");
        System.out.println("2. Create and add courier");
        System.out.println("3. Remove courier");
        System.out.println("4. update courier wage");
        System.out.println("5. Find courier by id");
        System.out.println("6. Connect Existing Courier To Existing Order");
        System.out.println("0. Return to main menu\n");
    }

    public void printDishMenu() {
        System.out.println("1. Show all dishes");
        System.out.println("2. Create and add dish");
        System.out.println("3. Remove dish");
        System.out.println("4. Update price");
        System.out.println("5. Find dish by id");
        System.out.println("6. Connect existing dish to existing restaurant");
        System.out.println("7. Connect existing dish to existing food order");
        System.out.println("0. Return to main menu");
        System.out.print("Enter your your choice: ");
    }

    public void printCustomerMenu() {
        System.out.println("1. Show all customer");
        System.out.println("2. Create and add customer");
        System.out.println("3. Remove customer");
        System.out.println("4. Update phone number");
        System.out.println("5. Find customer by id");
        System.out.println("0. Return to main menu\n");
    }

    public String askForCustomerName() {
        System.out.print("Customer name: ");
        return scanner.nextLine();
    }

    public String askForCustomerAddress() {
        System.out.print("Customer address: ");
        return scanner.nextLine();
    }

    public String askForCustomerTelephoneNumber() {
        System.out.print("Telephone number: ");
        return scanner.nextLine();
    }

    public int askForFoodOrderId() {
        int id = 0;
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("ID does not exist. Please try again: ");
            id = readInt();
            if (ApplicationManagers.getInstance().getFoodOrderManagement().checkFoodOrderId(id)) {
                isRunning = false;
            }
        }
        return id;
    }

    public int askForDishId() {
        int id = 0;
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("ID does not exist. Please try again: ");
            id = readInt();
            if (ApplicationManagers.getInstance().getDishManagement().checkDishId(id)) {
                isRunning = false;
            }
        }
        return id;
    }

    public int askForRestaurantId() {
        int id = 0;
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("ID does not exist. Please try again: ");
            id = readInt();
            if (ApplicationManagers.getInstance().getRestaurantManagement().checkRestaurantId(id)) {
                isRunning = false;
            }
        }
        return id;
    }

    public int askForCustomerId() {
        int id = 0;
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("ID does not exist. Please try again: ");
            id = readInt();
            if (ApplicationManagers.getInstance().getCustomerManagement().checkCustomerId(id)) {
                isRunning = false;
            }
        }
        return id;
    }

    public int askForCourierId() {
        int id = 0;
        System.out.print("ID: ");
        id = readInt();
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("ID does not exist. Please try again: ");
            id = readInt();
            if (ApplicationManagers.getInstance().getCourierManagement().checkCourierId(id)) {
                isRunning = false;
            }
        }
        return id;
    }

    public int askForId() {
        System.out.print("ID: ");
        return readInt();
    }

    public String askForName() {
        System.out.print("Name: ");
        return scanner.nextLine();
    }

    public String askForAddress() {
        System.out.print("Address: ");
        return scanner.nextLine();
    }

    public String askForCategory() {
        System.out.print("Category: ");
        return scanner.nextLine();
    }

    public double askForWage() {
        System.out.print("Wage: ");
        return readDouble();
    }

    public double askForPrice() {
        System.out.print("Price: ");
        return readDouble();
    }

    public String askForDeliveryType() {
        System.out.print("Delivery type: ");
        return scanner.nextLine();
    }

    public double askForTip() {
        System.out.print("Tip: ");
        return readDouble();
    }

    public void printAllDishes() {
        ApplicationManagers.getInstance().getDishManagement().getAllDishes()
                .stream()
                .forEach(System.out::println);
    }

    public void printAllRestaurants() {
        ApplicationManagers.getInstance().getRestaurantManagement().getAllRestaurants()
                .stream()
                .forEach(System.out::println);
    }

    public void printAllCouriers() {
        ApplicationManagers.getInstance().getCourierManagement().getAllCouriers()
                .stream()
                .forEach(System.out::println);
    }

    public void printAllCustomers() {
        ApplicationManagers.getInstance().getCustomerManagement().getAllCustomers()
                .stream()
                .forEach(System.out::println);
    }

    public void printAllOrders() {
        ApplicationManagers.getInstance().getFoodOrderManagement().getAllOrders()
                .stream()
                .forEach(System.out::println);
    }

    public void printCourierById() {
        Courier courier = ApplicationManagers.getInstance().getCourierManagement().findCourierById();
        System.out.println(courier);
    }

    public void printCustomerById() {
        Customer customer = ApplicationManagers.getInstance().getCustomerManagement().findCustomerById();
        System.out.println(customer);
    }

    public void printDishById() {
        Dish dish = ApplicationManagers.getInstance().getDishManagement().findDishById();
        System.out.println(dish);
    }

    public void printRestaurantById() {
        Restaurant restaurant = ApplicationManagers.getInstance().getRestaurantManagement().findRestaurantById();
        System.out.println(restaurant);
    }

    public void printFoodOrderById() {
        FoodOrder foodOrder = ApplicationManagers.getInstance().getFoodOrderManagement().findOrderById();
        System.out.println(foodOrder);
    }
}
