package cz.osu;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ParserCsv parser = new ParserCsv("./dataRoute.csv");
        parser.parseCities();

        CitiesSearchTree searchTree = new CitiesSearchTree();

        RouteFinder routeFinder = new RouteFinder();

        City rootCity = routeFinder.findRootCity();

        System.out.println("ROOT CITY: ");
        Printer.printCityOnly(rootCity);

        //System.out.println("ALL CITIES STRUCTURE: ");
        //Printer.printCityTree(cityMap);

        //System.out.println("TRAVERSED TREE: ");
        //routeFinder.traverseTreePreorder(rootCity);

        City searchedCity = routeFinder.findCityByName("Mohelnice");

        //System.out.println("TRAVERSED TREE: ");
        //routeFinder.traverseTreePreorder(searchedCity);

        if (searchedCity != null){
            System.out.println("UP TO ROOT: ");
            routeFinder.traceParentsUpToRoot(searchedCity);
        } else {
            System.out.println("Searched city is not in the tree.");
        }

        System.out.println("-----------------");

        City rootCityA = routeFinder.searchRootByTraceParents(searchedCity);

        if (rootCityA != null){
            System.out.println("ROOT: ");
            System.out.println(rootCityA.getName());
        } else {
            System.out.println("Root city is not in the tree.");
        }


    }
}
