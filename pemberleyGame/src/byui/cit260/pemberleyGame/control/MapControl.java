/*
* Pemberley Game
* BYUi CIT260
* Manning, Marriott & Wilkerson
 */
package byui.cit260.pemberleyGame.control;

import byui.cit260.pemberleyGame.model.*;
import byui.cit260.permberleyGame.exceptions.MapControlException;
import java.util.ArrayList;
import pemberley_game.PemberleyGame;

/**
 *
 * @author Alexis
 */
public class MapControl {

    public String playerNavigate(String direction, Player player) 
                            throws MapControlException{
        Game game = PemberleyGame.getCurrentGame();
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
            throw new MapControlException("You can't go that direction");
        } else {
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
            gameControl.updateGame();
            
            String playerMessage = nextRoom.getName() + "\n" + this.lookAtRoom();
            return playerMessage;
        }

    }

// author Sheila
    public String lookAtRoom() {
         Game game = PemberleyGame.getCurrentGame();
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

    public String renderMap(Room nextRoom) {
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

 
}
