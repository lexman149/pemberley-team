/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pemberley;

import cit260.pemberley.model.Player;

/**
 *
 * @author mbp
 */
public class Pemberley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Player playerOne = new Player();
            
        playerOne.setName("Fred Flintstone");
        playerOne.setBestTime(7.00);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    
    }
        
}

