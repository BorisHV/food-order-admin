package instance;

import io.IOUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateInstance {
    private final static IOUtils IOUTILS = new IOUtils();
    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PU");

    public static IOUtils getIoUtils() {
        return IOUTILS;
    }

    public static EntityManagerFactory getEmf() {
        return EMF;
    }
}
