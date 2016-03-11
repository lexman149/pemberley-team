/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.Actor;
import byui.cit260.pemberleyGame.model.Game;
import byui.cit260.pemberleyGame.model.Player;
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
        Actor[] allActorArray = game.getAllActorArray();
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

//by Melissa Marriott
    public int getActorIndex(String playerSelection, Player player, Actor[] localActorArray) {
//set default message.
        int actorIndex = -1;
        ActorControl actorControl = new ActorControl();
        /*take the array and make a new array containing the names of the actors to make
it searchable by name*/
        String[] localActorList = actorControl.createActorNameList(localActorArray);
//call the function that checks user selection against each actor name;
        actorIndex = this.findIndexOfValue(playerSelection, localActorList);
        return actorIndex;
    }

    public int findIndexOfValue(String playerSelection, String[] stringToCheck) {
//set the default to -1
        int indexOfValue = -1;
        /*loop through each string in the array to see if selection is anywhere 
in the string. I am using this instead of a normal array contains both 
to make it case insenstive and so that if any part of the players selection is 
in the string it will return an index of its location.  For example, using this
if the player says they want to get treats or dog treats instead of The 
Dog Treats, it will still find it.*/

        for (int i = 0; i < stringToCheck.length; i++) {
//change players selection to upper case to make the search case insensitive
            playerSelection = playerSelection.toUpperCase();
//change each string in the array to upper case to make the search case insensitive
            String stringToCheckUpper = stringToCheck[i].toUpperCase();
//if the string contains any part of the player's selection, return the index.
            if (stringToCheckUpper.contains(playerSelection) == true) {
                indexOfValue = i;
            }
        }

        return indexOfValue;
    }

// author Sheila    
    public String speakToActor(String playerSelection, Game game) {
        Actor[] localActorArray = game.getLocalActorArray();//set the variable for localActorArray to the game's localActorArray
        int indexOfItem = this.findIndexOfValue(playerSelection, game.getLocalActorNames()); // compares player's selection with String[] of actors in the same location as the player
        if (indexOfItem != -1) {
            return localActorArray[indexOfItem].getCharacterScript(); // returns description of actors in the room
        } else {
            return "That character is not here.";
        }
    }
}
