/* 
 * Pemberley Game
 * BYUi CIT260
 * Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.view;
import byui.cit260.pemberleyGame.control.ProgramControl;
import byui.cit260.pemberleyGame.model.Player;
import java.util.*;
/**
 *
 * @author mbp
 */
public class StartProgramView {

    public StartProgramView() {
    }
    
    public void startProgram(){
        //Display the banner screen
        this.displayBanner();
        // prompt the player to enter their name Retrieve the name of the player
        String playersName = this.getPlayersName();
        // create and save the player object
        Player player = ProgramControl.createPlayer(playersName);
        // Display a personalized welcome message
        this.displayWelcomeMessage(player);
        // Display the Main menu.
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayMenu();
    }

    private void displayBanner() {
        System.out.println("\n\n*******************************************");
        
        System.out.println("*"
                + "\n* This is the game of Pemberley  *"
                + "\n* In this game you will.....  *");
        
        System.out.println("*"
                + "\n* Good luck and have fun in this adventure. *"
                + "\n*");
        System.out.println("******************************************");
    }
    
    private String getPlayersName() {
        boolean valid = false; // indicates if the name has be retrieved
        String playersName = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream
        
        while(!valid) { // while a valid name has not been retrieved
            
            // prompt for the player's name
            System.out.println("Enter your name below:");
            
            // get the name from the keyboard and trim off the blanks
            playersName = keyboard.nextLine();
            playersName = playersName.trim();
            
            // if the name is invlaid (less than two characters in length)
            if (playersName.length() < 2) {
                System.out.println("Invalid name - the name must not be blank");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }
        
        return playersName; // return the name
    }

    private void displayWelcomeMessage(Player player) {
        System.out.println("\n\n===============================");
        System.out.println("\tWelcome to the game " + player.getName());
        System.out.println("\tWe hope you have a lot of fun!");
        System.out.println("===============================");
    }
}

