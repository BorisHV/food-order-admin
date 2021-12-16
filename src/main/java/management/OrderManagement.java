package management;

import applicationContext.ApplicationContext;
import applicationContext.ApplicationManagers;
import classfiles.Courier;
import classfiles.Customer;
import classfiles.Dish;
import classfiles.Order;
import dao.OrderDao;
import io.IOUtils;
import main.MainProgram;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

import static main.MainProgram.*;

public class OrderManagement implements OrderDao {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    @Override
    public List<Order> getAllOrders() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Order> query = em.createNamedQuery("Order.getAllOrders", Order.class);
        em.close();

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
        ApplicationContext.getInstance().getIOUTILS().printAllDishes();
        int id = ioUtils.askForId();

        EntityManager em = emf.createEntityManager();
        Dish dish = em.find(Dish.class, id);
        //TODO
        em.find(Courier.class, 1);

        double tip = ioUtils.askForTip();


        Order order = new Order(tip);
        order.addDish(dish);
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
}
