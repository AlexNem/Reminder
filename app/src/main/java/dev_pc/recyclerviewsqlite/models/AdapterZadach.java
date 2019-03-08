package dev_pc.recyclerviewsqlite.models;



public class AdapterZadach  {
    private int id;
    private String name;
    private String inf;


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

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }


    public AdapterZadach(int id, String name, String inf) {
        this.id = id;
        this.name = name;
        this.inf = inf;
    }

    @Override
    public String toString() {
        return "AdapterZadach{" +
                "name='" + name + '\'' +
                ", inf='" + inf + '\'' +
                '}';
    }
}
