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
import byui.cit260.pemberleyGame.model.Inventory;
import byui.cit260.pemberleyGame.model.Item;
import java.util.Scanner;
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
      Game game = PemberleyGame.getCurrentGame();
      
      int itemSelection = 0;
      String playerSelection = " ";
    
      Item[] inventoryNames = game.getInventoryItemArray();
      for (int i = 0; i < inventoryNames.length; i++) {
      System.out.println(i + " " + inventoryNames[i].getName()); 
  }

      String prompt = "what do you want to look at or X to exit"; 
         do {
            playerSelection = this.getStringInput(prompt);

         try {
                    itemSelection = Integer.parseInt(playerSelection); // converts string to int
                    System.out.println(inventoryNames[itemSelection].getDescription());
                } catch (NumberFormatException nf) {
                    System.out.println("\nYou must enter a valid number."
                            + " Try again or type X to exit.");
                    break;
                }
        } while (!playerSelection.equalsIgnoreCase("x"));

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
    
    private String getStringInput(String prompt) {
        boolean valid = false; // indicates if the name has be retrieved
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream

        while (!valid) { // while a valid name has not been retrieved

// prompt for the player's choice
            System.out.println(prompt);

// get the selection from the keyboard and trim off the blanks CAPs ok
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            playersInput = playersInput.toUpperCase();

// if the selection is invlaid (less than one characters in length)
            if (playersInput.length() < 1) {
                System.out.println("Invalid selection - selection can not be blank");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }

        return playersInput; // return the name
    }

}
