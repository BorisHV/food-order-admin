package classfiles;

import java.util.List;
import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(name = "Courier.showAllCouriers", query = "SELECT c FROM Courier c")
        }
)

@Entity
public class Courier {
    @Id
    @GeneratedValue
    private int employeeId;

    private String courierName;
    private String deliveryType;
    private double wage;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "courier")
    private List<Order> orders;

    public Courier() {
    }

    public Courier(String courierName, String deliveryType, double wage) {
        this.courierName = courierName;
        this.deliveryType = deliveryType;
        this.wage = wage;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
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

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        getOrders().add(order);
        order.setCourier(this);
    }
}