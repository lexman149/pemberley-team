/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.Actor;
import byui.cit260.pemberleyGame.model.Player;
import byui.cit260.pemberleyGame.model.Room;
import java.util.ArrayList;

/**
 *
 * @author mbp
 */
public class ActorControl {

    public Actor[] createLocalActorArray(Player playerOne, Actor[] allActorArray) {
//set the current location to wherever the player is.
        Room currentLocation = playerOne.getLocation();
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

}
