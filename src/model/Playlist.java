package model;

import java.util.List;

public class Playlist {
    private int id;
    private String name;
    private List<Media> mediaList;

    public Playlist(int id, String name, List<Media> mediaList) {
        this.id = id;
        this.name = name;
        this.mediaList = mediaList;
    }

    public int getTotalDuration() {
        int total = 0;
        for (Media m : mediaList) {
            total += m.getDuration();
        }
        return total;
    }
}