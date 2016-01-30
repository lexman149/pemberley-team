package byui.cit260.pemberleyGame.model;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wilkerson-sheila
 */
public class Map implements Serializable{
    
     //class instance variables //
    private String name;
    private String room;
    
    
    // constructor function //
    public Map() {
    }

    // getters & setters // 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRooms() {
        return room;
    }

    public void setRooms(String room) {
        this.room = room;
    }
    
    // string, equals & hash //

    @Override
    public String toString() {
        return "Map{" + "Map Name = " + name + ", Room = " + room + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.room);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
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
        if (!Objects.equals(this.room, other.room)) {
            return false;
        }
        return true;
    }
    
}

