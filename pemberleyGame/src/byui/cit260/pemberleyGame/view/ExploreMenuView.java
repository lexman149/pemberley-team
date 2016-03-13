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
    public boolean doAction(String value) {

        switch (value) {
            case "M":
                this.movePlayer();
                break;
            case "T":
                this.takeItem();
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
                System.out.println("\n***Invalid Selection *** Try Again");
                return false;
        }
        return false;
    }
// author Alexis

    private void movePlayer() {
         Game game = PemberleyGame.getCurrentGame();
        Player player = game.getPlayerOne();
        String prompt = "Which direction do you want to go? Type X to exit.";
        String playerSelection;
        do {
            playerSelection = this.getStringInput(prompt);
            MapControl mapControl = new MapControl();
            String roomDescription = mapControl.playerNavigate(playerSelection, player);
            System.out.println(roomDescription);
        } while (!playerSelection.equalsIgnoreCase("x"));

    }

    private void takeItem() {
//declare variables
 Game game = PemberleyGame.getCurrentGame();
        Player player = game.getPlayerOne();
        ItemControl itemControl = new ItemControl();
        Item[] localItemArray = game.getLocalItemArray();
        String gameMessage;
        int indexOfItem;
        int quantityOfItem;
        String playerSelection;
        InventoryControl inventoryControl = new InventoryControl();
//designate the inventory
        Inventory inventory = player.getInventory();
//while player's selection is not X loop
        do {
//if there is nothing in the localItemArray say there is nothing to take.
            if (localItemArray.length == 0) {
                System.out.println("Nothing to Take");
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

// author Sheila 
    private void speakToActor() {
        Game game = PemberleyGame.getCurrentGame();
        ActorControl actorControl = new ActorControl();
        String[] actorsName = game.getLocalActorNames(); //get list of actors in the current location
        sortStringExchange(actorsName);
//no actors in the player's location, print message and return to menu        
        if(actorsName.length<1){
            System.out.print("NO ONE IS HERE");
            return; //no selection possible, return to menu
        }
//actors available to speak - print list
        else {
            System.out.println("These characters are here:");
            for (String i : actorsName) {
                System.out.print(i + "\n");
            }
//player selects from list of actors or exits       
            String prompt = "To whom do you wish to speak? Type X to exit.";
            String playerSelection;
            do {
                playerSelection = this.getStringInput(prompt);
                String characterScript = actorControl.speakToActor(playerSelection);
                System.out.println(characterScript);
            } while (!playerSelection.equalsIgnoreCase("x"));
            
        }
    }
//    sort list of actors alphabetically using exhange sort    
        public static void sortStringExchange(String stringsToSort[]) {
            int i, j;
            String temp;
            
            for(i = 0; i < stringsToSort.length - 1; i++) {
                for(j = i + 1; j < stringsToSort.length; j++) {  
                    if(stringsToSort[i].compareToIgnoreCase(stringsToSort[j]) > 0){ // ascending sort
                        temp = stringsToSort[i];
                        stringsToSort[i] = stringsToSort[j]; // swapping
                        stringsToSort[j] = temp; 
                                      
                    } 
                } 
            } 
    }

    private void useItem() {
        
        Game game = PemberleyGame.getCurrentGame();
        ItemControl itemControl = new ItemControl();
        String prompt = "Which item do you want to use.";
        System.out.println("You can use these things:");

        
        String[] itemsHere = game.getLocalItemNames();
        
        if (itemsHere.length!= 0){
        for (String i : itemsHere) {
            System.out.print(i + "\n");
        }
        }
        itemsHere = game.getInventoryItemNames();        
        if (itemsHere.length!= 0){
        for (String i : itemsHere) {
        System.out.print(i + "\n");
        }        
        }
        String playerSelection;
        do {
            playerSelection = this.getStringInput(prompt);

            String useItemMessage = itemControl.useItem(playerSelection);
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
