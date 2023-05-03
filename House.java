/* This is a stub for the House class */
import java.util.ArrayList;

import javax.management.RuntimeErrorException;
/**
 * class creates house object
 */
public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Creates constructor for the House Class
   * @param name name of the house
   * @param address house address
   * @param nFloors number of floors in the house
   * @param hasDiningRoom boolean true or false if house has a dining room
   * @param hasElevator true or false if house has elevator
   */
  
   // first constructor, house has hardcoded single floor, it is a single story house with no possible dining room(because it is small house) or elevator
  /*
   * house constructor
   */
   public House(String name, String address){
    this(name, address, 1, true, false);
  }
// first overload, house now could have a dining room because it is bigger, still single story so hardcoded number of floors and no elevator
 /**
  * overloaded house constructor
  * @param name of house
  * @param address of house
  * @param hasDiningRoom true or false if house has dining room
  */
public House(String name, String address, boolean hasDiningRoom){
    this(name, address, 1, hasDiningRoom, false);
  }
  // second overload, house now can be mulitple stories, have a dining room, and have an elevator possibly 
   /**
    * second overload house constructor
    * @param name house
    * @param address house
    * @param nFloors in house
    * @param hasDiningRoom true or false if dining room
    * @param hasElevator true or false if has elevator
    */
  public House(String name, String address, int nFloors,boolean hasDiningRoom, boolean hasElevator ) {
    super(name, address, nFloors);
    this.residents= new ArrayList<String>();
    this.hasDiningRoom= hasDiningRoom;
    this.hasElevator= hasElevator;
    System.out.println("You have built a house: 🏠");
  }
  /**
   * String to describe whose the house's residents are, and if it has a dining room 
   */
  public String toString(){
    String description= super.toString();
    description += ". This house has " + this.residents.size() +" residents.";
    description += " This house";
    if (this.hasDiningRoom){
      description+= "has";
    }else{
      description += "does not have";
    }
    description += " a dining room";

    return description;
  }
  /**
   * accesses if house has elevator true or false
   * @return
   */
  public boolean hasElevator(){
    return this.hasElevator;
  }

  /**
   * Changes floor number
   * param- number of floors
   */
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
 * Shows options of class methods
 */
  public void showOptions() {//kep navigation from building class, added methods for house class
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n+ hasDiningRoom\n + nResidents\n + moveIn\n + moveOut\n+ isResident\n");
}

  /**
   * Accesses whether house has dining Room or not
   * @return boolean ture or false about dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
/**
 * accesses number of resident
 * @return the number of residents in the house
 */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * adds resident to house
   * @param name name of resident
   */
  public void moveIn(String name){
    if (this.residents.contains(name)){
      throw new RuntimeException("The resident "+ name + " already resides in the house.");
    }else{
    this.residents.add(name);
  }
}

/**
 * moves resident out of house
 * @param name name of resident 
 * @return returns residents name
 */
  public String moveOut(String name){
    if (this.residents.contains(name)){
      this.residents.remove(name);
      return name;
    }else{
      throw new RuntimeException("The resident "+ name + " does not live in the house.");
    }
  } 
  /**
   * checks if person is a resident of the house
   * @param person possible resident
   * @return true or false based if rhianna is resident of the house
   */

  public boolean isResident(String person){
    if (this.residents.contains(person)){
      System.out.println(person + "is a resident.");
      return true;
    }else{
      System.out.println(person +" is not a resident.");
      return false;
    }
  }

  public static void main(String[] args) {
    House Chase= new House("Chase", "1 chapin way", 3, false, true);
    System.out.println(Chase);
    Chase.moveIn("emma");
    Chase.moveIn("ava");
    System.out.println(Chase);
    Chase.moveOut("emma");
    System.out.println(Chase);
    Chase.isResident("ava");
    
  }
}