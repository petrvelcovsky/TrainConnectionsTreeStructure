package cz.osu;

import java.util.Map;

public class RouteFinder {

    private City root;

    public RouteFinder(City root) {
        this.root = root;
    }


    public void traverseTreePreorder(City city){

        if (city == null){
            return;
        }
        
        Printer.printCityOnly(city);

        if (city.getChild1() != null){
                traverseTreePreorder(city.getChild1());
        }
        if (city.getChild2() != null){
            traverseTreePreorder(city.getChild2());
        }
        if (city.getChild2() != null){
            traverseTreePreorder(city.getChild2());
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




}
