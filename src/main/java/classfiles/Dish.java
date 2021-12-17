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
    private List<FoodOrder> foodOrders;

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

    public List<FoodOrder> getOrders() {
        if (foodOrders == null) {
            foodOrders = new ArrayList<>();
        }
        return foodOrders;
    }

    public void setFoodOrders(List<FoodOrder> foodOrders) {
        this.foodOrders = foodOrders;
    }

    public void addFoodOrder(FoodOrder foodOrder) {
        getOrders().add(foodOrder);
        foodOrder.getDishes().add(this);
    }

    public void removeFoodOrder(FoodOrder foodOrder) {
        getOrders().remove(foodOrder);
        foodOrder.getDishes().remove(this);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", restaurant=" + restaurant +
                ", foodOrders=" + foodOrders +
                '}';
    }

    public void addRestaurant(Restaurant restaurant) {

        setRestaurant(restaurant);
        restaurant.getDishes().add(this);
    }

    public void addOrder(FoodOrder foodOrder) {
        getOrders().add(foodOrder);
        foodOrder.getDishes().add(this);
    }
}
