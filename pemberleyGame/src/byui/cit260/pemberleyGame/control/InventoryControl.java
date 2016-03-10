/*
* CIT260
* PemberlyGame
* Manning, Marriott, Wilkerson
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.*;


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
            return -1;
        }
//currentWeight = inventory.getCurrentWeight(); /*needs to be created */
        newWeight = currentWeight - (newWeight * newItemQuantity);
        if (newWeight < 0) {
            return -1;
        }
        return newWeight;
    }

    public boolean checkCanGet(int quantityLimit, int currentQuantity, int newQuantity) {
        if (newQuantity < 0 || newQuantity > 9) {
            return false;
        }
        int potentialQuantity = quantityLimit - (currentQuantity + newQuantity);
        if (potentialQuantity < 0) {
            return false;
        }
        return true;
    }
    

//function that takes any string and finds it in an array of strings. Move to a different control?

    
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
    
    // SHEILA This will be for the help menu - displayInventory when completed. 
//    public Inventory[] createLocalInventoryArray(Player player) {
////the player is the location of inventory
//        
////create an ArrayList to hold all of the actors in the above location.
//        ArrayList<Inventory> localInventoryList = new ArrayList<Inventory>();
//        for (Inventory i : allInventoryArray) {
//            if (currentInventoryLocation == player) {
//                localInvetoryList.add(i);
//            }
//        }
//        Actor[] localActorArray = localActorList.toArray(new Actor[localActorList.size()]);
//        return localActorArray;
//    }


}
