package dao;

import classfiles.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getAllOrders();
    Order findOrderById();
    Order createOrder();
    void addOrder(Order order);
    void removeOrder();
    void updateTip();
    void connectExistingOrderToExistingDish();
    void connectExistingOrderToExistingCourier();
    void connectExistingOrderToExistingCustomer();
}


