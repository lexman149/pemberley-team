/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;

import java.io.PrintWriter;
import pemberley_game.PemberleyGame;

/**
 *
 * @author frupp
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = PemberleyGame.getOutFile();
    private static final PrintWriter logFile = PemberleyGame.getLogFile();
            
    public static void display(String className, String errorMessage){
    
        errorFile.println(
        "----------------------------------------"
        + "\n- ERROR-" + errorMessage
        + "\n----------------------------------------");
        
        //log error
        logFile.println(className + " - " + errorMessage);
    }
    
    
    
    
}
