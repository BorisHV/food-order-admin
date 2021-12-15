package io;

import java.util.Scanner;

public class IOUtils {

    private Scanner scanner = new Scanner(System.in);

//    public int printMainMenu() {
//        //    1. customerMenu
//        //    2. runRestaurantMenu
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

    public int askForId(){
        System.out.print("ID: ");
        return readInt();
    }

    public String askForName(){
        System.out.print("Name: ");
        return scanner.nextLine();
    }

    public String askForAddress(){
        System.out.print("Address: ");
        return scanner.nextLine();
    }

    public String askForCategory(){
        System.out.print("Category: ");
        return scanner.nextLine();
    }

    public double askForWage(){
        System.out.print("Wage: ");
        return readDouble();
    }

    public double askForPrice() {
        System.out.print("Wage: ");
        return readDouble();
    }

    public String askForDeliveryType(){
        System.out.print("Delivery type: ");
        return scanner.nextLine();
    }

}
