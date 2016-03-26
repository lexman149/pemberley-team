/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.model.Game;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import pemberley_game.PemberleyGame;

/**
 *
 * @author frupp
 */
public abstract class View implements ViewInterface {

    protected String displayMessage;

    protected final BufferedReader keyboard = PemberleyGame.getInFile();
    protected final PrintWriter console = PemberleyGame.getOutFile();
    
    public View() {
    }

    public View(String message) {
        this.displayMessage = message;
    }

    @Override
    public void display() {
        String value;
        boolean done = false;
        do {
            this.console.println(this.displayMessage); // display the prompt message
            value = this.getInput(); // get the user's selection
            done = this.doAction(value); // do action based on selection 
        } while (!done);
    }

     @Override
     public String getInput() {
         return getInput(true); // overload function and rename getInput with a true to change uppercase
     }
     
    public String getInput(boolean upper) { // if upper=true make uppercase, otherwise don't run line 58
        boolean valid = false; // indicates if the selection has be retrieved
        String selection = null;
        try {

            while (!valid) { // while a valid menu selection has not been retrieved

// get the selecton from the keyboard and trim off the blanks CAPs ok
                selection = this.keyboard.readLine();
                selection = selection.trim();
                if (upper == true){
                    selection = selection.toUpperCase();
                }

// if the menu selection is invlaid (less than one character in length)
                if (selection.length() < 1) {
                    this.console.println("Invalid selection - the selection must not be blank");
                    continue; // and repeat again 
                }
                break; // out of the (exit) the repetition
            }
        } catch (Exception e) {
            this.console.println("Error reading input: " + e.getMessage());
        }
        return selection;
    }
}
