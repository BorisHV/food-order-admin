package classfiles;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
public class Dish {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Restaurant restaurant;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Order> orders;

    public Dish() {
    }

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", restaurant=" + restaurant +
                ", orders=" + orders +
                '}';
    }
}
