/*
 * Test files - instances of the classes
 */
package pemberleygame;

import byui.cit260.pemberleyGame.model.Location;
import byui.cit260.pemberleyGame.model.Player;
import byui.cit260.pemberleyGame.model.Room;
import pemberleyGame.model.Game;
import pemberleyGame.model.Item;
import pemberleyGame.model.Map;


/**
 *
 * @author jpmanning
 */
public class PemberleyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Player playerOne = new Player();
      
      playerOne.setName("John Doe");
      playerOne.setLocation("Library");
      playerOne.setGender("Male");
      
      String playerInfo = playerOne.toString();
      System.out.println(playerInfo);
      
      Location library = new Location();
      library.setName("Library");
      library.setDescription("This is the library.  It is large and impressive");
      
      String locationInfo = library.toString();
      System.out.println(locationInfo);
      
     Room drawingRoom = new Room();
     
     drawingRoom.setName("Drawing Room");
     drawingRoom.setDescription("The drawing room is comfortable");
     drawingRoom.setNorth("ballRoom");
     drawingRoom.setEast("diningRoom");
     drawingRoom.setSouth("greatHall");
     drawingRoom.setWest("gallery");
     drawingRoom.setVisited(true);

     
     String roomInfo = drawingRoom.toString();
     System.out.println(roomInfo);
     
     // instances inserted by sheila //
    Game gameOne = new Game();
        
    gameOne.setTimeRemaining(45);

    String gameInfo = gameOne.toString();
    System.out.println(gameInfo);


    Map mapOne = new Map();

    mapOne.setName("Finneas house");
    mapOne.setRooms("Secret lab");

    String mapInfo = mapOne.toString();
    System.out.println(mapInfo);


    Item itemOne = new Item();
    itemOne.setDescription("love letter");
    itemOne.setLocation("ballroom");
    itemOne.setName("letter");
    itemOne.setType("reusable");
    String itemInfo = itemOne.toString();
    System.out.println(itemInfo);
      
    }
    
}
