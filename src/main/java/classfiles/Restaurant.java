package classfiles;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries(
        {
                @NamedQuery(name = "Restaurant.showAllRestaurants", query = "SELECT r FROM Restaurant r")
        }
)
@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private int id;

    private String restaurantName;
    private String adress;
    private String category;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "restaurant")
    private List<Dish> dishes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                ", address='" + adress + '\'' +
                ", category='" + category;
    }
}
