package compulsory;

import java.sql.*;

public class Main {
    public static void main(String args[]) {
        try {
            var artists = new ArtistDAO();


            artists.create(1,"Pink Floyd");
            artists.create(2,"Michael Jackson");
            artists.create(3,"Queen");
            Database.getConnection().commit();

            var genres = new GenreDAO();
            genres.create(1,"Rock");
            genres.create(2,"Pop");
            Database.getConnection().commit();

            var albums = new AlbumDAO();
            albums.create(1,1979, 1, 1, "The Wall");
            albums.create(2,1982, 2, 2, "Thriller");
            albums.create(3,1991, 3, 1, "Innuendo");

            Database.getConnection().commit();



            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgrespass");
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM albums")) {

                System.out.println("Albums in the database:");
                while (rs.next()) {
                    Integer albumId = rs.getInt("id");
                    System.out.print(albumId + " ");
                    Integer relYear = rs.getInt("release_year");
                    System.out.print(relYear + " ");
                    try (Connection conn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgrespass");
                         Statement stmt2 = conn2.createStatement();
                         ResultSet rs2 = stmt2.executeQuery("SELECT name FROM artists WHERE id = (SELECT artist_id FROM albums WHERE id = " + albumId + ")")) {
                        while (rs2.next()) {
                            String artistName = rs2.getString(1);
                            System.out.print(artistName + " ");
                        }

                    } catch (SQLException e) {
                        System.out.println("Error connecting to the database: " + e.getMessage());
                    }
                    try (Connection conn3 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgrespass");
                         Statement stmt3 = conn3.createStatement();
                         ResultSet rs3 = stmt3.executeQuery("SELECT name FROM genres WHERE id = (SELECT genre_id FROM albums WHERE id = " + albumId + ")")) {
                        while (rs3.next()) {
                            String genreName = rs3.getString(1);
                            System.out.print(genreName + " ");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error connecting to the database: " + e.getMessage());
                    }

                    String title = rs.getString("title");
                    System.out.println(title);
                }
            } catch (SQLException e) {
                System.out.println("Error connecting to the database: " + e.getMessage());
            }
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }

        Database.closeConnection();
    }
}
