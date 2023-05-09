package homework.repos;

import homework.entities.Album;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepo extends AbstractRepository<Album, Integer> implements AlbumRepoInt{
    public AlbumRepo() {
        super(Album.class);
    }

    @Override
    public List<Album> findByTitle(String title) {
        TypedQuery<Album> query = entityManager.createQuery("SELECT a FROM Album a WHERE a.title LIKE CONCAT('%', :title, '%')", Album.class);
        query.setParameter("title", title);
        return executeQuery(query);
    }

    @Override
    public List<Album> findByReleaseYear(int releaseYear) {
        TypedQuery<Album> query = entityManager.createQuery("SELECT a FROM Album a WHERE a.releaseYear = :releaseYear", Album.class);
        query.setParameter("releaseYear", releaseYear);
        return executeQuery(query);
    }


    @Override
    public <S extends Album> S save(S entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    @Override
    public <S extends Album> Iterable<S> saveAll(Iterable<S> entities) {
        return super.saveAll(entities);
    }
}
