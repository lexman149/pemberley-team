/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;

import java.util.Scanner;
import java.lang.Character;
import byui.cit260.pemberleyGame.control.*;
import byui.cit260.pemberleyGame.model.*;
import byui.cit260.pemberleyGame.view.*;
import pemberley_game.PemberleyGame;

/**
 *
 * @author Melissa
 */
public class ExploreMenuView extends View{

    
    public ExploreMenuView(){
         super( "\n"
            + "\n----------------------------------------"
            + "\n | What do you want to do?"
            + "\n----------------------------------------"
            + "\nM - Move"
            + "\nT - Take"
            + "\nG - Give"
            + "\nS - Speak"
            + "\nU - Use"
            + "\nL - Look"
            + "\nX - Exit"
            + "\n----------------------------------------"
            + "\nEnter your selection below:");
    }

@Override
    public boolean doAction(String value, Player player, Item[] allItemArray, Actor[] allActorArray) {
        ActorControl actorControl = new ActorControl();
        ItemControl itemControl = new ItemControl();
        Item[] localItemArray = itemControl.createLocalItemArray(player, allItemArray);
        Actor[] localActorArray = actorControl.createLocalActorArray(player, allActorArray);
        switch (value) {
            case "M":
                this.movePlayer(player);
                break;
            case "T":
                this.takeItem(player, localItemArray);
                break;
            case "G":
                this.giveItem();
                break;
            case "S":
                this.speakToActor();
                break;
            case "U":
                this.useItem();
                break;
            case "L":
                this.lookAt(player, localItemArray, localActorArray);
                break;
            case "X": // quit help 
                return true;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                return false;
        }
return false;
    }
// author Alexis
    private void movePlayer(Player player) {
        String prompt = "Which direction do you want to go? Type X to cancel.";
        String playerSelection;
        do {
        playerSelection = this.getStringInput(prompt);
        MapControl mapControl = new MapControl();
        String roomDescription = mapControl.playerNavigate(playerSelection, player);
        System.out.println(roomDescription);
        } while(!playerSelection.equalsIgnoreCase("x"));
        

    }

    private void takeItem(Player player, Item[] localItemArray) {
       //declare variables
        String gameMessage; 
        int indexOfItem;
        int quantityOfItem;
        String playerSelection = " ";
        ItemControl itemControl = new ItemControl();
        InventoryControl inventoryControl = new InventoryControl();
        //designate the inventory
        Inventory inventory = player.getInventory();
        //while player's selection is not X loop
        do {
            //if there is nothing in the localItemArray say there is nothing to take.
            if (localItemArray.length == 0) {
                gameMessage = "Nothing to Take";
            } else {
                String prompt = "What do you want to take (type X to exit?";
                //get input from the player
                playerSelection = this.getStringInput(prompt);
                //see if the player's selected item is in the room. return it's index in the array.
                indexOfItem = itemControl.getItemIndex(playerSelection, player, localItemArray);
                
                if (indexOfItem != -1) {//run this code if there was an index match
                    //set the item to whatever item matched the players selection
                    Item selectedItem = localItemArray[indexOfItem];
                    //if the item's multiple attribute is true run this code
                    if (selectedItem.isMultiple() == true) {
                       prompt = "How Many do you want to take? (1 - 9)";
                       //get the players selection and make sure it is an integer
                        playerSelection = this.getIntegerInput(prompt);
                        //make the player's selection an integer
                        quantityOfItem = Integer.parseInt(playerSelection);
                        //call the takeMultipleItem function.
                        gameMessage = inventoryControl.takeMultipleItem(selectedItem, quantityOfItem, inventory);
                    } else {//run this code if the item's multiple attribue is not true
                        quantityOfItem = 1;
                        //call the takeSingleItem function
                        gameMessage = inventoryControl.takeSingleItem(selectedItem, quantityOfItem, inventory);
                    }
                    
                } else {
                    //if the player's selection is not in the array send this message
                    gameMessage = "Not sure what you are trying to take.";
                }
            }
            System.out.println(gameMessage);
        } while (!playerSelection.equalsIgnoreCase("X"));//loop

    }

    private void giveItem() {
        System.out.println("***giveItem function called ***");
    }

    private void speakToActor() {
        System.out.println("***speakToActor function called ***");
    }

    private void useItem() {
        System.out.println("***UseItem function called ***");
    }

    //author Melissa and Sheila
    private void lookAt(Player player, Item[] localItemArray, Actor[] localActorArray) {
        LookMenuView lookMenu = new LookMenuView();
        lookMenu.display(player, localItemArray, localActorArray);

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

    private String getIntegerInput(String prompt) {
        boolean valid = false; // indicates if the name has be retrieved
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream

        while (!valid) { // while a valid name has not been retrieved

// prompt for the player's choice
            System.out.println(prompt);

// get the selection from the keyboard and trim off the blanks CAPs ok
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            char ch = playersInput.charAt(0);
            
// if the selection is invlaid (less than one characters in length)
            if (!Character.isDigit(ch)) {
                System.out.println("Please enter a positive integer.");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }

        return playersInput; // return the name
    }
    
}
