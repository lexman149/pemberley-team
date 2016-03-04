/*
 * Pemberley Game
 * BYUi CIT260
 * Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.control.*;
import java.util.Scanner;
import byui.cit260.pemberleyGame.model.*;


/**
 *
 * @author Sheila
 */
public class LookMenuView extends View {

    public LookMenuView(){
         super("\n"
            + "\n----------------------------------------"
            + "\n | Look Menu"
            + "\n----------------------------------------"
            + "\nR - Look at the room"
            + "\nC - Look at a character" 
            + "\nI - Look at an inventory item"
            + "\nH - Look at an items here"
            + "\nX - Exit"
            + "\n----------------------------------------");
    }
   
   @Override     
    public boolean doAction(String value, Player player, Item[] localItemArray, Actor[] localActorArray) {
        
        switch(value){
            case "R":
                this.displayRoom(player);
                break;
            case "C":
                this.displayCharacter(player, localActorArray);
                break;
            case "I":
                this.displayInventory(player);
                break;
            case "H":
                this.displayItem(player, localItemArray);
                break;
            case "X":
                return true;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                break;
        }
        return false;
    }

    private void displayRoom(Player player) {
        MapControl mapControl = new MapControl();
        String roomDescription = mapControl.lookAtRoom(player);
        System.out.println(roomDescription);
    }

    //by Sheila
    private void displayCharacter(Player player, Actor[] localActorArray) {
        ActorControl actorControl = new ActorControl();
        String[] actorList = actorControl.createActorNameList(localActorArray); // creates String [] of actors
        String actorString = " "; // creates just a String of actors, not an array
        for (String i : actorList) {
            actorString += ' ' + i;
        }
        System.out.println(actorString + " IS IN THIS ROOM.");
    }

    private void displayInventory(Player player) {
        System.out.println("*** call the displayInventory function ***");
    }

    //by Sheila
    private void displayItem(Player player, Item[] localItemArray) {
        String prompt = "Which item do you want to look at? Type X to cancel.";
        String playerSelection;
        do {
        playerSelection = this.getStringInput(prompt);
        ItemControl itemControl = new ItemControl();
        String roomDescription = itemControl.lookAtItem(playerSelection, player, localItemArray);
        System.out.println(roomDescription);
        } while(!playerSelection.equalsIgnoreCase("x"));
    }
    private String getStringInput(String prompt) {
        boolean valid = false; // indicates if the name has be retrieved
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream

        while (!valid) { // while a valid name has not been retrieved

// prompt for the player's choice
            System.out.println(prompt);

// get the name from the keyboard and trim off the blanks CAPs ok
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            playersInput = playersInput.toUpperCase();

// if the name is invlaid (less than two characters in length)
            if (playersInput.length() < 1) {
                System.out.println("Invalid selection - selection can not be blank");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }

        return playersInput; // return the name
    }

}
    

   
