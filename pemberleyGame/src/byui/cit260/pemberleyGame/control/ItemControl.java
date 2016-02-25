/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.Item;
import byui.cit260.pemberleyGame.model.Location;
import byui.cit260.pemberleyGame.model.Player;
import java.util.ArrayList;

/**
 *
 * @author Mel
 */
public class ItemControl {

    public String[] createItemNameList(Item[] itemArray) {
        ArrayList<String> itemList = new ArrayList<String>();
        for (Item i : itemArray) {
            itemList.add(i.getName().toUpperCase());
        }
        String[] itemNameArray = itemList.toArray(new String[itemList.size()]);
        return itemNameArray;
    }

    public Item[] createLocalItemArray(Player player, Item[] allItemArray) {
//set the current location to wherever the player is.
        Location currentLocation = player.getLocation();
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
    public String lookAtItem(String playerSelection, Player player, Item[] localItemArray) {
        String[] localItemList = this.createItemNameList(localItemArray); // making a list of all the items in the localItemArray
        InventoryControl inventoryControl = new InventoryControl();
        int indexOfItem = inventoryControl.findIndexOfValue(playerSelection, localItemList); // compares player's selection to the String[] and pulls the location in the list 
        if (indexOfItem != -1) {
            return localItemArray[indexOfItem].getDescription(); // returns description of item
        }
        else {
            return "That item is not available here.";
        }
    }

}
