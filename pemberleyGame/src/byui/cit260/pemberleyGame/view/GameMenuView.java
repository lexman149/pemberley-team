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
                + "\nR - Reports"
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
            case "R":
                this.displayReportMenu();
                break;
            case "X":
                return true;
            default:
                this.console.println("\n***Invalid Selection *** Try Again");
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
      Player player = game.getPlayerOne();
      Inventory inventory = player.getInventory();
      int itemSelection = 0;
      String playerSelection = " ";
    
      Item[] inventoryNames = game.getInventoryItemArray();
      for (int i = 0; i < inventoryNames.length; i++) {
      this.console.println(i + " " + inventoryNames[i].getName()); 
  }

      String prompt = "what do you want to look at or X to exit"; 
         do {
            playerSelection = this.getStringInput(prompt);

         try {
                    itemSelection = Integer.parseInt(playerSelection); // converts string to int
                    this.console.println(inventoryNames[itemSelection].getDescription());
                    this.console.println(inventory.getWeight());
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number."
                            + " Try again or type X to exit.");
                    break;
                }
        } while (!playerSelection.equalsIgnoreCase("x"));

}

    private void displayMap() {
        Game game = PemberleyGame.getCurrentGame();
        Room currentRoom = game.getCurrentRoom();
        Map currentMap = game.getCurrentMap();
        this.console.println(currentMap.getMapDrawing());
        this.console.println("This map only contains places you have been\n\n");
    }

//display a list of all actors by Sheila 3/12/16
    
    private void displayPeople() {
        Game game = PemberleyGame.getCurrentGame();
        Actor[] allActorArray = game.getAllActorArray(); 
//        String[] peopleNames = ActorControl.;
            this.console.println("\n\n          ACTOR & LOCATION REPORT          ");        
            this.console.printf("%n%-30s%-14s", "Actor Name", "Location");
            this.console.printf("%n%-30s%-14s", "----------", "--------");

// print actor name and location
            for (Actor actor : allActorArray) { // goes through all the actors
                // null check - won't call a locationName if = null
                String location = "N/A"; // if location is null, print this
               
                if (actor.getLocation() !=null) { // otherwise print locationName
                    location = actor.getLocation().getName();
                }
                this.console.printf("%n%-30s%-14s", actor.getName()
                                             , location);
            }
    }

    private void displayCurrentTasks() {
        this.console.println("*** displayCurrentTasks function called ***");
    }
    
    private String getStringInput(String prompt) {
        boolean valid = false; // indicates if the name has be retrieved
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream

        while (!valid) { // while a valid name has not been retrieved

// prompt for the player's choice
            this.console.println(prompt);

// get the selection from the keyboard and trim off the blanks CAPs ok
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            playersInput = playersInput.toUpperCase();

// if the selection is invlaid (less than one characters in length)
            if (playersInput.length() < 1) {
                this.console.println("Invalid selection - selection can not be blank");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }

        return playersInput; // return the name
    }

    private void displayReportMenu() {   
        ReportMenuView reportMenu = new ReportMenuView();
        reportMenu.display();
    }

}
