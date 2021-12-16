package management;

import classfiles.Customer;
import applicationContext.ApplicationContext;
import io.IOUtils;

import javax.persistence.*;
import java.util.List;

public class CustomerManagement {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    public List<Customer> showAllCustomers() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Customer> query = em.createNamedQuery("Customer.getAllCustomers", Customer.class);
        em.close();

        return query.getResultList();
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

    public void changePhoneNumber() {
        int id = ioUtils.askForId();
        // TODO change name of method!!!!
        String phoneNumber = ioUtils.askForCustomerTelephoneNumber();

        EntityManager em = emf.createEntityManager();

        Customer customer = em.find(Customer.class, id);

        em.getTransaction().begin();
        customer.setPhoneNumber(phoneNumber);
        em.getTransaction().commit();
        em.close();
    }
}
