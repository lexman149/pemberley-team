package byui.cit260.pemberleyGame.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author jpmanning
 */
public class Quest implements Serializable{

    //class instance variables
    private Item needs;
    private boolean completed;
    private String completionScript;
    private Actor actorToChange;
    private Item itemToChange;
    private Player player;
    private Room roomToChange;
    private Room playerDestination;
    
    public Quest() {
    }

    public Item getNeeds() {
        return needs;
    }

    public void setNeeds(Item needs) {
        this.needs = needs;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCompletionScript() {
        return completionScript;
    }

    public void setCompletionScript(String completionScript) {
        this.completionScript = completionScript;
    }

    public Actor getActorToChange() {
        return actorToChange;
    }

    public void setActorToChange(Actor actorToChange) {
        this.actorToChange = actorToChange;
    }

    public Item getItemToChange() {
        return itemToChange;
    }

    public void setItemToChange(Item itemToChange) {
        this.itemToChange = itemToChange;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Room getRoomToChange() {
        return roomToChange;
    }

    public void setRoomToChange(Room roomToChange) {
        this.roomToChange = roomToChange;
    }

    public Room getPlayerDestination() {
        return playerDestination;
    }

    public void setPlayerDestination(Room playerDestination) {
        this.playerDestination = playerDestination;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.needs);
        hash = 29 * hash + (this.completed ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.completionScript);
        hash = 29 * hash + Objects.hashCode(this.actorToChange);
        hash = 29 * hash + Objects.hashCode(this.itemToChange);
        hash = 29 * hash + Objects.hashCode(this.player);
        hash = 29 * hash + Objects.hashCode(this.roomToChange);
        hash = 29 * hash + Objects.hashCode(this.playerDestination);
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
        final Quest other = (Quest) obj;
        if (this.completed != other.completed) {
            return false;
        }
        if (!Objects.equals(this.completionScript, other.completionScript)) {
            return false;
        }
        if (!Objects.equals(this.needs, other.needs)) {
            return false;
        }
        if (!Objects.equals(this.actorToChange, other.actorToChange)) {
            return false;
        }
        if (!Objects.equals(this.itemToChange, other.itemToChange)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.roomToChange, other.roomToChange)) {
            return false;
        }
        if (!Objects.equals(this.playerDestination, other.playerDestination)) {
            return false;
        }
        return true;
    }
   
}