package model;

public class Occasion {
    private int id;
    private String name;
    private String description;
    private String date;
    private String location;

    public Occasion() {}

    public Occasion(int id, String name, String description, String date, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.location = location;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Occasion [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", location=" + location + "]";
    }
} 