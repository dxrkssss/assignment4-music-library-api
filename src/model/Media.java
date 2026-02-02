package model;

public abstract class Media {
    protected int id;
    protected String name;

    public Media(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String getType();
    public abstract int getDuration();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
}