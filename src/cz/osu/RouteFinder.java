package cz.osu;

import java.util.Map;

public class RouteFinder {

    private Map<String, City> cityMap;

    public RouteFinder(Map<String, City> cityMap) {
        this.cityMap = cityMap;
    }

    public RouteFinder() {
    }

    public City findRootCity() {
        for (City city : cityMap.values()) {
            if (city.getParent() == null) {
                return city;
            }
        }
        return null;
    }

    public City findCityByName(String cityName) {
        for (City city : cityMap.values()) {
            if (city.getName().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        return null;
    }

    public void traverseTreePreorder(City city){

        if (city == null){
            return;
        }
        
        Printer.printCityOnly(city);

        if (city.getChildren() != null){
            for (City child: city.getChildren()) {
                traverseTreePreorder(child);
            }
        }
    }

    public void traceParentsUpToRoot(City city){

        Printer.printCityOnly(city);

        if (city.getParent() == null){
            return;
        }

        traceParentsUpToRoot(city.getParent());
    }

    public City searchRootByTraceParents(City city){

        if (city.getParent() == null){
            return city;
        }
        else{
            return searchRootByTraceParents(city.getParent());
        }
    }


    public City searchCityByTraverseTreePreorder(City city, String cityName){

        if (city.getChildren() == null){
            return city;
        } else {
            for (City child: city.getChildren()) {
                return searchCityByTraverseTreePreorder(child, cityName);
            }
        }
       return null;
    }


}
