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

/**
 *
 * @author Sheila
 */
public class HelpMenuView {

   private final String MENU = "\n"
            + "\n----------------------------------------"
            + "\n | Help Menu"
            + "\n----------------------------------------"
            + "\nG - What is the goal of the game?"
            + "\nM - How do I move?"
            + "\nA - How do I use actions?"
            + "\nC - How do I talk to game characters?"
            + "\nP - What do I type at the prompt?"
            + "\nX - Exit"
            + "\n----------------------------------------";
    
    public void displayMenu() {
        
        char selection =' ';
        do{
            
            System.out.println(MENU); // display the manin menu
            
            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0); // get first character of string
            
            this.doAction(selection); // do action based on selection
            
        } while (selection != 'X' ); // a selection is not "Quit"
        
    }

    public String getInput() {
        boolean valid = false; // indicates if the selection has be retrieved
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream
        
        while(!valid) { // while a valid menu selection has not been retrieved
            
            // prompt for the player's name
            System.out.println("Enter your Help selection below:");
            
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
            case 'G':
                this.displayHelpGoal(); // display help for the goal of the game
                break;
            case 'M':
                this.displayHelpMove(); // display help for how to move
                break;
            case 'A':
                this.displayHelpAction(); // display help for how to use actions
                break;
            case 'C':
                this.displayHelpTalk(); // display help for how to talk to characters
                break;
           case 'P':
                this.displayHelpType(); // display help for what to type at the prompt
                break;                
            case 'X': // quit help 
                return; 
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                break;
        }

    }

    private void displayHelpGoal() {
        System.out.println("*** displayHelpGoal function called ***");
    }

    private void displayHelpMove() {
        System.out.println("*** displayHelpMove function called ***");
    }

    private void displayHelpAction() {
        System.out.println("*** displayHelpAction function called ***");
    }

    private void displayHelpTalk() {
        System.out.println("*** displayHelpTalk function called ***");
    }

    private void displayHelpType() {
        System.out.println("*** displayHelpType function called ***");
    }
}
    

