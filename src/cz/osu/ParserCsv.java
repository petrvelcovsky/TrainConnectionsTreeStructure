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

    //public Map<String, City> parseCities (){



    public void parseCities (){

        Map<String, City> cityMap = new HashMap<>(); //pomocny HashSet
        Map<String, String[]> relations = new HashMap<>(); //pomocny HashSet

        //CitiesSearchTree citiesTree = new CitiesSearchTree();

        List<String> allRows = FileManager.convertFileToLines(path);

        //prvni smycka pro vytvoreni zakladu se Stringy
        for (String row : allRows.subList(1, allRows.size())) {

            String[] column = row.split(";");

            String id = column[0];
            String name = column[1];

            City city = new City(id, name);

            String parentId = null;
            if (!column[2].isEmpty()) parentId = column[2];

            String[] children = new String[3];

            int j = 0;

            for (int i = 3; i < column.length; i++) {
                if (!column[i].isEmpty()){
                    children[j] = column[i];
                    j++;
                }
            }

            String[] parentAndChildren = {parentId, children[0], children[1], children[2]};

            cityMap.put(id, city);
            relations.put(id, parentAndChildren);

        }





        // druha smycka pro ropojeni rodicu a deti
        for (Map.Entry<String, String[]> entry : relations.entrySet()) {
            String parentId = entry.getValue()[0];
            City city = cityMap.get(entry.getKey());

            // pripojeni rodice
            if (parentId != null && cityMap.containsKey(parentId)) {
                city.setParent(cityMap.get(parentId));
            }

            // pripojení deti
            for (int i = 1; i < entry.getValue().length; i++) {
                String childId = entry.getValue()[i];
                if (childId != null && cityMap.containsKey(childId)) {
                    if (city.getChildren() == null) {
                        city.setChildren(new ArrayList<>());
                    }
                    city.getChildren().add(cityMap.get(childId));
                }
            }
        }
        //return cityMap;
    }

}
