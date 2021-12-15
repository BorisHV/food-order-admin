package dao;

import classfiles.Customer;
import classfiles.Order;

import java.util.List;

public interface OrderDao {

    List<Order> showAllOrders();
    Customer createOrder();
    void addOrder(Order order);
    void removeOrder(Order order);
    void updateTip();
}
    //    @Id
    //    @GeneratedValue
    //    private Long id;
    //    @Basic
    //    private String tip;
    //    @ManyToOne
    //    private dao.CourierDao courier;
    //    @ManyToOne
    //    private Customer customer;
    //    @ManyToMany(mappedBy = "foodOrders")
    //    private List<dao.DishDao> dishes;

