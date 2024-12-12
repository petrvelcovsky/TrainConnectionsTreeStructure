package cz.osu;

public class CitiesTree {

    City root;

    ParserCsv parserCsv = new ParserCsv("./dataRoute.csv");

    public CitiesTree() {
        root = parserCsv.findRoot();
        connectChildren(root.getId());
        connectParents(root, null);
    }


    City connectChildren(String cityId){

        if (cityId == null){
            return null;
        }

        City newCity = parserCsv.findCity(cityId);

        newCity.setChild1(connectChildren(parserCsv.findCity(cityId).getChild1Id()));
        newCity.setChild2(connectChildren(parserCsv.findCity(cityId).getChild2Id()));
        newCity.setChild3(connectChildren(parserCsv.findCity(cityId).getChild3Id()));
        return newCity;
    }

    void connectParents(City city, City parent) {
        if (city == null) {
            return;
        }

        // Nastav rodiče aktuálního uzlu
        city.setParent(parent);

        // Rekurzivně nastav rodiče pro děti
        connectParents(city.getChild1(), city);
        connectParents(city.getChild2(), city);
        connectParents(city.getChild3(), city);
    }

    void display(){
        preorderPrint(root);
    }

    void preorderPrint(City city){

        if(city == null){
            return;
        }

        System.out.println(city.getName());
        preorderPrint(city.getChild1());
        preorderPrint(city.getChild2());
        preorderPrint(city.getChild3());
    }

    void searchParentByName(String name){
        City city = preorderSearchByName(root, name);
        System.out.println(city.getParent().getName());
    }

    City preorderSearchByName(City city, String name) {

        if (city == null) {
            return null;
        }

        if (city.getName().equals(name)) {
            return city;
        }

        City foundCity = preorderSearchByName(city.getChild1(), name);
        if (foundCity != null) {
            return foundCity;
        }

        foundCity = preorderSearchByName(city.getChild2(), name);
        if (foundCity != null) {
            return foundCity;
        }

        foundCity = preorderSearchByName(city.getChild3(), name);
        if (foundCity != null) {
            return foundCity;
        }

        return null; //pokud nic nenajde
    }



}
