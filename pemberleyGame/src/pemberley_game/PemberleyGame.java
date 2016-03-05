
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
//initialize everything
//        MapControl mapControl = new MapControl();
        Player playerOne = new Player();
        Room rmLivingRoom = new Room();
        Room rmFinnKithen = new Room();
        Room rmSecretLab = new Room();
        Room rmBlocked = new Room();
        Item itBoxDogTreats = new Item();
        Item itDogTreats = new Item();
        Item itNote = new Item();
        Item itTimeMachine = new Item();
        Item itClothing = new Item();
        Item itFan = new Item();
        Item itTeaCup = new Item();
        Item itUmbrella = new Item();
        Item itCarriage = new Item();
        Item itRock = new Item();
        Item itWorms = new Item();
        Item itCane = new Item();
        Item itTrout = new Item();
        Item itMusic = new Item();
        Item itPianoForte = new Item();
        Item itFishingPole = new Item();
        Item itHeartCard = new Item();
        Item itCarrotBag = new Item();
        Item itCarrots = new Item();
        Item itOven = new Item();
        Item itContainerOfSweets = new Item();
        Item itEmptyContainer = new Item();
        Item itPocKetWatch = new Item();
        Item itLetter = new Item();
        Item itPaintng = new Item();
        Item itMoney = new Item();
        Item itRibbons = new Item();
        Item itChestnuts = new Item();
        Item itChestnutTree = new Item();
        Item itContainerOfWorms = new Item();
        Game gameOne = new Game();
        Actor atHamster = new Actor();
        Inventory inventoryOne = new Inventory();
        Quest qtHamster = new Quest();
        Quest qtTimeMachine = new Quest();
        Scanner in = new Scanner(System.in);
        InventoryControl inventoryControl = new InventoryControl();
        ActorControl actorControl = new ActorControl();
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
        Room rmLibrary = new Room();
        Room rmMusicRoom = new Room();
        Room rmNathanielBedroom = new Room();
        Room rmPath = new Room();
        Room rmRoseBedroom = new Room();
        Room rmRoadEast = new Room();
        Room rmRoadWest = new Room();
        Room rmServantsQuarters = new Room();
        Room rmSmithy = new Room();
        Room rmStable = new Room();
        Room rmUpstairsHallWest = new Room();
        Room rmUpstairsHallEast = new Room();
        Quest qtNote = new Quest();

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
        rmFrontDrive.setNorth(rmEntry);
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

//player initialization
        playerOne.setLocation(rmLivingRoom);

        rmLivingRoom.setName("Living Room");
        rmLivingRoom.setDescription("The Living room of your Uncle Finneas' house is stacked high with books.  In one corner sits his "
                + " Hamster Bruiser's cage.");
        rmLivingRoom.setVisited(true);
        rmLivingRoom.setNorth(rmFinnKithen);
        rmLivingRoom.setSouth(rmSecretLab);

        rmFinnKithen.setName("Kitchen");
        rmFinnKithen.setDescription("The Kitchen is one of the cleanest rooms in Uncle Finneas' house.  Probably because"
                + " He mostly likes to eat out.");
        rmFinnKithen.setSouth(rmLivingRoom);
        rmFinnKithen.setVisited(true);

        rmSecretLab.setName("Secret Laboratory");
        rmSecretLab.setDescription("Like your uncle Finneas, the Secret Laboratory is a bit shabby and disorganized");
        rmSecretLab.setNorth(rmLivingRoom);
        rmSecretLab.setVisited(true);
        rmSecretLab.setBlocked(true);
        rmSecretLab.setAlternateBlocked(false);

        itBoxDogTreats.setDescription("It is a box of dog treats sitting on the table");
        itBoxDogTreats.setLocation(rmFinnKithen);
        itBoxDogTreats.setName("Package of Dog Treats");
        itBoxDogTreats.setTakable(false);
        itBoxDogTreats.setMultiple(true);
        itBoxDogTreats.setContains(itDogTreats);
        itDogTreats.setQuantity(0);
        itDogTreats.setWeight(0.25);
        itDogTreats.setName("Dog Treats");
        itDogTreats.setDescription("These dog treats are shaped like bones and smell like... dog treats.  They are rather small.");
        itDogTreats.setTakable(true);

        itNote.setDescription("The note is being guarded by the hamster.  He won'tl let you get at the note");
        itNote.setLocation(rmLivingRoom);
        itNote.setName("A Note");
        itNote.setAlternateTakable(true);
        itNote.setTakable(false);
        itNote.setTakeMessage("The Hamster is guarding it.  He snarls and snaps at you when you try to take it");
        itNote.setAlternateDescription("It is a note from Uncle Finneas.  It tells you that he needs you to come get him in the past.");
        itNote.setWeight(0.25);

        itTimeMachine.setDescription("A Time Machine");
        itTimeMachine.setLocation(rmSecretLab);
        itTimeMachine.setName("The Time Machine");
        itTimeMachine.setTakable(true);
        itTimeMachine.setUsable(true);
        itTimeMachine.setQuest(qtTimeMachine);
        itTimeMachine.setWeight(2);
        qtTimeMachine.setPlayer(playerOne);
        qtTimeMachine.setPlayerDestination(rmPath);

        atHamster.setName("Bruiser the Hamster");
        atHamster.setLocation(rmLivingRoom);
        atHamster.setDescription("It is Uncle Finneas' Pet Hamster.  Uncle Finneas put dog brain matter in his head.");
        atHamster.setCharacterScript("GRRR.  Snarl.");
        atHamster.setAlternateCharacterScript("Woof Woof");
        atHamster.setQuest(qtHamster);
        qtHamster.setNeeds(itDogTreats);
        qtHamster.setItemToChange(itNote);
        qtHamster.setCompletionScript("Bruiser jumps on the dog treats and eats them with relish.  Then he licks your hand.");

        itCane.setName("Cane");
        itCane.setDescription("It looks like a cane fit for a great and snobbish lady.");
        itCane.setLocation(rmGrandStaircase);
        itCane.setQuantity(0);
        itCane.setTakable(true);
        itCane.setWeight(2);
        itCarriage.setAlternateLocation(rmFrontDrive);
        itCarriage.setAlternateUsable(true);
        itCarriage.setDescription("It is a very stately carriage");
        itCarriage.setLocation(rmStable);
        itCarriage.setName("Carriage");
        itCarriage.setQuantity(0);
        itCarriage.setTakeMessage("You think a whole carriage will fit in your backpack?");
        itCarriage.setWeight(200);
        itCarrotBag.setContains(itCarrots);
        itCarrotBag.setDescription("It is a burlap sack of carrots");
        itCarrotBag.setLocation(rmCellar);
        itCarrotBag.setMultiple(true);
        itCarrotBag.setName("Bag of Carrots");
        itCarrotBag.setQuantity(0);
        itCarrotBag.setWeight(21);
        itCarrots.setDescription("The carrots are orange and large.");
        itCarrots.setLocation(null);
        itCarrots.setName("Carrots");
        itCarrots.setQuantity(0);
        itCarrots.setTakable(true);
        itCarrots.setWeight(0.25);
        itChestnuts.setDescription("These are very large chestnuts");
        itChestnuts.setLocation(null);
        itChestnuts.setName("Chestnuts");
        itChestnuts.setQuantity(0);
        itChestnuts.setTakable(true);
        itChestnuts.setWeight(0.1);
        itChestnutTree.setContains(itChestnuts);
        itChestnutTree.setDescription("It is a large tree with chetnuts all over the ground underneath it.");
        itChestnutTree.setLocation(rmGreen);
        itChestnutTree.setMultiple(true);
        itChestnutTree.setName("Tree with Chestnuts");
        itChestnutTree.setQuantity(0);
        itChestnutTree.setWeight(400);
        itClothing.setAlternateDescription("You are wearing clothing you are sure was fashionable sometime in history");
        itClothing.setDescription("It is some historic clothing");
        itClothing.setLocation(rmCloset);
        itClothing.setName("Clothing");
        itClothing.setQuantity(0);
        itClothing.setTakable(true);
        itClothing.setUsable(true);
        itClothing.setWeight(0);
        itContainerOfSweets.setDescription("It is a container of sweets");
        itContainerOfSweets.setLocation(rmLarder);
        itContainerOfSweets.setName("Sweets");
        itContainerOfSweets.setQuantity(0);
        itContainerOfSweets.setTakable(true);
        itContainerOfSweets.setWeight(0.5);
        itContainerOfWorms.setAlternateLocation(inventoryOne);
        itContainerOfWorms.setDescription("It is a container of squirming earthworms.");
        itContainerOfWorms.setLocation(null);
        itContainerOfWorms.setName("Container of Worms");
        itContainerOfWorms.setQuantity(0);
        itContainerOfWorms.setTakable(true);
        itContainerOfWorms.setUsable(true);
        itContainerOfWorms.setWeight(0.5);
        itEmptyContainer.setAlternateLocation(inventoryOne);
        itEmptyContainer.setDescription("It is an empty tin that used to hold sweets");
        itEmptyContainer.setLocation(null);
        itEmptyContainer.setName("Empty Tin");
        itEmptyContainer.setQuantity(0);
        itEmptyContainer.setTakable(true);
        itEmptyContainer.setWeight(0.25);
        itFan.setDescription("It is a lacy lady's fan.");
        itFan.setLocation(rmBallroom);
        itFan.setName("Fan");
        itFan.setQuantity(0);
        itFan.setTakable(true);
        itFan.setWeight(0.3);
        itFishingPole.setAlternateLocation(rmMusicRoom);
        itFishingPole.setDescription("It is a fishing pole fit for a gentleman.");
        itFishingPole.setLocation(null);
        itFishingPole.setName("Fishing Pole");
        itFishingPole.setQuantity(0);
        itFishingPole.setTakable(true);
        itFishingPole.setUsable(true);
        itFishingPole.setWeight(1);
        itHeartCard.setAlternateLocation(rmStable);
        itHeartCard.setDescription("It is a card that says \"Dear Sally.  I love you...\"");
        itHeartCard.setLocation(null);
        itHeartCard.setName("Heart-shaped card");
        itHeartCard.setQuantity(0);
        itHeartCard.setTakable(true);
        itHeartCard.setWeight(0.25);
        itLetter.setAlternateTakable(true);
        itLetter.setDescription("It is a letter from Nathaniel Willoughby for his father.  It says that Mr Willoughby is happy to report Jane Darcy will be rich.");
        itLetter.setLocation(rmNathanielBedroom);
        itLetter.setName("Letter");
        itLetter.setQuantity(0);
        itLetter.setWeight(0.25);
        itMoney.setAlternateLocation(inventoryOne);
        itMoney.setDescription("It is a little pile of coins");
        itMoney.setLocation(null);
        itMoney.setName("Money");
        itMoney.setQuantity(0);
        itMoney.setTakable(true);
        itMoney.setWeight(0.5);
        itMusic.setDescription("It appears to be some sheet music ");
        itMusic.setLocation(rmLibrary);
        itMusic.setName("Sheet Music");
        itMusic.setQuantity(0);
        itMusic.setTakable(true);
        itMusic.setWeight(0.25);
        itNote.setAlternateDescription("The note says that Uncle Finneas is stranded in the past.  Will you please find the time machine and come get him?");
        itNote.setAlternateTakable(true);
        itNote.setDescription("It is difficult to examine the note while it is in the Hamster's cage");
        itNote.setLocation(rmLivingRoom);
        itNote.setName("Note");
        itNote.setQuantity(0);
        itNote.setQuest(qtNote);
        itNote.setTakeMessage("When you try to take it, the Hamster snarls and tries to bite you.");
        itNote.setWeight(0.25);
        itOven.setAlternateDescription("It is very hot.  Someone is baking something");
        itOven.setDescription("The oven is currently cold");
        itOven.setLocation(rmKitchen);
        itOven.setName("Oven");
        itOven.setQuantity(0);
        itOven.setTakeMessage("Only you would try to take a whole oven.");
        itOven.setUsable(true);
        itOven.setWeight(100);
        itPaintng.setDescription("It is a painting of a young lady sighed E Woodhouse");
        itPaintng.setLocation(rmGallery);
        itPaintng.setName("Painting");
        itPaintng.setQuantity(0);
        itPaintng.setTakeMessage("I'm not sure the Darcys would appreciate you making off with their valuable painting");
        itPaintng.setWeight(21);
        itPianoForte.setDescription("It is a lovely piano forte.  It appears to be well used.");
        itPianoForte.setLocation(rmMusicRoom);
        itPianoForte.setName("Piano Forte");
        itPianoForte.setQuantity(0);
        itPianoForte.setTakeMessage("It won't fit in your backpack... and how rude is it to take a piano forte.");
        itPianoForte.setUsable(true);
        itPianoForte.setWeight(300);
        itPocKetWatch.setDescription("It is a gentleman's pocket watch");
        itPocKetWatch.setLocation(rmServantsQuarters);
        itPocKetWatch.setName("Pocket Watch");
        itPocKetWatch.setQuantity(0);
        itPocKetWatch.setTakable(true);
        itPocKetWatch.setUsable(true);
        itPocKetWatch.setWeight(0.5);
        itRibbons.setAlternateTakable(true);
        itRibbons.setDescription("It is a bunch of ribbons");
        itRibbons.setLocation(rmMilliner);
        itRibbons.setName("Ribbons");
        itRibbons.setQuantity(0);
        itRibbons.setTakeMessage("You think twice and decide not to steal the ribbons.");
        itRibbons.setWeight(0.5);
        itRock.setContains(itWorms);
        itRock.setDescription("It is a rock with some worms underneath");
        itRock.setLocation(rmGarden);
        itRock.setMultiple(true);
        itRock.setName("Rock");
        itRock.setQuantity(0);
        itRock.setWeight(10);
        itTeaCup.setDescription("It is a small porcelain tea cup ");
        itTeaCup.setLocation(rmDrawingRoom);
        itTeaCup.setName("Tea Cup");
        itTeaCup.setQuantity(0);
        itTeaCup.setTakable(true);
        itTeaCup.setWeight(0.5);
        itTimeMachine.setAlternateDescription("The main screen shows an error.");
        itTimeMachine.setAlternateUsable(true);
        itTimeMachine.setAlternateUsable(true);
        itTimeMachine.setName("Time Machine");
        itTimeMachine.setQuantity(0);
        itTimeMachine.setQuest(qtTimeMachine);
        itTimeMachine.setTakable(true);
        itTimeMachine.setWeight(2);
        itTimeMachine.setDescription("It is a time machine.  You have seen Uncle Finneas working on it before.  It looks like a tablet.");
        itTimeMachine.setLocation(rmSecretLab);
        itTrout.setAlternateTakable(true);
        itTrout.setDescription("It is a very big trout fit for a feast");
        itTrout.setLocation(rmLake);
        itTrout.setName("Trout");
        itTrout.setQuantity(0);
        itTrout.setWeight(2);
        itUmbrella.setDescription("It may be a parasol");
        itUmbrella.setLocation(rmEntry);
        itUmbrella.setName("Umbrella");
        itUmbrella.setQuantity(0);
        itUmbrella.setTakable(true);
        itUmbrella.setWeight(1);
        itWorms.setDescription("It is a bunch of earth worms.");
        itWorms.setLocation(null);
        itWorms.setName("Worms");
        itWorms.setQuantity(0);
        itWorms.setTakable(true);
        itWorms.setWeight(0.25);

        inventoryOne.setWeight(0);
        playerOne.setInventory(inventoryOne);

        Item allItems[] = {itBoxDogTreats, itNote, itTimeMachine};
        Actor allActors[] = {atHamster};

// create StartProgramViw and start the program
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.startProgram(playerOne, allItems, allActors);

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
