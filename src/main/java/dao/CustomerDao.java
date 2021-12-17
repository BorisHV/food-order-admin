package dao;

import classfiles.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCustomers();
    Customer findCustomerById();
    Customer createCustomer();
    void addCustomer(Customer customer);
    void removeCustomer();
    void updatePhoneNumber();
    void connectExistingCustomerToExistingOrder();
    boolean checkCustomerId(int id);
}


