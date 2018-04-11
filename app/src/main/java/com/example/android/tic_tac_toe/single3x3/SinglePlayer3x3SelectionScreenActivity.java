package com.example.android.tic_tac_toe.single3x3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.android.tic_tac_toe.R;

public class SinglePlayer3x3SelectionScreenActivity extends AppCompatActivity {


    Button easyButton;
    Button normalButton;
    Button hardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_difficulty_screen);

        easyButton = (Button) findViewById(R.id.easy);
        normalButton = (Button) findViewById(R.id.normal);
        hardButton = (Button) findViewById(R.id.hard);

        easyButton.setOnClickListener(e -> activityStart(1));
        normalButton.setOnClickListener(e -> activityStart(2));
        hardButton.setOnClickListener(e -> activityStart(3));
    }

    void activityStart(int option) {
        Intent i = new Intent(getApplicationContext(), GameScreen.class);
        i.putExtra("option", option);
        startActivity(i);
    }
}
