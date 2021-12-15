package instance;

import io.IOUtils;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {
    private final EntityManagerFactory EMF;
    private final IOUtils IOUTILS;

    // singleton
    private static ApplicationContext context;

    public static ApplicationContext getInstance(){
        if(context == null){
            context = new ApplicationContext();
        }
        return context;
    }

    // singleton
    //private för att ej kunna göra instanser av denna någon annanstans
    private ApplicationContext(){
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
