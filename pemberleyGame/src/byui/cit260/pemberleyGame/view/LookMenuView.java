/*
* Pemberley Game
* BYUi CIT260
* Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.control.*;
import java.util.Scanner;
import byui.cit260.pemberleyGame.model.*;
import byui.cit260.permberleyGame.exceptions.ActorControlException;
import pemberley_game.PemberleyGame;

/**
 *
 * @author Sheila
 */
public class LookMenuView extends View {

    public LookMenuView() {
        super("\n"
                + "\n----------------------------------------"
                + "\n | Look Menu"
                + "\n----------------------------------------"
                + "\nR - Look at the room"
                + "\nA - Look at a actor"
                + "\nI - Look at an inventory item"
                + "\nH - Look at an items here"
                + "\nX - Exit"
                + "\n----------------------------------------"
                + "\nEnter your selection below:");
    }

    @Override
    public boolean doAction(String value ) {

        switch (value) {
            case "R":
                this.displayRoom();
                break;
            case "A":
                this.displayActor();
                break;
            case "I":
                this.displayInventory();
                break;
            case "H":
                this.displayItem();
                break;
            case "X":
                return true;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                return false;
        }
        return false;
    }

    private void displayRoom() {
        MapControl mapControl = new MapControl();
        String roomDescription = mapControl.lookAtRoom();
        System.out.println(roomDescription);
    }

//by Sheila
    private void displayActor() {
        Game game = PemberleyGame.getCurrentGame();
        ActorControl actorControl = new ActorControl();
        String prompt = "Which actor do you want to look at? Type X to cancel.";
        System.out.println("These actors are here:");
        String[] actorsHere = game.getLocalActorNames();
        for (String i : actorsHere) {
            System.out.print(i + "\n");
        }
        String playerSelection = "";//scope variable
        do {
            String roomDescription = ""; // scope variable instantiate
                try {
                    playerSelection = this.getStringInput(prompt);
                    roomDescription = actorControl.lookAtActor(playerSelection, game);
                } catch (ActorControlException ae) {
                    System.out.println(ae.getMessage()); // thrown from ActorControl Line 109
                }
            System.out.println(roomDescription);
        } while (!playerSelection.equalsIgnoreCase("x"));
       
    }

//by Sheila
    private void displayItem() {
         Game game = PemberleyGame.getCurrentGame();
        ItemControl itemControl = new ItemControl();
        String prompt = "Which item do you want to look at? Type X to cancel.";
        System.out.println("These things are here:");
        String[] itemsHere = game.getLocalItemNames();
        for (String i : itemsHere) {
            System.out.print(i + "\n");
        }
        String playerSelection;
        do {
            playerSelection = this.getStringInput(prompt);

            String roomDescription = itemControl.lookAtItem(playerSelection);
            System.out.println(roomDescription);
        } while (!playerSelection.equalsIgnoreCase("x"));
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
                System.out.println("Invalid Selection - selection cannot be blank");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }

        return playersInput; // return the name
    }

    private void displayInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
