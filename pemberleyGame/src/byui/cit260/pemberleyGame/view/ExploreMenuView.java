/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;

import java.util.Scanner;
import java.lang.Character;//do not remove.  needed to check for integer
import byui.cit260.pemberleyGame.control.*;
import byui.cit260.pemberleyGame.model.*;
import byui.cit260.permberleyGame.exceptions.*;
import pemberley_game.PemberleyGame;

/**
 *
 * @author Melissa
 */
public class ExploreMenuView extends View {

    public ExploreMenuView() {
        super("\n"
                + "\n----------------------------------------"
                + "\n | What do you want to do?"
                + "\n----------------------------------------"
                + "\nM - Move"
                + "\nT - Take Item"
                + "\nG - Give Item"
                + "\nD - Drop Item"
                + "\nS - Speak"
                + "\nU - Use"
                + "\nL - Look"
                + "\nX - Exit"
                + "\n----------------------------------------"
                + "\nEnter your selection below:");
    }

    @Override
    public boolean doAction(String value) {

        switch (value) {
            case "M":
                this.movePlayer();
                break;
            case "T":
                this.takeItem();
                break;
            case "D":
                this.dropItem();
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
                this.lookAt();
                break;
            case "X": // quit help 
                return true;
            default:
                this.console.println("\n***Invalid Selection *** Try Again");
                return false;
        }
        return false;
    }
// author Alexis

    private void movePlayer() {
        Game game = PemberleyGame.getCurrentGame();
        String roomDescription = "";
        Player player = game.getPlayerOne();
        String prompt = "Which direction do you want to go? Type X to exit.";
        String playerSelection;
        do {
            playerSelection = this.getStringInput(prompt);
            MapControl mapControl = new MapControl();
            try{
            roomDescription = mapControl.playerNavigate(playerSelection, player);
            } catch (MapControlException me) {
                            ErrorView.display(this.getClass().getName(),me.getMessage());
                        }
            
            
            this.console.println(roomDescription);
        } while (!playerSelection.equalsIgnoreCase("x"));

    }

    private void takeItem() {
//declare variables
        Game game = PemberleyGame.getCurrentGame();
        Player player = game.getPlayerOne();
        ItemControl itemControl = new ItemControl();
        Item[] localItemArray = game.getLocalItemArray();
        String gameMessage = " ";
        int indexOfItem;
        int quantityOfItem = 1;
        String playerSelection;
        InventoryControl inventoryControl = new InventoryControl();
//designate the inventory
        Inventory inventory = player.getInventory();
//while player's selection is not X loop

        do {
//if there is nothing in the localItemArray say there is nothing to take.
            if (localItemArray.length == 0) {
                this.console.println("Nothing to Take");
                break;
            } else {
                String prompt = "What do you want to take? Type X to exit.";
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
                        playerSelection = this.getStringInput(prompt); // gets a string
//make the player's selection an integer
                        try {
                            quantityOfItem = Integer.parseInt(playerSelection); // converts string to int

                        } catch (NumberFormatException nf) {
                            ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number."
                                    + " Try again or type X to exit.");

                        }
//call the takeMultipleItem function.
                        try {
                            gameMessage = inventoryControl.takeMultipleItem(selectedItem, quantityOfItem, inventory);
                        } catch (InventoryControlException ie) {
                            ErrorView.display(this.getClass().getName(),ie.getMessage());
                        }
                    } else {//run this code if the item's multiple attribue is not true
                        quantityOfItem = 1;

//call the takeSingleItem function
                        try {
                            gameMessage = inventoryControl.takeSingleItem(selectedItem, quantityOfItem, inventory);
                        } catch (InventoryControlException ie) {
                            ErrorView.display(this.getClass().getName(),ie.getMessage());
                        }

                    }

                } else {
//if the player's selection is not in the array send this message
                    gameMessage = "Not sure what you are trying to take.";
                }
            }
            this.console.println(gameMessage);
           
        } while (!playerSelection.equalsIgnoreCase("X"));//loop

    }

    private void giveItem() {
        Game game = PemberleyGame.getCurrentGame();

        if (game.getInventoryItemNames().length == 0 || game.getLocalActorNames().length == 0) {
            this.console.println("You have nothing to give or there is no one to give something to."); 
            return;
        }

        ItemControl itemControl = new ItemControl();
        ActorControl actorControl = new ActorControl();
        InventoryControl inventoryControl = new InventoryControl();
        String prompt = "What do you want to give?";
        Player player = game.getPlayerOne();
        Item[] inventoryItems = game.getInventoryItemArray();
        Actor[] actorArray = game.getLocalActorArray();
        String gameMessage = " ";
        int quantityOfItem = 1;
        Item itemToGive;
        Actor actorToGive;
//check to see if there is anything to use.

        this.console.println("These things are in your inventory\n");

        for (String i : game.getInventoryItemNames()) {
            this.console.print(i + "\n");
        }

        String playerSelection;
        do {
            playerSelection = this.getStringInput(prompt);
            
            int indexOfItem = itemControl.getItemIndex(playerSelection, player, inventoryItems);

            try{
                itemToGive = inventoryItems[indexOfItem];
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    ErrorView.display(this.getClass().getName(),"\nNot Sure what you are trying to give.");
                    return;
            }
            
            if (itemToGive.getQuantity() > 1) {
                prompt = "How many " + itemToGive.getName() + " do you want to give?";
                playerSelection = this.getStringInput(prompt);

                try {
                    quantityOfItem = Integer.parseInt(playerSelection); // converts string to int

                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number."
                            + " Try again or type X to exit.");
                    break;
                }

            } else {
                quantityOfItem = 1;
            }

            this.console.print("\nThese people are here:");
            prompt = "Who do you want to give the " + itemToGive.getName() + " to?\n";
              for (String i : game.getLocalActorNames()) {
            this.console.print(i + "\n");
        }
            
            playerSelection = this.getStringInput(prompt);

            int indexOfActor = actorControl.getActorIndex(playerSelection, player, actorArray);
           
            try{
                actorToGive = actorArray[indexOfActor];
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    ErrorView.display(this.getClass().getName(),"\nNot Sure who you are trying to give the "+itemToGive.getName()
                            +" to.");
                    return;
            }
            
            this.console.println(inventoryControl.giveItem(itemToGive, quantityOfItem, actorToGive));
            
            break;
            
        } while (!playerSelection.equalsIgnoreCase("x"));

    }

// author Sheila 
    private void speakToActor() {
        Game game = PemberleyGame.getCurrentGame();

        int itemSelection = 1; // start at one so first item in list isn't zero
        String playerSelection = " ";

        Actor[] actorNames = game.getLocalActorArray(); // get list of actors in the current location
        
        
        for (int i = 0; i < actorNames.length; i++) {
            if (actorNames.length == 0) {
            this.console.print("NO ONE IS HERE");
            return; //no selection possible, return to menu
        } 
//actors available to speak - return list
            else {
                this.console.println("These actors are here: \n" 
                                    + itemSelection + " " + actorNames[i].getName());
                                    itemSelection++; // increments number   
                String prompt = "\nType the number of the actor you want to speak to? Type X to exit";
                do {
                    playerSelection = this.getStringInput(prompt);
                    if (playerSelection.equalsIgnoreCase("x")){ // without this here, the 'x' is seen as an error.
                        break;
                    }
                    
                try {
                    itemSelection = Integer.parseInt(playerSelection); // converts string input to int
                    this.console.println(actorNames[itemSelection-1].getCharacterScript()); //-1 returns selection to zero
                } catch(NumberFormatException nf) {
                   ErrorView.display(this.getClass().getName(), nf.getMessage()); 
                }
                }while (!playerSelection.equalsIgnoreCase("x"));
            }
        }
    }
    

    private void useItem() {

        Game game = PemberleyGame.getCurrentGame();
        ItemControl itemControl = new ItemControl();
        String prompt = "What do you want to try and use?";

//check to see if there is anything to use.
        if (game.getLocalItemNames().length == 0 && game.getInventoryItemNames().length == 0) {
            this.console.println("There is nothing to use here.");
            return;
        }

        this.console.println("These things are accessible:\n");

        for (String i : game.getLocalItemNames()) {
            this.console.print(i + "\n");
        }

        for (String i : game.getInventoryItemNames()) {
            this.console.print(i + "\n");
        }

        String playerSelection;
        do {
            playerSelection = this.getStringInput(prompt);

            String useItemMessage = itemControl.useItem(playerSelection, game);
            this.console.println(useItemMessage);
        } while (!playerSelection.equalsIgnoreCase("x"));

    }
//author Melissa and Sheila

    private void lookAt() {

        LookMenuView lookMenu = new LookMenuView();
        lookMenu.display();

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

    private String getIntegerInput(String prompt) {
        boolean valid = false; // indicates if the name has be retrieved
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream

        while (!valid) { // while a valid name has not been retrieved

// prompt for the player's choice
            this.console.println(prompt);

// get the selection from the keyboard and trim off the blanks CAPs ok
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();
            char ch = playersInput.charAt(0);

// if the selection is invlaid (less than one characters in length)
            if (!Character.isDigit(ch)) {
                this.console.println("Please enter a positive integer.");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }

        return playersInput; // return the name
    }

    private void dropItem() {
        Game game = PemberleyGame.getCurrentGame();
        Player player = game.getPlayerOne();
        ItemControl itemControl = new ItemControl();
        Item[] inventoryItemArray = game.getInventoryItemArray();
        String gameMessage = " ";
        int indexOfItem;
        int quantityOfItem = 1;
        String playerSelection;
        InventoryControl inventoryControl = new InventoryControl();
//designate the inventory
        Inventory inventory = player.getInventory();
//while player's selection is not X loop
        do {
//if there is nothing in the localItemArray say there is nothing to take.
            if (inventoryItemArray.length == 0) {
                this.console.println("Nothing to drop");
                break;
            } else {
                String prompt = "What do you want to drop? Type X to exit.";
//get input from the player
                playerSelection = this.getStringInput(prompt);
//see if the player's selected item is in the room. return it's index in the array.
                indexOfItem = itemControl.getItemIndex(playerSelection, player, inventoryItemArray);

                if (indexOfItem != -1) {//run this code if there was an index match
//set the item to whatever item matched the players selection
                    Item selectedItem = inventoryItemArray[indexOfItem];
//if the item's multiple attribute is true run this code
                    if (selectedItem.getQuantity()> 1) {
                        prompt = "How Many do you want to drop? (1 - " + selectedItem.getQuantity() + ")";
//get the players selection and make sure it is an integer
                        playerSelection = this.getStringInput(prompt); // gets a string
//make the player's selection an integer
                        try {
                            quantityOfItem = Integer.parseInt(playerSelection); // converts string to int

                        } catch (NumberFormatException nf) {
                            ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number."
                                    + " Try again or type X to exit.");

                        }
//call the takeMultipleItem function.
                        try {
                            gameMessage = inventoryControl.dropMultipleItem(selectedItem, quantityOfItem, inventory);
                        } catch (InventoryControlException ie) {
                            ErrorView.display(this.getClass().getName(),ie.getMessage());
                        }
                    } else {//run this code if the item's multiple attribue is not true
                        quantityOfItem = 1;

//call the takeSingleItem function
                        try {
                            gameMessage = inventoryControl.dropSingleItem(selectedItem, quantityOfItem, inventory);
                        } catch (InventoryControlException ie) {
                            ErrorView.display(this.getClass().getName(),ie.getMessage());
                        }

                    }

                } else {
//if the player's selection is not in the array send this message
                    gameMessage = "Not sure what you are trying to drop.";
                }
            }
            this.console.println(gameMessage);
        } while (!playerSelection.equalsIgnoreCase("X"));//loop

     
    }

}
