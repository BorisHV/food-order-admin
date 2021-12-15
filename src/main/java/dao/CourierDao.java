package dao;

import java.util.List;

public interface CourierDao {

    List<CourierDao> showAllDishes();
    CourierDao createCourier();
    void addCourier(CourierDao courierDao);
    void removeCourier(CourierDao courierDao);
    void updateWage();
}
//    @Id
//    @GeneratedValue
//    private Long id;
//    @Basic
//    private String courierName;
//    @Basic
//    private String deliveryType;
//    @Basic
//    private String wage;
//    @OneToMany(mappedBy = "courier")
//    private List<Order> foodOrders;

