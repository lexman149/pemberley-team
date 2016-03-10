/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.Actor;
import byui.cit260.pemberleyGame.model.Game;
import byui.cit260.pemberleyGame.model.Room;
import java.util.ArrayList;

/**
 *
 * @author mbp
 */
public class ActorControl {
// returns the actors in a location with all their attributes
       public Actor[] createLocalActorArray(Game game) {
//set the current location to wherever the player is.
        Room currentLocation = game.getCurrentRoom();
        Actor [] allActorArray = game.getAllActorArray();
//create an ArrayList to hold all of the actors in the above location.
        ArrayList<Actor> localActorList = new ArrayList<Actor>();
        for (Actor i : allActorArray) {
            Room currentActorLocation = i.getLocation();
            if (currentActorLocation == currentLocation) {
                localActorList.add(i);
            }
        }
        Actor[] localActorArray = localActorList.toArray(new Actor[localActorList.size()]);
        return localActorArray;
    }
    
    
    // returns a string of the actors without their non-name attributes
    public String[] createActorNameList(Actor[] actorArray) {
        ArrayList<String> actorList = new ArrayList<String>();
        for (Actor i : actorArray) {
            actorList.add(i.getName().toUpperCase());
        }
        String[] actorNameList = actorList.toArray(new String[actorList.size()]);
        return actorNameList;
    }
    
    
}
