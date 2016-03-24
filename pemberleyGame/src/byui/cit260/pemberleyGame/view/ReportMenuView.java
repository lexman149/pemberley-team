/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pemberleyGame.view;

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
            case "T":
                this.itemReport();
                break;
            case "G":
                this.actorReport();
                break;
            case "S":
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

    private void actorReport() {
         this.console.println("*** actorReport function called ***");
    }

    private void inventoryReport() {
             this.console.println("*** inventoryReport function called ***");
    }
}
