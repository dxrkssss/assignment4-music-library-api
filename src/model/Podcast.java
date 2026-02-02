package model;

public class Podcast extends Media {

    private int duration;

    public Podcast(int id, String name, int duration) {
        super(id, name);
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getType() {
        return "PODCAST";
    }
}
