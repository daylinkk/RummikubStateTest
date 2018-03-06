package com.example.daylinkuboyama.rummikubstatetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Instance Variables
    private Button runTestButton;
    private TextView runTestText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting instance variables
        runTestButton = (Button)findViewById(R.id.buttonRunTest);
        runTestText = (TextView)findViewById(R.id.editTextRunTest);

        runTestButton.setOnClickListener(this);

        onClick(runTestButton);
    }

    //@Override
    //listener for the runTest button

    public void onClick(View v) {
        runTestText.setText("");

        //creates a new instance of the game
        RummikubState firstInstance = new RummikubState();

        //calls copy constructor in rummikub state and makes copy of first instance
        //perspective of player 1
        RummikubState secondInstance = new RummikubState(firstInstance,0);

        //below call action methods and print want is happening to edit text
        if (firstInstance.canDraw(0)) {
            runTestText.append("Player 0 draws tile from deck\n");
        }
        if (firstInstance.canPlayTile(1,2)) {
            runTestText.append("Player 1 plays tile from hand\n");
        }
        if (firstInstance.canUndo(1)) {
            runTestText.append("Player 1 undoes prev play of tile from hand\n");
        }
        if (firstInstance.canPlayTile(1, 2)) {
            runTestText.append ("Player 1 plays a tile\n");
        }
        if (firstInstance.canPlayTile(1, 2)) {
            runTestText.append ("Player 1 plays a tile\n");
        }
        if (firstInstance.canConnect(1, 0, 1)) {
            runTestText.append ("tile 1 and tile 2 connected by player 1!\n");
        }
        if (firstInstance.canPlayTile(1, 11)) {
            runTestText.append ("Player 1 plays a tile\n");
        }
        if (firstInstance.canConnect(1, 0, 1)) {
            runTestText.append ("tile 1,2 and tile 3 connected by player 1!\n");
        }
        if (firstInstance.canKnock(1)) {
            runTestText.append ("player 1 knocked\n");
        }



        //creates a new instance of gamestate
        RummikubState thirdInstance = new RummikubState();

        //creates a deep copy of third instance in perspective of player 1
        RummikubState fourthInstance = new RummikubState(thirdInstance,0);

        //call twoString methods on instance 2 and 4
        //print both strings to edit text
        String secondString= secondInstance.toString();
        String fourthString= secondInstance.toString();

        runTestText.append(thirdInstance.toString());
        runTestText.append("---------------------------------------------------------------------------------------\n");
        //runTestText.append(secondString);
        //runTestText.append("---------------------------------------------------------------------------------------\n");
        runTestText.append(firstInstance.toString());
        //runTestText.append("---------------------------------------------------------------------------------------\n");
       // runTestText.append(fourthString);



        runTestText.append("\n\n\n\n\n"
                + secondString.equals(fourthString));

    }

}
