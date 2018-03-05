package com.example.daylinkuboyama.rummikubstatetest;

/**
 * class TileSet
 *
 *
 *
 * @author Daylin Kuboyama
 * @author Harry Thoma
 * @author Riley Snook
 * @author Chris Lytle
 */

public class TileSet extends TileGroup {

    private boolean isRun; //for sets: true = run, false = book

    /**
     * Constructor for TileSet
     */
    public TileSet(){
        super();
    }

    /**
     * Copy constructor for tileSets
     * @param copyTileSet tileSet to copy
     */
    public TileSet (TileSet copyTileSet){
        super (copyTileSet);
        this.isRun = copyTileSet.isRun;
    }

    /**
     * Check if //todo finish method/comment
     * @return
     */
    public boolean isValidSet(){
        return false;
    }

    /**
     * this tile set as a string
     * it will be the tilegroup string
     * immediately followed by a "_"
     * immediately followed by "Book" for a book
     * or "Run" for a run
     *
     * @return a string representation of this tilegroup
     */
    @Override
    public String toString(){
        String groupString= super.toString();

        String typeString= "";
        if(isRun) typeString= "Run";
        else typeString= "Book";

        return groupString + "_" + typeString;
    }

}
