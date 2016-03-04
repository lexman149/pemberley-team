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
public class MainMenuView extends View {

    public MainMenuView(){
         super("\n"
            +"\n----------------------------------------"
            + "\n | Main Menu"
            + "\n----------------------------------------"
            + "\nN - Start new game"
            + "\nG - Start game"
            + "\nH - Get help on how to play the game"
            + "\nS - Save game"
            + "\nX - Exit"
            + "\n----------------------------------------");
    }
  
@Override
    public boolean doAction(String value, Player player, Item[] allItemArray, Actor[] allActorArray) {

        
        switch(value){
            case "N":
                this.startNewGame(player, allItemArray, allActorArray);
                break;
            case "G":
                this.startExistingGame();
                break;
            case "H":
                this.displayHelpMe();
                break;
            case "S":
                this.saveGame();
                break;
            case "X":
                return true;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                break;
        }
return false;
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
    

   

 
