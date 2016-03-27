/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;

import byui.cit260.pemberleyGame.control.InventoryControl;
import byui.cit260.pemberleyGame.model.Actor;
import byui.cit260.pemberleyGame.model.Game;
import byui.cit260.pemberleyGame.model.Item;
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
                this.writeItemLocationReport();
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
                            + "'" + fileName + ".txt'");    
        }
    }
    
    
    private void writeItemLocationReport() {
// 3a
        this.console.println("\n\nEnter a file name where this report will "
                            + "be saved. Type X to exit");
 // 3b  // getInput function in View.java
           
        String fileName = this.getInput();
        
            if (fileName.equalsIgnoreCase("x")) { //without this here, the "x" is seen as a filename.
            return;
            }
           
// 3c
        try {
            // save the game to the specified file
            saveItemLocationReport(fileName);
        } catch (Exception ex) {
            ErrorView.display("ReportMenuView", ex.getMessage());
        }

        
    }
    
     
     
    private void saveItemLocationReport(String fileName) {  
        
        Game game = PemberleyGame.getCurrentGame(); // access to data
        Item[] allItemArray = game.getAllItemArray(); // form with the item's info
        boolean success = true;
        
        try (PrintWriter outFile = new PrintWriter(fileName)) { // try-with-resources 
            
// make headers for the report.
            outFile.println("\n\n          ITEM LOCATION REPORT          ");        
            outFile.printf("%n%-30s%-14s", "Item Name", "Location");
            outFile.printf("%n%-30s%-14s", "---------", "--------");

// print item name and location
            for(Item item : allItemArray){ // goes through all the items
                // null check - won't call a locationName if = null
                String location = "not applicable"; // if location is null, print this
                
                if (item.getLocation() != null){ // otherwise print locationName
                    location = item.getLocation().getName();
                }
                outFile.printf("%n%-30s%-14s", item.getName()
                                             , location);
            }
            
        } catch (IOException ex) {
            ErrorView.display("ReportMenuView", ex.getMessage());
            success = false;
        }
//3d
               if (success) {
                   this.console.println("The Item Location Report was saved to\n "
                            + "'" + fileName + ".txt'");     
               }
    }
                
    

       private void inventoryReport() {

        this.console.println("\n\nEnter a file name where this report will "
                            + "be saved. Type X to exit");

        String fileName = this.getInput();


            if (fileName.equalsIgnoreCase("x")){ 
            return;
        }

        try {
            InventoryControl inventoryControl = new InventoryControl();
            inventoryControl.saveInventoryReport(fileName);
        } catch (Exception ex) {
            ErrorView.display("ReportMenuView", ex.getMessage());
            return;
        }
        this.console.println("\nThe Inventory Report was saved to\n "
                            + fileName + "\n");     
//exmaple C:\Users\Cody\Documents\NetBeansProjects\ir
    }
}
