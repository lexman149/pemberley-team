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

    public Inventory() {
    }
    
    

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.contents);
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
        final Inventory other = (Inventory) obj;
        if (!Objects.equals(this.contents, other.contents)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventory{" + "contents=" + contents + '}';
    }

    public void setInventory(String keys) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}
