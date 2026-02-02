package model;

public class Song extends Media {
    private int duration;

    public Song(int id, String name, int duration) {
        super(id, name);
        this.duration = duration;
    }

    public String getType() {
        return "SONG";
    }

    public int getDuration() {
        return duration;
    }
}