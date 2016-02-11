package byui.cit260.pemberleyGame.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jpmanning
 */
public class Inventory implements Serializable {
    
    //class instance variables
    private String contents;
    private double currentWeight;

    public Inventory() {
    }
    
    

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public String toString() {
        return "Inventory{" + "contents=" + contents + ", currentWeight=" + currentWeight + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.contents);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.currentWeight) ^ (Double.doubleToLongBits(this.currentWeight) >>> 32));
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
        final Inventory other = (Inventory) obj;
        if (!Objects.equals(this.contents, other.contents)) {
            return false;
        }
        if (Double.doubleToLongBits(this.currentWeight) != Double.doubleToLongBits(other.currentWeight)) {
            return false;
        }
        return true;
    }

    
}
