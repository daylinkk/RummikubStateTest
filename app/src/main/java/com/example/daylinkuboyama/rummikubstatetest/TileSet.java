package com.example.daylinkuboyama.rummikubstatetest;

/**
 * Created by daylinkuboyama on 2/27/18.
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
     * @param copyTileSet
     */
    public TileSet (TileSet copyTileSet){
        isRun = copyTileSet.isRun;
    }

    /**
     * Check if //todo finish method/comment
     * @return
     */
    public boolean isValidSet(){
        return false;
    }


}
