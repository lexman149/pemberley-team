package byui.cit260.pemberleyGame.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wilkerson-sheila
 */
public class Item implements Serializable{

    //class instance variables //
    private String name;
    private Location location;
    private String description;
    private boolean takable;
    private String takeMessage;
    
    // constructor function //
    public Item() {
    }

    // getters & setters //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTakable() {
        return takable;
    }

    public void setTakable(boolean takable) {
        this.takable = takable;
    }

    public String getTakeMessage() {
        return takeMessage;
    }

    public void setTakeMessage(String takeMessage) {
        this.takeMessage = takeMessage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.location);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + (this.takable ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.takeMessage);
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
        final Item other = (Item) obj;
        if (this.takable != other.takable) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.takeMessage, other.takeMessage)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", location=" + location + ", description=" + description + ", takable=" + takable + ", takeMessage=" + takeMessage + '}';
    }

    
    
    
    
    
}
