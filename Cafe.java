public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory


    //First constructor, Cafe can only be Dunkin, hard coded name
    public Cafe(String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this("Dunkin", address, nFloors, nCoffeeOunces, nSugarPackets, nCreams, nCups);
    }


    //overload 1, the cafe only sells one size of coffee, 16oz:, so nCoffeeOunces hardcoded, now cafe can have different names.
    public Cafe(String name, String address, int nFloors, int nSugarPackets, int nCreams, int nCups){
        this(name, address, nFloors, 16, nSugarPackets, nCreams, nCups);
    }

    //overload 2, cafe now has can be named anyhting, and sell multiple different sizes of coffee.  
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors); 
        this.nCoffeeOunces= nCoffeeOunces;
        this.nSugarPackets= nSugarPackets;
        this.nCreams= nCreams;
        this.nCups=nCups;
        System.out.println("You have built a cafe: ☕");
    }

   /**
    * shows options of class methods
    */
    public void showOptions() {//got rid of go up go down, assuming that cafe only one floor
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee\n");
    }

//First method, every coffee come with a default 3 creams and three sugars
/**
 * sells coffe with set three creams and sugars in every coffee
 * @param size of coffee
 */
    public void sellCoffee(int size){
        while (this.nCoffeeOunces< size){
            this.restock(100, 100, 100, 100);
            System.out.println("We have to restock our supplies to make your order, just a moment!");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= 3;
        this.nCreams -= 3;
        this.nCups -= 1;
        System.out.println("You have bought a "+ size+" ounce coffee with " + nSugarPackets+ " sugar packets and "+ nCreams +" creams!");
        }



    // overload, now coffees can come with different numbers of sugar and creams.
    /**
     * selles cup of coffee
     * @param size of coffee
     * @param nSugarPackets amount of sugar packets
     * @param nCreams number of creams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        while (this.nCoffeeOunces< size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams){
            this.restock(100,100,100,500);
            System.out.println("We have to restock our supplies to make your order, just a moment!");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("You have bought a "+ size+" ounce coffee with " + nSugarPackets+ " sugar packets and "+ nCreams +" creams!");
        }

    /**
     * restockes inventory by adding to paramenters
     * @param nCoffeeOunces ounces of coffee
     * @param nSugarPackets sugar packets
     * @param nCreams creams
     * @param nCups cups of coffee
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups; 
    }
    public static void main(String[] args) {
        Cafe Dunkin = new Cafe("dunkin", "5 chapin way", 3, 24, 50, 4, 20);
        Dunkin.sellCoffee(4, 1, 300);
    }
    
}


