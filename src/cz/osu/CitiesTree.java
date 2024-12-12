package cz.osu;

public class CitiesTree {

    RawCity root;
    RawCity searched;

    public CitiesTree() {
        ParserCsv parserCsv = new ParserCsv("./dataRoute.csv");
        root = parserCsv.findRoot(parserCsv.parseCities());
        //searched = parserCsv.findCity(parserCsv.parseCities(), "e169c05a-1304-4421-9da1-1baaa0a5cef5");
    }


    City createTree(String cityId){
        String id = cityId;
        //String name = parserCsv.

        ////zakladni pripad
        //if (data == -1){       //tady bude asi empty string
        //    return null;
        //}
//
        ////rekurzivni pripad
        //City newCity = new City(id, name);
        //newCity.child1 = createTree(cit);
        //newCity.child2 = createTree(sc);
        //newCity.child3 = createTree(sc);
        //return newCity;

        return null;
    }




}
