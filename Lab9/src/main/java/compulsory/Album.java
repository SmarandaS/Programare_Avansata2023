package compulsory;

import javax.persistence.*;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "release_year")
    private int relYear;
    @Column(name = "title")
    private String title;

    @Column(name = "artist_id")
    private int artistId;
    @Column(name = "genre_id")
    private int genreId;
    public Album() {}

    public Album(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelYear() {
        return relYear;
    }

    public void setRelYear(int relYear) {
        this.relYear = relYear;
    }
    
     @Override
    public String toString() {
        return "Album title: " + title;
    }
}
