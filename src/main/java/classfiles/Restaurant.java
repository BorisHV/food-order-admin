package classfiles;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author boris
 */
@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String restaurantName;
    @Basic
    private String adress;
    @Basic
    private String category;
    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        dish.setRestaurant(this);
    }

    public void removeDish(Dish dish) {
        getDishes().remove(dish);
        dish.setRestaurant(null);
    }

}
