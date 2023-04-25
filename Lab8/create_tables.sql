CREATE TABLE artists (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE genres (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE albums (
    id INTEGER PRIMARY KEY,
    release_year INTEGER NOT NULL,
    title TEXT NOT NULL,
    artist_id INTEGER,
    genre_id  INTEGER 
);

CREATE TABLE album_genres (
    album_id INTEGER,
    genre_id INTEGER
);
