/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pemberleygame;

import byui.cit260.pemberleyGame.model.Player;

/**
 *
 * @author jpmanning
 */
public class PemberleyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Player playerOne = new Player();
      
      playerOne.setName("John Doe");
      playerOne.setLocation("Library");
      playerOne.setGender("Male");
      
      String playerInfo = playerOne.toString();
      System.out.println(playerInfo);
    }
    
}
