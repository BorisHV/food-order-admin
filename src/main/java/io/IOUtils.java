package io;

import java.util.Scanner;

public class IOUtils {

    private Scanner scanner = new Scanner(System.in);

//    public int printMainMenu() {
//        //    1. customerMenu
//        //    2. restaurantMenu
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
        double doubleInput = 0;
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

    public String askForCustomerName(){
        System.out.print("Customer name: ");
        return scanner.nextLine();
    }

    public String askForCustomerAddress(){
        System.out.print("Customer address: ");
        return scanner.nextLine();
    }

    public String askForCustomerTelephoneNumber(){
        System.out.print("Telephone number: ");
        return scanner.nextLine();
    }

    public int askForCustomerId(){
        System.out.print("Customer ID: ");
        return readInt();
    }

    public String askForRestaurantName(){
        System.out.print("classfiles.Restaurant name: ");
        return scanner.nextLine();
    }

    public String askForRestaurantAddress(){
        System.out.print("classfiles.Restaurant address: ");
        return scanner.nextLine();
    }

    public String askForCategory(){
        System.out.print("Category: ");
        return scanner.nextLine();
    }

    public int askForRestaurantId(){
        System.out.print("classfiles.Restaurant ID: ");
        return readInt();
    }

    public String askForCourierName(){
        System.out.print("Courier name: ");
        return scanner.nextLine();
    }

    public double askForWage(){
        System.out.print("Wage: ");
        return readDouble();
    }

    public int askForEmployeeId(){
        System.out.print("Employee ID: ");
        return readInt();
    }
}
