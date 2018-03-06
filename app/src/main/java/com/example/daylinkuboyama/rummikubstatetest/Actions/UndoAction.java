package com.example.daylinkuboyama.rummikubstatetest.Actions;

import com.example.daylinkuboyama.rummikubstatetest.GamePlayer;

/**
 * Undo Action class
 * Subclass of GameAction
 * Action for when the user wants to perform a undo action on their turn
 *
 * @author Daylin Kuboyama
 * @author Harry Thoma
 * @author Riley Snook
 * @author Chris Lytle
 */

public class UndoAction extends GameAction {

    /**
     * Constructor for UndoAction
     * @param player
     */
    public UndoAction(GamePlayer player){
        super(player);
    }
}
