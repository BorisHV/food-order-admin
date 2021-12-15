package instance;

import io.IOUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateInstance {


    public CreateInstance() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        IOUtils ioUtils = new IOUtils();
    }
}
