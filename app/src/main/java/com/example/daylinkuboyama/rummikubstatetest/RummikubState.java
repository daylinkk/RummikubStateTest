package com.example.daylinkuboyama.rummikubstatetest;

import java.util.ArrayList;

/**
 * Created by daylinkuboyama on 2/27/18.
 */

public class RummikubState {
    /*
    #number of players

    players hands
        number of tiles
        values of tiles
    #score
    tiles left in draw pile
    #whose turn it is/current player
    current state of the table

    #what players have melded
     */

    //number of players in the game
    int numPlayers;

    // These instance vaiables are parallel
    String[] players; //names of players
    TileGroup[] playerHands; // parallel to players
    int[] playerScores; //parallel to players[], indicates score of each player
    //parallel to players[], indicates weather each player has melded
    boolean[] playersMelded;

    //index of players[], indicates whose turn it is
    int currentPlayer;

    TileGroup drawPile;

    ArrayList<TileGroup> tableTileGroups;

    // TODO add a previous tableTileGroup variable


    public RummikubState(){
        this.numPlayers = 2;
        this.players = new String[numPlayers];
        this.players[0] = "Matt";
        this.players[1] = "Nux";
        this.playerHands = new TileGroup[numPlayers];
        this.playerHands[0] = new TileGroup();
        this.playerHands[1] = new TileGroup();
        this.playerScores = new int[numPlayers];
        this.playerScores[0] = 0;
        this.playerScores[1] = 0;
        this.playersMelded = new boolean[numPlayers];
        this.playersMelded[0] = false;
        this.playersMelded[1] = false;
        this.currentPlayer = 0;
        this.tableTileGroups = new ArrayList<>();

    }

    private void initDrawPile(){
        drawPile = new TileGroup();
        for(int i = 0; i < 2; i++){
            for(int val = 1; val <= 13; val++){
                for(int col = 0; col <= 3; col++){
                    drawPile.add(new Tile(-1, -1, val, col));
                }
            }
        }
    }
}
