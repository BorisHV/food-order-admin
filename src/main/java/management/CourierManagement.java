package management;

import classfiles.Courier;
import instance.ApplicationContext;
import instance.CreateInstance;
import io.IOUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourierManagement {

    EntityManagerFactory emf = ApplicationContext.getInstance().getEMF();
    IOUtils ioUtils = ApplicationContext.getInstance().getIOUTILS();


    public List<Courier> showAllCouriers() {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Courier> query = em.createNamedQuery("Courier.showAllCouriers", Courier.class);

        em.close();
        return query.getResultList();
    }

    public Courier findCourierById() {
        EntityManager em = emf.createEntityManager();
        int employeeId = ioUtils.askForId();

        TypedQuery<Courier> query = em.createNamedQuery("Courier.findCourierById", Courier.class);

        //alt
       /* Courier courier = null;
        try {
            courier = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No courier with ID " + employeeId + " found.");
        }*/

        em.close();
        return queary.getSingleResult();
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

    public void deleteCourier() {
        EntityManager em = emf.createEntityManager();
        int employeeId = ioUtils.askForId();

        em.getTransaction().begin();
        em.remove(em.find(Courier.class, employeeId));
        em.getTransaction().commit();

        em.close();
    }

    public void updateCourierWage() {
        showAllCouriers();

        int employeeId = ioUtils.askForId();
        double newWage = ioUtils.askForWage();

        EntityManager em = emf.createEntityManager();
        Courier courier = em.find(Courier.class, employeeId);
        em.getTransaction().begin();
        courier.setWage(newWage);
        em.getTransaction().commit();

        em.close();
    }
}
