package byui.cit260.pemberleyGame.model;

import java.io.Serializable;

/**
 *
 * @author wilkerson-sheila
 */
public class Game implements Serializable{
    
    // class instance variables //
    private int timeRemaining;
    
    // constructor function //
    public Game() {
    }
    
   // getters & setters //
    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }
    // string, equals & hash //

    @Override
    public String toString() {
        return "Game{" + "Time Remaining = " + timeRemaining + " seconds" + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.timeRemaining;
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
        final Game other = (Game) obj;
        if (this.timeRemaining != other.timeRemaining) {
            return false;
        }
        return true;
    }
    
}
