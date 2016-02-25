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
public class LookMenuView {

    private final String MENU = "\n"
            + "\n----------------------------------------"
            + "\n | Look Menu"
            + "\n----------------------------------------"
            + "\nR - Look at the room"
            + "\nC - Look at a character" 
            + "\nI - Look at an inventory item"
            + "\nH - Look at an items here"
            + "\nX - Exit"
            + "\n----------------------------------------";
    
    public void displayMenu(Player player, Item[] localItemArray, Actor[] localActorArray) {
        
        char selection =' ';
        do{
            
            System.out.println(MENU); // display the manin menu
            
            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0); // get first character of string
            
            this.doAction(selection, player, localItemArray); // do action based on selection
            
        } while (selection != 'X' ); // a selection is not "Exit"
        
    }

    public String getInput() {
        boolean valid = false; // indicates if the selection has be retrieved
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream
        
        while(!valid) { // while a valid menu selection has not been retrieved
            
            // prompt for the player's name
            System.out.println("Enter your selection below:");
            
            // get the selecton from the keyboard and trim off the blanks
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            playersInput = playersInput.toUpperCase();
            
            // if the menu selection is invlaid (less than one character in length)
            if (playersInput.length() < 1) {
                System.out.println("Invalid selection - the selection must not be blank");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }
        
        return playersInput; // return the name
    }
        
    public void doAction(char choice, Player player, Item[] localItemArray) {
        
        switch(choice){
            case 'R':
                this.displayRoom(player);
                break;
            case 'C':
                this.displayCharacter();
                break;
            case 'I':
                this.displayInventory();
                break;
            case 'H':
                this.displayItem(player, localItemArray);
                break;
            case 'X':
                return;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                break;
        }
    }

    private void displayRoom(Player player) {
        MapControl mapControl = new MapControl();
        String roomDescription = mapControl.lookAtRoom(player);
        System.out.println(roomDescription);
    }

    private void displayCharacter() {
        System.out.println("*** startExistingGame function called ***");
    }

    private void displayInventory() {
        System.out.println("*** displayInventory function called *** ");
    }

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
    

   
