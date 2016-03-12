
/*
* Test files - instances of the classes
 */
package pemberley_game;

import byui.cit260.pemberleyGame.control.*;
import byui.cit260.pemberleyGame.model.*;
import byui.cit260.pemberleyGame.view.StartProgramView;
import java.util.Scanner;

/**
 *
 * @author jpmanning
 */
public class PemberleyGame {

    /**
     * @param args the command line arguments
     */
    private static Game currentGame = null;
    private static User user = null;

    public static void main(String[] args) {

// create StartProgramViw and start the program
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.startProgram();

    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        PemberleyGame.currentGame = currentGame;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        PemberleyGame.user = user;
    }

}
