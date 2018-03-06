package com.example.daylinkuboyama.rummikubstatetest.Actions;

import com.example.daylinkuboyama.rummikubstatetest.GamePlayer;
import com.example.daylinkuboyama.rummikubstatetest.TileGroup;
import com.example.daylinkuboyama.rummikubstatetest.TileSet;

/**
 * Class PlaceNewTileGroup
 *
 * @author Daylin Kuboyama
 * @author Harry Thoma
 * @author Riley Snook
 * @author Chris Lytle
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
