package classfiles;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Courier {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String courierName;
    @Basic
    private String deliveryType;
    @Basic
    private String wage;
    @OneToMany(mappedBy = "courier")
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
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
        order.setCourier(this);
    }

    public void removeFoodOrder(Order order) {
        getFoodOrders().remove(order);
        order.setCourier(null);
    }

}
