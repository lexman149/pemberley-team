package byui.cit260.pemberleyGame.model;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author MMarriott
 */

/*since room is a subclass of Location, it doesn't need to implement Serializable.  
Location already does that
*/

public class Room extends Location{
    
       
    //class instance variables
      private Room north;
      private Room east;
      private Room south;
      private Room west;
      private Map map;
      private String[] roomDrawing;
      
    public Room() {
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String[] getRoomDrawing() {
        return roomDrawing;
    }

    public void setRoomDrawing(String[] roomDrawing) {
        this.roomDrawing = roomDrawing;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.north);
        hash = 83 * hash + Objects.hashCode(this.east);
        hash = 83 * hash + Objects.hashCode(this.south);
        hash = 83 * hash + Objects.hashCode(this.west);
        hash = 83 * hash + Objects.hashCode(this.map);
        hash = 83 * hash + Arrays.deepHashCode(this.roomDrawing);
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
        final Room other = (Room) obj;
        if (!Objects.equals(this.north, other.north)) {
            return false;
        }
        if (!Objects.equals(this.east, other.east)) {
            return false;
        }
        if (!Objects.equals(this.south, other.south)) {
            return false;
        }
        if (!Objects.equals(this.west, other.west)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Arrays.deepEquals(this.roomDrawing, other.roomDrawing)) {
            return false;
        }
        return true;
    }

    
    
    
}
