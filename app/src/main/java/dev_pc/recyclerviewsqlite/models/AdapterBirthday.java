package dev_pc.recyclerviewsqlite.models;

/**
 * Created by Dev-pc on 15.01.2018.
 */

public class AdapterBirthday {
    private int id;
    private String name;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public AdapterBirthday(int id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    @Override
    public String toString() {
        return "AdapterBirthday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
