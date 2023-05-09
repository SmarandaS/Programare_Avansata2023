package compulsory;

import javax.persistence.*;
import java.util.List;

public class ArtistRepository {

    private EntityManagerFactory emf;

    public ArtistRepository() {
        emf = PersistenceUtil.getEntityManagerFactory();
    }

    public void create(Artist artist) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
    }

    public Artist findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Artist.class, id);
        } finally {
            em.close();
        }
    }

    public List<Artist> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Artist> query = em.createNamedQuery("Artist.findByName", Artist.class);
            query.setParameter(1, name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
