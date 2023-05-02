package homework;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    public AlbumDAO() throws SQLException{
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM albums")) {
            pstmt.executeUpdate();
        }
    }
    public void create(Album album) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (id, release_year, artist_id, genre_id, title) values (?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, album.getAlbumId());
            pstmt.setInt(2, album.getReleaseYear());
            pstmt.setInt(3, album.getArtistId());
            pstmt.setInt(4, album.getGenreId());
            pstmt.setString(5, album.getTitle());
            pstmt.executeUpdate();
        }
    }

    public Integer findByTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + title + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id=" + id)) {
            return rs.next() ? rs.getString(5) : null;
        }

    }

    protected String createFindAllQuery() {
        return "SELECT * FROM albums";
    }
    public List<StringBuilder> findAll() throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(createFindAllQuery())) {
            List<StringBuilder> albumList= new ArrayList<>();
            while (resultSet.next()) {
                StringBuilder sb = new StringBuilder();
                int albumId = resultSet.getInt("id");
                sb.append(resultSet.getInt("id"));
                sb.append(" ");
                sb.append(resultSet.getInt("release_year"));
                sb.append(" ");
                try (Connection conn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgrespass");
                     Statement stmt2 = conn2.createStatement();
                     ResultSet rs2 = stmt2.executeQuery("SELECT name FROM artists WHERE id = (SELECT artist_id FROM albums WHERE id = " + albumId + ")")) {
                    while (rs2.next()) {
                        sb.append(rs2.getString(1));
                        sb.append(" ");
                    }

                } catch (SQLException e) {
                    System.out.println("Error connecting to the database: " + e.getMessage());
                }
                try (Connection conn3 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgrespass");
                     Statement stmt3 = conn3.createStatement();
                     ResultSet rs3 = stmt3.executeQuery("SELECT name FROM genres WHERE id = (SELECT genre_id FROM albums WHERE id = " + albumId + ")")) {
                    while (rs3.next()) {
                        sb.append(rs3.getString(1));
                        sb.append(" ");
                    }
                } catch (SQLException e) {
                    System.out.println("Error connecting to the database: " + e.getMessage());
                }

                sb.append(resultSet.getString("title"));

                albumList.add(sb);
            }
            return albumList;
        }
    }
}

