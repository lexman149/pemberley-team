/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.Actor;
import byui.cit260.pemberleyGame.model.Game;
import byui.cit260.pemberleyGame.model.Inventory;
import byui.cit260.pemberleyGame.model.Item;
import byui.cit260.pemberleyGame.model.Location;
import byui.cit260.pemberleyGame.model.Player;
import byui.cit260.pemberleyGame.model.Room;
import byui.cit260.permberleyGame.exceptions.ActorControlException;
import pemberley_game.PemberleyGame;
import java.util.ArrayList;

/**
 *
 * @author mbp
 */
public class ActorControl {
// returns the actors in a location with all their attributes

    public Actor[] createLocalActorArray() {
//set the current location to wherever the player is.
        Game game = PemberleyGame.getCurrentGame();
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

// author Sheila, throw by SW 3/17/16   
    public String speakToActor(String playerSelection) 
                    throws ActorControlException {
        Game game = PemberleyGame.getCurrentGame();
        Actor[] localActorArray = game.getLocalActorArray();//set the variable for localActorArray to the game's localActorArray
        int indexOfItem = this.findIndexOfValue(playerSelection, game.getLocalActorNames()); // compares player's selection with String[] of actors in the same location as the player
        if (indexOfItem == -1) {
            throw new ActorControlException("That actor is not here.");
        } else {
            return localActorArray[indexOfItem].getCharacterScript(); // returns description of actors in the room
        }
    }
    
//by Alexis Actor Control, throw by SW 3/17/16
    public String lookAtActor(String playerSelection, Game game) 
                    throws ActorControlException {
        Actor[] localActorArray = game.getLocalActorArray();//set the variable for localActorArray to the game's local item ar
        int indexOfActor = this.findIndexOfValue(playerSelection, game.getLocalActorNames()); // compares player's selection to the String[] and pulls the location in the list 
        if (indexOfActor == -1) {
            throw new ActorControlException ("That actor is not available here.");
        } else {
           return localActorArray[indexOfActor].getDescription(); // returns description of actor 
        }
    }
    
    
    //this function cycles through alternate attributes and resets primary attributes
    
    public void changeActorAttributes (Actor currentActor){
 if (currentActor.getAlternateCharacterScript()!=null)
    currentActor.setCharacterScript(currentActor.getAlternateCharacterScript());
 if (currentActor.getAlternateDescription()!=null)
     currentActor.setDescription(currentActor.getAlternateDescription());
 if (currentActor.getAlternateLocation()!=null)
     currentActor.setLocation(currentActor.getAlternateLocation());
 if (currentActor.getAlternateQuest()!=null)
     currentActor.setQuest(currentActor.getAlternateQuest());
    }
    
    
   
}
