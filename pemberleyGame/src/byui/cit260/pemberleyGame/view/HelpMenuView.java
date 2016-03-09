 /*
 * Pemberley Game
 * BYUi CIT260
 * Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.view;


import byui.cit260.pemberleyGame.model.Game;


/**
 *
 * @author Sheila
 */
public class HelpMenuView extends View{

   public HelpMenuView(){
         super( "\n"
            + "\n----------------------------------------"
            + "\n | Help Menu"
            + "\n----------------------------------------"
            + "\nG - What is the goal of the game?"
            + "\nM - How do I move?"
            + "\nA - How do I use actions?"
            + "\nC - How do I talk to game characters?"
            + "\nP - What do I type at the prompt?"
            + "\nX - Exit"
            + "\n----------------------------------------"
            + "\nEnter your selection below:");
   }
    
   @Override
     public boolean doAction(String value, Game game) {
        
        switch(value){
            case "G":
                this.displayHelpGoal(); // display help for the goal of the game
                break;
            case "M":
                this.displayHelpMove(); // display help for how to move
                break;
            case "A":
                this.displayHelpAction(); // display help for how to use actions
                break;
            case "C":
                this.displayHelpTalk(); // display help for how to talk to characters
                break;
           case "P":
                this.displayHelpType(); // display help for what to type at the prompt
                break;                
            case "X": // quit help 
                return true; 
            default:
                System.out.println("\n***Invalid Selection *** Try Again");
                return false;
        }
return false;
    }

    private void displayHelpGoal() {
        System.out.println("*** displayHelpGoal function called ***");
    }

    private void displayHelpMove() {
        System.out.println("*** displayHelpMove function called ***");
    }

    private void displayHelpAction() {
        System.out.println("*** displayHelpAction function called ***");
    }

    private void displayHelpTalk() {
        System.out.println("*** displayHelpTalk function called ***");
    }

    private void displayHelpType() {
        System.out.println("*** displayHelpType function called ***");
    }
}
    

