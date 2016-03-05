package byui.cit260.pemberleyGame.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author wilkerson-sheila
 */
public class Game implements Serializable{
    
    // class instance variables //
   private Player playerOne;
   private Map [] maps;
   private Item [] allItemArray;
   private Actor [] allActorArray;
   private Quest [] allQuestArray;
   
         
    
    // constructor function //
    public Game() {
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Map[] getMaps() {
        return maps;
    }

    public void setMaps(Map[] maps) {
        this.maps = maps;
    }

    public Item[] getAllItemArray() {
        return allItemArray;
    }

    public void setAllItemArray(Item[] allItemArray) {
        this.allItemArray = allItemArray;
    }

    public Actor[] getAllActorArray() {
        return allActorArray;
    }

    public void setAllActorArray(Actor[] allActorArray) {
        this.allActorArray = allActorArray;
    }

    public Quest[] getAllQuestArray() {
        return allQuestArray;
    }

    public void setAllQuestArray(Quest[] allQuestArray) {
        this.allQuestArray = allQuestArray;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.playerOne);
        hash = 97 * hash + Arrays.deepHashCode(this.maps);
        hash = 97 * hash + Arrays.deepHashCode(this.allItemArray);
        hash = 97 * hash + Arrays.deepHashCode(this.allActorArray);
        hash = 97 * hash + Arrays.deepHashCode(this.allQuestArray);
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.playerOne, other.playerOne)) {
            return false;
        }
        if (!Arrays.deepEquals(this.maps, other.maps)) {
            return false;
        }
        if (!Arrays.deepEquals(this.allItemArray, other.allItemArray)) {
            return false;
        }
        if (!Arrays.deepEquals(this.allActorArray, other.allActorArray)) {
            return false;
        }
        if (!Arrays.deepEquals(this.allQuestArray, other.allQuestArray)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "playerOne=" + playerOne + ", maps=" + maps + ", allItemArray=" + allItemArray + ", allActorArray=" + allActorArray + ", allQuestArray=" + allQuestArray + '}';
    }
   
    
}
