/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.Game;
import byui.cit260.pemberleyGame.model.Player;
import byui.cit260.pemberleyGame.model.Quest;

/**
 *
 * @author mbp
 */
public class QuestControl {

    public QuestControl() {
    }

    public String executeQuestActions(Game game, Quest currentQuest){
    String gameMessage = currentQuest.getCompletionScript();
    ActorControl actorControl = new ActorControl();
    ItemControl itemControl = new ItemControl();
    MapControl mapControl = new MapControl();
    Player player = game.getPlayerOne();
    
    if (currentQuest.getActorToChange() !=null)
        actorControl.changeActorAttributes(currentQuest.getActorToChange());
    if (currentQuest.getItemToChange() != null)
        itemControl.changeItemAttributes(currentQuest.getItemToChange());
    if (currentQuest.getPlayer() !=null)
        player.setLocation(currentQuest.getPlayerDestination());
    return gameMessage;
    }

    }