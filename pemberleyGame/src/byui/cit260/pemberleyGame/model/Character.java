package byui.cit260.pemberleyGame.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jpmanning
 */
public class Character implements Serializable{
    
    //class instance variables
    private String name;
    private String location;
    private String description;
    private String characterScript;
    
    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacterScript() {
        return characterScript;
    }

    public void setCharacterScript(String characterScript) {
        this.characterScript = characterScript;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.location);
        hash = 13 * hash + Objects.hashCode(this.description);
        hash = 13 * hash + Objects.hashCode(this.characterScript);
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
        final Character other = (Character) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.characterScript, other.characterScript);
    }

    @Override
    public String toString() {
        return "Character{" + "name=" + name + ", location=" + location + ", description=" + description + ", characterScript=" + characterScript + '}';
    }
    
    
    
    
    
    
    
}
