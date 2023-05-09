package homework;

import compulsory.PersistenceUtil;
import homework.entities.Album;
import homework.entities.Artist;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = PersistenceUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        //fake artists + persist
        List<Artist> artists = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Artist artist = new Artist();
            artist.setName("Artist " + i);
            artists.add(artist);
        }

        long begin = System.currentTimeMillis();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        for (Artist artist : artists)
        {
            em.persist(artist);
        }

        em.flush();
        transaction.commit();
        long finish = System.currentTimeMillis();
        long execTime = finish - begin;
        System.out.println("Inserting " + artists.size() + " artists took " + execTime + " ms.");

        em.close();
        emf.close();

    }
}