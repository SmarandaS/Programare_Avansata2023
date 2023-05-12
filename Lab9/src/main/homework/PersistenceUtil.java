package homework;


import javax.persistence.*;

public class PersistenceUtil {

    private static final String PERSISTENCE_UNIT_NAME = "my-persistence-unit";
    private static EntityManagerFactory emf;

    private PersistenceUtil() {

    }

    //daca nu exista persistence unit ul, il creeaza, altfel il returneaza
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }
    
//inchide Entity manager factory-ul
    public static  void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            emf = null;
        }
    }
}
