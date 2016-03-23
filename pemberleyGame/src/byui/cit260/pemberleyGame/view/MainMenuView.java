/*
* Pemberley Game
* BYUi CIT260
* Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.control.GameControl;
import byui.cit260.pemberleyGame.control.InventoryControl;
import byui.cit260.pemberleyGame.model.Game;
import byui.cit260.pemberleyGame.model.Inventory;
import byui.cit260.permberleyGame.exceptions.GameControlException;
import pemberley_game.PemberleyGame;

/**
 *
 * @author mbp
 */
public class MainMenuView extends View {

    public MainMenuView() {
        super("\n"
                + "\n----------------------------------------"
                + "\n | Main Menu"
                + "\n----------------------------------------"
                + "\nN - Start new game"
                + "\nG - Start saved game"
                + "\nH - Get help on how to play the game"
                + "\nS - Save game"
                + "\nX - Exit"
                + "\n----------------------------------------"
                + "\nEnter your selection below:");
    }

    @Override
    public boolean doAction(String value) {

        switch (value) {
            case "N":
                this.startNewGame();
                break;
            case "G":
                this.startSavedGame();
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
                return false;
        }
        return false;
    }

    private void startNewGame() {
        Game game = PemberleyGame.getCurrentGame();
        GameControl.createNewGame(PemberleyGame.getUser());
        game = PemberleyGame.getCurrentGame();
//update game 
        GameControl gameControl = new GameControl();
        gameControl.updateGame();
//update inventory  
        InventoryControl inventoryControl = new InventoryControl();
        inventoryControl.updateInventory();
// display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
// L11 Team Assignment
private void startSavedGame() {
        this.console.println("\n\nEnter the file path where the game "
                            + "is saved.");
        
        String filePath = this.getInput(); 
                this.console.println("Your game has been loaded.");
        try {
            // start a saved game
            GameControl.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void displayHelpMe() {
// display the help menu
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    
    private void saveGame() {
        System.out.println("\n\nEnter the file path for the file where the game "
                            + "is to be saved.");
        String filePath = this.getInput(); // getInput function in View.java
        this.console.println("Your game has been saved.");
        try {
            // save the game to the specified file
            GameControl.saveGame(PemberleyGame.getCurrentGame(), filePath);
        } catch (GameControlException ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        // needs display message indicating that the game is saved successfully to the file.
    }

}
