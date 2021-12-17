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
    private List<FoodOrder> foodOrders;

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

    public List<FoodOrder> getOrders() {
        return foodOrders;
    }

    public void setOrders(List<FoodOrder> foodOrders) {
        this.foodOrders = foodOrders;
    }

    public void addOrder(FoodOrder foodOrder) {
        getOrders().add(foodOrder);
        foodOrder.setCourier(this);
    }

    @Override
    public String toString() {
        return "Courier{" +
                "employeeId=" + employeeId +
                ", courierName='" + courierName + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", wage=" + wage;
    }
}