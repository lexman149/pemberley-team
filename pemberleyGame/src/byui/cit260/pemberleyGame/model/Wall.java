/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pemberleyGame.model;

import java.io.Serializable;

/**
 *
 * @author Mel
 */
public enum Wall implements Serializable{

   xWall(" -------------- "),
   leftWall(" | "),
   rightWall("| "),
   empty ("                "),
   west ("=| "),
   east ("|="), 
   vertPassage("      | |       "),
   emptyWall (" |            | ");
   
   private final String wall;

    
    private Wall(String wallString) {
        this.wall = wallString;
    }

    public static Wall getxWall() {
        return xWall;
    }

    public static Wall getLeftWall() {
        return leftWall;
    }

    public static Wall getRightWall() {
        return rightWall;
    }

    public static Wall getEmpty() {
        return empty;
    }

    public static Wall getWest() {
        return west;
    }

    public static Wall getEast() {
        return east;
    }

    public static Wall getEmptyWall() {
        return emptyWall;
    }

    public String getWall() {
        return wall;
    }

    
    
    @Override
    public String toString() {
        return "Wall{" + "wall=" + wall + '}';
    }
    
    

    
    
    
}