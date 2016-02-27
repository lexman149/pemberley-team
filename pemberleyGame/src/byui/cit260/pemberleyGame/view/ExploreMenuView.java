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
public class ExploreMenuView {

    private final String MENU = "\n"
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
            + "\n----------------------------------------";

    public void displayMenu(Player player, Item[] allItemArray, Actor[] allActorArray) {

        char selection = ' ';
        do {

            System.out.println(MENU); // display the manin menu

            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0); // get first character of string

            this.doAction(selection, player, allItemArray, allActorArray); // do action based on selection

        } while (selection != 'X'); // a selection is not "Quit"

    }

    public String getInput() {
        boolean valid = false; // indicates if the selection has be retrieved
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream

        while (!valid) { // while a valid menu selection has not been retrieved

// prompt for the player's name
            System.out.println("Enter your selection below:");

// get the selecton from the keyboard and trim off the blanks CAPs ok
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            playersInput = playersInput.toUpperCase();

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
        ActorControl actorControl = new ActorControl();
        ItemControl itemControl = new ItemControl();
        Item[] localItemArray = itemControl.createLocalItemArray(player, allItemArray);
        Actor[] localActorArray = actorControl.createLocalActorArray(player, allActorArray);
        switch (choice) {
            case 'M':
                this.movePlayer(player);
                break;
            case 'T':
                this.takeItem(player, localItemArray);
                break;
            case 'G':
                this.giveItem();
                break;
            case 'S':
                this.speakToActor();
                break;
            case 'U':
                this.useItem();
                break;
            case 'L':
                this.lookAt(player, localItemArray, localActorArray);
                break;
            case 'X': // quit help 
                return;
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                break;
        }

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
        String gameMessage; 
        int indexOfItem;
        int quantityOfItem;
        String playerSelection = " ";
        InventoryControl inventoryControl = new InventoryControl();
        Inventory inventory = player.getInventory();
        do {
            if (localItemArray.length == 0) {
                gameMessage = "Nothing to Take";
            } else {
                String prompt = "What do you want to take (type X to exit?";
                playerSelection = this.getStringInput(prompt);
                indexOfItem = inventoryControl.getItemIndex(playerSelection, player, localItemArray);
                if (indexOfItem != -1) {
                    Item selectedItem = localItemArray[indexOfItem];
                    if (selectedItem.isMultiple() == true) {
                       prompt = "How Many do you want to take? (1 - 9)";
                        playerSelection = this.getIntegerInput(prompt);
                        quantityOfItem = Integer.parseInt(playerSelection);
                        gameMessage = inventoryControl.takeMultipleItem(selectedItem, quantityOfItem, inventory);
                    } else {
                        quantityOfItem = 1;
                        gameMessage = inventoryControl.takeSingleItem(selectedItem, quantityOfItem, inventory);
                    }
                    
                } else {

                    gameMessage = "Not sure what you are trying to take.";
                }
            }
            System.out.println(gameMessage);
        } while (!playerSelection.equalsIgnoreCase("X"));

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
        lookMenu.displayMenu(player, localItemArray, localActorArray);

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
