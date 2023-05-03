import java.util.ArrayList;


/**
 * Creates list and map of all buildings, houses, cafes and libraries.
 */
public class CampusMap {

    ArrayList<Building> buildings;
    ArrayList <House> houses;
    ArrayList <Cafe> cafes;
    ArrayList <Library> libraries;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
        houses= new ArrayList<House>();
        cafes= new ArrayList<Cafe>();
        libraries= new ArrayList<Library>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * Prints out list of all buildings in array list.
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        //DONT COPY AND PASTE ITS NOT NEEDED LOL
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        //added buildings
        myMap.addBuilding(new Building("Seelye Hall", "2 Clark Street Northampton, MA 01063", 4));
        //added houses
        myMap.addBuilding(new House("Chase", "3 Elm Street Northampton, MA 01063", 4, true, true));
         myMap.addBuilding(new House("Gardiner", "1 Paradise Street Northampton, MA 01063", 4, true, true));
         myMap.addBuilding(new House("Duckett", "4 Elm Street Street Northampton, MA 01063", 4, true, true));
         myMap.addBuilding(new House("Tyler", "1 Green Street Northampton, MA 01063", 4, true, true));
         // added cafes
         myMap.addBuilding(new Cafe("Compass Cafe", "1 College Lane Street Northampton, MA 01063", 4, 3, 3, 3));
         myMap.addBuilding(new Cafe("Campus Center Cafe", "3 College Lane Street Northampton, MA 01063", 4, 3, 3, 3));
         //added libraries
         myMap.addBuilding(new Library());
         myMap.addBuilding(new Library("Hillyer Art Library", "9 Elm Street Northampton, MA 01063", 4));
         myMap.addBuilding(new Library("Josten Music Library", "12 Clark Street Northampton, MA 01063", 4));
        
        System.out.println(myMap);
    }
    
}
