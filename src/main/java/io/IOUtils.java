package io;

import applicationContext.ApplicationManagers;
import classfiles.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class IOUtils {
    private final Scanner scanner = new Scanner(System.in);

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

    public void printMainMenu() {
        System.out.println("\n====================");
        System.out.println("     MAIN MENU");
        System.out.println("====================");
        System.out.println("1. Restaurant menu");
        System.out.println("2. Courier menu");
        System.out.println("3. Dish menu");
        System.out.println("4. Customer menu");
        System.out.println("5. Food Order menu");
        System.out.println("6. Statistics menu");
        System.out.println("0. Exit\n");
    }

    public void printOrderMenu() {
        System.out.println("\n====================");
        System.out.println("     ORDER MENU");
        System.out.println("====================");
        System.out.println("1. Show all food orders");
        System.out.println("2. Add order");
        System.out.println("3. Remove order");
        System.out.println("4. Update tip");
        System.out.println("5. Find order by id");
        System.out.println("6. Connect existing food order to existing dish");
        System.out.println("7. Connect existing food order to existing courier");
        System.out.println("8. Connect existing food order to existing customer");
        System.out.println("0. Return to main menu\n");
    }

    public void printRestaurantMenu() {

        System.out.println("\n====================");
        System.out.println("   RESTAURANT MENU");
        System.out.println("====================");
        System.out.println("1. Show all restaurants");
        System.out.println("2. Add a new restaurant");
        System.out.println("3. Update address of a restaurant");
        System.out.println("4. Remove a restaurant");
        System.out.println("5. Find restaurant by id");
        System.out.println("6. Connect Existing Restaurant To Existing Dish");
        System.out.println("0. Return to main menu\n");
    }

    public void printCourierMenu() {
        System.out.println("\n====================");
        System.out.println("   COURIER MENU");
        System.out.println("====================");
        System.out.println("1. Show all couriers");
        System.out.println("2. Add courier");
        System.out.println("3. Remove courier");
        System.out.println("4. Update courier wage");
        System.out.println("5. Find courier by id");
        System.out.println("6. Connect Existing Courier To Existing Order");
        System.out.println("0. Return to main menu\n");
    }

    public void printDishMenu() {
        System.out.println("\n====================");
        System.out.println("   DISH MENU");
        System.out.println("====================");
        System.out.println("1. Show all dishes");
        System.out.println("2. Add dish");
        System.out.println("3. Remove dish");
        System.out.println("4. Update price");
        System.out.println("5. Find dish by id");
        System.out.println("6. Connect existing dish to existing restaurant");
        System.out.println("7. Connect existing dish to existing food order");
        System.out.println("0. Return to main menu\n");
    }

    public void printCustomerMenu() {
        System.out.println("\n====================");
        System.out.println("   CUSTOMER MENU");
        System.out.println("====================");
        System.out.println("1. Show all customer");
        System.out.println("2. Add customer");
        System.out.println("3. Remove customer");
        System.out.println("4. Update phone number");
        System.out.println("5. Find customer by id");
        System.out.println("0. Return to main menu\n");
    }

    public void printStatisticsMenu() {
        System.out.println("\n====================");
        System.out.println("   STATISTICS MENU");
        System.out.println("====================");
        System.out.println("1. Show average wage");
        System.out.println("2. Show maximum dish price");
        System.out.println("3. Show most popular dish");
        System.out.println("4. Show all restaurant names in alphabetical order");
        System.out.println("0. Return to main menu\n");
    }

    public String askForCustomerTelephoneNumber() {
        System.out.print("Telephone number: ");
        return scanner.nextLine();
    }

    public int askForFoodOrderId() {
        int id;
        boolean isRunning = true;

        System.out.print("ID: ");
        id = readInt();

        if (ApplicationManagers.getInstance().getFoodOrderManagement().checkFoodOrderId(id)) {
            isRunning = false;
        }

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
        int id;
        boolean isRunning = true;

        System.out.print("ID: ");
        id = readInt();

        if (ApplicationManagers.getInstance().getDishManagement().checkDishId(id)) {
            isRunning = false;
        }

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
        int id;
        boolean isRunning = true;

        System.out.print("ID: ");
        id = readInt();

        if (ApplicationManagers.getInstance().getRestaurantManagement().checkRestaurantId(id)) {
            isRunning = false;
        }

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
        int id;
        boolean isRunning = true;

        System.out.print("ID: ");
        id = readInt();

        if (ApplicationManagers.getInstance().getCustomerManagement().checkCustomerId(id)) {
            isRunning = false;
        }

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
        int id;
        boolean isRunning = true;

        System.out.print("ID: ");
        id = readInt();

        if (ApplicationManagers.getInstance().getCourierManagement().checkCourierId(id)) {
            isRunning = false;
        }

        while (isRunning) {
            System.out.print("ID does not exist. Please try again: ");
            id = readInt();
            if (ApplicationManagers.getInstance().getCourierManagement().checkCourierId(id)) {
                isRunning = false;
            }
        }

        return id;
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
                .forEach(System.out::println);
    }

    public void printAllRestaurants() {
        ApplicationManagers.getInstance().getRestaurantManagement().getAllRestaurants()
                .forEach(System.out::println);
    }

    public void printAllCouriers() {
        ApplicationManagers.getInstance().getCourierManagement().getAllCouriers()
                .forEach(System.out::println);
    }

    public void printAllCustomers() {
        ApplicationManagers.getInstance().getCustomerManagement().getAllCustomers()
                .forEach(System.out::println);
    }

    public void printAllOrders() {
        ApplicationManagers.getInstance().getFoodOrderManagement().getAllOrders()
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

    public void printMostPopularDish() {
        String mostCommonDish = ApplicationManagers.getInstance().getDishManagement().getMostPopularDish();

        System.out.println("The most popular dish is " + mostCommonDish + ".");
    }

    public void printAverageWage() {
        double wageAverage = ApplicationManagers.getInstance().getCourierManagement().getAverageCourierWage();

        System.out.println("The average salary of a Courier is: " + wageAverage);
    }

    public void printMaxPrice(Optional<Double> maxPrice) {
        if (maxPrice.isPresent()) {
            System.out.println("Max price of a dish is " + maxPrice.get() + ".");
        } else {
            System.out.println("No max price found");
        }
    }

    public void printRestaurantNamesInAscOrder() {
        List<String> restaurantNames =
                ApplicationManagers.getInstance().getRestaurantManagement().sortRestaurantNameAsc();

        for (String restaurantName : restaurantNames) {
            System.out.println(restaurantName);
        }
    }
}
