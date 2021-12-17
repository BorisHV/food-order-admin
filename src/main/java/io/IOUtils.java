package io;

import applicationContext.ApplicationManagers;

import java.util.Scanner;

public class IOUtils {

    private Scanner scanner = new Scanner(System.in);

//    public int printMainMenu() {
//        //    1. customerMenu
//        //    2. printRestaurantMenu
//        //    3. courierMenu
//    }
//
//    public int printCustomerMenu() {
//    }
//
//    public int printRestaurantMenu() {
//    }
//
//    public int printCourierMenu() {
//    }

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

    public int askForId() {
        System.out.print("ID: ");
        return readInt();
    }

    public int askForRestaurantId() {
        System.out.print("Restaurant ID: ");
        return readInt();
    }

    public int askForDishId() {
        System.out.print("Dish ID: ");
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

        ApplicationManagers.getInstance().getOrderManagement().getAllOrders()
                .stream()
                .forEach(System.out::println);
    }
}
