/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.model.Game;
import java.util.Scanner;

/**
 *
 * @author frupp
 */
public abstract class View implements ViewInterface {

    protected String displayMessage;

    public View() {
    }

    public View(String message) {
        this.displayMessage = message;
    }

    @Override
    public void display(Game game) {
        String value;
        boolean done = false;
        do {
            System.out.println(this.displayMessage); // display the prompt message
            value = this.getInput(); // get the user's selection
            done = this.doAction(value, game); // do action based on selection 
        } while (!done);
    }

    @Override
    public String getInput() {
        boolean valid = false; // indicates if the selection has be retrieved
        String value = null;
        Scanner keyboard = new Scanner(System.in); // keyboard input stream

        while (!valid) { // while a valid menu selection has not been retrieved

// get the selecton from the keyboard and trim off the blanks CAPs ok
            value = keyboard.nextLine();
            value = value.trim();
            value = value.toUpperCase();

// if the menu selection is invlaid (less than one character in length)
            if (value.length() < 1) {
                System.out.println("Invalid selection - the selection must not be blank");
                continue; // and repeat again 
            }
            break; // out of the (exit) the repetition
        }

        return value; // return the name
    }
}
