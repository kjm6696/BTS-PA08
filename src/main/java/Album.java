import java.util.ArrayList;

public class Album implements Comparable<Album> {
    int id;
    String name;
    String title;
    int songs;

    public Album(int id, String name, String title, int songs) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.songs = songs;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSongs() {
        return songs;
    }

    public void setSongs(int songs) {
        this.songs = songs;
    }

    @Override
    public int compareTo(Album data) {
        return Integer.compare(this.songs, data.songs);
    }

    @Override
    public String toString() {
        return id + ": " + songs + " -- " + "[" + name + "]";
    }
}
