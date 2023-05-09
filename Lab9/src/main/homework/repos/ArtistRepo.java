package homework.repos;

import homework.entities.Artist;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepo extends AbstractRepository<Artist, Integer> implements ArtistRepoInt {

    public ArtistRepo() {
        super(Artist.class);
    }

    @Override
    public List<Artist> findByName(String name) {
        TypedQuery<Artist> query = entityManager.createQuery("SELECT a FROM Artist a WHERE a.name LIKE CONCAT('%', :name, '%')", Artist.class);
        query.setParameter("name", name);
        return executeQuery(query);
    }


    @Override
    public <S extends Artist> S save(S entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }



    @Override
    public <S extends Artist> Iterable<S> saveAll(Iterable<S> entities) {
        return super.saveAll(entities);
    }
}

