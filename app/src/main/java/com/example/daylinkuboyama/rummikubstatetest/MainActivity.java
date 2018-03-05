package com.example.daylinkuboyama.rummikubstatetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button runTestButton = (Button)findViewById(R.id.buttonRunTest);
    EditText runTestText = (EditText) findViewById(R.id.editTextRunTest);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RummikubState state= new RummikubState();

        RummikubState state2 = new RummikubState(state, 0);

        Log.i("TAG",state.toString());
        Log.i("TAG",state2.toString());
    }

    @Override
    //listener for the runTest button

    public void onClick(View v) {

    }

}
