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
      private String north;
      private String east;
      private String south;
      private String west;
      private String up;
      private String down;
      private boolean visited; 

    public Room() {
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.north);
        hash = 67 * hash + Objects.hashCode(this.east);
        hash = 67 * hash + Objects.hashCode(this.south);
        hash = 67 * hash + Objects.hashCode(this.west);
        hash = 67 * hash + Objects.hashCode(this.up);
        hash = 67 * hash + Objects.hashCode(this.down);
        hash = 67 * hash + (this.visited ? 1 : 0);
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
        if (!Objects.equals(this.up, other.up)) {
            return false;
        }
        if (!Objects.equals(this.down, other.down)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Room{" + "north=" + north + ", east=" + east + ", south=" + south + ", west=" + west + ", up=" + up + ", down=" + down + ", visited=" + visited + " Location{" + "name=" + name + ", description=" + description + '}';
    }


      
      
      
    
}
