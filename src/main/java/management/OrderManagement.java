package management;

import applicationContext.ApplicationContext;
import classfiles.*;
import dao.OrderDao;
import io.IOUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderManagement implements OrderDao {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    @Override
    public List<Order> getAllOrders() {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Order> query = em.createNamedQuery("Order.getAllOrders", Order.class);
        //em.close();

        return query.getResultList();

    }

    @Override
    public Order findOrderById() {
        EntityManager em = emf.createEntityManager();
        int id = ioUtils.askForId();

        Order order = em.find(Order.class, id);

        em.close();
        return order;

    }

    @Override
    public Order createOrder() {

        String name = ioUtils.askForName();
        String phoneNumber = ioUtils.askForCustomerTelephoneNumber();
        String address = ioUtils.askForAddress();
        double tip = ioUtils.askForTip();

        Order order = new Order(tip);
        return order;

    }

    @Override
    public void addOrder(Order order) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();

        em.close();

    }

    @Override
    public void removeOrder() {
        int id = ioUtils.askForId();
        //TODO nulla

        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, id);

        em.getTransaction().begin();
        em.remove(order);
        em.getTransaction().commit();

        em.close();

    }

    @Override
    public void updateTip() {

        int id = ioUtils.askForId();
        // TODO change name of method!!!!
        double tip = ioUtils.askForTip();

        EntityManager em = emf.createEntityManager();

        Order order = em.find(Order.class, id);

        em.getTransaction().begin();
        order.setTip(tip);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void connectExistingOrderToExistingDish() {
        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForId();

        ApplicationContext.getInstance().getIOUTILS().printAllDishes();
        int dishId = ioUtils.askForId();

        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, orderId);
        Dish dish = em.find(Dish.class, dishId);

        em.getTransaction().begin();
        order.addDish(dish);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void connectExistingOrderToExistingCourier() {
        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForId();

        ApplicationContext.getInstance().getIOUTILS().printAllCouriers();
        int courierId = ioUtils.askForId();

        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, orderId);
        Courier courier = em.find(Courier.class, courierId);

        em.getTransaction().begin();
        order.addCourier(courier);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void connectExistingOrderToExistingCustomer() {
        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForId();

        ApplicationContext.getInstance().getIOUTILS().printAllCustomers();
        int customerId = ioUtils.askForId();

        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, orderId);
        Customer customer = em.find(Customer.class, customerId);

        em.getTransaction().begin();
        order.addCustomer(customer);
        em.getTransaction().commit();
        em.close();

    }
}
