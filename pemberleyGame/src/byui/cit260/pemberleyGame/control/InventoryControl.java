/*
* CIT260
* PemberlyGame
* Manning, Marriott, Wilkerson
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.*;
import java.util.ArrayList;

/**
 *
 * @author mbp
 */
public class InventoryControl {

    public double calcAddInventoryWeight(double currentWeight, double newWeight, int newItemQuantity) {
        if (newItemQuantity < 0 || newItemQuantity > 9) {
            return -1;
        }
//currentWeight = inventory.getCurrentWeight(); /*needs to be created */
        newWeight = currentWeight + (newWeight * newItemQuantity);
        if (newWeight > 20) {
            return -2;
        }
        return newWeight;
    }

    public double calcRemoveInventoryWeight(double currentWeight, double newWeight, int newItemQuantity) {
        if (newItemQuantity < 0 || newItemQuantity > 9) {
            return -2;
        }
//currentWeight = inventory.getCurrentWeight(); /*needs to be created */
        newWeight = currentWeight - (newWeight * newItemQuantity);
        if (newWeight < 0) {
            return -1;
        }
        return newWeight;
    }

    public boolean checkCanGet(int quantityLimit, int currentQuantity, int newQuantity) {
        boolean itemCanBeAdded;
        if (newQuantity < 0 || newQuantity > 9) {
            return false;
        }
        int potentialQuantity = quantityLimit - (currentQuantity + newQuantity);
        if (potentialQuantity < 0) {
            return false;
        }
        return true;
    }

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
//if the item's takable attribute is true, say the item is taken.
//still needs to transfer item to inventory and incorporate other inventory controls
//        if (localItemArray[indexOfSelection].isTakable()) {
//            if (localItemArray[indexOfSelection].isMultiple()==true){      
//            } 
//            takeMessage = "You take the " + localItemArray[indexOfSelection].getName();
//        }
        return itemIndex;
    }

//function that takes any string and finds it in an array of strings. Move to a different control?
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

    public String takeItem(Item itemToTake, int quantityToTake, Inventory inventory) {
        String takeMessage = "You can't take that";
        boolean canTake;
        int currentQuantity = itemToTake.getQuantity();
        canTake = this.checkCanGet(9, currentQuantity, quantityToTake);
        double potentialWeight = this.calcAddInventoryWeight(inventory.getWeight(), itemToTake.getWeight(), quantityToTake);
        System.out.println(potentialWeight);
        if (!itemToTake.isTakable()) {
            if (itemToTake.getTakeMessage() == null) {
                takeMessage = "You can't get that at this time.";
            } else {
                takeMessage = itemToTake.getTakeMessage();
            }
        } else if (potentialWeight == -1) {
            return "That is not a valid quantity.";
        } else if (potentialWeight == -2) {
            return "That exceeds your weight limit.";

        } else if (itemToTake.isMultiple()) {
            if (canTake) {
                itemToTake.setLocation(inventory);
                itemToTake.setQuantity(quantityToTake);
                takeMessage = ("You get " + quantityToTake + " " + itemToTake.getName());
                inventory.setWeight(inventory.getWeight() + potentialWeight);
            } else {
                return "You cannot have that many " + itemToTake.getName() + " (limit 9)";
            }
        } else {
            itemToTake.setLocation(inventory);
            takeMessage = ("You get " + itemToTake.getName());
            inventory.setWeight(inventory.getWeight() + potentialWeight);
        }

        return takeMessage;

    }

}
