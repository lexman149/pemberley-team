/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.*;

/**
 *
 * @author mbp
 */
public class MapControl {
    
    public String playerNavigate(String direction, Player player) {
        Room currentRoom = player.getLocation();
        Room nextRoom;
        direction = direction.toUpperCase();
        direction = direction.trim();
        System.out.println(direction);
        switch (direction) { 
        case"E":
        case"EAST":    
            nextRoom = currentRoom.getEast(); 
            break;
        case"S":
        case"South":
            nextRoom = currentRoom.getSouth(); 
            break;
        case"N":
        case"North":
            nextRoom = currentRoom.getNorth(); 
            break;
        case"W":
        case"West":
            nextRoom = currentRoom.getWest(); 
            break;
            
        default: 
            return "Not sure where you are going.";
            
        } 
        
        
        
        if (nextRoom == null) {
            return "You cannot go that direction. Please choose again.";
        }
        else {
            player.setLocation(nextRoom);
            return nextRoom.getDescription();
        }
    }
    
}
