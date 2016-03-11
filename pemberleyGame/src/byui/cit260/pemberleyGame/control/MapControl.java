/*
* Pemberley Game
* BYUi CIT260
* Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.*;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class MapControl {

    public String playerNavigate(String direction, Player player, Game game) {
        Room currentRoom = player.getLocation();
        Room nextRoom;
        switch (direction) {
            case "E":
            case "EAST":
                nextRoom = currentRoom.getEast();
                break;
            case "S":
            case "SOUTH":
                nextRoom = currentRoom.getSouth();
                break;
            case "N":
            case "NORTH":
                nextRoom = currentRoom.getNorth();
                break;
            case "W":
            case "WEST":
                nextRoom = currentRoom.getWest();
                break;

            default:
                return "Not sure where you are going.";

        }
        if (nextRoom == null) {
            return "You cannot go that direction. Please choose again.";
        } else {
            System.out.println(nextRoom.getName());
            player.setLocation(nextRoom);
            currentRoom = player.getLocation();
            String[] roomArray = currentRoom.getRoomDrawing();
            if (roomArray == null) {
                String[] roomDrawing = this.renderRoom(nextRoom);
                nextRoom.setRoomDrawing(roomDrawing);

                String mapDrawing = this.renderMap(nextRoom);
                Map currentMap = nextRoom.getMap();
                currentMap.setMapDrawing(mapDrawing);
            }

            GameControl gameControl = new GameControl();
            gameControl.updateGame(game);
            String playerMessage = this.lookAtRoom(game);
            return playerMessage;
        }

    }

// author Sheila
    public String lookAtRoom(Game game) {
        Room currentRoom = game.getCurrentRoom();
        String roomDescription = currentRoom.getDescription();
        roomDescription = roomDescription + "\nThese are the directions you can move from here: ";
        int i;

        if (currentRoom.getNorth() != null) {
            roomDescription = roomDescription + "NORTH ";
        }
        if (currentRoom.getWest() != null) {
            roomDescription = roomDescription + "WEST ";
        }
        if (currentRoom.getSouth() != null) {
            roomDescription = roomDescription + "SOUTH ";
        }
        if (currentRoom.getEast() != null) {
            roomDescription = roomDescription + "EAST ";
        }

        if (game.getLocalItemNames().length != 0) {
            roomDescription = roomDescription + "\nThese Items are here: ";
            for (String s : game.getLocalItemNames()) {
                roomDescription = roomDescription + s + "-";
            }
        }

        if (game.getLocalActorNames().length != 0) {
            roomDescription = roomDescription + "\nThese People are here: ";
            for (String s : game.getLocalActorNames()) {
                roomDescription = roomDescription + s + "-";
            }
        }

        String[] roomDrawing = currentRoom.getRoomDrawing();

        for (String v : roomDrawing) {
            roomDescription = roomDescription + "\n";
            roomDescription = roomDescription + v;
        }

        return roomDescription;
    }

    public String[] renderRoom(Room room) {
        String roomName = room.getName();
        int i = 0;
//break the room down into pieces by space so each row of the room drawing can have part of a name.  Makes for a narrow room.
        String[] splitRoomName = roomName.split(" ");
//add spaces to each name in the array to make them uniformly long
        for (int n = 0; n < splitRoomName.length; n++) {
            int spacesNeeded = 11 - splitRoomName[n].length();
                for (int x = 0; x < spacesNeeded; x++) {
                splitRoomName[n] = splitRoomName[n] + " ";
            }
        }
        String[] roomDraw;
        String buildLine = "";

        ArrayList<String> roomDrawList = new ArrayList<>();

        if (room.getNorth() != null) {
            roomDrawList.add(Wall.vertPassage.getWall());
        } else {
            roomDrawList.add(Wall.empty.getWall());
        }

        roomDrawList.add(Wall.xWall.getWall());

        if (splitRoomName.length == 3) {
            roomDrawList.add(Wall.leftWall.getWall() + splitRoomName[i] + Wall.rightWall.getWall());
            i++;
        } else {
            roomDrawList.add(Wall.emptyWall.getWall());
        }

        if (room.getWest() != null) {
            buildLine = Wall.west.getWall() + splitRoomName[i];
        } else {
            buildLine = Wall.leftWall.getWall() + splitRoomName[i];
        }
        i++;

        if (room.getEast() != null) {
            buildLine = buildLine + Wall.east.getWall();
        } else {
            buildLine = buildLine + Wall.rightWall.getWall();
        }

        roomDrawList.add(buildLine);
        if (splitRoomName.length == 2) {
            roomDrawList.add(Wall.leftWall.getWall() + splitRoomName[i] + Wall.rightWall.getWall());
        } else {
            roomDrawList.add(Wall.emptyWall.getWall());
        }
        roomDrawList.add(Wall.xWall.getWall());
        if (room.getSouth() != null) {
            roomDrawList.add(Wall.vertPassage.getWall());
        } else {
            roomDrawList.add(Wall.empty.getWall());
        }
        String[] roomDrawListArray = roomDrawList.toArray(new String[roomDrawList.size()]);

        return roomDrawListArray;

    }


    private String renderMap(Room nextRoom) {
        Room currentRoom;
        Map currentMap = nextRoom.getMap();
        String[] roomDrawing;
        Room[] roomsArray = currentMap.getRooms();
        String mapDrawing = "\n";

        for (int[] row : currentMap.getMapCoordinates()) {
//            mapDrawing = mapDrawing + "\n";
            for (int x = 0; x < 7; x++) {
                mapDrawing = mapDrawing + "\n";
                for (int mapCoordinates : row) {
                    if (mapCoordinates == -1) {
                        mapDrawing = mapDrawing + Wall.empty.getWall();
                    } else {
                        currentRoom = roomsArray[mapCoordinates];
                        if (currentRoom.getRoomDrawing() == null) {
                            mapDrawing = mapDrawing + Wall.empty.getWall();
                        } else {
                            mapDrawing = mapDrawing + currentRoom.getRoomDrawing()[x];
                        }
                    }

                }
            }
        }
        return mapDrawing;
    }
    
    public static Room[] createRoomList(){
	Room[] room = new Room[35];

	Room rmBackStaircase = new Room();
	Room rmBallroom = new Room();
	Room rmBlocked = new Room();
	Room rmCellar = new Room();
	Room rmCloset = new Room();
	Room rmDiningRoom = new Room();
	Room rmDownstairsHall = new Room();
	Room rmDrawingRoom = new Room();
	Room rmEntry = new Room();
	Room rmFinnKithen = new Room();
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
	
	rmFinnKithen.setDescription("The Kitchen is one of the cleanest rooms in Uncle Finneas' house.  Probably because He mostly likes to eat out.");
	rmFinnKithen.setName("Kitchen");
	rmFinnKithen.setSouth(rmLivingRoom);
	
	
	rmFrontDrive.setDescription("You are on the Front Drive of Pemberley looking up at its impressive height and width.");
	rmFrontDrive.setEast(rmPath);
	rmFrontDrive.setName("Front Drive");
	rmFrontDrive.setNorth(rmEntry);
	rmGallery.setDescription("You are in the gallery. There are several large and impressive paintings.");
	
	rmGallery.setName("Gallery");
	rmGallery.setSouth(rmUpstairsHallWest);
	
	rmGarden.setDescription("You are in the expansive Gardens at Pemberley. You think a person can spend many enjoyable hours here.");
	rmGarden.setEast(rmStable);
	rmGarden.setName("Garden");
	rmGarden.setSouth(rmPath);
	
	rmGrandStaircase.setDescription("You are on the Grand Staircase. It is impressive as befits a staircase of Pemberley");
	rmGrandStaircase.setEast(rmEntry);
	rmGrandStaircase.setName("GrandStaircase");
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
	rmLivingRoom.setNorth(rmFinnKithen);
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
	rmUpstairsHallEast.setName("Up Hall East");
	rmUpstairsHallEast.setNorth(rmRoseBedroom);
	rmUpstairsHallEast.setEast(rmNathanielBedroom);
	rmUpstairsHallEast.setWest(rmUpstairsHallWest);
	rmUpstairsHallWest.setDescription("You are in an upstairs hall.");
	rmUpstairsHallWest.setEast(rmUpstairsHallEast);
	rmUpstairsHallWest.setName("Up Hall West");
	rmUpstairsHallWest.setNorth(rmGallery);
	rmUpstairsHallWest.setSouth(rmGrandStaircase);
        
    Room[] rooms = {rmBackStaircase, rmBallroom, rmBlocked, rmCellar, rmCloset,
    rmDiningRoom, rmDownstairsHall, rmDrawingRoom, rmEntry, rmFinnKithen, rmFrontDrive, rmGallery, rmGarden, rmGrandStaircase, rmGreatHall,
    rmGreen, rmGrocer, rmKitchen, rmLake, rmLarder, rmLibrary, rmLivingRoom,
    rmMilliner, rmMusicRoom, rmNathanielBedroom, rmPath, rmRoadEast, rmRoadWest, rmRoseBedroom, rmSecretLab, rmServantsQuarters, rmSmithy, rmStable, rmUpstairsHallEast, rmUpstairsHallWest,};

    return rooms;
    }
}
    
