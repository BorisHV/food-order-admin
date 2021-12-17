package management;

import classfiles.Customer;
import applicationContext.ApplicationContext;
import classfiles.FoodOrder;
import dao.CustomerDao;
import io.IOUtils;

import javax.persistence.*;
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
        int id = ioUtils.askForId();

        Customer customer = em.find(Customer.class, id);

        em.close();
        return customer;
    }

    public Customer createCustomer() {
        String name = ioUtils.askForName();
        String phoneNumber = ioUtils.askForCustomerTelephoneNumber();
        String address = ioUtils.askForAddress();

        Customer customer = new Customer(name, phoneNumber, address);
        return customer;
    }

    public void addCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();

        em.close();
    }

    public void removeCustomer() {
        int id = ioUtils.askForId();
        //TODO nulla
        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class, id);

        em.getTransaction().begin();
        em.remove(customer);
        em.getTransaction().commit();

        em.close();
    }

    public void updatePhoneNumber() {
        int id = ioUtils.askForId();
        String phoneNumber = ioUtils.askForCustomerTelephoneNumber();

        EntityManager em = emf.createEntityManager();

        Customer customer = em.find(Customer.class, id);

        em.getTransaction().begin();
        customer.setPhoneNumber(phoneNumber);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void connectExistingCustomerToExistingOrder() {

        ApplicationContext.getInstance().getIOUTILS().printAllCustomers();
        int customerId = ioUtils.askForId();

        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForId();

        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class, customerId);
        FoodOrder foodOrder = em.find(FoodOrder.class, orderId);

        em.getTransaction().begin();
        customer.addOrder(foodOrder);
        em.getTransaction().commit();
        em.close();
    }
}
