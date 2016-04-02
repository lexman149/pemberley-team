/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.Game;
import byui.cit260.pemberleyGame.model.Inventory;
import byui.cit260.pemberleyGame.model.Item;
import byui.cit260.pemberleyGame.model.Location;
import byui.cit260.pemberleyGame.model.Player;
import byui.cit260.permberleyGame.exceptions.ItemControlException;
import pemberley_game.PemberleyGame;
import java.util.ArrayList;

/**
 *
 * @author Mel
 */
public class ItemControl {
//by Melissa Marriott

    public int getItemIndex(String playerSelection, Player player, Item[] localItemArray) {
        Inventory inventory = player.getInventory();
//set default message.
        int itemIndex = -1;
        ItemControl itemControl = new ItemControl();
        /*take the array and make a new array containing the names of the items to make
it searchable by name*/
        String[] localItemList = itemControl.createItemNameList(localItemArray);
//call the function that checks user selection against each item name;
        itemIndex = this.findIndexOfValue(playerSelection, localItemList);
        return itemIndex;
    }

    public int findIndexOfValue(String playerSelection, String[] stringToCheck) {
//set the default to -1
        int indexOfValue = -1;
        /*loop through each string in the array to see if selection is anywhere 
in the string. I am using this instead of a normal array contains both 
to make it case insenstive and so that if any part of the players selection is 
in the string it will return an index of its location.  For example, using this
if the player says they want to get treats or dog treats instead of The 
Dog Treats, it will still find it.*/

        for (int i = 0; i < stringToCheck.length; i++) {
//change players selection to upper case to make the search case insensitive
            playerSelection = playerSelection.toUpperCase();
//change each string in the array to upper case to make the search case insensitive
            String stringToCheckUpper = stringToCheck[i].toUpperCase();
//if the string contains any part of the player's selection, return the index.
            if (stringToCheckUpper.contains(playerSelection) == true) {
                indexOfValue = i;
            }
        }

        return indexOfValue;
    }

    public String[] createItemNameList(Item[] itemArray) {
        ArrayList<String> itemList = new ArrayList<String>();

        for (Item i : itemArray) {
            itemList.add(i.getName().toUpperCase());
        }
        String[] itemNameArray = itemList.toArray(new String[itemList.size()]);
        return itemNameArray;
    }

    public Item[] createLocalItemArray() {
//set the current location to wherever the player is.
        Game game = PemberleyGame.getCurrentGame();
        Location currentLocation = game.getCurrentRoom();
        Item[] allItemArray = game.getAllItemArray();
//create an ArrayList to hold all of the items in the above location.
        ArrayList<Item> localItemList = new ArrayList<Item>();
        for (Item i : allItemArray) {
            Location currentItemLocation = i.getLocation();

            if (currentItemLocation == currentLocation) {

                localItemList.add(i);
            }
        }
        Item[] localItemArray = localItemList.toArray(new Item[localItemList.size()]);
        return localItemArray;
    }

// author Melissa and Sheila
    public String lookAtItem(String playerSelection, Game game) 
        throws ItemControlException {
                    
        Item[] localItemArray = game.getLocalItemArray();//set the variable for localItemArray to the game's local item ar
        int indexOfItem = this.findIndexOfValue(playerSelection, game.getLocalItemNames()); // compares player's selection to the String[] and pulls the location in the list 
        if (indexOfItem != -1) {
            return localItemArray[indexOfItem].getDescription();
//return localItemArray[indexOfItem].getDescription(); // returns description of item
        } else {
            throw new ItemControlException ("That item is not available here.");
        }
    }

    public String useItem(String playerSelection, Game game) {
        //Game game = PemberleyGame.getCurrentGame();
        int indexOfItem;
        boolean itemIsPresent = false;
        Item itemToUse;

        indexOfItem = this.findIndexOfValue(playerSelection, game.getLocalItemNames()); // compares player's selection to the String[] and pulls the location in the list 
        if (indexOfItem != -1) {
            itemIsPresent = true;
            itemToUse = game.getLocalItemArray()[indexOfItem];
        } else {
//if there are no local items to use, check inventory items to use.
            indexOfItem = this.findIndexOfValue(playerSelection, game.getInventoryItemNames());
            if (indexOfItem != -1) {
                itemToUse = game.getInventoryItemArray()[indexOfItem];
            } else {
                return "That item is not here.";
            }
        }

        if (itemToUse.isUsable() != true && itemToUse.getUseMessage() == null) {
            return "You can't use the " + itemToUse.getName();
        } else if (itemToUse.isUsable() != true){
            return itemToUse.getUseMessage();
        } else if (itemToUse.isUsable()== true && itemToUse.getQuest() != null){
            QuestControl questControl = new QuestControl();
            this.changeItemAttributes(itemToUse);
            return questControl.executeQuestActions(game, itemToUse.getQuest());
        } else if (itemToUse.isUsable()== true && itemToUse.getUseMessage() != null){      
            return itemToUse.getUseMessage(); 
        } else{
            return "You use the " + itemToUse.getName();
        }

    }

    public void changeItemAttributes(Item currentItem) {
        if (currentItem.getAlternateDescription() != null) 
            currentItem.setDescription(currentItem.getAlternateDescription());
        
        if (currentItem.isAlternateUsable() == true)
            currentItem.setUsable(true);
        
        if (currentItem.getAlternateLocation() != null)
            currentItem.setLocation(currentItem.getAlternateLocation());
        
        if (currentItem.isAlternateTakable() == true) 
            currentItem.setTakable(true);
        
        if (currentItem.getAlternateTakeMessage() != null) 
            currentItem.setTakeMessage(currentItem.getAlternateTakeMessage());
        
        if (currentItem.getAlternateUseMessage() != null) 
            currentItem.setUseMessage(currentItem.getAlternateUseMessage());
        
    }

}
