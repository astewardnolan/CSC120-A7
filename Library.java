/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building {
  private Hashtable <String, Boolean> collection;
  private boolean hasElevator;


// First constructor, only creates Neilson library, name, address, nFloors, and Elevator all hardcoded.
    public Library(){
        this("Neilson Library","1 College Lane Street Northampton, MA 01063", 4, true);

    }

    //overload now can be any library, but applies to older libraries with no elevators, Elevator boolean hardcoded to false.
    public Library (String name, String address, int nFloors){
        this(name, address, nFloors, false);
    }
    
    //secodn overload, now library can have elevator.
    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.collection= new Hashtable<String, Boolean>();
        this.hasElevator= hasElevator;
    
        System.out.println("You have built a library: 📖");
        }
/**
 * accesses if Library has elevator, if not, throws exception
 * @return hasElevator boolean
 */
    public boolean hasElevator(){
        return this.hasElevator;
      }
    public void goToFloor(int floorNum) {
        if (this.hasElevator){
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
        }else{
            throw new RuntimeException("goToFloor method invalid, house has no elevator");
        }
    }

    /**
     * shows class methods
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle\n + removeTitle\n + checkOut\n + returnBook\n + containsTitle\n + isAvailable\n + printCollection");
    }
   /**
    * add book to the library
    * @param title title of the book
    */ 
    public void addTitle(String title){
      if (this.collection.containsKey(title)){
        throw new RuntimeException("The book "+ title + " already exists in this Library.");
      }else{
      this.collection.put(title, true);
    }
  }
    /**
     * removes title from the library
     * @param title title of the book
     * @return returns itile
     */
    public String removeTitle(String title){
      if (this.collection.containsKey(title)){
        this.collection.remove(title);
        return (title);        
      }else{
        throw new RuntimeException("The book "+ title + " does not exist in this Library.");
    }
  }

//first method, every person will check out the book War and Peace
/**
 * checks out War and Peace everytime
 */
  public void checkOut(){
    System.out.println("you have checked out War and Peace");
    
  }

// first overload, now different books can be checked out based on title, title will then be removed from collection
/**
 * checks out book
 * @param title title of book
 */
    public void checkOut(String title){
      System.out.println("you have checked out "+ title);
      this.collection.replace(title, false);
    }
/**
 * changes boolean from false to true, returning a book
 * @param title title of book
 */
    public void returnBook(String title){
      System.out.println("you have returned "+ title);
      this.collection.replace(title, true);
    }
/**
 * checks to see if book title is in collection
 * @param title title of book
 * @return true or flase based on if book is in collection
 */
    public boolean containsTitle(String title){
      if (this.collection.containsKey(title)){
        return true;
    
      }else{
        return false;
      }
    }
/**
 * checks if boolean value is true making book availbe
 * @param title title of book
 * @return title of book
 */
    public boolean isAvailable(String title ){
      if (this.collection.containsKey(title) && this.collection.get(title).equals(true)){
        
        System.out.println("Yes! " + title +" is availble");
        return this.collection.get(title);
        
      }else{
        throw new RuntimeException("Sorry "+ title+ " is unavailble, it is currently checked out or not owned by this library.");
      }
    }
/**
 * prints out collection of book titles and if availbe or not.
 */
    public void printCollection(){
      this.collection.forEach((title, avail)-> System.out.println("availible: "+ avail + "  title: " + title));}
    
  
    public static void main(String[] args) {
      Library Hillyer= new Library("Hillyer","3 chapinn way", 4);
      Hillyer.addTitle("loraz");
      Hillyer.addTitle("barbie");
      Hillyer.printCollection();
      Hillyer.isAvailable("barbie");
      Hillyer.checkOut("barbie");
      Hillyer.printCollection();
      //Hillyer.removeTitle("hi");
      Hillyer.isAvailable("hi");


    }
  
  }

