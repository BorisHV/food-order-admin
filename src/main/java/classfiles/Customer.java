package classfiles;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String name;
    @Basic
    private String telephoneNumber;
    @Basic
    private String numberOfOrders;
    @Basic
    private String adress;
    @OneToMany(mappedBy = "customer")
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(String numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
        order.setCustomer(this);
    }

    public void removeFoodOrder(Order order) {
        getFoodOrders().remove(order);
        order.setCustomer(null);
    }

}
