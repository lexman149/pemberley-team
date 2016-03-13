/*
* Pemberley Game
* BYUi CIT260
* Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.model.Game;

/**
 *
 * @author Sheila
 */
public class HelpMenuView extends View {

    public HelpMenuView() {
        super("\n"
                + "\n----------------------------------------"
                + "\n | Help Menu"
                + "\n----------------------------------------"
                + "\nG - What is the goal of the game?"
                + "\nM - How do I move?"
                + "\nA - How do I use actions?"
                + "\nC - How do I talk to game characters?"
                + "\nP - What do I type at the prompt?"
                + "\nX - Exit"
                + "\n----------------------------------------"
                + "\nEnter your selection below:");
    }

    @Override
    public boolean doAction(String value) {

        switch (value) {
            case "G":
                this.displayHelpGoal(); // display help for the goal of the game
                break;
            case "M":
                this.displayHelpMove(); // display help for how to move
                break;
            case "A":
                this.displayHelpAction(); // display help for how to use actions
                break;
            case "C":
                this.displayHelpTalk(); // display help for how to talk to characters
                break;
            case "P":
                this.displayHelpType(); // display help for what to type at the prompt
                break;
            case "X": // quit help 
                return true;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                return false;
        }
        return false;
    }

  private void displayHelpGoal() {
        System.out.println("\n"
                + "\nThe goal of Pemberley Game is to find the time  "
                + "\nmachine and return to the present day. Before  "
                + "\nyou can do that, you will need to navigate  "
                + "\nthrough the Pemberley estate and the town of "
                + "\nLambton to solve a few puzzles.");
    }

    private void displayHelpMove() {
        System.out.println("\n"
                + "\nTo move go to the Explore Menu and select M. "
                + "\nAt the prompt, type in: "
                + "\n   * N or North"
                + "\n   * E or East"
                + "\n   * S or South"
                + "\n   * W or West"
                + "\nto move your player one room in that direction.");
    }

    private void displayHelpAction() {
        System.out.println("\n"
                + "\nFrom the Explore Menu: "
                + "\n - T or Take allows you to add an item to your inventory."
                + "\n - G or Give allows you to give an item from your inventory"
                + "\n   to a character."
                + "\n - U or Use allows you to use an item from your inventory."
                + "\n - L or Look allows you to: "
                + "\n     •look at the description of the room the player is in."
                + "\n     •look at the characters located in the room."
                + "\n     •look at items located in the room."
                + "\n     •look at items in your inventory.");
    }

    private void displayHelpTalk() {
        System.out.println("\n"
                + "\nTo talk with characters go to the Explore Menu "
                + "\nand select S. A list of characters in the room will "
                + "\ndisplay. Type the name of the character, and "
                + "\ns/he will speak to you.");
    }

    private void displayHelpType() {
        System.out.println("\n"
                + "\nAt the prompt type in your selection from the "
                + "\nvarious menus or from the list provided.");
    }
}
