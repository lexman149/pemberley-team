/*
 * Pemberley Game
 * BYUi CIT260
 * Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.*;

/**
 *
 * @author Alexis
 */
public class MapControl {
    
    public String playerNavigate(String direction, Player player) {
        Room currentRoom = player.getLocation();
        Room nextRoom;
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
            String playerMessage = "You move to the " + nextRoom.getName() + "\n";
//            return playerMessage.concat(nextRoom.getDescription());--- previous code.  Can delete if function has been graded.
            return this.lookAtRoom(player);//changed this to call the lookAtRoom function to display detailed descript of room.
        }
    }
    
    // author Sheila
    public String lookAtRoom(Player player) {
        Room currentRoom = player.getLocation(); 
        String roomDescription = currentRoom.getDescription();
        roomDescription = roomDescription + "\nThese are the directions you can move from here: ";
        
        if (currentRoom.getNorth() != null){
            roomDescription = roomDescription + "NORTH ";
        }
        if (currentRoom.getWest() != null){
            roomDescription = roomDescription + "WEST ";
        }
        if (currentRoom.getSouth() != null){
            roomDescription = roomDescription + "SOUTH ";
        }
        if (currentRoom.getEast() != null){
            roomDescription = roomDescription + "EAST ";
        }
            return roomDescription;
    }
}
