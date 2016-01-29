/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pemberleygame;

import byui.cit260.pemberleyGame.model.Location;
import byui.cit260.pemberleyGame.model.Player;
import byui.cit260.pemberleyGame.model.Room;

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


     
     String roomInfo = drawingRoom.toString();
     System.out.println(roomInfo);
     
     
     
      
    }
    
}
