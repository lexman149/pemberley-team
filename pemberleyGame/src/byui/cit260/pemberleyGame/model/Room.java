package byui.cit260.pemberleyGame.model;

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
      private boolean visited; 

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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.north);
        hash = 53 * hash + Objects.hashCode(this.east);
        hash = 53 * hash + Objects.hashCode(this.south);
        hash = 53 * hash + Objects.hashCode(this.west);
        hash = 53 * hash + (this.visited ? 1 : 0);
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
        if (this.visited != other.visited) {
            return false;
        }
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
        return true;
    }

    @Override
    public String toString() {
        return "Room{" + "north=" + north + ", east=" + east + ", south=" + south + ", west=" + west + ", visited=" + visited + '}';
    }

   
    
}
