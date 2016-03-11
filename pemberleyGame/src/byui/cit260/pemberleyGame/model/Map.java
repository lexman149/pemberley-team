package byui.cit260.pemberleyGame.model;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author wilkerson-sheila
 */
public class Map implements Serializable{
    
     //class instance variables //
    private Room[] rooms;
    private String name;
    private String mapDrawing;
    private int[][] mapCoordinates;

    public Map() {
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMapDrawing() {
        return mapDrawing;
    }

    public void setMapDrawing(String mapDrawing) {
        this.mapDrawing = mapDrawing;
    }

    public int[][] getMapCoordinates() {
        return mapCoordinates;
    }

    public void setMapCoordinates(int[][] mapCoordinates) {
        this.mapCoordinates = mapCoordinates;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.deepHashCode(this.rooms);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.mapDrawing);
        hash = 97 * hash + Arrays.deepHashCode(this.mapCoordinates);
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
        final Map other = (Map) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.mapDrawing, other.mapDrawing)) {
            return false;
        }
        if (!Arrays.deepEquals(this.rooms, other.rooms)) {
            return false;
        }
        if (!Arrays.deepEquals(this.mapCoordinates, other.mapCoordinates)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "rooms=" + rooms + ", name=" + name + ", mapDrawing=" + mapDrawing + ", mapCoordinates=" + mapCoordinates + '}';
    }

    
}
