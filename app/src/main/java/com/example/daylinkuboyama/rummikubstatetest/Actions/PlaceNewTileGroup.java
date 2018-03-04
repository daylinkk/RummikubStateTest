package com.example.daylinkuboyama.rummikubstatetest.Actions;

import com.example.daylinkuboyama.rummikubstatetest.GamePlayer;
import com.example.daylinkuboyama.rummikubstatetest.TileGroup;
import com.example.daylinkuboyama.rummikubstatetest.TileSet;

/**
 * Created by lytle on 3/4/2018.
 */

public class PlaceNewTileGroup extends GameAction {

    private TileGroup tileGroup; // TileGroup object to represent any group of tile sets

    /**
     * Constructor for PlaceNewTileGroup
     * @param player
     */
    public PlaceNewTileGroup(GamePlayer player, TileGroup tiles) {
        super(player);
        this.tileGroup = tiles;
    }

    /**
     * Get method that returns the Tiles being played
     * @return
     */
    public TileGroup getTileGroup(){
        return this.tileGroup;
    }
}
