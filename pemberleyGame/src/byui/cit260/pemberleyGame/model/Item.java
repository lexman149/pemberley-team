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
    private String description;
    private Location location;
    private Location alternateLocation;
    private String alternateDescription;
    private boolean takable;
    private boolean alternateTakable;
    private boolean usable;
    private boolean alternateUsable;
    private boolean multiple;
    private int quantity;
    private double weight;
    private String takeMessage;
    private String alternateTakeMessage;
    private String useMessage;
    private String alternateUseMessage;
    private Quest quest;
    private Item contains;
    
    
    public Item() {
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getAlternateLocation() {
        return alternateLocation;
    }

    public void setAlternateLocation(Location alternateLocation) {
        this.alternateLocation = alternateLocation;
    }

    public String getAlternateDescription() {
        return alternateDescription;
    }

    public void setAlternateDescription(String alternateDescription) {
        this.alternateDescription = alternateDescription;
    }

    public boolean isTakable() {
        return takable;
    }

    public void setTakable(boolean takable) {
        this.takable = takable;
    }

    public boolean isAlternateTakable() {
        return alternateTakable;
    }

    public void setAlternateTakable(boolean alternateTakable) {
        this.alternateTakable = alternateTakable;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public boolean isAlternateUsable() {
        return alternateUsable;
    }

    public void setAlternateUsable(boolean alternateUsable) {
        this.alternateUsable = alternateUsable;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getTakeMessage() {
        return takeMessage;
    }

    public void setTakeMessage(String takeMessage) {
        this.takeMessage = takeMessage;
    }

    public String getAlternateTakeMessage() {
        return alternateTakeMessage;
    }

    public void setAlternateTakeMessage(String alternateTakeMessage) {
        this.alternateTakeMessage = alternateTakeMessage;
    }

    public String getUseMessage() {
        return useMessage;
    }

    public void setUseMessage(String useMessage) {
        this.useMessage = useMessage;
    }

    public String getAlternateUseMessage() {
        return alternateUseMessage;
    }

    public void setAlternateUseMessage(String alternateUseMessage) {
        this.alternateUseMessage = alternateUseMessage;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public Item getContains() {
        return contains;
    }

    public void setContains(Item contains) {
        this.contains = contains;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.description);
        hash = 23 * hash + Objects.hashCode(this.location);
        hash = 23 * hash + Objects.hashCode(this.alternateLocation);
        hash = 23 * hash + Objects.hashCode(this.alternateDescription);
        hash = 23 * hash + (this.takable ? 1 : 0);
        hash = 23 * hash + (this.alternateTakable ? 1 : 0);
        hash = 23 * hash + (this.usable ? 1 : 0);
        hash = 23 * hash + (this.alternateUsable ? 1 : 0);
        hash = 23 * hash + (this.multiple ? 1 : 0);
        hash = 23 * hash + this.quantity;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.takeMessage);
        hash = 23 * hash + Objects.hashCode(this.alternateTakeMessage);
        hash = 23 * hash + Objects.hashCode(this.useMessage);
        hash = 23 * hash + Objects.hashCode(this.alternateUseMessage);
        hash = 23 * hash + Objects.hashCode(this.quest);
        hash = 23 * hash + Objects.hashCode(this.contains);
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
        if (this.alternateTakable != other.alternateTakable) {
            return false;
        }
        if (this.usable != other.usable) {
            return false;
        }
        if (this.alternateUsable != other.alternateUsable) {
            return false;
        }
        if (this.multiple != other.multiple) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.alternateDescription, other.alternateDescription)) {
            return false;
        }
        if (!Objects.equals(this.takeMessage, other.takeMessage)) {
            return false;
        }
        if (!Objects.equals(this.alternateTakeMessage, other.alternateTakeMessage)) {
            return false;
        }
        if (!Objects.equals(this.useMessage, other.useMessage)) {
            return false;
        }
        if (!Objects.equals(this.alternateUseMessage, other.alternateUseMessage)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.alternateLocation, other.alternateLocation)) {
            return false;
        }
        if (!Objects.equals(this.quest, other.quest)) {
            return false;
        }
        if (!Objects.equals(this.contains, other.contains)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", description=" + description + ", location=" + location + ", alternateLocation=" + alternateLocation + ", alternateDescription=" + alternateDescription + ", takable=" + takable + ", alternateTakable=" + alternateTakable + ", usable=" + usable + ", alternateUsable=" + alternateUsable + ", multiple=" + multiple + ", quantity=" + quantity + ", weight=" + weight + ", takeMessage=" + takeMessage + ", alternateTakeMessage=" + alternateTakeMessage + ", useMessage=" + useMessage + ", alternateUseMessage=" + alternateUseMessage + ", quest=" + quest + ", contains=" + contains + '}';
    }

    
}
