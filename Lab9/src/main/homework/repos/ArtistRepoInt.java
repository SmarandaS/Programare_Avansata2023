package homework.repos;

import homework.CrudRepository;
import homework.entities.Artist;

import java.util.List;

public interface ArtistRepoInt extends CrudRepository<Artist, Integer> {

    List<Artist> findByName(String name);

}

