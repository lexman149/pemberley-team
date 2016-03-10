package byui.cit260.pemberleyGame.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author wilkerson-sheila
 */
public class Game implements Serializable{
    
   // class instance variables //
   private Player playerOne;
   private Map [] maps;
   private Item [] allItemArray;
   private Actor [] allActorArray;
   private Item [] localItemArray;
   private Actor [] localActorArray;
   private Quest [] allQuestArray;
   private Item[] inventoryItemArray;
   private String [] localItemNames;
   private String [] localActorNames;
   private String [] inventoryItemNames;
   private Room currentRoom;
   private Map currentMap;
   private User user;
   private Room[] rooms;
   
    
    // constructor function //
    public Game() {
        
        
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Map[] getMaps() {
        return maps;
    }

    public void setMaps(Map[] maps) {
        this.maps = maps;
    }

    public Item[] getAllItemArray() {
        return allItemArray;
    }

    public void setAllItemArray(Item[] allItemArray) {
        this.allItemArray = allItemArray;
    }

    public Actor[] getAllActorArray() {
        return allActorArray;
    }

    public void setAllActorArray(Actor[] allActorArray) {
        this.allActorArray = allActorArray;
    }

    public Item[] getLocalItemArray() {
        return localItemArray;
    }

    public void setLocalItemArray(Item[] localItemArray) {
        this.localItemArray = localItemArray;
    }

    public Actor[] getLocalActorArray() {
        return localActorArray;
    }

    public void setLocalActorArray(Actor[] localActorArray) {
        this.localActorArray = localActorArray;
    }

    public Quest[] getAllQuestArray() {
        return allQuestArray;
    }

    public void setAllQuestArray(Quest[] allQuestArray) {
        this.allQuestArray = allQuestArray;
    }

    public Item[] getInventoryItemArray() {
        return inventoryItemArray;
    }

    public void setInventoryItemArray(Item[] inventoryItemArray) {
        this.inventoryItemArray = inventoryItemArray;
    }

    public String[] getLocalItemNames() {
        return localItemNames;
    }

    public void setLocalItemNames(String[] localItemNames) {
        this.localItemNames = localItemNames;
    }

    public String[] getLocalActorNames() {
        return localActorNames;
    }

    public void setLocalActorNames(String[] localActorNames) {
        this.localActorNames = localActorNames;
    }

    public String[] getInventoryItemNames() {
        return inventoryItemNames;
    }

    public void setInventoryItemNames(String[] inventoryItemNames) {
        this.inventoryItemNames = inventoryItemNames;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.playerOne);
        hash = 83 * hash + Arrays.deepHashCode(this.maps);
        hash = 83 * hash + Arrays.deepHashCode(this.allItemArray);
        hash = 83 * hash + Arrays.deepHashCode(this.allActorArray);
        hash = 83 * hash + Arrays.deepHashCode(this.localItemArray);
        hash = 83 * hash + Arrays.deepHashCode(this.localActorArray);
        hash = 83 * hash + Arrays.deepHashCode(this.allQuestArray);
        hash = 83 * hash + Arrays.deepHashCode(this.inventoryItemArray);
        hash = 83 * hash + Arrays.deepHashCode(this.localItemNames);
        hash = 83 * hash + Arrays.deepHashCode(this.localActorNames);
        hash = 83 * hash + Arrays.deepHashCode(this.inventoryItemNames);
        hash = 83 * hash + Objects.hashCode(this.currentRoom);
        hash = 83 * hash + Objects.hashCode(this.currentMap);
        hash = 83 * hash + Objects.hashCode(this.user);
        hash = 83 * hash + Arrays.deepHashCode(this.rooms);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.playerOne, other.playerOne)) {
            return false;
        }
        if (!Arrays.deepEquals(this.maps, other.maps)) {
            return false;
        }
        if (!Arrays.deepEquals(this.allItemArray, other.allItemArray)) {
            return false;
        }
        if (!Arrays.deepEquals(this.allActorArray, other.allActorArray)) {
            return false;
        }
        if (!Arrays.deepEquals(this.localItemArray, other.localItemArray)) {
            return false;
        }
        if (!Arrays.deepEquals(this.localActorArray, other.localActorArray)) {
            return false;
        }
        if (!Arrays.deepEquals(this.allQuestArray, other.allQuestArray)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inventoryItemArray, other.inventoryItemArray)) {
            return false;
        }
        if (!Arrays.deepEquals(this.localItemNames, other.localItemNames)) {
            return false;
        }
        if (!Arrays.deepEquals(this.localActorNames, other.localActorNames)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inventoryItemNames, other.inventoryItemNames)) {
            return false;
        }
        if (!Objects.equals(this.currentRoom, other.currentRoom)) {
            return false;
        }
        if (!Objects.equals(this.currentMap, other.currentMap)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Arrays.deepEquals(this.rooms, other.rooms)) {
            return false;
        }
        return true;
       
    }

    @Override
    public String toString() {
        return "Game{" + "playerOne=" + playerOne + ", maps=" + maps + ", allItemArray=" + allItemArray + ", allActorArray=" + allActorArray + ", localItemArray=" + localItemArray + ", localActorArray=" + localActorArray + ", allQuestArray=" + allQuestArray + ", inventoryItemArray=" + inventoryItemArray + ", localItemNames=" + localItemNames + ", localActorNames=" + localActorNames + ", inventoryItemNames=" + inventoryItemNames + ", currentRoom=" + currentRoom + ", currentMap=" + currentMap + ", user=" + user + ", rooms=" + rooms + '}';
    }

    
    

    
    
    
    
    
}
