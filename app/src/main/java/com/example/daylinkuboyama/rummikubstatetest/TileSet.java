package com.example.daylinkuboyama.rummikubstatetest;

import android.util.Log;

/**
 * class TileSet
 * Subclass of TileGroup
 * These are valid groups of tiles on the table.
 * Minimum of 3 tiles.
 * A TileSet may be either a book or a run of tiles
 *
 * @author Daylin Kuboyama
 * @author Harry Thoma
 * @author Riley Snook
 * @author Chris Lytle
 */

public class TileSet extends TileGroup {

    private boolean isRun; //for sets: true = run, false = book

    /**
     * Constructor for TileSet
     */
    public TileSet(){
        super();
    }

    /**
     * constructor to make set out of a given group
     *
     * @param group the group to turn into a set
     */
    public TileSet(TileGroup group){
        super();
        if(isRun(group)){
            isRun= true;
        }
        else if(isBook(group)){
            isRun= false;
        }
        else{
            Log.i("TileSet","Invalid Set");
            System.exit(-1);
        }

        for(Tile t : group.tiles){
            this.add(t);
        }
    }

    /**
     * Copy constructor for tileSets
     *
     * @param copyTileSet tileSet to copy
     */
    public TileSet (TileSet copyTileSet){
        super (copyTileSet);
        this.isRun = copyTileSet.isRun;
    }

    /**
     * Check if group is a valid set
     *
     * @param group the group to check
     * @return whether group is a valid set
     */
    public static boolean isValidSet(TileGroup group){
        return (isRun(group) || isBook(group));
    }

    /**
     * Determines whether the group passed in is a run or not
     *
     * @param group the group to check
     * @return whether it is a run
     */
    private static boolean isRun(TileGroup group){
        if(group == null) return false;
        if(group.tiles.size() < 3 || group.tiles.size() > 13) return false;

        //make a copy
        group= new TileGroup(group);
        Tile[] tileAr= new Tile[group.tiles.size()];
        group.tiles.toArray(tileAr);

        //bubble sort the list
        for(int j= tileAr.length -1 ;j>=0;j--){
            for (int i = 0; i < j; i++) {
                if (tileAr[i].getValue() > tileAr[i + 1].getValue()) {
                    Tile temp = tileAr[i];
                    tileAr[i] = tileAr[i + 1];
                    tileAr[i + 1] = temp;
                }
            }
        }

        int tileColor= tileAr[0].getColor();
        //walk array and make sure they are in natural order
        //and all same color
        for(int i=1;i<tileAr.length;i++){
            if(tileAr[i].getColor() != tileColor) return false;
            if(tileAr[i-1].getValue()+1 != tileAr[i].getValue()) return false;
        }

        return true;
    }

    /**
     * Determines whether group passed in is book or not
     *
     * @param group the group to check
     * @return whether it is a book
     */
    private static boolean isBook(TileGroup group){
        if(group == null) return false;
        if(group.tiles.size() < 3 || group.tiles.size() > 4) return false;

        //whether we have seen each color
        boolean seenRed= false;
        boolean seenGreen= false;
        boolean seenBlack= false;
        boolean seenBlue= false;

        int bookVal= group.tiles.get(0).getValue();
        for(Tile t : group.tiles){
            if(t.getValue() != bookVal){
                return false;
            }
            int tileColor= t.getColor();
            if(tileColor == Tile.RED){
                if(seenRed){
                    return false;
                }
                seenRed= true;
            }
            else if(tileColor == Tile.GREEN){
                if(seenGreen){
                    return false;
                }
                seenGreen= true;
            }
            else if(tileColor == Tile.BLACK){
                if(seenBlack){
                    return false;
                }
                seenBlack= true;
            }
            else if(tileColor == Tile.BLUE){
                if(seenBlue){
                    return false;
                }
                seenBlue= true;
            }
        }

        return true;
    }

    /**
     * checks if adding this tile to the set would
     * yeild a valid set
     * @param tile the tile we are checking to add
     * @return whether tile can be added
     */
    public boolean canAdd(Tile tile){
        //adds the tile for checking purposes
        add(tile);

        //check if this is still a valid set
        boolean isValid= isValidSet(this);

        //we don't actually want to change this set
        remove(tile);

        return isValid;
    }

    /**
     * this tile set as a string
     * it will be the tilegroup string
     * immediately followed by a "_"
     * immediately followed by "Book" for a book
     * or "Run" for a run
     *
     * @return a string representation of this tilegroup
     */
    @Override
    public String toString(){
        String groupString= super.toString();

        String typeString= "";
        if(isRun) typeString= "Run";
        else typeString= "Book";

        return groupString + "_" + typeString;
    }
}
