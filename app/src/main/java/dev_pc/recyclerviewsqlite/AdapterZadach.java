package dev_pc.recyclerviewsqlite;

/**
 * Created by Dev-pc on 27.12.2017.
 */

public class AdapterZadach  {
    private int Id;
    private String Name;
    private String Inf;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInf() {
        return Inf;
    }

    public void setInf(String inf) {
        Inf = inf;
    }


    public AdapterZadach(int id, String name, String inf) {
        Id = id;
        Name = name;
        Inf = inf;
    }

    @Override
    public String toString() {
        return "AdapterZadach{" +
                "Name='" + Name + '\'' +
                ", Inf='" + Inf + '\'' +
                '}';
    }
}
