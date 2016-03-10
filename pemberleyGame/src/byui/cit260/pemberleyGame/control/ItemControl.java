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

 
    public Item[] createLocalItemArray(Game game) {
//set the current location to wherever the player is.

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
    public String lookAtItem(String playerSelection, Game game) {
        Item[] localItemArray = game.getLocalItemArray();//set the variable for localItemArray to the game's local item ar
        int indexOfItem = this.findIndexOfValue(playerSelection, game.getLocalItemNames()); // compares player's selection to the String[] and pulls the location in the list 
        if (indexOfItem != -1) {
            return localItemArray[indexOfItem].getDescription(); // returns description of item
        }
        else {
            return "That item is not available here.";
        }
    }

}
