package byui.cit260.pemberleyGame.model;

import java.io.Serializable;
import byui.cit260.pemberleyGame.model.*;
import byui.cit260.pemberleyGame.control.*;
import java.util.*;

/**
 *
 * @author jpmanning
 */
public class Actor implements Serializable{
    
    //class instance variables
    private String name;
    private Room location;
    private String description;
    private String characterScript;
    Quest quest;
   
    public Actor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
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

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.location);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.characterScript);
        hash = 79 * hash + Objects.hashCode(this.quest);
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
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.characterScript, other.characterScript)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.quest, other.quest)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", location=" + location + ", description=" + description + ", characterScript=" + characterScript + ", quest=" + quest + '}';
    }

    
    
    
    
    
}
