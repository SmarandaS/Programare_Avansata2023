package compulsory;

import java.sql.*;

public class AlbumDAO {

    public AlbumDAO() throws SQLException{
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM albums")) {
            pstmt.executeUpdate();
        }
    }
    public void create(int albumId, int releaseYear, int artistId, int genreId, String title) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (id, release_year, artist_id, genre_id, title) values (?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, albumId);
            pstmt.setInt(2, releaseYear);
            pstmt.setInt(3, artistId);
            pstmt.setInt(4, genreId);
            pstmt.setString(5, title);
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
}

