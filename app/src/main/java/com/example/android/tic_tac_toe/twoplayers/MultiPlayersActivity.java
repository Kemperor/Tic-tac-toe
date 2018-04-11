package com.example.android.tic_tac_toe.twoplayers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.tic_tac_toe.R;

public class MultiPlayersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_players);
    }

    public void multi_easy_clicked(View view) {
        Intent intent = new Intent(MultiPlayersActivity.this, MultiPlayersEasyModeActivity.class);
        startActivity(intent);
    }

    public void multi_hard_clicked(View view) {
        Intent intent = new Intent(MultiPlayersActivity.this, MultiPlayersHardModeActivity.class);
        startActivity(intent);
    }
}
