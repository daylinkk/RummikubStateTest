package com.example.daylinkuboyama.rummikubstatetest;

import java.util.ArrayList;
import java.util.Random;

/**
 * class TileGroup
 *
 * Any grouping of tiles with a minimum of 1 tile
 * Used to save tiles on table and in player's hands
 * (example: Tiles in player's racks)
 * check values of set when melding
 *
 *
 * @author Daylin Kuboyama
 * @author Harry Thoma
 * @author Riley Snook
 * @author Chris Lytle
 */

public class TileGroup {

    //an array list of tile objects
    protected ArrayList <Tile> tiles;

    /**
     * TileGroup Initial Constructor
     */
    public TileGroup(){
        this.tiles = new ArrayList<>();
    }

    /**
     * Constructor that takes in an ArrayList of given Tiles
     * @param tileList
     */
    public TileGroup(Tile ... tileList){
        for(Tile T : tileList){
            tiles.add(T);
        }
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

    /**
     * Method to add a Tile to ArrayList tiles
     * @param addTile
     */
    public void add(Tile addTile){
        tiles.add(addTile);
    }

    /**
     * adds all tiles in addGroup to this group
     * removes all tiles from addGroup
     * @param addGroup the group to add to this group
     */
    public void merge(TileGroup addGroup){
        for(Tile t : addGroup.tiles){
            this.add(t);
            addGroup.remove(t);
        }
    }

    /**
     * Method to remove Tile from TileGroup tiles
     * @param remove
     */
    public void remove(Tile remove){
        this.tiles.remove(remove);
    }

    /**
     * Helper Method to return size of TileGroup
     * @return tiles.size
     */
    public int groupSize(){
        return this.tiles.size();
    }

    /**
     * Add all the values of tiles in a TileGroup
     * @return
     */
    public int groupPointValues(){
        int rtnVal = 0;
        for(Tile t : tiles){
            rtnVal = rtnVal + t.getValue();
        }
        return rtnVal;
    }

    /**
     * Get tile based on index
     * @param index
     * @return
     */
    public Tile getTile(int index){
        return this.tiles.get(index);
    }

    /**
     * Getter method to return ArrayList of Tiles
     * @return
     */
    public ArrayList getTileGroup(){
        return this.tiles;
    }

    /**
     * arranges this tile group into a random order
     */
    public void randomize(){
        Random rand= new Random(45454);

        //go through the array list and choose a rondom position to swap with
        for(int i=0;i<tiles.size();i++){
            int randPos= rand.nextInt(tiles.size());
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
