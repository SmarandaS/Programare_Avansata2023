package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class AlbumImporter {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";

    public static void importData(String filepath) {

        String csvFile = "C:/Users/smara_9yjfm5z/IdeaProjects/Lab8/albumlist.csv";
        String line = "";
        String cvsSplitBy = ",";
        int count = 0;
        int maxArtist = 0;
        int maxAlbum= 0;
        int maxGenre = 0;
        try (Connection conn1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgrespass");
             Statement stmt1 = conn1.createStatement();
             ResultSet rs = stmt1.executeQuery("SELECT MAX(id) FROM albums;")) {
            while (rs.next()) {
                maxAlbum = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }

        try (Connection conn1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgrespass");
             Statement stmt1 = conn1.createStatement();
             ResultSet rs = stmt1.executeQuery("SELECT MAX(id) FROM artists;")) {
            while (rs.next()) {
                maxArtist = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }

        try (Connection conn1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgrespass");
             Statement stmt1 = conn1.createStatement();
             ResultSet rs = stmt1.executeQuery("SELECT MAX(id) FROM genres;")) {
            while (rs.next()) {
                maxGenre = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgrespass");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO albums (id, release_year, title, artist_id, genre_id) VALUES (?, ?, ?, ?, ?)")) {

            Class.forName(JDBC_DRIVER);

            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                if (count > 0) {
                    maxAlbum++;
                    stmt.setInt(1, maxAlbum);
                    stmt.setString(2, data[1]);
                    stmt.setString(3, data[2]);
                    stmt.setString(3, data[3]);
                    stmt.setString(3, data[4]);

                    stmt.executeUpdate();
                }
                count++;
            }

            br.close();
            System.out.println("Import completed successfully.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();s
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
