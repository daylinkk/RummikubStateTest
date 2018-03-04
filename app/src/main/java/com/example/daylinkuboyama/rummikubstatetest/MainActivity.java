package com.example.daylinkuboyama.rummikubstatetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RummikubState state= new RummikubState();

        Log.i("TAG",state.toString());
    }
}
