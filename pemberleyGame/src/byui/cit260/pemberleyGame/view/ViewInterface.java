/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
