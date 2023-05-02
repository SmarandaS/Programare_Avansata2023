package homework;


import java.sql.*;

public class Main {
    public static void main(String args[]) {
        try {


            var artists = new ArtistDAO();

            Artist pf = new Artist(1,"Pink FLoyd");
            artists.create(pf);
            Artist mj = new Artist(2, "Michael Jackson");
            artists.create(mj);
            Artist q = new Artist(3, "Queen");
            artists.create(q);


            var genres = new GenreDAO();
            Genre rock = new Genre(1, "Rock");
            genres.create(rock);
            Genre pop = new Genre(2,"Pop");
            genres.create(pop);


            var albums = new AlbumDAO();
            Album wall = new Album(1,1979,1,1,"The Wall", pf, rock);
            albums.create(wall);
            Album thriller = new Album(2,1982,2,2,"Thriller", mj, pop);
            albums.create(thriller);
            Album innuendo = new Album(3,1991,3,1,"Innuendo", q,rock);
            albums.create(innuendo);




            mj.addAlbum(thriller);
            mj.printAllAlbums();
            System.out.println("\n");


            var allAlbs = albums.findAll();

            for(StringBuilder title : allAlbs)
            {
                System.out.println(title);
            }

            System.out.println("\n");

            var allGens = genres.findAll();

            for(String name : allGens)
            {
                System.out.println(name);
            }

            System.out.println("\n");


            var allArt = artists.findAll();

            for(String name : allArt)
            {
                System.out.println(name);
            }


            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }

        Database.closeConnectionPool();
    }
}
