
/*
 * Test files - instances of the classes
 */
package pemberley_game;

import byui.cit260.pemberleyGame.control.*;
import byui.cit260.pemberleyGame.model.*;



/**
 *
 * @author jpmanning
 */
public class PemberleyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Player playerOne = new Player();
//All room instances by Melissa Marriott



Room rmMilliner = new Room();

Room rmBackStaircase = new Room();

Room rmBallroom = new Room();

Room rmCellar = new Room();

Room rmCloset = new Room();

Room rmDiningRoom = new Room();

Room rmDrawingRoom = new Room();

Room rmDownstairsHall = new Room();

Room rmEntry = new Room();

Room rmFrontDrive = new Room();

Room rmGallery = new Room();

Room rmGarden = new Room();

Room rmGrandStaircase = new Room();

Room rmGreatHall = new Room();

Room rmGreen = new Room();

Room rmGrocer = new Room();

Room rmLake = new Room();

Room rmKitchen = new Room();

Room rmLarder = new Room();

Room rmLivingRoom = new Room();

Room rmLibrary = new Room();

Room rmMusicRoom = new Room();

Room rmNathanielBedroom = new Room();

Room rmPath = new Room();

Room rmRoseBedroom = new Room();

Room rmRoadEast = new Room();

Room rmRoadWest = new Room();

Room rmSecretLab = new Room();

Room rmServantsQuarters = new Room();

Room rmSmithy = new Room();

Room rmStable = new Room();

Room rmUpstairsHallWest = new Room();

Room rmUpstairsHallEast = new Room();



rmMilliner.setDescription("You are in a small Milliner's shop.  The hats are very beautiful but some of them are sort of strange too.");

rmMilliner.setName("Milliner");

rmMilliner.setSouth(rmRoadWest);

//end rmMilliner object instance

//start rmBackStaircase object instance

rmBackStaircase.setDescription("You are on the Back Staircase.  This leads to the lower floors where the kitchen and servant's quarters are.");

rmBackStaircase.setEast(rmKitchen);

rmBackStaircase.setName("Back Staircase");

rmBackStaircase.setSouth(rmDiningRoom);

//end rmBackStaircase object instance



//start rmBallroom object instance

rmBallroom.setDescription("You are in the Ballroom.  It is large and beautifully decorated for a ball.");

rmBallroom.setEast(rmGreatHall);

rmBallroom.setName("Ballroom");

rmBallroom.setNorth(rmMusicRoom);

//end rmBallroom object instance



//start rmCellar object instance

rmCellar.setDescription("You are in the Cellar.  Bottles of expensive wines and other liquors are stacked high against the walls.");

rmCellar.setName("Cellar");

rmCellar.setSouth(rmKitchen);

//end rmCellar object instance



//start rmCloset object instance

rmCloset.setDescription("You are in your Uncle Finneas' closet.  Here are all of the clothes he has collected over the years.");

rmCloset.setName("Closet");

rmCloset.setWest(rmLivingRoom);

//end rmCloset object instance



//start rmDiningRoom object instance

rmDiningRoom.setDescription("You are in the Dining Room.  The table is laden with dishes and silverware in preparation for the Ball tonight");

rmDiningRoom.setEast(rmLibrary);

rmDiningRoom.setName("Dining Room");

rmDiningRoom.setNorth(rmBackStaircase);

rmDiningRoom.setSouth(rmGreatHall);

rmDiningRoom.setWest(rmMusicRoom);

//end rmDiningRoom object instance



//start rmDownstairsHall object instance

rmDownstairsHall.setDescription("You are in a small dark hall in the lower floor.");

rmDownstairsHall.setName("Downstairs Hall");

rmDownstairsHall.setSouth(rmServantsQuarters);

rmDownstairsHall.setWest(rmKitchen);

//end rmDownstairsHall object instance



//start rmDrawingRoom object instance

rmDrawingRoom.setDescription("You are in a small and comfortable drawing room with windows facing full East.");

rmDrawingRoom.setName("Drawing Room");

rmDrawingRoom.setNorth(rmLibrary);

rmDrawingRoom.setWest(rmGreatHall);

//end rmDrawingRoom object instance



//start rmEntry object instance

rmEntry.setDescription("You are in the front Entry of Pemberley.  It is a very fashionable Entry.");

rmEntry.setName("Entry");

rmEntry.setNorth(rmGreatHall);

rmEntry.setSouth(rmFrontDrive);

rmEntry.setWest(rmGrandStaircase);

//end rmEntry object instance



//start rmFrontDrive object instance

rmFrontDrive.setDescription("You are on the Front Drive of Pemberley looking up at its impressive height and width.");

rmFrontDrive.setEast(rmPath);

rmFrontDrive.setName("Front Drive");

//end rmFrontDrive object instance



//start rmGallery object instance

rmGallery.setDescription("You are in the gallery.  There are several large and impressive paintings.  ");

rmGallery.setName("Gallery");

rmGallery.setSouth(rmUpstairsHallWest);

//end rmGallery object instance



//start rmGarden object instance

rmGarden.setDescription("You are in the expansive Gardens at Pemberley.  You think a person can spend many enjoyable hours here.");

rmGarden.setEast(rmStable);

rmGarden.setName("Garden");

rmGarden.setSouth(rmPath);

//end rmGarden object instance



//start rmGrandStaircase object instance

rmGrandStaircase.setDescription("You are on the Grand Staircase.  It is impressive as befits a staircase of Pemberley");

rmGrandStaircase.setEast(rmEntry);

rmGrandStaircase.setName("GrandStaircase");

rmGrandStaircase.setNorth(rmUpstairsHallWest);

//end rmGrandStaircase object instance



//start rmGreatHall object instance

rmGreatHall.setDescription("You are in the Great Hall.  It is very tall.");

rmGreatHall.setEast(rmDrawingRoom);

rmGreatHall.setName("Great Hall");

rmGreatHall.setNorth(rmDiningRoom);

rmGreatHall.setSouth(rmEntry);

rmGreatHall.setWest(rmBallroom);

//end rmGreatHall object instance



//start rmGreen object instance

rmGreen.setDescription("You are on the green next to the Smithy.  ");

rmGreen.setName("Green");

rmGreen.setWest(rmSmithy);

//end rmGreen object instance



//start rmGrocer object instance

rmGrocer.setDescription("You are in the Lambton Grocer");

rmGrocer.setName("Grocer");

rmGrocer.setNorth(rmRoadWest);

//end rmGrocer object instance



//start rmKitchen object instance

rmKitchen.setDescription("You are in the Kitchen.  It is very busy as the staff prepares for the Ball");

rmKitchen.setEast(rmDownstairsHall);

rmKitchen.setName("Kitchen");

rmKitchen.setNorth(rmCellar);

rmKitchen.setSouth(rmLarder);

rmKitchen.setWest(rmBackStaircase);

//end rmKitchen object instance



//start rmLake object instance

rmLake.setDescription("You are standing on the edge of a pretty lake.  Beneath the surface you can see carp, pike and ___ swimming");

rmLake.setName("Lake");

rmLake.setNorth(rmStable);

rmLake.setWest(rmPath);

//end rmLake object instance



//start rmLarder object instance

rmLarder.setDescription("You are in the Larder.  It is stacked high with jars and sacks of food and ingredients");

rmLarder.setName("Larder");

rmLarder.setNorth(rmKitchen);

//end rmLarder object instance



//start rmLibrary object instance

rmLibrary.setDescription("You are in the Library.  You can tell that someone who lives here is an extensive reader and takes great pleasure in reading.");

rmLibrary.setName("Library");

rmLibrary.setSouth(rmDrawingRoom);

rmLibrary.setWest(rmDiningRoom);

//end rmLibrary object instance



//start rmLivingRoom object instance

rmLivingRoom.setDescription("You are in the Living Room of your Uncle Finneas' House.  ");

rmLivingRoom.setEast(rmCloset);

rmLivingRoom.setName("Living Rom");

rmLivingRoom.setSouth(rmSecretLab);

//end rmLivingRoom object instance



//start rmMusicRoom object instance



rmMusicRoom.setDescription("You a re in the Music Room.  There is a lovely pianoforte in one corner and a couch good for sitting and looking broodingly on whoever might be playing.");

rmMusicRoom.setEast(rmDiningRoom);

rmMusicRoom.setName("Music Room");

rmMusicRoom.setSouth(rmBallroom);

//end rmMusicRoom object instance



//start rmNathanielBedroom object instance



rmNathanielBedroom.setDescription("You are in Mr Willoughby's room.");

rmNathanielBedroom.setName("Mr Ws Room");

rmNathanielBedroom.setNorth(rmUpstairsHallEast);

//end rmNathanielBedroom object instance



//start rmPath object instance



rmPath.setDescription("You are on a Path outside the main house");

rmPath.setEast(rmLake);

rmPath.setName("Path");

rmPath.setNorth(rmGarden);

rmPath.setWest(rmFrontDrive);

//end rmPath object instance



//start rmRoadEast object instance



rmRoadEast.setDescription("You are on a road in the town of Lambton");

rmRoadEast.setName("Road East");

rmRoadEast.setSouth(rmSmithy);

rmRoadEast.setWest(rmRoadWest);

//end rmRoadEast object instance



//start rmRoadWest object instance



rmRoadWest.setDescription("You are on a road in the town of Lambton");

rmRoadWest.setEast(rmRoadEast);

rmRoadWest.setName("Road West");

rmRoadWest.setNorth(rmMilliner);

rmRoadWest.setSouth(rmGrocer);

//end rmRoadWest object instance



//start rmRoseBedroom object instance



rmRoseBedroom.setDescription("You are in Miss Rose Brandon's room");

rmRoseBedroom.setName("Rose's Room");

rmRoseBedroom.setSouth(rmUpstairsHallEast);

//end rmRoseBedroom object instance



//start rmSecretLab object instance

rmSecretLab.setDescription("You are in your Uncle Finneas' secret lab.  Like your uncle it is a bit shabby and disorganized.");

rmSecretLab.setName("Secret Lab");

rmSecretLab.setNorth(rmLivingRoom);

//end rmSecretLab object instance



//start rmServantsQuarters object instance

rmServantsQuarters.setDescription("You are in one of the Servant's rooms");

rmServantsQuarters.setName("Servants ");

rmServantsQuarters.setNorth(rmDownstairsHall);

//end rmServantsQuarters object instance



//start rmSmithy object instance

rmSmithy.setDescription("You are in the Lambton Smithy");

rmSmithy.setEast(rmGreen);

rmSmithy.setName("Smithy");

rmSmithy.setNorth(rmRoadEast);

//end rmSmithy object instance



//start rmStable object instance

rmStable.setDescription("You are in the Stable.  Against one wall is a row of impressive horses.");

rmStable.setName("Stable");

rmStable.setSouth(rmLake);

rmStable.setWest(rmGarden);

//end rmStable object instance



//start rmUpstairsHallEast object instance
rmUpstairsHallEast.setDescription("You are in an upstairs hall.");
rmUpstairsHallEast.setName("Up Hall East");
rmUpstairsHallEast.setNorth(rmRoseBedroom);
rmUpstairsHallEast.setSouth(rmNathanielBedroom);
rmUpstairsHallEast.setWest(rmUpstairsHallWest);
//end rmUpstairsHallEast object instance



//start rmUpstairsHallWest object instance

rmUpstairsHallWest.setDescription("You are in an upstairs hall.");

rmUpstairsHallWest.setEast(rmUpstairsHallEast);

rmUpstairsHallWest.setName("Up Hall West");

rmUpstairsHallWest.setNorth(rmGallery);

rmUpstairsHallWest.setSouth(rmGrandStaircase);

//end rmUpstairsHallWest object instance


























      
      playerOne.setName("John Doe");
      playerOne.setLocation("Library");
      playerOne.setGender("Male");
      
      String playerInfo = playerOne.toString();
      System.out.println(playerInfo);

      
     
      
      
     String roomInfo = rmDrawingRoom.toString();
     System.out.println(roomInfo);
     
     // instances inserted by sheila //
    Game gameOne = new Game();
        
    gameOne.setTimeRemaining(45);

    String gameInfo = gameOne.toString();
    System.out.println(gameInfo);


    Map mapOne = new Map();

    mapOne.setName("Finneas house");
    mapOne.setRooms("Secret lab");

    String mapInfo = mapOne.toString();
    System.out.println(mapInfo);


    Item itemOne = new Item();
    itemOne.setDescription("love letter");
    itemOne.setLocation(rmLibrary);
    itemOne.setName("letter");
    itemOne.setTakable(true);
    String itemInfo = itemOne.toString();
    System.out.println(itemInfo);
    
    // instances inserted by alexis //
    Actor actorOne = new Actor();
    actorOne.setName("Mr. Darcy");
    actorOne.setLocation(rmBallroom);
    actorOne.setDescription("Tall dark gentlemen");
    actorOne.setCharacterScript("Hello, I'm Mr. Darcy");
    String actorInfo = actorOne.toString();
    System.out.println(actorInfo);

    Inventory inventoryOne = new Inventory();
    inventoryOne.setContents("key");
    String inventoryInfo = inventoryOne.toString();
    System.out.println(inventoryInfo);

      
      
}
    
}
