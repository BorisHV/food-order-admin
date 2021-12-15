package dao;

import classfiles.Restaurant;

import java.util.List;

public interface RestaurantDao {

    List<Restaurant> showAllRestaurants();
    Restaurant createRestaurant();
    void addRestaurant(Restaurant restaurant);
    void removeRestaurant(Restaurant restaurant);
    void updateAdressById();
}
    //@Id
    //    @GeneratedValue
    //    private Long id;
    //    @Basic
    //    private String restaurantName;
    //    @Basic
    //    private String adress;
    //    @Basic
    //    private String category;
    //    @OneToMany(mappedBy = "restaurant")
    //    private List<dao.DishDao> dishes;


