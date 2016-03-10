/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;


import byui.cit260.pemberleyGame.model.Game;
import byui.cit260.pemberleyGame.model.Map;
import byui.cit260.pemberleyGame.model.Player;
import byui.cit260.pemberleyGame.model.Room;


/**
 *
 * @author mbp
 */
public class GameMenuView extends View {

public GameMenuView(){
         super( "\n"
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
    public boolean doAction(String value, Game game) {
        
        switch(value){
            case "I":
                this.displayInventory();
                break;
            case "M":
                this.displayMap(game);
                break;
            case "P":
                this.displayPeople();
                break;
            case "T":
                this.displayCurrentTasks();
                break;
            case "E":
                this.displayExploreMenu(game);
                break;
            case "X":
                return true;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                return false;
        }
return false;
    }

    private void displayExploreMenu(Game game) {
        ExploreMenuView exploreMenu = new ExploreMenuView();
        exploreMenu.display(game);
        
    }

    private void displayInventory() {
        System.out.println("*** displayInventory function called ***");
    }

    private void displayMap(Game game) {

          
        System.out.println("*** displayMap function called ***");
    }

    private void displayPeople() {
        System.out.println("*** displayPeople function called ***");
    }

    private void displayCurrentTasks() {
        System.out.println("*** displayCurrentTasks function called ***");
    }

    
    }




    

   

 