package com.example.android.tic_tac_toe.twoplayers;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.tic_tac_toe.R;

import static android.graphics.Color.GREEN;

public class MultiPlayersEasyModeActivity extends AppCompatActivity implements View.OnClickListener {

    // This method declares the 2D Array for the game
    private Button[][] buttons = new Button[3][3];

    // This method set X as the first player whenever a new game is started

    private boolean xTurn = true;

    // This method declares count round for the buttons when they are pressed. It counts the first button to the last button
    private int roundCount;

    // This method declares the point scored by x and o
    private int xPoints;
    private int oPoints;

    // This method declares the Turn Board
    private TextView turnBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_players_3_x_3_mode);

        turnBoard = findViewById(R.id.multiPlayersEasyTurn);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById((resID));
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.multiPlayersResetButton);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }

        if (xTurn) {
            ((Button) view).setText("X");
            ((Button) view).setTextColor(GREEN);
            turnBoard.setText(R.string.o_turn);
        } else {
            ((Button) view).setText("O");
            ((Button) view).setTextColor(Color.BLUE);
            turnBoard.setText(R.string.x_turn);
        }

        roundCount++;

        if (checkWhoWon()) {
            if (xTurn) {
                xWins();
            } else {
                oWins();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            xTurn = !xTurn;
        }
    }


    private boolean checkWhoWon() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }

        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }

        return false;

    }

    private void xWins() {
        xPoints++;
        updatePoints();
        reset();
        turnBoard.setText(R.string.x_wins);
    }

    private void oWins() {
        oPoints++;
        updatePoints();
        reset();
        turnBoard.setText(R.string.o_wins);
    }

    private void draw() {
        reset();
        turnBoard.setText(R.string.draw_game);
    }

    private void updatePoints() {
        TextView multiPlayersEasyScoreCounterForX = (TextView) findViewById(R.id.multiPlayersEasyScoreCounterForX);
        multiPlayersEasyScoreCounterForX.setText("" + xPoints);

        TextView multiPlayersEasyScoreCounterForO = (TextView) findViewById(R.id.multiPlayersEasyScoreCounterForO);
        multiPlayersEasyScoreCounterForO.setText("" + oPoints);
    }

    private void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                buttons[i][j].setText("");
        }

        roundCount = 0;
        xTurn = true;

    }

    private void resetGame() {
        xPoints = 0;
        oPoints = 0;
        updatePoints();
        reset();
        turnBoard.setText(R.string.x_turn);
    }
}
