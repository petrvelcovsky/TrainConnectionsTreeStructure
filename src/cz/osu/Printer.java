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

   // public static void printCityTree(Map<String, City> cityMap){
   //     for (City city : cityMap.values()) {
   //         System.out.println("City: " + city.getName());
   //         if (city.getParent() != null) {
   //             System.out.println(" Parent: " + city.getParent().getName());
   //         }
   //         if (city.getChildren() != null) {
   //             for (City child : city.getChildren()) {
   //                 System.out.println("  Child: " + child.getName());
   //             }
   //         }
   //     }
   // }


}
