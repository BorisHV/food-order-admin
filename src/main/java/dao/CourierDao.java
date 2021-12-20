package dao;

import classfiles.Courier;

import java.util.List;

public interface CourierDao {

    List<Courier> getAllCouriers();

    Courier findCourierById();

    Courier createCourier();

    void addCourier(Courier courier);

    void removeCourier();

    void updateCourierWage();

    void connectExistingCourierToExistingFoodOrder();

    boolean checkCourierId(int id);

    double getAverageCourierWage();
}


