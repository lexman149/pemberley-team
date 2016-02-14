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
 
    public double calcAddInventoryWeight(double currentWeight, double newWeight, int newItemQuantity){
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
 
    public double calcRemoveInventoryWeight(double currentWeight, double newWeight, int newItemQuantity){
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
    
}
