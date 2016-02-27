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

    
    //by Melissa Marriott
    public String takeSingleItem(Item itemToTake, int quantityToTake, Inventory inventory) {
//check to make sure that the potetial weight does not exceed the 20 lb limit
        double potentialWeight = this.calcAddInventoryWeight(inventory.getWeight(), itemToTake.getWeight(), quantityToTake);
//if the item's takable attribute is not true, return an appropriate message.
        if (!itemToTake.isTakable()) {
            if (itemToTake.getTakeMessage() == null) {
                return "You can't get that at this time.";
            } else {
                return itemToTake.getTakeMessage();
            }
//else if the potential weight is too much return an appropriate message
        } else if (potentialWeight == -2) {

            return "You are trying to carry too much weight.";
//else everything is okay to move the item to the inventory.  set the inventory's new weight
        } else {
            itemToTake.setLocation(inventory);
            inventory.setWeight(inventory.getWeight() + potentialWeight);
            return ("You take " + itemToTake.getName());

        }
    }




//by Melissa Marriott
    public String takeMultipleItem(Item itemToTake, int quantityToTake, Inventory inventory) {
        //make the item to take whatever is in the container.
    itemToTake = itemToTake.getContains();
    //check to make sure that the potetial weight does not exceed the 20 lb limit
        double potentialWeight = this.calcAddInventoryWeight(inventory.getWeight(), itemToTake.getWeight(), quantityToTake);
        //set the current quantity to whatever is currently in the inventory
        int currentQuantity = itemToTake.getQuantity(); 
        //check to make sure that the quantity does not exceed the limit
        boolean canTake = this.checkCanGet(9, currentQuantity, quantityToTake);   
        //if the quantity exceeds the limit let the player know how many they alredy have
        if (!canTake) {
            return "You already have " + currentQuantity + " " + itemToTake.getName() + "You can only have 9";
        //else let the player know that the quantity is not valid
        } else if (potentialWeight == -1) {
            return "That is not a valid quantity";
        //else if the potential weight is too much return an appropriate message  
        } else if (potentialWeight == -2) {
            return "That exceeds your weight limit";
        } else  {
            //else everything is okay to move the item to the inventory.  set the inventory's new weight.
                itemToTake.setLocation(inventory);
                itemToTake.setQuantity(itemToTake.getQuantity() + quantityToTake);
                inventory.setWeight(inventory.getWeight() + potentialWeight);
		return ("You get " + quantityToTake + " " + itemToTake.getName());
        }
         }
    

}
