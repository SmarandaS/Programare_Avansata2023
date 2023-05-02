package homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Genre {

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Album> findAlbums() throws SQLException {
        // use the Database class to execute a SQL query to find all albums in this genre
        List<Album> albums = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM albums WHERE genre_id = " + id)) {
            while (rs.next()) {
                int albumId = rs.getInt("id");
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                int artistId = rs.getInt("artist_id");
                int genreId = rs.getInt("genre_id");
                var artist = new ArtistDAO().findById(artistId);
                var genre = new GenreDAO().findById(genreId);
                Album album = new Album(albumId, releaseYear, artistId, genreId, title, artist, genre);
                albums.add(album);
            }
        }
        return albums;
    }

}
