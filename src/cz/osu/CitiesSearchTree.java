package cz.osu;

public class CitiesSearchTree {

    City root;

    public CitiesSearchTree() {}

    public void insert(City city){
        root = insertHelper(root, city);
    }

    private City insertHelper(City root, City city){
        String name = city.getName();
        String id = city.getId();

        return null;

    }

    public void display(){}

    private void displayHelper(City root){

    }

    public boolean search(String name){
        return false;
    }

    private boolean searchHelper(City root, String name){
        return false;
    }



}
