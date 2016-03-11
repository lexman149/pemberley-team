/* 
* Pemberley Game
* BYUi CIT260
* Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.control.ProgramControl;
import byui.cit260.pemberleyGame.model.Game;
import byui.cit260.pemberleyGame.model.User;
import java.util.*;

/**
 *
 * @author mbp
 */
public class StartProgramView {

    public StartProgramView() {
    }

    public void startProgram(Game game) {
//Display the banner screen
        this.displayBanner();
// prompt the player to enter their name Retrieve the name of the player
        String playersName = this.getPlayersName();
// create and save the player object
        User user = ProgramControl.createPlayer(playersName);
// Display a personalized welcome message
        this.displayWelcomeMessage(user);
// Display the Main menu.
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display(game);
    }

    private void displayBanner() {
        System.out.println("\n\n*************************************************"
                + "\n* Welcome to the beauty, the romance and the    *"
                + "\n* grandeur that is Pemberley.  You are about to *"
                + "\n* embark on an adventure back in time where you *"
                + "\n* will help the residents at Pemberley a        *"
                + "\n* generation after the events of Jane Austen's  *"
                + "\n* Pride and Prejudice.  You will face intrigue  *"
                + "\n* and adventure  as you solve problems and      *"
                + "\n* puzzles.  In the end it is up to you to bring *"
                + "\n* together two sweethearts destined for a truly *"
                + "\n* Austenesque ending.  Here is to happily ever  *"
                + "\n* after!  Good Luck!                            *"
                + "\n*************************************************"
                + "\n Enter your name below:");
    }

    private String getPlayersName() {
        boolean valid = false; // indicates if the name has be retrieved
        String playersName = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream

        while (!valid) { // while a valid name has not been retrieved

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

    private void displayWelcomeMessage(User player) {
        System.out.println("\n\n=========================================");
        System.out.println("\tWelcome to the game " + player.getName());
        System.out.println("\tWe hope you have a lot of fun!");
        System.out.println("=========================================");
    }
}
