package com.example.daylinkuboyama.rummikubstatetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Instance Variables
    private Button runTestButton;
    private EditText runTestText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting instance variables
        runTestButton = (Button)findViewById(R.id.buttonRunTest);
        runTestText = (EditText)findViewById(R.id.editTextRunTest);

        runTestButton.setOnClickListener(this);

        //RummikubState state= new RummikubState();

        //RummikubState state2 = new RummikubState(state);

        //Log.i("TAG",state.toString());
        //Log.i("TAG",state2.toString());
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



        //creates a new instance of gamestate
        RummikubState thirdInstance = new RummikubState();

        //creates a deep copy of third instance in perspective of player 1
        RummikubState fourthInstance = new RummikubState(thirdInstance,0);

        //call twoString methods on instance 2 and 4
        //print both strings to edit text
        runTestText.append(thirdInstance.toString());
        runTestText.append(thirdInstance.toString());



    }

}
