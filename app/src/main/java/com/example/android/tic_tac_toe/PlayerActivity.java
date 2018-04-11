package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.tic_tac_toe.twoplayers.MultiPlayersActivity;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }

    public void single_player_clicked(View view) {
        Intent intent = new Intent(PlayerActivity.this, GameTypeActivity.class);
        startActivity(intent);
    }

    public void multi_players_clicked(View view) {
        Intent intent = new Intent(PlayerActivity.this, MultiPlayersActivity.class);
        startActivity(intent);
    }
}
