package classfiles;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Dish {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String name;
    @Basic
    private String price;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToMany
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Order> getFoodOrders() {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        return orders;
    }

    public void setFoodOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addFoodOrder(Order order) {
        getFoodOrders().add(order);
        order.getDishes().add(this);
    }

    public void removeFoodOrder(Order order) {
        getFoodOrders().remove(order);
        order.getDishes().remove(this);
    }

}
