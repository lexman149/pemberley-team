
/*
* Test files - instances of the classes
 */
package pemberley_game;

import byui.cit260.pemberleyGame.model.*;
import byui.cit260.pemberleyGame.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    protected final PrintWriter console = PemberleyGame.getOutFile();
    private static PrintWriter logFile = null;
        
    public static void main(String[] args) {

// create StartProgramViw and start the program
        StartProgramView startProgramView = new StartProgramView();
        try {            
            PemberleyGame.inFile = 
                    new BufferedReader(new InputStreamReader(System.in));
            
            PemberleyGame.outFile = new PrintWriter(System.out, true);
            
            //open log file
            try {
                String filePath = "log.txt";
                PemberleyGame.logFile = new PrintWriter(filePath);
            } catch (Exception e) {
                System.out.println("Exception: " + e.toString() +
                                   "\nCause: " + e.getCause() +
                                   "\nMessage: " + e.getMessage());
                 e.printStackTrace();;      
            }
            
            startProgramView.startProgram();
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
            startProgramView.startProgram();
        } finally {
            try {
                if (PemberleyGame.inFile !=null)
                    PemberleyGame.inFile.close();
                if (PemberleyGame.outFile != null)
                    PemberleyGame.outFile.close();  
                if (PemberleyGame.logFile != null)
                    PemberleyGame.logFile.close();
            } catch (IOException ex) {
                System.out.println("Error Closing Files");
                return;
            }
        }
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

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        PemberleyGame.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        PemberleyGame.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        PemberleyGame.logFile = logFile;
    }

}
