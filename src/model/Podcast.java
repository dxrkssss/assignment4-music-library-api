package model;

public class Podcast extends Media {
    private int duration;

    public Podcast(int id, String name, int duration) {
        super(id, name);
        this.duration = duration;
    }

    public String getType() {
        return "PODCAST";
    }

    public int getDuration() {
        return duration;
    }
}