package compulsory;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = PersistenceUtil.getEntityManagerFactory();
        ArtistRepository artistRepository = new ArtistRepository();

        Artist artist1 = new Artist("Michael Jackson");
        Artist artist2 = new Artist("Queen");
        Artist artist3 = new Artist("Pink Floyd");
        artistRepository.create(artist1);
        artistRepository.create(artist2);
        artistRepository.create(artist3);

        List<Artist> artists = artistRepository.findByName("Queen");
        System.out.println(artists);
        System.out.println(artistRepository.findById(2));

    }
}
