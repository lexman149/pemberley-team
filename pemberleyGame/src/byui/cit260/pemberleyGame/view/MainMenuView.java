/*
 * Pemberley Game
 * BYUi CIT260
 * Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.control.GameControl;
import byui.cit260.pemberleyGame.model.Actor;
import byui.cit260.pemberleyGame.model.Item;
import byui.cit260.pemberleyGame.model.Player;
import byui.cit260.pemberleyGame.view.GameMenuView;
import java.util.Scanner;
import pemberley_game.PemberleyGame;

/**
 *
 * @author mbp
 */
public class MainMenuView {

    private final String MENU = "\n"
            + "\n----------------------------------------"
            + "\n | Main Menu"
            + "\n----------------------------------------"
            + "\nN - Start new game"
            + "\nG - Start game"
            + "\nH - Get help on how to play the game"
            + "\nS - Save game"
            + "\nX - Exit"
            + "\n----------------------------------------";
    
    public void displayMenu(Player player, Item[] allItemArray, Actor[] allActorArray) {
        
        char selection =' ';
        do{
            
            System.out.println(MENU); // display the manin menu
            
            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0); // get first character of string
            
            this.doAction(selection, player, allItemArray, allActorArray); // do action based on selection
            
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

    public void doAction(char choice, Player player, Item[] allItemArray, Actor[] allActorArray) {
        
        switch(choice){
            case 'N':
                this.startNewGame(player, allItemArray, allActorArray);
                break;
            case 'G':
                this.startExistingGame();
                break;
            case 'H':
                this.displayHelpMe();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'X':
                return;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                break;
        }

    }

    private void startNewGame(Player player, Item[] allItemArray, Actor[] allActorArray) {
        GameControl.createNewGame(PemberleyGame.getUser());
        
        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu(player, allItemArray, allActorArray);
    }

    private void startExistingGame() {
        System.out.println("*** startExistingGame function called ***");
    }

    private void displayHelpMe() {
        // System.out.println("*** displayHelpMenu function called ");
        
        // display the help menu
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayMenu();
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }
}
    

   

 
