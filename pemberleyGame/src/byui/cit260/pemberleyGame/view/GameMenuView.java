/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.model.Actor;
import byui.cit260.pemberleyGame.model.Game;
import byui.cit260.pemberleyGame.model.Map;
import byui.cit260.pemberleyGame.model.Player;
import byui.cit260.pemberleyGame.model.Room;
import byui.cit260.pemberleyGame.control.*;
import pemberley_game.PemberleyGame;

/**
 *
 * @author mbp
 */
public class GameMenuView extends View {

    public GameMenuView() {
        super("\n"
                + "\n----------------------------------------"
                + "\n | Game Menu"
                + "\n----------------------------------------"
                + "\nI - Inventory"
                + "\nM - Map"
                + "\nP - People"
                + "\nT - Current Tasks"
                + "\nE - Explore"
                + "\nX - Exit"
                + "\n----------------------------------------"
                + "\nEnter your selection below:");
    }

    @Override
    public boolean doAction(String value) {

        switch (value) {
            case "I":
                this.displayInventory();
                break;
            case "M":
                this.displayMap();
                break;
            case "P":
                this.displayPeople();
                break;
            case "T":
                this.displayCurrentTasks();
                break;
            case "E":
                this.displayExploreMenu();
                break;
            case "X":
                return true;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                return false;
        }
        return false;
    }

    private void displayExploreMenu() {
        ExploreMenuView exploreMenu = new ExploreMenuView();
        exploreMenu.display();

    }

    private void displayInventory() {
        System.out.println("*** displayInventory function called ***");
    }

    private void displayMap() {
        Game game = PemberleyGame.getCurrentGame();
        Room currentRoom = game.getCurrentRoom();
        Map currentMap = game.getCurrentMap();
        System.out.println(currentMap.getMapDrawing());
        System.out.println("This map only contains places you have been\n\n");
    }

//display a list of all actors by Sheila 3/12/16
    
    private void displayPeople() {
        Game game = PemberleyGame.getCurrentGame();
        Actor[] allActorArray = game.getAllActorArray(); 
//        String[] peopleNames = ActorControl.;
        
//create an ArrayList to hold all of the actors in the above location.
            for(Actor actors : allActorArray){
                System.out.println(actors.getName());
            }
    }

    private void displayCurrentTasks() {
        System.out.println("*** displayCurrentTasks function called ***");
    }

}
