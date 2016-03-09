package byui.cit260.pemberleyGame.model;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author jpmanning
 */
public class Actor implements Serializable{
    
    //class instance variables
    private String name;
    private Room location;
    private Room alternateLocation;
    private String description;
    private String alternateDescription;
    private String characterScript;
    private String AlternateCharacterScript;
    private Quest quest;
    private Quest alternateQuest;
   
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

    public Room getAlternateLocation() {
        return alternateLocation;
    }

    public void setAlternateLocation(Room alternateLocation) {
        this.alternateLocation = alternateLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlternateDescription() {
        return alternateDescription;
    }

    public void setAlternateDescription(String alternateDescription) {
        this.alternateDescription = alternateDescription;
    }

    public String getCharacterScript() {
        return characterScript;
    }

    public void setCharacterScript(String characterScript) {
        this.characterScript = characterScript;
    }

    public String getAlternateCharacterScript() {
        return AlternateCharacterScript;
    }

    public void setAlternateCharacterScript(String AlternateCharacterScript) {
        this.AlternateCharacterScript = AlternateCharacterScript;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public Quest getAlternateQuest() {
        return alternateQuest;
    }

    public void setAlternateQuest(Quest alternateQuest) {
        this.alternateQuest = alternateQuest;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.location);
        hash = 67 * hash + Objects.hashCode(this.alternateLocation);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.alternateDescription);
        hash = 67 * hash + Objects.hashCode(this.characterScript);
        hash = 67 * hash + Objects.hashCode(this.AlternateCharacterScript);
        hash = 67 * hash + Objects.hashCode(this.quest);
        hash = 67 * hash + Objects.hashCode(this.alternateQuest);
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
        if (!Objects.equals(this.alternateDescription, other.alternateDescription)) {
            return false;
        }
        if (!Objects.equals(this.characterScript, other.characterScript)) {
            return false;
        }
        if (!Objects.equals(this.AlternateCharacterScript, other.AlternateCharacterScript)) {
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
        if (!Objects.equals(this.alternateQuest, other.alternateQuest)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", location=" + location + ", alternateLocation=" + alternateLocation + ", description=" + description + ", alternateDescription=" + alternateDescription + ", characterScript=" + characterScript + ", AlternateCharacterScript=" + AlternateCharacterScript + ", quest=" + quest + ", alternateQuest=" + alternateQuest + '}';
    }

  
    
    
    
}
