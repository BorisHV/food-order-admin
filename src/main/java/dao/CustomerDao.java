package dao;

import classfiles.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> showAllCustomers();
    Customer createCustomer();
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    void updateTelephoneNumber();
}

//    @Id
//    @GeneratedValue
//    private Long id;
//    @Basic
//    private String name;
//    @Basic
//    private String telephoneNumber;
//    @Basic
//    private String numberOfOrders;
//    @Basic
//    private String adress;
//    @OneToMany(mappedBy = "customer")
//    private List<Order> foodOrders;

