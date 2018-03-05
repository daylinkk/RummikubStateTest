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

    //todo what is the next 3 lines?
    //index of players[], indicates whose turn it is
    private Boolean crrentPlayerPlayed;
    //ArrayList<ArrayList<TileGroup>> tableChanges;

    private TileGroup drawPile; //tiles that are not played/in player's hand

    private ArrayList<TileGroup> tableTileGroups; //tiles and sets on the table

    // TODO add a previous tableTileGroup variable


    /**
     * RumikubState Constructor
     */
    public RummikubState() {
        this.numPlayers = 2;
        this.players = new String[numPlayers];
        this.players[0] = "Matt";
        this.players[1] = "Nux";

        initDrawPile();

        this.playerHands = new TileGroup[numPlayers];

        this.playerHands[0] = new TileGroup();
        this.playerHands[1] = new TileGroup();

        dealHands();

        this.playerScores = new int[numPlayers];
        this.playerScores[0] = 0;
        this.playerScores[1] = 0;

        this.playersMelded = new boolean[numPlayers];
        this.playersMelded[0] = false;
        this.playersMelded[1] = false;

        this.currentPlayer = 0;
        this.currentPlayerPlayed = false;
        this.tableTileGroups = new ArrayList<>();
    }

    /**
     * Copy constructor for gameState
     * @param copy rummikubState to copy
     */
    public RummikubState (RummikubState copy) {
       //copies num of players
        numPlayers = copy.numPlayers;

        //copies names of players
        players = new String [numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            this.players[i] = new String (copy.players[i]);
        }

        //copies players' hands
        playerHands = new TileGroup[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            this.playerHands[i] = new TileGroup (copy.playerHands[i]);
        }

        //copies players' scores
        playerScores = new int [numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            playerScores[i] = playerScores[i];
        }

        //copies boolean[] whether player melded or not
        playersMelded = new boolean[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            playersMelded[i] = playersMelded[i];
        }

        //copies current player
        currentPlayer = copy.currentPlayer;

        //copies draw pile
        drawPile = new TileGroup (copy.drawPile);

        //copies tableTileGroups
        tableTileGroups = new ArrayList <TileGroup>();
        for (TileGroup group : copy.tableTileGroups){
            this.tableTileGroups.add(new TileGroup (group));
        }
    }

    /**
     * Initial Setup State's Draw Pile
     */
    private void initDrawPile(){
        drawPile = new TileGroup();
        for(int i = 0; i < 2; i++){
            for(int val = 1; val <= 13; val++){
                for(int col = 0; col <= 3; col++){
                    drawPile.add(new Tile(-1, -1, val, Tile.colorArray[col]));
                }
            }
        }

        drawPile.randomize();
    }

    /**
     * deals 14 tiles from drawpile to each player's hand
     */
    private void dealHands(){
        for(int i=0;i<14;i++){
            for(int j=0;j<numPlayers;j++){
                playerHands[j].add(drawPile.draw());
            }
        }
    }

    /**
     * Method to draw and add tile to player's hand and update state
     * @param playerID
     */
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

    /**
     * Helper method which returns if a player can draw
     * @param playerID
     * @return
     *  - false - if player has made move and can't draw
     *  - true - if player hasn't made move
     */
    private Boolean canDraw(int playerID){
        if (currentPlayer == playerID){
            if(!(currentPlayerPlayed)){
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method which returns if a player can knock
     * @param playerID
     * @return
     *  - false - if player has not made move and can't knock
     *  - true - if player has made move, end turn
     */
    private Boolean canKnock(int playerID){
        if (currentPlayer == playerID){
            if(currentPlayerPlayed){
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks if a TileGroup is a valid Set to play
     * @param playerID
     * @param tiles
     * @return
     */
    private Boolean validMove(int playerID, TileGroup tiles){
        if (tiles instanceof TileSet){
            if(currentPlayer == playerID){
                if(((TileSet) tiles).isValidSet()){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Method to determine if a player can make a move.
     * @param playerID
     * @return
     */
    private Boolean canUndo(int playerID){
        return false;
    }

    /**
     *
     * @param playerID
     * @return
     */
    private Boolean canShowMenue(int playerID){
        return false;
    }

    /**
     *
     * @param playerID
     * @param tile
     * @return
     */
    private Boolean canSelectTile(int playerID, Tile tile){
        return false;
    }

    /**
     * this state as a string
     * will be the variable name followed by a colon and newline
     * then the value of the variable
     * e.g. for numPlayers part of the string:
     * "numPlayers:\n
     * 2\n"
     *
     * in the case of arrays it will look like this:
     * "playerHands[0]:\n
     * B7,U8\n
     * playerHands[1]:\n
     * G8,R12\n"
     *
     * @return a string representation of this state
     */
    @Override
    public String toString(){
        String stateString= "";

        stateString+= getNumPlayerString();
        stateString+= getPlayersString();
        stateString+= getPlayerHandsString();
        stateString+= getPlayerScoresString();
        stateString+= getPlayersMeldedString();
        stateString+= getCurrentPlayerString();
        stateString+= getDrawPileString();
        stateString+= getTableTileGroupString();

        return stateString;
    }

    /**
     *
     * @return string representation of the variable numPlayers
     */
    private String getNumPlayerString(){
        return "numPlayers:\n"+
                numPlayers+"\n";
    }

    /**
     *looks like:
     *
     * players[0]:
     * Matt
     * players[1]:
     * Nux
     *
     * @return string representation of the array players
     */
    private String getPlayersString(){
        //playerString is the string of the entire players array
        String playersString= "";
        for(int i=0;i<numPlayers;i++){
            //currPlayerString is each string in players
            String currPlayerString=
                    "players["+i+"]:\n";
            currPlayerString+= players[i];
            currPlayerString+= "\n";

            playersString+= currPlayerString;
        }

        return playersString;
    }

    /**
     *looks like:
     *
     * playerScores[0]:
     * 89
     * playerScores[1]:
     * -45
     *
     * @return string representation of the array playerScores
     */
    private String getPlayerScoresString(){
        //playerScoresString is the string of the entire playersScores array
        String playerScoresString= "";
        for(int i=0;i<numPlayers;i++){
            String currPlayerScoreString=
                    "playerScores["+i+"]:\n";
            currPlayerScoreString+= String.valueOf(playerScores[i]);
            currPlayerScoreString+= "\n";

            playerScoresString+= currPlayerScoreString;
        }

        return playerScoresString;
    }

    /**
     *looks like:
     *
     * playerHands[0]:
     * B6,R8
     * playerHands[1]:
     * G12,U5,B6
     *
     * @return string representation of the array playerHands
     */
    private String getPlayerHandsString(){
        //playerHandsString is the string of the entire playersHands array
        String playerHandsString= "";
        for(int i=0;i<numPlayers;i++){
            //currPlayerHandsString is each string in of a single player's hand
            String currPlayerHandsString=
                    "playerHands["+i+"]:\n";
            currPlayerHandsString+= playerHands[i].toString();
            currPlayerHandsString+= "\n";

            playerHandsString+= currPlayerHandsString;
        }

        return playerHandsString;
    }

    /**
     * looks like:
     *
     * playersMelded[0]:
     * T
     * playersMelded[1]:
     * F
     *
     * @return string representation of the array playersMelded
     */
    private String getPlayersMeldedString(){
        //playersMeldedString is the string of the entire playersMelded array
        String playersMeldedString= "";
        for(int i=0;i<numPlayers;i++){
            //currPlayerHandsString is each string in of a single player's hand
            String currPlayerMeldedString=
                    "playersMelded["+i+"]:\n";

            if(playersMelded[i]) currPlayerMeldedString+= "T";
            else currPlayerMeldedString+= "F";
            currPlayerMeldedString+= "\n";

            playersMeldedString+= currPlayerMeldedString;
        }

        return playersMeldedString;
    }

    /**
     *
     * @return string representation of the variable currentPlayer
     */
    private String getCurrentPlayerString(){
        return "currentPlayer:\n"+
                currentPlayer+"\n";
    }

    /**
     *
     * @return string representation of the variable drawPile
     */
    private String getDrawPileString(){
        return "drawPile:\n"+
                drawPile.toString()+"\n";
    }

    /**
     * looks like:
     *
     * tableTileGroups<0>:
     * B7
     * tableTileGroups<1>:
     * U8,B8,R8_Book
     * tableTileGroups<2>:
     * G4,G5,G6_Run
     *
     * @return string representation of the arraylist tableTileGroups
     */
    private String getTableTileGroupString(){
        String tableGroupsString= "";
        for(int i=0;i<tableTileGroups.size();i++){
            TileGroup currGroup= tableTileGroups.get(i);

            //currGroupString is each group in the arraylist as a string
            String currGroupString=
                    "tableTileGroups<"+i+">:\n";

            currGroupString+= currGroup.toString();
            currGroupString+= "\n";

            tableGroupsString+= currGroupString;
        }

        return tableGroupsString;
    }
}
