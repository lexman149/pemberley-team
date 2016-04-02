/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.*;
import byui.cit260.pemberleyGame.model.User;
import byui.cit260.permberleyGame.exceptions.GameControlException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import pemberley_game.PemberleyGame;

/**
 *
 * @author mbp
 */
public class GameControl {

    public static void createNewGame(User player) {

        Game game = new Game(); // create new game
        PemberleyGame.setCurrentGame(game); //save

        game.setUser(player);
        GameControl.createGameObjects();

    }

    public static void createGameObjects() {
        Game game = PemberleyGame.getCurrentGame();
        Actor atCarter = new Actor();
        Actor atDaisy = new Actor();
        Actor atGeorgie = new Actor();
        Actor atJaneDarcy = new Actor();
        Actor atJonathan = new Actor();
        Actor atLadyCatherine = new Actor();
        Actor atLadyRoslyn = new Actor();
        Actor atLordRandolph = new Actor();
        Actor atMarshall = new Actor();
        Actor atMissNorwood = new Actor();
        Actor atMrBarns = new Actor();
        Actor atMrDarcy = new Actor();
        Actor atMrHarmon = new Actor();
        Actor atMrsDarcy = new Actor();
        Actor atOliveNelson = new Actor();
        Actor atRabbit = new Actor();
        Actor atRoberDarcy = new Actor();
        Actor atRoseBrandon = new Actor();
        Actor atSally = new Actor();
        Actor atUncleFinneas = new Actor();
        Actor atWilliam = new Actor();
        Actor atWilloughby = new Actor();
        Actor atHamster = new Actor();
        ActorControl actorControl = new ActorControl();
        Game gameOne = new Game();
        Inventory inventoryOne = new Inventory();
        InventoryControl inventoryControl = new InventoryControl();
        Item itBoxDogTreats = new Item();
        Item itCane = new Item();
        Item itCarriage = new Item();
        Item itCarrotBag = new Item();
        Item itCarrots = new Item();
        Item itChestnuts = new Item();
        Item itChestnutTree = new Item();
        Item itClothing = new Item();
        Item itContainerOfSweets = new Item();
        Item itContainerOfWorms = new Item();
        Item itDogTreats = new Item();
        Item itBall = new Item ();
        Item itEmptyContainer = new Item();
        Item itFan = new Item();
        Item itFishingPole = new Item();
        Item itHeartCard = new Item();
        Item itLetter = new Item();
        Item itMoney = new Item();
        Item itMusic = new Item();
        Item itNote = new Item();
        Item itOven = new Item();
        Item itPaintng = new Item();
        Item itPianoForte = new Item();
        Item itPocKetWatch = new Item();
        Item itRibbons = new Item();
        Item itRock = new Item();
        Item itTeaCup = new Item();
        Item itTimeMachine = new Item();
        Item itTrout = new Item();
        Item itUmbrella = new Item();
        Item itWorms = new Item();
        Map mpFinneasHouse = new Map();
        Map mpPemberleyMain = new Map();
        Map mpPemberleyLower = new Map();
        Map mpPemberleyUpper = new Map();
        Map mpLambton = new Map();
        Player playerOne = new Player();
        Quest qtCane = new Quest();
        Quest qtCarrots = new Quest();
        Quest qtCarter = new Quest();
        Quest qtCoach = new Quest();
        Quest qtCook = new Quest();
        Quest qtDaisy = new Quest();
        Quest qtGrocer = new Quest();
        Quest qtJaneDarcy = new Quest();
        Quest qtLadyRoslyn = new Quest();
        Quest qtLake = new Quest();
        Quest qtMiliner = new Quest();
        Quest qtMrDarcy = new Quest();
        Quest qtMrsDarcy = new Quest();
        Quest qtRabbit = new Quest();
        Quest qtRandolph = new Quest();
        Quest qtRose = new Quest();
        Quest qtSally = new Quest();
        Quest qtSweets = new Quest();
        Quest qtHamster = new Quest();
        Quest qtNote = new Quest();
        Quest qtTimeMachine = new Quest();
        Room rmBackStaircase = new Room();
        Room rmBallroom = new Room();
        Room rmBlocked = new Room();
        Room rmCellar = new Room();
        Room rmCloset = new Room();
        Room rmDiningRoom = new Room();
        Room rmDownstairsHall = new Room();
        Room rmDrawingRoom = new Room();
        Room rmEntry = new Room();
        Room rmFinnKitchen = new Room();
        Room rmFrontDrive = new Room();
        Room rmGallery = new Room();
        Room rmGarden = new Room();
        Room rmGrandStaircase = new Room();
        Room rmGreatHall = new Room();
        Room rmGreen = new Room();
        Room rmGrocer = new Room();
        Room rmKitchen = new Room();
        Room rmLake = new Room();
        Room rmLarder = new Room();
        Room rmLibrary = new Room();
        Room rmLivingRoom = new Room();
        Room rmMilliner = new Room();
        Room rmMusicRoom = new Room();
        Room rmNathanielBedroom = new Room();
        Room rmPath = new Room();
        Room rmRoadEast = new Room();
        Room rmRoadWest = new Room();
        Room rmRoseBedroom = new Room();
        Room rmSecretLab = new Room();
        Room rmServantsQuarters = new Room();
        Room rmSmithy = new Room();
        Room rmStable = new Room();
        Room rmUpstairsHallEast = new Room();
        Room rmUpstairsHallWest = new Room();
        Scanner in = new Scanner(System.in);




          
        atCarter.setAlternateCharacterScript("Carter says \"Thank you for finding the tea cup\"");
        atCarter.setAlternateDescription("Carter is relieved that you have found the tea cup.");
        atCarter.setCharacterScript("Cater says \"I seem to have misplaced a tea cup.\"");
        atCarter.setDescription("Carter, is a footman. He appears very distressed.");
        atCarter.setLocation(rmDiningRoom);
        atCarter.setName("Carter the Footman");
        atCarter.setQuest(qtCarter);
        atDaisy.setAlternateCharacterScript("Daisy says \"Thank you for your help.\"");
        atDaisy.setAlternateDescription("Daisy is mixing up some cake batter");
        atDaisy.setAlternateLocation(rmKitchen);
        atDaisy.setCharacterScript("Daisy says \"I seem to have misplaced cook's best cake recipe\"");
        atDaisy.setDescription("Daisy is looking all over the cellar for something");
        atDaisy.setLocation(rmCellar);
        atDaisy.setName("Daisy an undercook");
        atDaisy.setQuest(qtDaisy);
        atGeorgie.setCharacterScript("Georgie says \"Mrs Darcy said I could catch fish her for my family but I broke my fishing pole\"");
        atGeorgie.setAlternateCharacterScript("Georgie says \"Thank you for letting me borrow the fishing pole.\"");
        atGeorgie.setDescription("A young boy sits and lounges by the side of the lake.");
        atGeorgie.setLocation(rmLake);
        atGeorgie.setName("Georgie");
        atGeorgie.setQuest(qtLake);
        atHamster.setAlternateCharacterScript("Bruiser says \"Woof Woof\"");
        atHamster.setCharacterScript("Bruiser says\" GRRR.  Snarl.\"");
        atHamster.setDescription("It is Uncle Finneas' Pet Hamster. Uncle Finneas put dog brain matter in his head.");
        atHamster.setLocation(rmLivingRoom);
        atHamster.setName("Bruiser the Hamster");
        atHamster.setQuest(qtHamster);
        atJaneDarcy.setAlternateCharacterScript("She appears too busy to speak.");
        atJaneDarcy.setAlternateDescription("Jane Darcy is playing the Piano Forte beautifully.");
        atJaneDarcy.setCharacterScript("Jane Darcy says \"Where is it... where is it...\"");
        atJaneDarcy.setDescription("Jane Darcy is the eldest child of Mr and Mrs Darcy. Right now she seems very concerned as she searches the music room for something.");
        atJaneDarcy.setLocation(rmMusicRoom);
        atJaneDarcy.setName("Jane Darcy");
        atJaneDarcy.setQuest(qtJaneDarcy);
        atJonathan.setAlternateLocation(rmMusicRoom);
        atJonathan.setCharacterScript("Jonathan Ferrars says\"You may borrow my fishing pole if you want.\"");
        atJonathan.setDescription("Jonathan Ferrars seems enthralled by Jane Darcy's playing.");
        atJonathan.setLocation(null);
        atJonathan.setName("Jonathan Ferrars");
        atLadyCatherine.setAlternateCharacterScript("Lady Catherine says \"Thank you for finding my cane.\"");
        atLadyCatherine.setCharacterScript("Lady Catherine says \"I have misplaced my cane.\"");
        atLadyCatherine.setDescription("Lady Catherine is looking at a painting on the wall signed E Woodhouse.");
        atLadyCatherine.setLocation(rmGallery);
        atLadyCatherine.setName("Lady Catherine");
        atLadyCatherine.setQuest(qtCane);
        atLadyRoslyn.setAlternateCharacterScript("Lady Roslyn says \"Thank you for finding my umbrella\"");
        atLadyRoslyn.setAlternateDescription("Lady Roslyn smiles as she strolls under her umbrella");
        atLadyRoslyn.setCharacterScript("Lady Roslyn says \"I can't seem to find  my umbrella anywhere.  Have you seen it?\"");
        atLadyRoslyn.setDescription("Lady Roslyn seems to be looking around for something.");
        atLadyRoslyn.setLocation(rmGarden);
        atLadyRoslyn.setName("Lady Roslyn");
        atLadyRoslyn.setQuest(qtLadyRoslyn);
        atLordRandolph.setAlternateCharacterScript("Lord Randolph says \"Thank you for finding my pocket watch\"");
        atLordRandolph.setAlternateDescription("Lord Randolph takes his pocket watch out and smiles down at the time before safely securing it back in his pocket.");
        atLordRandolph.setCharacterScript("Lord Randolph says \"Have you seen a pocket watch laying around somewhere?\"");
        atLordRandolph.setDescription("Lord Randolph seems a bit frazzled.  He keeps patting his pockets.  You wonder if he is missing something.");
        atLordRandolph.setLocation(rmDrawingRoom);
        atLordRandolph.setName("Lord Randolph");
        atLordRandolph.setQuest(qtRandolph);
        atMarshall.setAlternateCharacterScript("Marshall says \"Ready and willing!\"");
        atMarshall.setAlternateDescription("The coachman stands ready to assist you into the coach.");
        atMarshall.setCharacterScript("Marshall says \"I am Marshall, the coachman.  The coach isn't ready at present.  I wonder what is taking the stable hand so long.\"");
        atMarshall.setDescription("The coachman seems forlorn here without a coach to tend.  You wonder where the coach is.");
        atMarshall.setLocation(rmFrontDrive);
        atMarshall.setName("Marshall the Coachman");
        atMarshall.setQuest(qtCoach);
        atMissNorwood.setCharacterScript("The Milliner says \"My ribbons cost a schilling each.\"");
        atMissNorwood.setDescription("The Milliner smiles at you expectantly.");
        atMissNorwood.setLocation(rmMilliner);
        atMissNorwood.setName("Miss Norwood the Milliner");
        atMissNorwood.setQuest(qtMiliner);
        atMrBarns.setCharacterScript("Mr Barns says \"I do have a chestnut tree out back.\"");
        atMrBarns.setDescription("The Smithy is busy making metal things");
        atMrBarns.setLocation(rmSmithy);
        atMrBarns.setName("Mr Barns the Smithy");
        atMrDarcy.setAlternateCharacterScript("Mr Darcy says \"Thank you very much for the information.  I will not stand in the way of my daughter and Mr Ferrars.\"");
        atMrDarcy.setAlternateDescription("Mr Darcy seems very grateful to you for finding the incriminating letter.");
        atMrDarcy.setAlternateLocation(rmBallroom);
        atMrDarcy.setCharacterScript("Mr Darcy says \"I do not have time to speak right now.\"");
        atMrDarcy.setDescription("Mr Darcy is a tall brooding gentleman, a  little on the proud side.");
        atMrDarcy.setLocation(null);
        atMrDarcy.setName("Mr Darcy");
        atMrDarcy.setQuest(qtMrDarcy);
        atMrHarmon.setAlternateCharacterScript("Mr Harmon says \"Thank you for the chestnuts.\"");
        atMrHarmon.setAlternateDescription("The grocer is busy helping other shoppers.");
        atMrHarmon.setCharacterScript("Mr Harmon says \"I seem to be running low on chestnuts.  I will give you some money if you bring me some.\"");
        atMrHarmon.setDescription("The Grocer frowns down at an empty barrel labeled \"chestnuts\".");
        atMrHarmon.setLocation(rmGrocer);
        atMrHarmon.setName("Mr Harmon the Grocer");
        atMrHarmon.setQuest(qtGrocer);
        atMrsDarcy.setAlternateCharacterScript("Mrs Darcy says \"Thank you for finding my fan.\"");
        atMrsDarcy.setAlternateDescription("Mrs Darcy waves a beautiful fan in front of her.");
        atMrsDarcy.setCharacterScript("Mrs Darcy says \"Have you seen a fan?  It was given to me by Mr Darcy when we were in Vienna.\"");
        atMrsDarcy.setDescription("Mrs Darcy his a beautiful woman with fine eyes.");
        atMrsDarcy.setLocation(rmGrandStaircase);
        atMrsDarcy.setName("Mrs Darcy");
        atMrsDarcy.setQuest(qtMrsDarcy);
        atOliveNelson.setAlternateCharacterScript("The cook says \"Thank you for bringing the trout\"");
        atOliveNelson.setAlternateDescription("The cook is fixing the trout you caught.");
        atOliveNelson.setCharacterScript("The cook says \"That boy should have been back by now with the trout...\"");
        atOliveNelson.setDescription("The cook seems preoccupied as she pours over her cookbooks");
        atOliveNelson.setLocation(rmKitchen);
        atOliveNelson.setName("Olive Nelson the Cook");
        atOliveNelson.setQuest(qtCook);
        atRabbit.setAlternateDescription("The rabbit eats his carrot gratefully.");
        atRabbit.setCharacterScript("\"...\"");
        atRabbit.setDescription("There is a small white rabbit here but he doesn't appear to be late for any important dates.”");
        atRabbit.setLocation(rmPath);
        atRabbit.setName("A rabbit");
        atRabbit.setQuest(qtRabbit);
        atRoberDarcy.setAlternateCharacterScript("Robert Darcy says \"Thank you for the sweets!\"");
        atRoberDarcy.setAlternateDescription("Robert Darcy munches on sweets as he examines a large atlas.");
        atRoberDarcy.setCharacterScript("Robert Darcy says \"The cook won't let me go get any sweets.  She says they are too busy preparing for the ball and I should go play.\"");
        atRoberDarcy.setDescription("Robert Darcy is the youngest son of Mr and Mrs Darcy.  He is sitting under a table examining a very large and detailed atlas.");
        atRoberDarcy.setLocation(rmLibrary);
        atRoberDarcy.setName("Robert Darcy");
        atRoberDarcy.setQuest(qtSweets);
        atRoseBrandon.setAlternateCharacterScript("Rose Brandon says \"Thank you for buying me some ribbons.  The are very lovely.\"");
        atRoseBrandon.setAlternateDescription("Rose is busy arranging the ribbons in her hair.");
        atRoseBrandon.setCharacterScript("Rose Brandon says \"Where have I put my ribbons?\"");
        atRoseBrandon.setDescription("Rose Brandon is looking around her vanity for something");
        atRoseBrandon.setLocation(rmRoseBedroom);
        atRoseBrandon.setName("Rose Brandon");
        atRoseBrandon.setQuest(qtRose);
        atSally.setAlternateCharacterScript("Sally says \"Love is a strange thing, Isn't it. Sigh.\"");
        atSally.setAlternateDescription("Sally is speaking to Nathaniel Willoughby.");
        atSally.setAlternateLocation(rmUpstairsHallWest);
        atSally.setCharacterScript("She appears to be too busy talking to Mr Willoughby.");
        atSally.setDescription("Sally  the scullery maid seems a little sad.");
        atSally.setLocation(rmServantsQuarters);
        atSally.setName("Sally a Scullery Maid");
        atSally.setQuest(qtSally);
        atUncleFinneas.setCharacterScript("Uncle Finneas says \"So glad you have come.  We must get the paradox fixed before we return to our time.\"");
        atUncleFinneas.setDescription("Uncle Finneas looks comfortable in his historic clothing.");
        atUncleFinneas.setLocation(rmGreatHall);
        atUncleFinneas.setName("Uncle Finneas");
        atWilliam.setAlternateLocation(rmMilliner);
        atWilliam.setAlternateDescription("William the Stablehand appears to be looking"
                                        + "\nat a pretty little hat.  Is it for a girl"
                                        + "\nhe likes?");
        atWilliam.setCharacterScript("William says \"I don't have time to get the coach ready.  These horses are being difficult.\"");
        atWilliam.setDescription("William the Stable hand appears to be having some trouble with the horses  He seems a little distracted himself.");
        atWilliam.setLocation(rmStable);
        atWilliam.setName("William a Stable Hand");
        atWilliam.setQuest(qtCarrots);
        atWilloughby.setAlternateCharacterScript("He appears to be quite busy talking to Sally.");
        atWilloughby.setAlternateDescription("Mr Willoughby seems quite stricken by the pretty Sally but you suspect his motives.");
        atWilloughby.setCharacterScript("Mr Willoughby says \"What are you doing in my room?\"");
        atWilloughby.setDescription("Mr Willoughby doesn't seem very happy to see you in his room.");
        atWilloughby.setLocation(rmNathanielBedroom);
        atWilloughby.setName("Mr Nathaniel Willoughby");
        itBall.setDescription("A plastic ball for hamsters to roll around on the floor");
        itBall.setLocation(rmFinnKitchen);
        itBall.setMultiple(false);
        itBall.setName("Hamster exercise ball");
        itBoxDogTreats.setContains(itDogTreats);
        itBoxDogTreats.setDescription("It is a box of dog treats sitting on the table");
        itBoxDogTreats.setLocation(rmFinnKitchen);
        itBoxDogTreats.setMultiple(true);
        itBoxDogTreats.setName("Package of Dog Treats");
        itBoxDogTreats.setTakable(false);
        itCane.setDescription("It looks like a cane fit for a great and snobbish lady.");
        itCane.setLocation(rmGrandStaircase);
        itCane.setName("Cane");
        itCane.setQuantity(0);
        itCane.setTakable(true);
        itCane.setWeight(2);
        itCarriage.setAlternateLocation(rmFrontDrive);
        itCarriage.setAlternateUsable(true);
        itCarriage.setDescription("It is a very stately carriage");
        itCarriage.setLocation(rmStable);
        itCarriage.setName("Carriage");
        itCarriage.setQuantity(0);
        itCarriage.setQuest(qtCoach);
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
        itCarrots.setLocation(inventoryOne);
        itCarrots.setName("Carrots");
        itCarrots.setQuantity(5);
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
        itClothing.setWeight(20);
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
        itDogTreats.setDescription("These dog treats are shaped like bones and smell like... dog treats.  They are rather small.");
        itDogTreats.setName("Dog Treats");
        itDogTreats.setQuantity(0);
        itDogTreats.setTakable(true);
        itDogTreats.setWeight(0.25);
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
        itNote.setAlternateDescription("It is a note from Uncle Finneas.  It tells you that he needs you to come get him in the past.");
        itNote.setAlternateDescription("The note says that Uncle Finneas is stranded in the past.  Will you please find the time machine and come get him?");
        itNote.setAlternateTakable(true);
        itNote.setAlternateTakable(true);
        itNote.setDescription("It is difficult to examine the note while it is in the Hamster's cage");
        itNote.setDescription("The note is being guarded by the hamster.  He won'tl let you get at the note");
        itNote.setLocation(rmLivingRoom);
        itNote.setLocation(rmLivingRoom);
        itNote.setName("A Note");
        itNote.setName("Note");
        itNote.setQuantity(0);
        itNote.setQuest(qtNote);
        itNote.setTakable(false);
        itNote.setTakeMessage("When you try to take it, the Hamster snarls and tries to bite you.");
        itNote.setWeight(0.25);
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
        itPianoForte.setUseMessage("You play that piece beautifully");
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
        itRock.setName("Rock with worms");
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
        itTimeMachine.setDescription("A Time Machine");
        itTimeMachine.setDescription("It is a time machine.  You have seen Uncle Finneas working on it before.  It looks like a tablet.");
        itTimeMachine.setLocation(rmSecretLab);
        itTimeMachine.setLocation(rmSecretLab);
        itTimeMachine.setName("The Time Machine");
        itTimeMachine.setName("Time Machine");
        itTimeMachine.setQuantity(0);
        itTimeMachine.setQuest(qtTimeMachine);
        itTimeMachine.setTakable(true);
        itTimeMachine.setTakable(true);
        itTimeMachine.setUsable(true);
        itTimeMachine.setWeight(2);
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
        itUmbrella.setUseMessage("Didn't anyone ever tell you that it isn't polite to use other people's umbrellas?");
        itUmbrella.setWeight(1);
        itWorms.setDescription("It is a bunch of earth worms.");
        itWorms.setLocation(null);
        itWorms.setName("Worms");
        itWorms.setTakeMessage("You have nothing to put the worms in");
        itWorms.setAlternateTakeMessage("Those worms are squirmy");
        itWorms.setQuantity(0);
        itWorms.setTakable(false);
        itWorms.setAlternateTakable(true);
        itWorms.setWeight(0.25);
        playerOne.setLocation(rmStable);
        qtCane.setNeeds(itCane);
        qtCane.setCompletionScript("Lady Catherine thanks you for the return of her cane.");
        qtCarrots.setItemToChange(itCarriage);
        qtCarrots.setNeeds(itCarrots);
        qtCarrots.setCompletionScript("William seems very grateful for the carrots.  "
                                    + "\nHe feeds them to the horses and then gets "
                                    + "\nthe carriage ready");
        qtCarter.setNeeds(itTeaCup);
        qtCarter.setCompletionScript("Carter smiles and accepts the tea cup.");
        qtCoach.setPlayer(playerOne);
        qtCoach.setPlayerDestination(rmRoadWest);
        qtCoach.setCompletionScript("Marshall helps you into the carriage"
                                  + "\nand it takes you to a quaint"
                                  + "\nvillage");
        qtCook.setNeeds(itTrout);
        qtCook.setCompletionScript("The cook is thrilled to finally get"
                                + "\nthe trout at last.");
        qtGrocer.setNeeds(itChestnuts);
        qtGrocer.setCompletionScript("The grocer thanks you for the chestnuts.");
        qtHamster.setActorToChange(atHamster);
        qtHamster.setCompletionScript("Bruiser jumps on the dog treats and eats them with relish.  Then he licks your hand.");
        qtHamster.setItemToChange(itNote);
        qtHamster.setNeeds(itDogTreats);
        qtJaneDarcy.setNeeds(itMusic);
        qtJaneDarcy.setItemToChange(itFishingPole);
        qtJaneDarcy.setActorToChange(atJonathan);
        qtJaneDarcy.setCompletionScript("Jane claps in delight and sits at"
                                      + "\nthe piano forte.  She begins to "
                                      + "\nplay.  In a moment a young man"
                                      + "\ncomes in and sits in a nearby"
                                      + "\ncouch.  He stares at Miss"
                                      + "\nDarcy in admiration.");
        qtLadyRoslyn.setNeeds(itUmbrella);
        qtLadyRoslyn.setCompletionScript("Lady Roslyn seems thrilled to get the umbrella.  She thanks you.");
        qtLake.setNeeds(itFishingPole);
        qtLake.setItemToChange(itTrout);
        qtLake.setCompletionScript("Georgie baits the fishing pole and catches"
                                 + "\na large trout for his family.  Then he"
                                 + "\ncatches one for you.");
        qtMiliner.setNeeds(itMoney);
        qtMiliner.setItemToChange(itRibbons);
        qtMiliner.setCompletionScript("The Miliner hands you ribbons.");
        qtMrDarcy.setNeeds(itLetter);
        qtMrDarcy.setActorToChange(atMrDarcy);
        qtMrDarcy.setCompletionScript("Mr Darcy reads the letter and anger"
                                    + "\ninfuses his features.  He stalks"
                                    + "\nover to Mr Willoughby and whispers"
                                    + "\nin his ear.  The next moment a servant"
                                    + "\nhands Mr Willoughby his hat and coat.");
        qtMrsDarcy.setNeeds(itFan);
        qtMrsDarcy.setCompletionScript("Mrs Darcy seems very happy to get her fan.");
        qtRabbit.setNeeds(itCarrots);
        qtRabbit.setCompletionScript("The rabbit gladly takes the carrot and hops"
                                   + "\ninto the bushes.  Peering through the leaves"
                                    + "\nyou see the rabbit drop the carrot in front"
                                    +"\nof a dozen baby rabbits.  They eat the carrot"
                                    + "\nravenously.");
        qtRandolph.setNeeds(itPocKetWatch);
        qtRandolph.setCompletionScript("Lord Randolph smiles as he accepts his watch.");
        qtRose.setNeeds(itRibbons);
        qtRose.setCompletionScript("Rose Brandon is happy to have ribbons.");
        qtSally.setNeeds(itHeartCard);
        qtSally.setActorToChange(atWilloughby);
        qtSally.setCompletionScript("Sally reads the card and smiles."
                                  + "\nShe says \"Thank you for bringing this"
                                  + "\nto me.  If there is anything I can do "
                                  + "\nfor you, just ask.");
        qtSweets.setNeeds(itContainerOfSweets);
        qtSweets.setItemToChange(itEmptyContainer);
        qtTimeMachine.setCompletionScript("\nThe lights start to dim. Your world"		
              + "\ndances with colors and movement."		
              + "\nEverything goes dark.  When you "		
              + "\nat last reach conciousness again"		
              + "\nYou find that you are standing"		
              + "\nnext to a great and stately mansion."		
              + "\nWhere are you?  Or better yet, when "		
              + "\nare you?");		
        qtTimeMachine.setPlayer(playerOne);
        qtTimeMachine.setPlayerDestination(rmPath);
        rmBackStaircase.setDescription("You are on the Back Staircase.  This leads to the lower floors where the kitchen and servant's quarters are.");
        rmBackStaircase.setEast(rmKitchen);
        rmBackStaircase.setName("Back Staircase");
        rmBackStaircase.setSouth(rmDiningRoom);
        rmBallroom.setDescription("You are in the Ballroom.  It is large and beautifully decorated for a ball.");
        rmBallroom.setEast(rmGreatHall);
        rmBallroom.setName("Ballroom");
        rmBallroom.setNorth(rmMusicRoom);
        rmCellar.setDescription("You are in the Cellar.  Bottles of expensive wines and other liquors are stacked high against the walls.");
        rmCellar.setName("Cellar");
        rmCellar.setSouth(rmKitchen);
        rmCloset.setDescription("You are in your Uncle Finneas' closet.  Here are all of the clothes he has collected over the years.");
        rmCloset.setName("Closet");
        rmCloset.setWest(rmLivingRoom);
        rmDiningRoom.setDescription("You are in the Dining Room.  The table is laden with dishes and silverware in preparation for the Ball tonight");
        rmDiningRoom.setEast(rmLibrary);
        rmDiningRoom.setName("Dining Room");
        rmDiningRoom.setNorth(rmBackStaircase);
        rmDiningRoom.setSouth(rmGreatHall);
        rmDiningRoom.setWest(rmMusicRoom);
        rmDownstairsHall.setDescription("You are in a small dark hall in the lower floor.");
        rmDownstairsHall.setName("Downstairs Hall");
        rmDownstairsHall.setSouth(rmServantsQuarters);
        rmDownstairsHall.setWest(rmKitchen);
        rmDrawingRoom.setDescription("You are in a small and comfortable drawing room with windows facing full East.");
        rmDrawingRoom.setName("Drawing Room");
        rmDrawingRoom.setNorth(rmLibrary);
        rmDrawingRoom.setWest(rmGreatHall);
        rmEntry.setDescription("You are in the front Entry of Pemberley.  It is a very fashionable Entry.");
        rmEntry.setName("Entry");
        rmEntry.setNorth(rmGreatHall);
        rmEntry.setSouth(rmFrontDrive);
        rmEntry.setWest(rmGrandStaircase);
        rmFinnKitchen.setDescription("The Kitchen is one of the cleanest rooms in Uncle Finneas' house.  Probably because He mostly likes to eat out.");
        rmFinnKitchen.setName("Kitchen");
        rmFinnKitchen.setSouth(rmLivingRoom);
        rmFrontDrive.setDescription("You are on the Front Drive of Pemberley looking up at its impressive height and width.");
        rmFrontDrive.setEast(rmPath);
        rmFrontDrive.setName("Front Drive");
        rmFrontDrive.setNorth(rmEntry);
        rmGallery.setDescription("You are in the gallery.  There are several large and impressive paintings.  ");
        rmGallery.setName("Gallery");
        rmGallery.setSouth(rmUpstairsHallWest);
        rmGarden.setDescription("You are in the expansive Gardens at Pemberley.  You think a person can spend many enjoyable hours here.");
        rmGarden.setEast(rmStable);
        rmGarden.setName("Garden");
        rmGarden.setSouth(rmPath);
        rmGrandStaircase.setDescription("You are on the Grand Staircase.  It is impressive as befits a staircase of Pemberley");
        rmGrandStaircase.setEast(rmEntry);
        rmGrandStaircase.setName("Grand Staircase");
        rmGrandStaircase.setNorth(rmUpstairsHallWest);
        rmGreatHall.setDescription("You are in the Great Hall.  It is very tall.");
        rmGreatHall.setEast(rmDrawingRoom);
        rmGreatHall.setName("Great Hall");
        rmGreatHall.setNorth(rmDiningRoom);
        rmGreatHall.setSouth(rmEntry);
        rmGreatHall.setWest(rmBallroom);
        rmGreen.setDescription("You are on the green next to the Smithy.  ");
        rmGreen.setName("Green");
        rmGreen.setWest(rmSmithy);
        rmGrocer.setDescription("You are in the Lambton Grocer");
        rmGrocer.setName("Grocer");
        rmGrocer.setNorth(rmRoadWest);
        rmKitchen.setDescription("You are in the Kitchen.  It is very busy as the staff prepares for the Ball");
        rmKitchen.setEast(rmDownstairsHall);
        rmKitchen.setName("Kitchen");
        rmKitchen.setNorth(rmCellar);
        rmKitchen.setSouth(rmLarder);
        rmKitchen.setWest(rmBackStaircase);
        rmLake.setDescription("You are standing on the edge of a pretty lake.  Beneath the surface you can see carp, pike and ___ swimming");
        rmLake.setName("Lake");
        rmLake.setNorth(rmStable);
        rmLake.setWest(rmPath);
        rmLarder.setDescription("You are in the Larder.  It is stacked high with jars and sacks of food and ingredients");
        rmLarder.setName("Larder");
        rmLarder.setNorth(rmKitchen);
        rmLibrary.setDescription("You are in the Library.  You can tell that someone who lives here is an extensive reader and takes great pleasure in reading.");
        rmLibrary.setName("Library");
        rmLibrary.setSouth(rmDrawingRoom);
        rmLibrary.setWest(rmDiningRoom);
        rmLivingRoom.setDescription("The Living room of your Uncle Finneas' house is stacked high with books.  In one corner sits his Hamster Bruiser's cage.");
        rmLivingRoom.setDescription("You are in the Living Room of your Uncle Finneas' House.  ");
        rmLivingRoom.setEast(rmCloset);
        rmLivingRoom.setName("Living Rom");
        rmLivingRoom.setName("Living Room");
        rmLivingRoom.setNorth(rmFinnKitchen);
        rmLivingRoom.setSouth(rmSecretLab);
        rmLivingRoom.setSouth(rmSecretLab);
        rmMilliner.setDescription("You are in a small Milliner's shop.  The hats are very beautiful but some of them are sort of strange too.");
        rmMilliner.setName("Milliner");
        rmMilliner.setSouth(rmRoadWest);
        rmMusicRoom.setDescription("You a re in the Music Room.  There is a lovely pianoforte in one corner and a couch good for sitting and looking broodingly on whoever might be playing.");
        rmMusicRoom.setEast(rmDiningRoom);
        rmMusicRoom.setName("Music Room");
        rmMusicRoom.setSouth(rmBallroom);
        rmNathanielBedroom.setDescription("You are in Mr Willoughby's room.");
        rmNathanielBedroom.setName("Mr Ws Room");
        rmNathanielBedroom.setWest(rmUpstairsHallEast);
        rmPath.setDescription("You are on a Path outside the main house");
        rmPath.setEast(rmLake);
        rmPath.setName("Path");
        rmPath.setNorth(rmGarden);
        rmPath.setWest(rmFrontDrive);
        rmRoadEast.setDescription("You are on a road in the town of Lambton");
        rmRoadEast.setEast(rmFrontDrive);
        rmRoadEast.setName("Road East");
        rmRoadEast.setSouth(rmSmithy);
        rmRoadEast.setWest(rmRoadWest);
        rmRoadWest.setDescription("You are on a road in the town of Lambton");
        rmRoadWest.setEast(rmRoadEast);
        rmRoadWest.setName("Road West");
        rmRoadWest.setNorth(rmMilliner);
        rmRoadWest.setSouth(rmGrocer);
        rmRoseBedroom.setDescription("You are in Miss Rose Brandon's room");
        rmRoseBedroom.setName("Rose's Room");
        rmRoseBedroom.setSouth(rmUpstairsHallEast);
        rmSecretLab.setDescription("Like your uncle Finneas, the Secret Laboratory is a bit shabby and disorganized");
        rmSecretLab.setDescription("You are in your Uncle Finneas' secret lab.  Like your uncle it is a bit shabby and disorganized.");
        rmSecretLab.setName("Secret Lab");
        rmSecretLab.setName("Secret Laboratory");
        rmSecretLab.setNorth(rmLivingRoom);
        rmSecretLab.setNorth(rmLivingRoom);
        rmServantsQuarters.setDescription("You are in one of the Servant's rooms");
        rmServantsQuarters.setName("Servants ");
        rmServantsQuarters.setNorth(rmDownstairsHall);
        rmSmithy.setDescription("You are in the Lambton Smithy");
        rmSmithy.setEast(rmGreen);
        rmSmithy.setName("Smithy");
        rmSmithy.setNorth(rmRoadEast);
        rmStable.setDescription("You are in the Stable.  Against one wall is a row of impressive horses.");
        rmStable.setName("Stable");
        rmStable.setSouth(rmLake);
        rmStable.setWest(rmGarden);
        rmUpstairsHallEast.setDescription("You are in an upstairs hall.");
        rmUpstairsHallEast.setEast(rmNathanielBedroom);
        rmUpstairsHallEast.setName("Up Hall East");
        rmUpstairsHallEast.setNorth(rmRoseBedroom);
        rmUpstairsHallEast.setWest(rmUpstairsHallWest);
        rmUpstairsHallWest.setDescription("You are in an upstairs hall.");
        rmUpstairsHallWest.setEast(rmUpstairsHallEast);
        rmUpstairsHallWest.setName("Up Hall West");
        rmUpstairsHallWest.setNorth(rmGallery);
        rmUpstairsHallWest.setSouth(rmGrandStaircase);











//make a room array
        Room roomsArray1[] = {rmFinnKitchen, rmLivingRoom, rmCloset, rmSecretLab};
        Room roomsArray2[] = {rmMilliner, rmRoadWest, rmRoadEast, rmGrocer, rmSmithy, rmGreen};
        Room roomsArray3[] = {rmMusicRoom, rmDiningRoom, rmLibrary, rmBallroom, rmGreatHall, rmDrawingRoom, rmEntry, rmGarden, rmStable, rmFrontDrive, rmPath, rmLake};
        Room roomsArray4[] = {rmCellar, rmBackStaircase, rmKitchen, rmDownstairsHall, rmLarder, rmServantsQuarters};
        Room roomsArray5[] = {rmUpstairsHallEast, rmNathanielBedroom, rmGrandStaircase, rmGallery, rmRoseBedroom, rmUpstairsHallWest,};

//then assign it to the map
        mpFinneasHouse.setRooms(roomsArray1);
        mpLambton.setRooms(roomsArray2);
        mpPemberleyMain.setRooms(roomsArray3);
        mpPemberleyLower.setRooms(roomsArray4);
        mpPemberleyUpper.setRooms(roomsArray5);

        mpFinneasHouse.setMapCoordinates(MapCoordinates.mpFinnHouse.getRoomPositions());
        mpLambton.setMapCoordinates(MapCoordinates.mpLambton.getRoomPositions());
        mpPemberleyMain.setMapCoordinates(MapCoordinates.mpPemberleyMain.getRoomPositions());
        mpPemberleyLower.setMapCoordinates(MapCoordinates.mpPemberleyLower.getRoomPositions());
        mpPemberleyUpper.setMapCoordinates(MapCoordinates.mpPemberleyUpper.getRoomPositions());

//set which map a room belongs to
        for (Room i : mpPemberleyMain.getRooms()) {
            i.setMap(mpPemberleyMain);
        }

        for (Room i : mpFinneasHouse.getRooms()) {
            i.setMap(mpFinneasHouse);
        }

        for (Room i : mpLambton.getRooms()) {
            i.setMap(mpLambton);
        }

        for (Room i : mpPemberleyLower.getRooms()) {
            i.setMap(mpPemberleyLower);
        }

        for (Room i : mpPemberleyUpper.getRooms()) {
            i.setMap(mpPemberleyUpper);
        }

        inventoryOne.setWeight(0);
        playerOne.setInventory(inventoryOne);

        Item allItems[] = {itBoxDogTreats, itPaintng, itPianoForte, itOven, itRock, itNote, itCarriage,
            itRibbons, itTimeMachine, itLetter, itTrout, itClothing, itCane, itCarrotBag,
            itCarrots, itChestnuts, itChestnutTree, itContainerOfSweets, itContainerOfWorms,
            itEmptyContainer, itFan, itFishingPole, itHeartCard, itMoney, itMusic,
            itPocKetWatch, itTeaCup, itBall, itUmbrella, itWorms, itDogTreats};

        Actor allActors[] = {atHamster, atMrDarcy, atCarter, atLordRandolph, atMarshall,
            atUncleFinneas, atLadyRoslyn, atMrsDarcy, atGeorgie, atRoberDarcy, atJaneDarcy,
            atJonathan, atRabbit, atWilliam, atDaisy, atOliveNelson, atSally, atRoseBrandon,
            atLadyCatherine, atMrHarmon, atMissNorwood, atMrBarns, atWilloughby};

        Quest allQuests[] = {qtCane, qtCarrots, qtCarter, qtCoach, qtCook, qtDaisy,
            qtGrocer, qtHamster, qtJaneDarcy, qtLadyRoslyn, qtLake, qtMiliner, qtMrDarcy,
            qtMrsDarcy, qtNote, qtRabbit, qtRandolph, qtSally, qtRose, qtSweets, qtTimeMachine};

        Map allMaps[] = {mpFinneasHouse, mpLambton, mpPemberleyLower, mpPemberleyMain,
            mpPemberleyUpper};

        game.setAllActorArray(allActors);
        game.setAllItemArray(allItems);
        game.setAllQuestArray(allQuests);
        game.setPlayerOne(playerOne);
        game.setMaps(allMaps);
        game.setCurrentRoom(playerOne.getLocation());
//render initial room and map
        game.setCurrentMap(game.getCurrentRoom().getMap());
        MapControl mapControl = new MapControl();
        rmLivingRoom.setRoomDrawing(mapControl.renderRoom(rmLivingRoom));

        String mapDrawing = mapControl.renderMap(rmLivingRoom);
        Map currentMap = rmLivingRoom.getMap();
        currentMap.setMapDrawing(mapDrawing);
        
        
    }
// L11 Team Assignment
    public static void saveGame(Game game, String filePath) 
            throws GameControlException {
//write serialized Java Bean object directly to an object to an output byte stream.        
        try( FileOutputStream fops = new FileOutputStream(filePath)) { 
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game); // write the game object out to file
        }
        catch(IOException e) {
            throw new GameControlException(e.getMessage());
        }
    }

    public static void getSavedGame(String filePath) 
                        throws GameControlException{
        Game game = null;
        
        try(FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject(); //read the game object from file
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
        // close the output file
        PemberleyGame.setCurrentGame(game); // save in PemberleyGame
    }
    

    public void updateGame() {
         Game game = PemberleyGame.getCurrentGame();
        Player player = game.getPlayerOne();
        game.setCurrentRoom(player.getLocation());
        game.setCurrentMap(game.getCurrentRoom().getMap());
        ActorControl actorControl = new ActorControl();
        ItemControl itemControl = new ItemControl();
        game.setLocalItemArray(itemControl.createLocalItemArray());
        game.setLocalActorArray(actorControl.createLocalActorArray());
        game.setLocalActorNames(actorControl.createActorNameList(game.getLocalActorArray()));
        game.setLocalItemNames(itemControl.createItemNameList(game.getLocalItemArray()));
    }

}
