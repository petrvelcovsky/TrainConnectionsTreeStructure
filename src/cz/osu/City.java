package cz.osu;

import java.util.ArrayList;

public class City {
    private String id;
    private String name;
    private String parentId;
    private String child1Id;
    private String child2Id;
    private  String child3Id;

    private City parent;
    private City child1;
    private City child2;
    private City child3;


    public City(String id, String name) {
        this.id = id;
        this.name = name;
        this.parent = null;
        this.child1 = null;
        this.child2 = null;
        this.child3 = null;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getChild1Id() {
        return child1Id;
    }

    public void setChild1Id(String child1Id) {
        this.child1Id = child1Id;
    }

    public String getChild2Id() {
        return child2Id;
    }

    public void setChild2Id(String child2Id) {
        this.child2Id = child2Id;
    }

    public String getChild3Id() {
        return child3Id;
    }

    public void setChild3Id(String child3Id) {
        this.child3Id = child3Id;
    }

    public City getParent() {
        return parent;
    }

    public void setParent(City parent) {
        this.parent = parent;
    }

    public City getChild1() {
        return child1;
    }

    public void setChild1(City child1) {
        this.child1 = child1;
    }

    public City getChild2() {
        return child2;
    }

    public void setChild2(City child2) {
        this.child2 = child2;
    }

    public City getChild3() {
        return child3;
    }

    public void setChild3(City child3) {
        this.child3 = child3;
    }



    @Override
    public String toString() {
        return "City named " + name + "has id: " + id;
    }

}
