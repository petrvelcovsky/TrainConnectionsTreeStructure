package cz.osu;

import java.util.Map;

public class Printer {

    private City city;

    public Printer() {}

    public static void printCityOnly(City city){
        if (city != null) {
            System.out.println(city.getName());
        } else {
            System.out.println("Not found!");
        }
    }



}
