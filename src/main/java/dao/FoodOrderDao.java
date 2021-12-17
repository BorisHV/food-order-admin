package dao;

import classfiles.FoodOrder;

import java.util.List;

public interface FoodOrderDao {

    List<FoodOrder> getAllOrders();
    FoodOrder findOrderById();
    FoodOrder createOrder();
    void addOrder(FoodOrder foodOrder);
    void removeOrder();
    void updateTip();
    void connectExistingFoodOrderToExistingDish();
    void connectExistingFoodOrderToExistingCourier();
    void connectExistingFoodOrderToExistingCustomer();
}


