package management;

import applicationContext.ApplicationContext;
import classfiles.Customer;
import classfiles.FoodOrder;
import dao.CustomerDao;
import io.IOUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerManagement implements CustomerDao {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        List<Customer> customers = em.createNamedQuery("Customer.getAllCustomers", Customer.class).getResultList();

        em.close();

        return customers;
    }

    public Customer findCustomerById() {
        EntityManager em = emf.createEntityManager();
        int id = ioUtils.askForCustomerId();

        Customer customer = em.find(Customer.class, id);

        em.close();
        return customer;
    }

    public Customer createCustomer() {
        String name = ioUtils.askForName();
        String phoneNumber = ioUtils.askForCustomerTelephoneNumber();
        String address = ioUtils.askForAddress();

        return new Customer(name, phoneNumber, address);
    }

    public void addCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();

        em.close();
    }

    public void removeCustomer() {
        ioUtils.printAllCustomers();
        EntityManager em = emf.createEntityManager();
        int customerId = ioUtils.askForCustomerId();

        em.getTransaction().begin();
        TypedQuery<FoodOrder> query = em.createQuery("SELECT f FROM FoodOrder f", FoodOrder.class);
        List<FoodOrder> foodOrders = query.getResultList();

        for (FoodOrder foodorder : foodOrders) {
            if (foodorder.getCustomer().getId() == customerId) {
                foodorder.setCustomer(null);
            }
        }
        em.remove(em.find(Customer.class, customerId));
        em.getTransaction().commit();
        em.close();
    }

    public void updatePhoneNumber() {
        ioUtils.printAllCustomers();

        int id = ioUtils.askForCustomerId();
        String phoneNumber = ioUtils.askForCustomerTelephoneNumber();

        EntityManager em = emf.createEntityManager();

        Customer customer = em.find(Customer.class, id);

        em.getTransaction().begin();
        customer.setPhoneNumber(phoneNumber);
        em.getTransaction().commit();
        em.close();
    }

    public void connectExistingCustomerToExistingOrder() {

        ApplicationContext.getInstance().getIOUTILS().printAllCustomers();
        int customerId = ioUtils.askForCustomerId();

        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForFoodOrderId();

        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class, customerId);
        FoodOrder foodOrder = em.find(FoodOrder.class, orderId);

        em.getTransaction().begin();
        customer.addOrder(foodOrder);
        em.getTransaction().commit();
        em.close();
    }

    public boolean checkCustomerId(int id) {
        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class, id);
        return customer != null;
    }
}
