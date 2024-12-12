package cz.osu;

public class CitiesTree {

    RawCity root;
    RawCity searched;

    ParserCsv parserCsv = new ParserCsv("./dataRoute.csv");

    public CitiesTree() {

        root = parserCsv.findRoot();
        createTree(root.getId());
        //searched = parserCsv.findCity(parserCsv.parseCities(), "e169c05a-1304-4421-9da1-1baaa0a5cef5");
    }


    City createTree(String cityId){

        if (cityId == null){
            return null;
        }

        String id = cityId;
        String name = parserCsv.findCity(cityId).getName();

        //rekurzivni pripad
        City newCity = new City(id, name);

        newCity.setChild1(createTree(parserCsv.findCity(cityId).getChild1Id()));
        newCity.setChild2(createTree(parserCsv.findCity(cityId).getChild2Id()));
        newCity.setChild3(createTree(parserCsv.findCity(cityId).getChild3Id()));

        return newCity;

    }

}
