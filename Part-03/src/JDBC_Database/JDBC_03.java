package JDBC_Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Working with music database
class Music {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION = "jdbc:sqlite:C:\\Java DB\\sqlite-jdbc\\db\\" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUMS_ID = "_id";
    public static final String COLUMN_ALBUMS_NAME = "name";
    public static final String COLUMN_ALBUMS_ARTIST = "artist";

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONGS_ID = "id";
    public static final String COLUMN_SONGS_TRACK = "track";
    public static final String COLUMN_SONGS_TITLE = "title";
    public static final String COLUMN_SONGS_ALBUM = "album";

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + '.' + COLUMN_ALBUMS_NAME + " FROM " +
                    TABLE_ALBUMS + " INNER JOIN " + TABLE_ARTISTS + " ON " +
                    TABLE_ALBUMS + '.' + COLUMN_ALBUMS_ARTIST + " = " +
                    TABLE_ARTISTS + '.' + COLUMN_ARTISTS_ID + " WHERE " +
                    TABLE_ARTISTS + '.' + COLUMN_ARTISTS_NAME + " = \"";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + '.' + COLUMN_ALBUMS_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_FOR_SONG_START =
            "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " +
                   TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + ", " + TABLE_SONGS +
                   "." + COLUMN_SONGS_TRACK + " FROM " + TABLE_SONGS + " INNER JOIN " +
                    TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONGS_ALBUM + " = " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST + " = " + TABLE_ARTISTS + "." +
                    COLUMN_ARTISTS_ID + " WHERE " + TABLE_SONGS + "." + COLUMN_SONGS_TITLE + " = \"";

    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME +
            ", " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + " AS " + COLUMN_SONGS_ALBUM + ", " +
            TABLE_SONGS + "." + COLUMN_SONGS_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONGS_TITLE +
            " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONGS_ALBUM +
            " = " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " +
            TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID +
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " + TABLE_ALBUMS +
            "." + COLUMN_ALBUMS_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONGS_TRACK;

    private Connection conn;

    public boolean openConnection() {
        try {
            conn = DriverManager.getConnection(CONNECTION);
            return true;
        } catch (SQLException e) {
            System.out.println("Database Connection: " + e.getMessage());
            return false;
        }
    }

    public List<Artist> queryArtists(int sortOrder) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTISTS_NAME);
            sb.append(" COLLATE NOCASE ");

            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sb.toString())) {

            List<Artist> artists = new ArrayList<>();

            while (rs.next()) {
                Artist artist = new Artist();
                artist.setId(rs.getInt(COLUMN_ARTISTS_ID));
                artist.setName(rs.getString(COLUMN_ARTISTS_NAME));
                artists.add(artist);
            }

            return artists;

        } catch (SQLException e) {
            System.out.println("Query Artist: " + e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbumsForArtist(String artistName, int sortOrder) {
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artistName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);

            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        System.out.println("SQL Statement: " + sb.toString());

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sb.toString())) {
            List<String> albums = new ArrayList<>();
            while (rs.next()) {
                albums.add(rs.getString(COLUMN_ALBUMS_NAME));
            }

            return albums;
        } catch (SQLException e) {
            System.out.println("Query Failed: " + e.getMessage());
            return null;
        }
    }

    public List<SongArtist> queryArtistsForSong(String songName, int sortOrder) {
        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        sb.append(songName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ARTIST_FOR_SONG_SORT);

            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        System.out.println("SQL Statement: " + sb.toString());
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sb.toString())) {
            List<SongArtist> songArtists = new ArrayList<>();
            while (rs.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(rs.getString(1));
                songArtist.setAlbumName(rs.getString(2));
                songArtist.setTrack(rs.getInt(3));
                songArtists.add(songArtist);
            }

            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query Failed: " + e.getMessage());
            return null;
        }
    }

    public void querySongsMetadata() {
        String sql = "SELECT * FROM " + TABLE_SONGS;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData rsm = rs.getMetaData();
            int numsColumns = rsm.getColumnCount();

            for (int i = 1; i < numsColumns; i++) {
                System.out.format("Column %d in the songs tables is name %s\n", i, rsm.getColumnName(i));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getCount(String table) {
        String sql = "SELECT COUNT(*), MIN(_id) FROM " + table;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            int count = rs.getInt(1);
            int min = rs.getInt(2);

            System.out.println("Count: " + count);
            System.out.println("Min: " + min);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean createViewForSongArtists() {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE_ARTIST_FOR_SONG_VIEW);

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Database Connection Close: " + e.getMessage());
        }
    }
}

class Artist {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Album {
    private int id, artistID;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Song {
    private int id, track, albumID;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class SongArtist {
    private String artistName, albumName;
    private int track;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }
}

public class JDBC_03 {
    public static void main(String[] args) {
        Music music = new Music();
        if (music.openConnection()) {
            System.out.println("Database Connected.");
        } else {
            System.out.println("Error Database Connection");
        }

        List<Artist> artists = music.queryArtists(Music.ORDER_BY_NONE);

        if (artists == null) {
            System.out.println("No Artists");
            return;
        }

        for (Artist artist: artists) {
            System.out.println("ID: " + artist.getId());
            System.out.println("Name: " + artist.getName());
            System.out.println("---------------------------");
        }

        List<String> albumsForArtist = music.queryAlbumsForArtist("Pink Floyd", Music.ORDER_BY_ASC);

        for (String album: albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = music.queryArtistsForSong("Go Your Own Way", Music.ORDER_BY_ASC);
        if (songArtists == null) {
            System.out.println("No Song");
            return;
        }

        for (SongArtist artist: songArtists) {
            System.out.println("Artist Name: " + artist.getArtistName());
            System.out.println("Album Name: " + artist.getAlbumName());
            System.out.println("Track: " + artist.getTrack());
            System.out.println("-------------------");
        }

        music.querySongsMetadata();

        music.getCount(Music.TABLE_SONGS);

        music.createViewForSongArtists();

        music.closeConnection();
    }
}
