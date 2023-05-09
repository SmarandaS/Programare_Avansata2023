package homework;


import javax.persistence.*;

public class PersistenceUtil {

    private static final String PERSISTENCE_UNIT_NAME = "my-persistence-unit";
    private static EntityManagerFactory emf;

    private PersistenceUtil() {

    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }

    public static  void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            emf = null;
        }
    }
}