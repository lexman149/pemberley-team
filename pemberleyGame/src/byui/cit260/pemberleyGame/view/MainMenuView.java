/*
 * Pemberley Game
 * BYUi CIT260
 * Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.control.GameControl;
import byui.cit260.pemberleyGame.model.Game;
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
            + "\n----------------------------------------"
            + "\nEnter your selection below:");
    }
  
@Override
    public boolean doAction(String value, Game game) {

        
        switch(value){
            case "N":
                this.startNewGame(game);
                break;
            case "G":
                this.startExistingGame();
                break;
            case "H":
                this.displayHelpMe(game);
                break;
            case "S":
                this.saveGame();
                break;
            case "X":
                return true;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                return false;
        }
return false;
    }

    private void startNewGame(Game game) {
        GameControl.createNewGame(PemberleyGame.getUser(), game);
        
        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display(game);
    }

    private void startExistingGame() {
        System.out.println("*** startExistingGame function called ***");
    }

    private void displayHelpMe(Game game) {
        // System.out.println("*** displayHelpMenu function called ");
        
        // display the help menu
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display(game);
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }

}
    

   

 
