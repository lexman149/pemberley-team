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
    private String completionAction;
    boolean movesActor;
    boolean movesItem;
    boolean changesActorScript;
    boolean movesPlayer;
    boolean changesItemsTakable;
    Actor actorToChange;
    Item itemToChange;
    Location potentialLocationActor1;
    Location potentialLocationItem1;
    String changeActorScript;
    
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

    public String getCompletionAction() {
        return completionAction;
    }

    public void setCompletionAction(String completionAction) {
        this.completionAction = completionAction;
    }

    public boolean isMovesActor() {
        return movesActor;
    }

    public void setMovesActor(boolean movesActor) {
        this.movesActor = movesActor;
    }

    public boolean isMovesItem() {
        return movesItem;
    }

    public void setMovesItem(boolean movesItem) {
        this.movesItem = movesItem;
    }

    public boolean isChangesActorScript() {
        return changesActorScript;
    }

    public void setChangesActorScript(boolean changesActorScript) {
        this.changesActorScript = changesActorScript;
    }

    public boolean isMovesPlayer() {
        return movesPlayer;
    }

    public void setMovesPlayer(boolean movesPlayer) {
        this.movesPlayer = movesPlayer;
    }

    public boolean isChangesItemsTakable() {
        return changesItemsTakable;
    }

    public void setChangesItemsTakable(boolean changesItemsTakable) {
        this.changesItemsTakable = changesItemsTakable;
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

    public Location getPotentialLocationActor1() {
        return potentialLocationActor1;
    }

    public void setPotentialLocationActor1(Location potentialLocationActor1) {
        this.potentialLocationActor1 = potentialLocationActor1;
    }

    public Location getPotentialLocationItem1() {
        return potentialLocationItem1;
    }

    public void setPotentialLocationItem1(Location potentialLocationItem1) {
        this.potentialLocationItem1 = potentialLocationItem1;
    }

    public String getChangeActorScript() {
        return changeActorScript;
    }

    public void setChangeActorScript(String changeActorScript) {
        this.changeActorScript = changeActorScript;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.needs);
        hash = 79 * hash + (this.completed ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.completionScript);
        hash = 79 * hash + Objects.hashCode(this.completionAction);
        hash = 79 * hash + (this.movesActor ? 1 : 0);
        hash = 79 * hash + (this.movesItem ? 1 : 0);
        hash = 79 * hash + (this.changesActorScript ? 1 : 0);
        hash = 79 * hash + (this.movesPlayer ? 1 : 0);
        hash = 79 * hash + (this.changesItemsTakable ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.actorToChange);
        hash = 79 * hash + Objects.hashCode(this.itemToChange);
        hash = 79 * hash + Objects.hashCode(this.potentialLocationActor1);
        hash = 79 * hash + Objects.hashCode(this.potentialLocationItem1);
        hash = 79 * hash + Objects.hashCode(this.changeActorScript);
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
        if (this.movesActor != other.movesActor) {
            return false;
        }
        if (this.movesItem != other.movesItem) {
            return false;
        }
        if (this.changesActorScript != other.changesActorScript) {
            return false;
        }
        if (this.movesPlayer != other.movesPlayer) {
            return false;
        }
        if (this.changesItemsTakable != other.changesItemsTakable) {
            return false;
        }
        if (!Objects.equals(this.completionScript, other.completionScript)) {
            return false;
        }
        if (!Objects.equals(this.completionAction, other.completionAction)) {
            return false;
        }
        if (!Objects.equals(this.changeActorScript, other.changeActorScript)) {
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
        if (!Objects.equals(this.potentialLocationActor1, other.potentialLocationActor1)) {
            return false;
        }
        if (!Objects.equals(this.potentialLocationItem1, other.potentialLocationItem1)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quest{" + "needs=" + needs + ", completed=" + completed + ", completionScript=" + completionScript + ", completionAction=" + completionAction + ", movesActor=" + movesActor + ", movesItem=" + movesItem + ", changesActorScript=" + changesActorScript + ", movesPlayer=" + movesPlayer + ", changesItemsTakable=" + changesItemsTakable + ", actorToChange=" + actorToChange + ", itemToChange=" + itemToChange + ", potentialLocationActor1=" + potentialLocationActor1 + ", potentialLocationItem1=" + potentialLocationItem1 + ", changeActorScript=" + changeActorScript + '}';
    }

    
    
    
    
    
    
}
