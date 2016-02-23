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
            return -1;
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

    public String takeItem(String playerSelection, Player player, Item[] localItemArray) {
        String takeMessage = "you can't take this";
        ItemControl itemControl = new ItemControl();
        playerSelection = playerSelection.toUpperCase();
        String[] localItemList = itemControl.createItemNameList(localItemArray);
        int indexOfSelection = this.findIndexOfValue(playerSelection, localItemList);
        System.out.println(indexOfSelection);
        System.out.println(localItemArray[indexOfSelection].getName());
        if (localItemArray[indexOfSelection].isTakable()) {
            takeMessage = "You take the " + playerSelection;
        }
        return takeMessage;
    }

    public int findIndexOfValue(String playerSelection, String[] localItemList) {
        int indexOfValue = -1;
        boolean doesContain;
        for (int i = 0; i < localItemList.length; i++) {
            if (localItemList[i].contains(playerSelection) == true) {
                indexOfValue = i;
            }
        }
        return indexOfValue;
    }
}
