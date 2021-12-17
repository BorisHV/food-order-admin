package management;

import applicationContext.ApplicationContext;
import classfiles.*;
import dao.FoodOrderDao;
import io.IOUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class FoodOrderManagement implements FoodOrderDao {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    @Override
    public List<FoodOrder> getAllOrders() {

        EntityManager em = emf.createEntityManager();
        TypedQuery<FoodOrder> query = em.createNamedQuery("Order.getAllOrders", FoodOrder.class);
        //em.close();

        return query.getResultList();

    }

    @Override
    public FoodOrder findOrderById() {
        EntityManager em = emf.createEntityManager();
        int id = ioUtils.askForId();

        FoodOrder foodOrder = em.find(FoodOrder.class, id);

        em.close();
        return foodOrder;

    }

    @Override
    public FoodOrder createOrder() {

        double tip = ioUtils.askForTip();

        FoodOrder foodOrder = new FoodOrder(tip);
        return foodOrder;

    }

    @Override
    public void addOrder(FoodOrder foodOrder) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(foodOrder);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void removeOrder() {
        int id = ioUtils.askForId();
        //TODO nulla

        EntityManager em = emf.createEntityManager();
        FoodOrder foodOrder = em.find(FoodOrder.class, id);

        em.getTransaction().begin();
        em.remove(foodOrder);
        em.getTransaction().commit();

        em.close();

    }

    @Override
    public void updateTip() {

        int id = ioUtils.askForId();
        // TODO change name of method!!!!
        double tip = ioUtils.askForTip();

        EntityManager em = emf.createEntityManager();

        FoodOrder foodOrder = em.find(FoodOrder.class, id);

        em.getTransaction().begin();
        foodOrder.setTip(tip);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void connectExistingFoodOrderToExistingDish() {
        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForId();

        ApplicationContext.getInstance().getIOUTILS().printAllDishes();
        int dishId = ioUtils.askForId();

        EntityManager em = emf.createEntityManager();
        FoodOrder foodOrder = em.find(FoodOrder.class, orderId);
        Dish dish = em.find(Dish.class, dishId);

        em.getTransaction().begin();
        foodOrder.addDish(dish);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void connectExistingFoodOrderToExistingCourier() {
        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForId();

        ApplicationContext.getInstance().getIOUTILS().printAllCouriers();
        int courierId = ioUtils.askForId();

        EntityManager em = emf.createEntityManager();
        FoodOrder foodOrder = em.find(FoodOrder.class, orderId);
        Courier courier = em.find(Courier.class, courierId);

        em.getTransaction().begin();
        foodOrder.addCourier(courier);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void connectExistingFoodOrderToExistingCustomer() {
        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForId();

        ApplicationContext.getInstance().getIOUTILS().printAllCustomers();
        int customerId = ioUtils.askForId();

        EntityManager em = emf.createEntityManager();
        FoodOrder foodOrder = em.find(FoodOrder.class, orderId);
        Customer customer = em.find(Customer.class, customerId);

        em.getTransaction().begin();
        foodOrder.addCustomer(customer);
        em.getTransaction().commit();
        em.close();

    }
}
