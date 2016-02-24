/*
 * Pemberley Game
 * BYUi CIT260
 * Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.control.GameControl;
import byui.cit260.pemberleyGame.view.GameMenuView;
import java.util.Scanner;
import pemberley_game.PemberleyGame;
import byui.cit260.pemberleyGame.model.*;

/**
 *
 * @author mbp
 */
public class LookMenuView {

    private final String MENU = "\n"
            + "\n----------------------------------------"
            + "\n | Look Menu"
            + "\n----------------------------------------"
            + "\nR - Look at the room"
            + "\nC - Look at a character" // can I use C?
            + "\nI - Look at an inventory item"
            + "\nO - Look at an item other than inventory items"
            + "\nX - Exit"
            + "\n----------------------------------------";
    
    public void displayMenu(Player player, Item[] localItemArray, Actor[] localActorArray) {
        
        char selection =' ';
        do{
            
            System.out.println(MENU); // display the manin menu
            
            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0); // get first character of string
            
            this.doAction(selection); // do action based on selection
            
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
            
            // if the menu selection is invlaid (less than one character in length)
            if (playersInput.length() < 1) {
                System.out.println("Invalid selection - the selection must not be blank");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }
        
        return playersInput; // return the name
    }

    public void doAction(char choice) {
        
        switch(choice){
            case 'R':
                this.displayRoom();
                break;
            case 'C':
                this.displayCharacter();
                break;
            case 'I':
                this.displayInventory();
                break;
            case 'O':
                this.displayItem();
                break;
            case 'X':
                return;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                break;
        }

    }

    private void displayRoom() {
        System.out.println("*** displayRoom function called ***");
    }

    private void displayCharacter() {
        System.out.println("*** startExistingGame function called ***");
    }

    private void displayInventory() {
        System.out.println("*** displayInventory function called *** ");
    }

    private void displayItem() {
        System.out.println("*** displayItem function called ***");
    }
}
    

   
