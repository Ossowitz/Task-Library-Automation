package us.ossowitz.springcourse.models;

public class Music {
    private String name;
    private int id;

    public Music(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Music() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
