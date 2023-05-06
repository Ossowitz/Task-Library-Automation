package us.ossowitz.springcourse.models;

public class Music {
    private String name;
    private int id;

    public Music(int id, String name) {
        this.id = id;
        this.name = name;
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
