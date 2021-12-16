package applicationContext;

import io.IOUtils;
import management.DishManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {

    private final EntityManagerFactory EMF;
    private final IOUtils IOUTILS;
    private static ApplicationContext context;

    public static ApplicationContext getInstance() {
        if (context == null) {
            context = new ApplicationContext();
        }
        return context;
    }

    private ApplicationContext() {
        EMF = Persistence.createEntityManagerFactory("PU");
        IOUTILS = new IOUtils();
    }

    public EntityManagerFactory getEMF() {
        return EMF;
    }

    public IOUtils getIOUTILS() {
        return IOUTILS;
    }
}

