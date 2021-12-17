package classfiles;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(name = "Customer.getAllCustomers", query = "SELECT c FROM Customer c"),
                @NamedQuery(name = "Customer.findCustomerById", query = "SELECT c FROM Customer c")
        }
)

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String phoneNumber;
    private String address;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "customer")
    private List<FoodOrder> foodOrders;

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String adress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = adress;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void addOrder(FoodOrder foodOrder) {
        getOrders().add(foodOrder);
        foodOrder.setCustomer(this);
    }

    public void removeFoodOrder(FoodOrder foodOrder) {
        getOrders().remove(foodOrder);
        foodOrder.setCustomer(null);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
