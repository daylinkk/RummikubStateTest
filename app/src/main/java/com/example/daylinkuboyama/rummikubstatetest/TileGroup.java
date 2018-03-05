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
     * @param copyTileGroup tileGroup to copy
     */
    public TileGroup (TileGroup copyTileGroup){
        tiles = new ArrayList<>();

        for (Tile t : copyTileGroup.tiles) {
            tiles.add (new Tile(t));
        }
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

    /**
     * arranges this tile group into a random order
     */
    public void randomize(){
        //go through the array list and choose a rondom position to swap with
        for(int i=0;i<tiles.size();i++){
            int randPos= (int)(Math.random()*tiles.size());
            //now swap them
            Tile temp= tiles.get(i);
            tiles.set(i,tiles.get(randPos));
            tiles.set(randPos,temp);
        }

        /**
         * External Citation
         * Source:
         *  Java ArrayList doc
         * Problem:
         *  how to set specific index in array list
         * Solution:
         *  use set(int,object) method
         */
    }

    /**
     * removes the top tile from the group and returns it
     * @return the top tile in the group
     *         null if empty group
     */
    public Tile draw(){
        if(tiles.size() == 0) return null;

        Tile topTile= getTile(tiles.size()-1);
        remove(topTile);

        return topTile;
    }

    /**
     * Helper method to find if a TileGroup has a given tile
     * @param findTile
     * @return
     */
    public Boolean contains(Tile findTile){
        if(tiles.contains(findTile)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * returns this tile group as a string
     * it will be each tile followed by a comma
     * @return a string representation of this tile group
     */
    @Override
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
