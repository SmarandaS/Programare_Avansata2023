package homework.entities;


import javax.persistence.*;

@Entity
@Table(name = "albums")
public class Album {

    //cheia primara a tabelului
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //coloanele
    @Column(name = "title")
    private String title;

    @Column(name = "release_year")
    private int releaseYear;

    //pot fi mai multe albume la un artist
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist", referencedColumnName = "id")
    private Artist artist;

    //setteri si getteri
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
