package com.example.daylinkuboyama.rummikubstatetest;

import java.util.ArrayList;

/**
 * purpose: A generic grouping of tiles
 * (example: Tiles in player's racks)
 * check values of set when melding
 *
 * Created by daylinkuboyama on 2/27/18.
 */

public class TileGroup {

    //an array list of tile objects
    private ArrayList <Tile> tiles;

    public TileGroup(){
        this.tiles = new ArrayList<>();
    }

    /**
     * Copy constructor for tileGroups
     * @param copyTileGroup
     */
    public TileGroup (TileGroup copyTileGroup){
        tiles = copyTileGroup.tiles;
    }

    public void add(Tile addTile){
        tiles.add(addTile);
    }

    public void remove(Tile remove){
        this.tiles.remove(remove);
    }

    public int groupSize(){
        return this.tiles.size();
    }

    public Tile getTile(int index){
        return this.tiles.get(index);
    }

    public ArrayList getTileGroup(){
        return this.tiles;
    }

    public void randomize(){}


    /**
     * returns this tile group as a string
     * it will be each tile followed by a comma
     * @return a string representation of this tile group
     */
    public String toString(){
        //if empty, return empty string
        if(tiles.size() == 0) return "";

        String groupString= "";

        for(Tile t : tiles){
            groupString+= t.toString();
            groupString+= ',';
        }

        //remove last comma
        groupString= groupString.substring(0,groupString.length()-1);

        return groupString;
    }


}
