package cz.osu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserCsv {

    String path;

    ArrayList<City> parsedCities = new ArrayList<>();

    public ParserCsv(String path) {

        this.path = path;
        parsedCities = parseCities ();
    }

    public ArrayList<City> parseCities (){

        List<String> allRows = FileManager.convertFileToLines(path);

        //prvni smycka pro vytvoreni zakladu se Stringy
        for (String row : allRows.subList(1, allRows.size())) {

            String[] column = row.split(";");

            String id = column[0];
            String name = column[1];
            String parentId = null;
            String child1Id = null;
            String child2Id = null;
            String child3Id = null;

            if (!column[2].isEmpty()) {parentId = column[2];}
            if (column.length > 3 && !column[3].isEmpty()) {child1Id = column[3];}
            if (column.length > 4 && !column[4].isEmpty()) {child2Id = column[4];}
            if (column.length > 5 &&!column[5].isEmpty()) {child3Id = column[5];}

            City newCity = new City(id, name);

            newCity.setParentId(parentId);
            newCity.setChild1Id(child1Id);
            newCity.setChild2Id(child2Id);
            newCity.setChild3Id(child3Id);

            parsedCities.add(newCity);


        }
        return parsedCities;
    }

    public City findRoot (){

        for (City city: parsedCities) {
            if (city.getParentId() == null){
                return city;
            }
        }

        return null;
    }

    public City findCity (String id){

        for (City city: parsedCities) {
            if (city.getId().equals(id)){
                return city;
            }
        }

        return null;

    }

}