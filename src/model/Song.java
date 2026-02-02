package model;

public class Song extends Media {

    private int duration;

    public Song(int id, String name, int duration) {
        super(id, name);
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getType() {
        return "SONG";
    }
}
