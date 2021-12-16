package dao;

import classfiles.Courier;

import java.util.List;

public interface CourierDao {

    List<CourierDao> showAllDishes();
    Courier findCourierById();
    Courier createCourier();
    void addCourier(Courier courier);
    void removeCourier();
    void updateWage();
    void connectExistingCourierToExistingOrder();
}


