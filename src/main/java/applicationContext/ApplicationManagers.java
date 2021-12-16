package applicationContext;

import management.*;



public class ApplicationManagers {

    private static ApplicationManagers applicationManagers;
    private final CourierManagement COURIER_MANAGAMENT;
    private final CustomerManagement CUSTOMER_MANAGEMENT;
    private final DishManagement DISH_MANAGEMENT;
    private final OrderManagement ORDER_MANAGEMENT;
    private final RestaurantManagement RESTAURANT_MANAGEMENT;



    public static ApplicationManagers getInstance() {

        if (applicationManagers == null) {
            applicationManagers = new ApplicationManagers();
        }
        return applicationManagers;
    }

    private ApplicationManagers() {

        COURIER_MANAGAMENT = new CourierManagement();
        CUSTOMER_MANAGEMENT = new CustomerManagement();
        DISH_MANAGEMENT = new DishManagement();
        ORDER_MANAGEMENT = new OrderManagement();
        RESTAURANT_MANAGEMENT = new RestaurantManagement();
    }

    public CourierManagement getCourierManagement() {
        return COURIER_MANAGAMENT;
    }

    public CustomerManagement getCustomerManagement() {
        return CUSTOMER_MANAGEMENT;
    }

    public DishManagement getDishManagement() {
        return DISH_MANAGEMENT;
    }

    public OrderManagement getOrderManagement() {
        return ORDER_MANAGEMENT;
    }

    public RestaurantManagement getRestaurantManagement() {
        return RESTAURANT_MANAGEMENT;
    }
}
