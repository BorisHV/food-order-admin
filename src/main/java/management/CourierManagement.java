package management;

import classfiles.*;
import applicationContext.ApplicationContext;
import dao.CourierDao;
import io.IOUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
        int id = ioUtils.askForCourierId();

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
        ioUtils.printAllCouriers();
        EntityManager em = emf.createEntityManager();
        int courierId = ioUtils.askForCourierId();
        //Vi vill nulla courier_employeeid i foodorder
        em.getTransaction().begin();
        TypedQuery<FoodOrder> query = em.createQuery("SELECT f FROM FoodOrder f", FoodOrder.class);
        List<FoodOrder> foodorders = query.getResultList();

        for (FoodOrder foodorder : foodorders) {
            if(foodorder.getCourier().getEmployeeId() == courierId){
                foodorder.setCourier(null);
            }
        }
        em.remove(em.find(Courier.class, courierId));
        em.getTransaction().commit();
        em.close();
    }

    public void updateCourierWage() {
        getAllCouriers();

        int employeeId = ioUtils.askForCourierId();
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
        int courierId = ioUtils.askForCourierId();

        ApplicationContext.getInstance().getIOUTILS().printAllOrders();
        int orderId = ioUtils.askForFoodOrderId();

        EntityManager em = emf.createEntityManager();
        Courier courier = em.find(Courier.class, courierId);
        FoodOrder foodOrder = em.find(FoodOrder.class, orderId);

        em.getTransaction().begin();
        courier.addFoodOrder(foodOrder);
        em.getTransaction().commit();
        em.close();

    }

    public boolean checkCourierId(int id) {
        EntityManager em = emf.createEntityManager();
        Courier courier = em.find(Courier.class, id);
        if (courier == null) {
            return false;
        } else {
            return true;
        }
    }
}
