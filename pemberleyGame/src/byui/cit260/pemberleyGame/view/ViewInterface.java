/*
 * Pemberley Game
 * BYUIdaho CIT260 winter 2016
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.model.Actor;
import byui.cit260.pemberleyGame.model.Item;
import byui.cit260.pemberleyGame.model.Player;

/**
 *
 * @author frupp
 */
public interface ViewInterface {
   
    public void display(Player player, Item[] allItemArray, Actor[] allActorArray);
    public String getInput();
    public boolean doAction(String value,Player player, Item[] allItemArray, Actor[] allActorArray); 
    
}
