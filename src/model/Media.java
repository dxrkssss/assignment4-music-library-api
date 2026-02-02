package model;

public abstract class Media {
    private int id;
    private String name;

    protected Media(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract int getDuration();
    public abstract String getType();

    public String getDisplayName() {
        return name + " (" + getType() + ")";
    }
}
