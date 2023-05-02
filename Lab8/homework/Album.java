package homework;

public class Album {

    private int albumId;
    private int releaseYear;
    private int artistId;
    private int genreId;
    private String title;
    private Artist artist;
    private Genre genre;

    public Album(int albumId, int releaseYear, int artistId, int genreId, String title, Artist artist, Genre genre) {
        this.albumId = albumId;
        this.releaseYear = releaseYear;
        this.artistId = artistId;
        this.genreId = genreId;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getArtistId() {
        return artistId;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getTitle() {
        return title;
    }

    public void setArtist(int id) {
        this.artistId = id;
    }

    public Artist getArtist() {

        return artist;
    }

    public void setGenre(int id) {
        this.genreId = id;
    }

    public Genre getGenre() {
        return genre;
    }
}
