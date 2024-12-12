package cz.osu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserCsv {

    String path;


    public ParserCsv(String path) {
        this.path = path;
    }

    public ArrayList<RawCity> parseCities (){

        List<String> allRows = FileManager.convertFileToLines(path);
        ArrayList<RawCity> parsedCities = new ArrayList<>();

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

            RawCity newCity = new RawCity(id, name, parentId, child1Id, child2Id, child3Id);

            parsedCities.add(newCity);

        }
        return parsedCities;
    }

    public RawCity findRoot (ArrayList<RawCity> cities){

        for (RawCity city: cities) {
            if (city.getParentId() == null){
                return city;
            }
        }

        return null;
    }

    public RawCity findCity (ArrayList<RawCity> cities, String id){

        for (RawCity city: cities) {
            if (city.getId().equals(id)){
                return city;
            }
        }

        return null;

    }

}