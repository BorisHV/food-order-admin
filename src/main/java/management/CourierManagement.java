package management;

import classfiles.*;
import applicationContext.ApplicationContext;
import dao.CourierDao;
import io.IOUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CourierManagement implements CourierDao {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();

    public List<Courier> getAllCouriers() {

        EntityManager em = emf.createEntityManager();
        List<Courier> couriers = em.createNamedQuery("Courier.showAllCouriers", Courier.class).getResultList();

        em.close();
        return couriers;
    }

    public Courier findCourierById() {
        EntityManager em = emf.createEntityManager();
        int id = ioUtils.askForId();

        Courier courier = em.find(Courier.class, id);

        em.close();
        return courier;
    }

    public Courier createCourier() {
        String CourierName = ioUtils.askForName();

        String deliveryType = ioUtils.askForDeliveryType();
        double wage = ioUtils.askForWage();

        return new Courier(CourierName, deliveryType, wage);
    }

    public void addCourier(Courier courier) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(courier);
        em.getTransaction().commit();

        em.close();
    }

    public void removeCourier() {
        EntityManager em = emf.createEntityManager();
        int employeeId = ioUtils.askForId();

        em.getTransaction().begin();
        em.remove(em.find(Courier.class, employeeId));
        em.getTransaction().commit();

        em.close();
    }

    public void updateCourierWage() {
        getAllCouriers();

        int employeeId = ioUtils.askForId();
        double newWage = ioUtils.askForWage();

        EntityManager em = emf.createEntityManager();
        Courier courier = em.find(Courier.class, employeeId);
        em.getTransaction().begin();
        courier.setWage(newWage);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void connectExistingCourierToExistingFoodOrder() {
        ApplicationContext.getInstance().getIOUTILS().printAllCouriers();
        int courierId = ioUtils.askForId();

        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForId();

        EntityManager em = emf.createEntityManager();
        Courier courier = em.find(Courier.class, courierId);
        FoodOrder foodOrder = em.find(FoodOrder.class, orderId);

        em.getTransaction().begin();
        courier.addOrder(foodOrder);
        em.getTransaction().commit();
        em.close();

    }
}
