package homework;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private int id;
    private String name;

    List<Album> albums;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
        this.albums = new ArrayList<>();
    }

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

    public void getArtist()
    {
        System.out.println(id + " " + name);

    }
    public void addAlbum(Album album)
    {
        albums.add(album);
        album.setArtist(this.id);
    }

    public List<Album> getAllAlbums() {
        return albums;
    }

    public void printAllAlbums() {
        for(Album album : albums ) {
            System.out.println(album.getTitle() + " ");
        }
    }

}
