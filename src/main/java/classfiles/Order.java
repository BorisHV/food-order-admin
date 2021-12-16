package classfiles;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(name = "Order.getAllOrders", query = "SELECT o FROM Order o"),
                @NamedQuery(name = "Order.findOrderById", query = "SELECT o FROM Order o")
        }
)

@Entity
public class Order {

    @Id
    @GeneratedValue
    private int id;
    private double tip;

    @ManyToOne
    private Courier courier;
    @ManyToOne
    private Customer customer;
    @ManyToMany(mappedBy = "orders")
    private List<Dish> dishes;

    public Order() {
    }

    public Order(double tip) {
        this.tip = tip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Dish> getDishes() {
        if (dishes == null) {
            dishes = new ArrayList<>();
        }
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish) {
        getDishes().add(dish);
    }

    public void removeDish(Dish dish) {
        getDishes().remove(dish);
    }

}
