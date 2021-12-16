package management;

import applicationContext.ApplicationContext;
import classfiles.Customer;
import classfiles.Order;
import dao.OrderDao;
import io.IOUtils;
import org.eclipse.persistence.internal.oxm.schema.model.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderManagement implements OrderDao {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    @Override
    public List<Order> showAllOrders() {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Order> query = em.createNamedQuery("Order.getAllOrders", Order.class);
        em.close();

        return query.getResultList();

    }

    @Override
    public Customer createOrder() {

        String name = ioUtils.askForName();
        String phoneNumber = ioUtils.askForCustomerTelephoneNumber();
        String address = ioUtils.askForAddress();
        double tip = ioUtils.askForOrderTip();

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
}
