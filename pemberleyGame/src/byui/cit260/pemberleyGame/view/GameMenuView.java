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
            + "\n----------------------------------------");
}

 @Override
    public boolean doAction(String value, Player player, Item[] allItemArray, Actor[] allActorArray) {
        
        switch(value){
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
                this.displayExploreMenu(player, allItemArray, allActorArray);
                break;
            case "X":
                return true;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                return false;
        }
return false;
    }

    private void displayExploreMenu(Player player, Item[] allItemArray, Actor[] allActorArray) {
        ExploreMenuView exploreMenu = new ExploreMenuView();
        exploreMenu.display(player, allItemArray, allActorArray);
        
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




    

   

 