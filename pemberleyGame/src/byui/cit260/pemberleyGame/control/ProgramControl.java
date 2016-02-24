/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.User;
import java.util.ArrayList;
import pemberley_game.PemberleyGame;

/**
 *
 * @author mbp
 */
public class ProgramControl {

    public static User createPlayer(String name) {

        if (name == null) {
            return null;
        }

        User player = new User();
        player.setName(name);

        PemberleyGame.setUser(player); // save the player

        return player;
    }

}
