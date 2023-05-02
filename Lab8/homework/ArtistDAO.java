package homework;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {

    public ArtistDAO() throws SQLException{
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM artists")) {
            pstmt.executeUpdate();
        }
    }

    public void create(Artist artist) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (id, name) values (?, ?)")) {
            pstmt.setInt(1, artist.getId());
            pstmt.setString(2, artist.getName());
            pstmt.executeUpdate();
        }
    }
    public Artist findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where name='" + name + "'")) {
            if (rs.next()) {
                int id = rs.getInt("id");
                String artistName = rs.getString("name");
                return new Artist(id, artistName);
            } else {
                return null;
            }
        }
    }

    public Artist findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, name from artists where id=" + id)) {
            if (rs.next()) {
                int artistId = rs.getInt("id");
                String artistName = rs.getString("name");
                Artist artist = new Artist(artistId, artistName);
                return artist;
            } else {
                return null;
            }
        }
    }

    protected String createFindAllQuery() {
        return "SELECT * FROM artists";
    }
    public List<String> findAll() throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(createFindAllQuery())) {
            List<String> artistList= new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                //System.out.println(title);
                artistList.add(name);
            }
            return artistList;
        }
    }

}

