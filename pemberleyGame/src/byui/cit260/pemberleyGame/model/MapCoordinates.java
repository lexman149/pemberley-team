package byui.cit260.pemberleyGame.model;

import java.io.Serializable;

public enum MapCoordinates implements Serializable{
    mpLambton(new int [][]{
        {0, -1, -1}, // miliner
        {1, 2, -1},	// road west, road East
        {3, 4, 5}}), // grocer, smithy, green
       

    mpPemberleyLower(new int [][]{
        {-1, 0, -1}, // null, Cellar, null
        {1, 2, 3}, // back stairs, kitchen, downstairs hall
        {-1, 4, 5}}),  // null, Larder, Servants
        
    
    mpPemberleyMain(new int [][]{
        {0, 1, 2, -1}, // music room, dining room, library, null
        {3, 4, 5, -1}, // ballroom, Great Hall, drawing room, null
        {-1, 9, 10, 11}}), // null, front drive, path, lake

    
    mpPemberleyUpper(new int [][]{
        {0, 1, -1}, // gallery, Rose's Room, null
        {2, 3, 4}, // up hall, up hall, Mr Ws
        {5, -1, -1}}), // grand staircase, null, null

    
    mpFinnHouse(new int [][]{
        {0, -1}, // kitchen, null
        {1, 2}, // living room, closet
        {3, -1}}); // secret lab, null
    
    private final int [][] roomPositions;

    private MapCoordinates(int[][] roomPositions) {
        this.roomPositions = roomPositions;
    }

    public static MapCoordinates getMpLampton() {
        return mpLambton;
    }

    public static MapCoordinates getMpPemberleyDownstairs() {
        return mpPemberleyLower;
    }

    public static MapCoordinates getMpPemberleyMain() {
        return mpPemberleyMain;
    }

    public static MapCoordinates getMpPemberleyUpstairs() {
        return mpPemberleyUpper;
    }

    public static MapCoordinates getMpFinnHouse() {
        return mpFinnHouse;
    }

    public int[][] getRoomPositions() {
        return roomPositions;
    }
    
    
}