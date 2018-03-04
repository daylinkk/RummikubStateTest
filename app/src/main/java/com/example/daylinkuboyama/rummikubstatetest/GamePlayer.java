package com.example.daylinkuboyama.rummikubstatetest;

/**
 * Created by lytle on 3/4/2018.
 */

public interface GamePlayer {

    public abstract void gameSetAsGui(MainActivity activity);

    // sets this player as the GUI player (overrideable)
    public abstract void setAsGui(MainActivity activity);

    // sends a message to the player
    //public abstract void sendInfo(GameInfo info);

    // start the player
    public abstract void start();

    // whether this player requires a GUI
    public boolean requiresGui();

    // whether this player supports a GUI
    public boolean supportsGui();
}
