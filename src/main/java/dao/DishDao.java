package dao;

import java.util.List;

public interface DishDao {

    List<DishDao> showAllDishes();
    DishDao createDish();
    void addDish(DishDao dishDao);
    void removeOrder(DishDao dishDao);
    void updatePrice();
}
    //    @Id
    //    @GeneratedValue
    //    private Long id;
    //    @Basic
    //    private String name;
    //    @Basic
    //    private String price;
    //    @ManyToOne
    //    private classfiles.Restaurant restaurant;
    //    @ManyToMany
    //    private List<Order> foodOrders;

