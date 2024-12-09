package cz.osu;

import java.util.ArrayList;

public class City {
    private String id;
    private String name;
    private City parent;
    private ArrayList<City> children;


    public City(String id, String name) {
        this.id = id;
        this.name = name;
        this.parent = null;
        this.children = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getParent() {
        return parent;
    }

    public ArrayList<City> getChildren() {
        return children;
    }

    public void setParent(City parent) {
        this.parent = parent;
    }

    public void setChildren(ArrayList<City> children) {
        this.children = children;
    }

}
