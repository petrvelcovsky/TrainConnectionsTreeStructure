package cz.osu;


public class Main {
    public static void main(String[] args) {

        CitiesTree citiesTree = new CitiesTree();

        citiesTree.display();

        citiesTree.searchParentByName("Hlučín");
        System.out.println(citiesTree.root.getName());

    }
}
