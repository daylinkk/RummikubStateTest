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
    ArrayList <Tile> tiles;

    public TileGroup(){
        this.tiles = new ArrayList<>();
    }

    public void add(Tile addTile){
        tiles.add(addTile);
    }



}
