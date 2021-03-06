/*
* CIT260
* PemberlyGame
* Manning, Marriott, Wilkerson
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.*;
import byui.cit260.pemberleyGame.view.ErrorView;
import byui.cit260.permberleyGame.exceptions.InventoryControlException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import pemberley_game.PemberleyGame;

/**
 *
 * @author mbp
 */
public class InventoryControl {

    public double calcAddInventoryWeight(double currentWeight, double newWeight, int newItemQuantity) 
                        throws InventoryControlException {
        if (newItemQuantity < 0 || newItemQuantity > 9) {
            throw new InventoryControlException("Please enter a number between 1 - 9");
        }
//currentWeight = inventory.getCurrentWeight(); /*needs to be created */
        newWeight = currentWeight + (newWeight * newItemQuantity);
        if (newWeight > 20) {
            throw new InventoryControlException("You have exceeded your inventory weight of 20 lbs.");
        }
        return newWeight;
    }

    
    
    public double calcRemoveInventoryWeight(double currentWeight, double itemWeight, int dropItemQuantity, int currentItemQuantity) 
                        throws InventoryControlException{
        double newWeight;
        
        if (dropItemQuantity < 1 || dropItemQuantity > currentItemQuantity) {
            throw new InventoryControlException("Please enter a number between 1 - " + currentItemQuantity);
        }
//currentWeight = inventory.getCurrentWeight(); /*needs to be created */
        newWeight = currentWeight - (itemWeight * dropItemQuantity);
        
        return newWeight;
    }

        public double calcRemoveInventoryWeight(double currentWeight, double newWeight, int newItemQuantity) 
                        throws InventoryControlException{
        if (newItemQuantity < 0 || newItemQuantity > 9) {
            throw new InventoryControlException("Please enter a number between 0 - 9");
        }
//currentWeight = inventory.getCurrentWeight(); /*needs to be created */
        newWeight = currentWeight - (newWeight * newItemQuantity);
        if (newWeight < 0) {
            throw new InventoryControlException("Your cannot take away more weight than you have.");
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
    public String takeSingleItem(Item itemToTake, int quantityToTake, Inventory inventory) 
                        throws InventoryControlException {
//check to make sure that the potetial weight does not exceed the 20 lb limit
//if the item's takable attribute is not true, return an appropriate message.
        if (!itemToTake.isTakable()) {
            if (itemToTake.getTakeMessage() == null) {
                
                return "You can't get that at this time.";
            } else {
                return itemToTake.getTakeMessage();
            }
        } else {
            double potentialWeight = this.calcAddInventoryWeight(inventory.getWeight(), itemToTake.getWeight(), quantityToTake);
            itemToTake.setLocation(inventory);
            inventory.setWeight(inventory.getWeight() + potentialWeight);
            this.updateInventory();
            return ("You take " + itemToTake.getName());

        }
    }

//by Melissa Marriott
    public String takeMultipleItem(Item itemToTake, int quantityToTake, Inventory inventory) 
                        throws InventoryControlException{
//make the item to take whatever is in the container.

        itemToTake = itemToTake.getContains();
        if (itemToTake.isTakable()!= true)
            return "You can't take the " + itemToTake.getName();
//check to make sure that the potetial weight does not exceed the 20 lb limit
        double potentialWeight = this.calcAddInventoryWeight(inventory.getWeight(), itemToTake.getWeight(), quantityToTake);
//set the current quantity to whatever is currently in the inventory
        int currentQuantity = itemToTake.getQuantity();
//check to make sure that the quantity does not exceed the limit
        boolean canTake = this.checkCanGet(9, currentQuantity, quantityToTake);
//if the quantity exceeds the limit let the player know how many they alredy have
        if (!canTake) {
            return "You already have " + currentQuantity + " " + itemToTake.getName() + "You can only have 9";
        } else {
//else everything is okay to move the item to the inventory.  set the inventory's new weight.
            itemToTake.setLocation(inventory);
            itemToTake.setQuantity(itemToTake.getQuantity() + quantityToTake);
            inventory.setWeight(inventory.getWeight() + potentialWeight);
            this.updateInventory();
            return ("You get " + quantityToTake + " " + itemToTake.getName());
        }
    }
    
     //this function updates the inventory
        public void updateInventory() {
            Game game = PemberleyGame.getCurrentGame();
        Player player = game.getPlayerOne();
        Inventory inventory = player.getInventory();
        ItemControl itemControl = new ItemControl();
        
        Item[] allItemArray = game.getAllItemArray();
        ArrayList<Item> inventoryItemList = new ArrayList<>();

        for (Item i : allItemArray) {
            Location currentItemLocation = i.getLocation();
            if (currentItemLocation == inventory) {
                inventoryItemList.add(i);
            }
        }

        Item[] inventoryItemArray = inventoryItemList.toArray(new Item[inventoryItemList.size()]);
        game.setInventoryItemArray(inventoryItemArray);

        String[] inventoryNameString = itemControl.createItemNameList(inventoryItemArray);
        game.setInventoryItemNames(inventoryNameString);
        
        
        GameControl gameControl = new GameControl();
        gameControl.updateGame();
    }

//    public String giveMultipleItem(Item selectedItem, int quantityOfItem, Inventory inventory) 
//                               throws InventoryControlException{
////make the item to take whatever is in the container.
//
//
//  }

    public String giveItem(Item selectedItem, int quantityOfItem, Actor actorToReceive) {
        String gameMessage = " ";
        Game game = PemberleyGame.getCurrentGame();
        QuestControl questControl = new QuestControl();
        ActorControl actorControl = new ActorControl();
        GameControl gameControl = new GameControl();
        
        Player player = game.getPlayerOne();
        Inventory inventory = player.getInventory();
        
        Quest currentQuest = actorToReceive.getQuest();
        
        if (selectedItem == currentQuest.getNeeds()){
            if(quantityOfItem == 1){
                selectedItem.setLocation(null); 
                double weightToRemove =inventory.getWeight() - selectedItem.getWeight();
                inventory.setWeight(weightToRemove);
                this.updateInventory();
            } else {
                int potentialQuantity = selectedItem.getQuantity() - quantityOfItem;
                if (potentialQuantity < 1){
                    return "You don't have that many " + selectedItem.getName();
                }
                selectedItem.setQuantity(selectedItem.getQuantity() - quantityOfItem);
                inventory.setWeight(inventory.getWeight() - (selectedItem.getWeight() * quantityOfItem));
                this.updateInventory();
            }
            
            

            actorControl.changeActorAttributes(actorToReceive);
            gameControl.updateGame();
            return questControl.executeQuestActions(game, currentQuest);
        
        } else{
    
            return actorToReceive.getName() + " doesn't appear to want that.";
        }
            
        
        
        
        
        
        
        
        
}
    
    
    
    
        public void saveInventoryReport(String fileName) {
         Game game = PemberleyGame.getCurrentGame(); 
        Item[] inventoryItemArray = game.getInventoryItemArray();
        try (FileWriter outFile = new FileWriter(fileName)) { // try-with-resources 
        String separator = System.getProperty("line.separator");    

        
            outFile.write("          INVENTORY REPORT          ");     

            outFile.write(separator);
            outFile.write(String.format ("%-30s %7s %n","Item","Weight"));
            outFile.write(String.format ("%-30s %7s %n","________","________"));

            for(Item i : inventoryItemArray){ 
                //add spaces
                

                outFile.write (String.format ("%n%-30s%-2.2f",i.getName() , i.getWeight()));
   
                
            }
        
            outFile.flush();
            
        } catch (IOException ex) {
            ErrorView.display("ReportMenuView", ex.getMessage());
        
        }
    }

    public String dropSingleItem(Item selectedItem, int quantityOfItem, Inventory inventory) 
                            throws InventoryControlException {
        Game game = PemberleyGame.getCurrentGame();
        Player player = game.getPlayerOne();
        double currentWeight = inventory.getWeight();
        double itemWeight = selectedItem.getWeight();
        
        int currentItemQuantity = selectedItem.getQuantity();
        Location currentLocation = player.getLocation();
        selectedItem.setLocation(currentLocation);
        double newInventoryWeight = this.calcRemoveInventoryWeight(currentWeight, itemWeight , 1, 1);
        this.updateInventory();                    
        return "you have dropped the " + selectedItem.getName();
        
    }

    public String dropMultipleItem(Item selectedItem, int quantityOfItem, Inventory inventory) 
                        throws InventoryControlException{
        Game game = PemberleyGame.getCurrentGame();
        Player player = game.getPlayerOne();
        double currentWeight = inventory.getWeight();
        double itemWeight = selectedItem.getWeight();
        int currentItemQuantity = selectedItem.getQuantity();
        
        double newWeight = this.calcRemoveInventoryWeight(currentWeight, itemWeight, quantityOfItem, currentItemQuantity);
        if (currentItemQuantity - quantityOfItem == 0){
        selectedItem.setLocation(null);
        } else if (currentItemQuantity - quantityOfItem <0){
        throw new InventoryControlException("You can't drop more than you are carrying.");
        } else {
        selectedItem.setQuantity(currentItemQuantity-quantityOfItem);
        }
        
   
        this.updateInventory();
        return "As you drop some " + selectedItem.getName() + " The housekeeper bustles in and cleans them up.  She scolds you for being so careless";
    }

}