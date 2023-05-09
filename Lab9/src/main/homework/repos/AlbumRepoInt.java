package homework.repos;

import homework.entities.Album;
import homework.CrudRepository;

import java.util.List;

public interface AlbumRepoInt extends CrudRepository<Album, Integer>{

    List<Album> findByTitle(String title);

    List<Album> findByReleaseYear(int releaseYear);


}
