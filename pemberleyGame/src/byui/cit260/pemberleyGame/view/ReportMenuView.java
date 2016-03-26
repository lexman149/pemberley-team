/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.model.Actor;
import byui.cit260.pemberleyGame.model.Game;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import pemberley_game.PemberleyGame;

/**
 *
 * @author Cody
 */
public class ReportMenuView extends View{

    public ReportMenuView() {
                super("\n"
                + "\n----------------------------------------"
                + "\n | What do you want to do?"
                + "\n----------------------------------------"
                + "\nM - Print Maps"
                + "\nI - Print Item Locations"
                + "\nA - Print Actor Locations"
                + "\nV - Print Inventory List"
                + "\nX - Exit"
                + "\n----------------------------------------"
                + "\nEnter your selection below:");
    }
      
    @Override
    public boolean doAction(String value) {

        switch (value) {
            case "M":
                this.mapReport();
                break;
            case "I":
                this.itemReport();
                break;
            case "A":
                this.writeActorLocationReport();
                break;
            case "V":
                this.inventoryReport();
                break;
            case "X": // quit help 
                return true;
            default:
                this.console.println("\n***Invalid Selection *** Try Again");
                return false;
        }
        return false;
    }

    private void mapReport() {
       this.console.println("*** mapReport function called ***");
    }

    private void itemReport() {
        this.console.println("*** itemReport function called ***");
    }
    
//3/25/16 L11 Individual Assignment by Sheila Wilkerson    
    private void writeActorLocationReport() {
// 3a
        this.console.println("\n\nEnter a file name where this report will "
                            + "be saved. Type X to exit");
 // 3b  
        String fileName = this.getInput(false); // calls the special case of getInput() from View.java

//         // getInput function in View.java
            if (fileName.equalsIgnoreCase("x")){ // without this here, the 'x' is seen as a filename.
            return;
        }
 // 3c
            // save the game to the specified file
            saveActorLocationReport(fileName);

    }
     
     
    private void saveActorLocationReport(String fileName) {  
        
        Game game = PemberleyGame.getCurrentGame(); // access to data
        Actor[] allActorArray = game.getAllActorArray(); // form with the actor's info
        boolean success = true;
        

        try (PrintWriter outFile = new PrintWriter(fileName)) { // try-with-resources 
            
// make headers for the report.
            outFile.println("\n\n          ACTOR LOCATION REPORT          ");        
            outFile.printf("%n%-30s%-14s", "Actor Name", "Location");
            outFile.printf("%n%-30s%-14s", "----------", "--------");

// print actor name and location
            for (Actor actor : allActorArray) { // goes through all the actors
                // null check - won't call a locationName if = null
                String location = "N/A"; // if location is null, print this
               
                if (actor.getLocation() !=null) { // otherwise print locationName
                    location = actor.getLocation().getName();
                }
                outFile.printf("%n%-30s%-14s", actor.getName()
                                             , location);
            }
            
        } catch (IOException ex) {
            ErrorView.display("ReportMenuView", ex.getMessage());
            success = false;
        }
 // 3d     
        if (success){
            this.console.println("The Actor Location Report was saved to\n"
                            + fileName);    
        }
    }
    
   
   
         
    

    private void inventoryReport() {
             this.console.println("*** inventoryReport function called ***");
    }
}
