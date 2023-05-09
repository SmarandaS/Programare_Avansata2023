package homework.repos;

import homework.CrudRepository;
import homework.entities.Genre;

public interface GenreRepoInt extends CrudRepository<Genre, Integer> {

    Genre findByName(String name);

}
