package Exercise;

// Exercise 33 - Playlist

import java.util.ArrayList;
import java.util.LinkedList;

class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + ": " + duration;
    }
}

class Album {
    private String name, artist;
    private ArrayList<Song> songs;
    private LinkedList<Song> playlist;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
        this.playlist = new LinkedList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title,duration));
            return true;
        }

        return false;
    }

    public Song findSong(String title) {
        for(Song song : songs) {
            if(song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

//    public boolean addToPlaylist(int trackNumber, Song playlist) {
//        if(findSong(trackNumber) != null) {
//            this.playlist.add(findSong(trackNumber));
//            return true;
//        } else {
//            System.out.println("Could not find song " + trackNumber + " in " + songs + " album");
//            return false;
//        }
//    }

    public boolean addToPlaylist(String title, Song playlist) {
        if(findSong(title) != null) {
            this.playlist.add(findSong(title));
            return true;
        } else {
            System.out.println("Could not find song " + title + " in " + songs + " album");
            return false;
        }
    }
}

public class Exercise_33 {
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);
    }
}
