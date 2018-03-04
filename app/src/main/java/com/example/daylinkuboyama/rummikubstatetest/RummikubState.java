package com.example.daylinkuboyama.rummikubstatetest;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by daylinkuboyama on 2/27/18.
 */

public class RummikubState {

    private int numPlayers; //number of players in the game

    // These instance variables are parallel to players[]
    private String[] players; //names of players
    private TileGroup[] playerHands; //groups of tiles in players' hands
    private int[] playerScores; //indicates score of each player
    private boolean[] playersMelded; //indicates whether each player has melded
    private int[] playersID;
    //parallel to players[], indicates weather each player has melded

    private int currentPlayer; //index of players[], indicates whose turn it is
    //index of players[], indicates whose turn it is
    private Boolean crrentPlayerPlayed;
    //ArrayList<ArrayList<TileGroup>> tableChanges;

    private TileGroup drawPile; //tiles that are not played/in player's hand

    private ArrayList<TileGroup> tableTileGroups;

    // TODO add a previous tableTileGroup variable


    public RummikubState() {
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

    /**
     * Copy constructor for gameState
     * @param copy
     */
    public void RummikubState (RummikubState copy) {
        numPlayers = copy.numPlayers;
        players = copy.players;
        players[0] = copy.players[0];
        players[1] = copy.players[1];

        playerHands = copy.playerHands;
        playerHands[0] = copy.playerHands[0];
        playerHands[1] = copy.playerHands[1];

        playerScores = copy.playerScores;
        playerScores[0] = copy.playerScores[0];
        playerScores[1] = copy.playerScores[1];

        playersMelded = copy.playersMelded;
        playersMelded[0] = copy.playersMelded[0];
        playersMelded[1] = copy.playersMelded[1];

        currentPlayer = copy.currentPlayer;
        tableTileGroups = copy.tableTileGroups;
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


    private void drawTile(int playerID){
        int p;
        for(p = 0; p < numPlayers; p++){
            if (playerID == playersID[p]){
                Random rando = new Random();
                int randomint = rando.nextInt(drawPile.groupSize()-1);
                Tile tempTile = drawPile.getTile(randomint);
                drawPile.getTileGroup().remove(randomint);
                playerHands[p].add(tempTile);
            }
        }
    }

    private Boolean canDraw(int playerID){
        return false;
    }

    private Boolean canKnock(int playerID){
        return false;
    }

    private Boolean validMove(int playerID, TileGroup tiles){
        return false;
    }

    private Boolean canUndo(int playerID){
        return false;
    }

    private Boolean canShowMenue(int playerID){
        return false;
    }

    private Boolean canSelectTile(int playerID, Tile tile){
        return false;
    }
}
