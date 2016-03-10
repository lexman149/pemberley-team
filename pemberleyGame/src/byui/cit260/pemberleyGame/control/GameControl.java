/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.*;
import byui.cit260.pemberleyGame.model.User;

/**
 *
 * @author mbp
 */
public class GameControl {

    public static void createNewGame(User player, Game game) {
        
    }
    
    
    
    public void updateGame (Game game){
        Player player = game.getPlayerOne();
        game.setCurrentRoom(player.getLocation());
        game.setCurrentMap(game.getCurrentRoom().getMap());
        ActorControl actorControl = new ActorControl();
        ItemControl itemControl = new ItemControl();
        game.setLocalItemArray(itemControl.createLocalItemArray(game));
        game.setLocalActorArray(actorControl.createLocalActorArray(game));
        game.setLocalActorNames(actorControl.createActorNameList(game.getLocalActorArray()));
        game.setLocalItemNames(itemControl.createItemNameList(game.getLocalItemArray()));
        
    }

}
