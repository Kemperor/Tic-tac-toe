package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.tic_tac_toe.single3x3.SinglePlayer3x3SelectionScreenActivity;
import com.example.android.tic_tac_toe.single5x5.GameScreen5x5;

public class GameTypeActivity extends AppCompatActivity {

    Button fiveByFiveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type);

        fiveByFiveButton = (Button) findViewById(R.id.five_by_five);
        fiveByFiveButton.setOnClickListener(e -> activityStart(1));
    }

    public void single_three_by_three_clicked(View view) {
        Intent intent = new Intent(GameTypeActivity.this, SinglePlayer3x3SelectionScreenActivity.class);
        startActivity(intent);
    }


    void activityStart(int option) {
        Intent i = new Intent(getApplicationContext(), GameScreen5x5.class);
        i.putExtra("option", option);
        startActivity(i);
    }
}
