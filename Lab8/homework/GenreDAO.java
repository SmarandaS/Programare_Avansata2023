package homework;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {

    public GenreDAO() throws SQLException{
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM genres")) {
            pstmt.executeUpdate();
        }
    }
    public void create(Genre genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (id, name) values (?, ?)")) {
            pstmt.setInt(1, genre.getId());
            pstmt.setString(2, genre.getName());
            pstmt.executeUpdate();
        }
    }
    public Genre findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres where name='" + name + "'")) {
            if (rs.next()) {
                int id = rs.getInt("id");
                String genreName = rs.getString("name");
                return new Genre(id, genreName);
            } else {
                return null;
            }
        }
    }

    public Genre findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, name from artists where id=" + id)) {
            if (rs.next()) {
                int genreId = rs.getInt("id");
                String genreName = rs.getString("name");
                Genre genre = new Genre(genreId, genreName);
                return genre;
            } else {
                return null;
            }
        }
    }

    protected String createFindAllQuery() {
        return "SELECT * FROM genres";
    }
    public List<String> findAll() throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(createFindAllQuery())) {
            List<String> genreList= new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                //System.out.println(title);
                genreList.add(name);
            }
            return genreList;
        }
    }

}

