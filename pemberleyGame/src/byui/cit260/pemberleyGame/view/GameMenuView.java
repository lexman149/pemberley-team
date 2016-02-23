/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.control.GameControl;
import byui.cit260.pemberleyGame.model.Actor;
import byui.cit260.pemberleyGame.model.Item;
import byui.cit260.pemberleyGame.model.Player;
import byui.cit260.pemberleyGame.model.Room;
import java.util.Scanner;
import pemberley_game.PemberleyGame;

/**
 *
 * @author mbp
 */
public class GameMenuView {

    private final String MENU = "\n"
            + "\n----------------------------------------"
            + "\n | Game Menu"
            + "\n----------------------------------------"
            + "\nI - Inventory"
            + "\nM - Map"
            + "\nP - People"
            + "\nT - Current Tasks"
            + "\nE - Explore"
            + "\nX - Exit"
            + "\n----------------------------------------";
    
    public void displayMenu(Player player, Item[] allItemArray, Actor[] allActorArray) {
        
        char selection =' ';
        do{
            
            System.out.println(MENU); // display the manin menu
            
            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0); // get first character of string
            
            this.doAction(selection, player, allItemArray, allActorArray); // do action based on selection
            
        } while (selection != 'X' ); // a selection is not "Exit"
        
    }

    public String getInput() {
        boolean valid = false; // indicates if the selection has be retrieved
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream
        
        while(!valid) { // while a valid menu selection has not been retrieved
            
            // prompt for the player's name
            System.out.println("Enter your selection below:");
            
            // get the selecton from the keyboard and trim off the blanks
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            
            // if the menu selection is invlaid (less than one character in length)
            if (playersInput.length() < 1) {
                System.out.println("Invalid selection - the selection must not be blank");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }
        
        return playersInput; // return the name
    }

    public void doAction(char choice, Player player, Item[] allItemArray, Actor[] allActorArray) {
        
        switch(choice){
            case 'I':
                this.displayInventory();
                break;
            case 'M':
                this.displayMap();
                break;
            case 'P':
                this.displayPeople();
                break;
            case 'T':
                this.displayCurrentTasks();
                break;
            case 'E':
                this.displayExploreMenu(player, allItemArray, allActorArray);
                break;
            case 'X':
                return;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                break;
        }

    }

    private void displayExploreMenu(Player player, Item[] allItemArray, Actor[] allActorArray) {
        ExploreMenuView exploreMenu = new ExploreMenuView();
        exploreMenu.displayMenu(player, allItemArray, allActorArray);
    }

    private void displayInventory() {
        System.out.println("*** displayInventory function called ***");
    }

    private void displayMap() {
        System.out.println("*** displayMap function called ***");
    }

    private void displayPeople() {
        System.out.println("*** displayPeople function called ***");
    }

    private void displayCurrentTasks() {
        System.out.println("*** displayCurrentTasks function called ***");
    }

    
    }




    

   

 