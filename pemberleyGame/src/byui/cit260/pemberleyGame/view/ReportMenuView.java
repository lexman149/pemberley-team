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
        String fileName = this.getInput();
        do{
         // getInput function in View.java
            if (fileName.equalsIgnoreCase("x")){ // without this here, the 'x' is seen as a filename.
            break;
        }
 // 3c
        try {
            // save the game to the specified file
            saveActorLocationReport(fileName);
        } catch (Exception ex) {
            ErrorView.display("ERROR", ex.getMessage());
        }
 // 3d
        this.console.println("The Actor Location Report was saved to\n "
                            + fileName);     
        }while (!fileName.equalsIgnoreCase("x"));
    }
   
     
     
    private void saveActorLocationReport(String fileName) {  
        
        Game game = PemberleyGame.getCurrentGame(); // access to data
        Actor[] allActorArray = game.getAllActorArray(); // form with the actor's info
        try (FileWriter outFile = new FileWriter(fileName)) { // try-with-resources 
            
// make headers for the report.
            outFile.write("\n\n          ACTOR LOCATION REPORT          ");        
            outFile.write("\nActor Name                     Location");
            outFile.write("\n----------                     --------");

// print actor name and location
            for(Actor actor : allActorArray){ // goes through all the actors
                // null check - won't call a locationName if = null
                String location = "not applicable"; // if location is null, print this
                if (actor.getLocation() != null){ // otherwise print locationName
                    location = actor.getLocation().getName();
                }
                else {
                outFile.write(actor.getName() + "\t" + actor.getLocation().getName() + "\n");
                } 
            }
        
//        try (PrintWriter out = new PrintWriter(fileName)) { // try-with-resources 
//            
//// make headers for the report.
//            out.println("\n\n          ACTOR LOCATION REPORT          ");        
//            out.printf("%n%-30s%14s", "Actor Name", "Location");
//            out.printf("%n%-30s%14s", "----------", "--------");
//
//// print actor name and location
//            for(Actor actor : allActorArray){ // goes through all the actors
//                // null check - won't call a locationName if = null
//                String location = "not applicable"; // if location is null, print this
//                if (actor.getLocation() != null){ // otherwise print locationName
//                    location = actor.getLocation().getName();
//                }
//                else {
//                out.printf("%n%-30s%14s", actor.getName()
//                                        , actor.getLocation().getName());
//                } 
//            }
            outFile.flush();
            
        } catch (IOException ex) {
            ErrorView.display("ReportMenuView", ex.getMessage());
        
        }
    }
    
    
    /*private void writeItemLocationReport() {
// 3a
        this.console.println("\n\nEnter a file name where this report will "
                            + "be saved. Type X to exit");
 // 3b  
        String fileName = this.getInput();
        do{
         // getInput function in View.java
           if (item.getLocation()!= null) { //otherwise print locationName
             outFile.write(item.getName() + "\t" + item.getLocation().getName() + "\n");
        }
        else { 
          outFile.write(item.getName() + "\t" + location + "\n");
        }
        }
 // 3c
        try {
            // save the game to the specified file
            saveItemLocationReport(fileName);
        } catch (Exception ex) {
            ErrorView.display("ERROR", ex.getMessage());
        }
 // 3d
        this.console.println("The Item Location Report was saved to\n "
                            + fileName);     
        }while (!fileName.equalsIgnoreCase("x"));
    }
     
     
    private void saveItemLocationReport(String fileName) {  
        
        Game game = PemberleyGame.getCurrentGame(); // access to data
        Item[] allItemArray = game.getAllItemArray(); // form with the item's info
        try (FileWriter outFile = new FileWriter(fileName)) { // try-with-resources 
            
// make headers for the report.
            outFile.write("\n\n          ITEM LOCATION REPORT          ");        
            outFile.write("\nItem Name                     Location");
            outFile.write("\n----------                     --------");

// print item name and location
            for(Item item : allItemArray){ // goes through all the items
                // null check - won't call a locationName if = null
                String location = "not applicable"; // if location is null, print this
                if (item.getLocation() != null){ // otherwise print locationName
                    location = item.getLocation().getName();
                }
                else {
                outFile.write(item.getName() + "\t" + item.getLocation().getName() + "\n");
                } 
            }
            
                 try (PrintWriter out = new PrintWriter(fileName)) { // try-with-resources 
//            
//// make headers for the report.
//            out.println("\n\n          ITEM LOCATION REPORT          ");        
//            out.printf("%n%-30s%14s", "Item Name", "Location");
//            out.printf("%n%-30s%14s", "----------", "--------");
//
//// print item name and location
//            for(Item item : allItemArray){ // goes through all the items
//                // null check - won't call a locationName if = null
//                String location = "not applicable"; // if location is null, print this
//                if (item.getLocation() != null){ // otherwise print locationName
//                    location = item.getLocation().getName();
//                }
//                else {
//                out.printf("%n%-30s%14s", item.getName()
//                                        , item.getLocation().getName());
//                } 
//            }
*/
    
   
   
         
    

    private void inventoryReport() {
             this.console.println("*** inventoryReport function called ***");
    }
}
