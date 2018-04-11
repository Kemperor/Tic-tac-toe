package com.example.android.tic_tac_toe.single5x5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.tic_tac_toe.R;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;

/**
 * Created by Esther Onyekwele on 4/8/2018.
 */

public class GameScreen5x5 extends AppCompatActivity {

    public TextView turnBoard;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14,
            btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24;
    private TextView humanPlayerScoreBoard, computerScoreBoard;
    private SinglePlayer5x5GameLogic game;
    private int computerMove = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_5_x_5);

        turnBoard = (TextView) findViewById(R.id.singlePlayer5x5Turn);

        Bundle bundle = getIntent().getExtras();
        computerMove = bundle.getInt("option");


        btn0 = (Button) findViewById(R.id.button_00);
        btn1 = (Button) findViewById(R.id.button_01);
        btn2 = (Button) findViewById(R.id.button_02);
        btn3 = (Button) findViewById(R.id.button_03);
        btn4 = (Button) findViewById(R.id.button_04);
        btn5 = (Button) findViewById(R.id.button_10);
        btn6 = (Button) findViewById(R.id.button_11);
        btn7 = (Button) findViewById(R.id.button_12);
        btn8 = (Button) findViewById(R.id.button_13);
        btn9 = (Button) findViewById(R.id.button_14);
        btn10 = (Button) findViewById(R.id.button_20);
        btn11 = (Button) findViewById(R.id.button_21);
        btn12 = (Button) findViewById(R.id.button_22);
        btn13 = (Button) findViewById(R.id.button_23);
        btn14 = (Button) findViewById(R.id.button_24);
        btn15 = (Button) findViewById(R.id.button_30);
        btn16 = (Button) findViewById(R.id.button_31);
        btn17 = (Button) findViewById(R.id.button_32);
        btn18 = (Button) findViewById(R.id.button_33);
        btn19 = (Button) findViewById(R.id.button_34);
        btn20 = (Button) findViewById(R.id.button_40);
        btn21 = (Button) findViewById(R.id.button_41);
        btn22 = (Button) findViewById(R.id.button_42);
        btn23 = (Button) findViewById(R.id.button_43);
        btn24 = (Button) findViewById(R.id.button_44);

        humanPlayerScoreBoard = (TextView) findViewById(R.id.human_player_score_board);
        computerScoreBoard = (TextView) findViewById(R.id.computer_player_score_board);


        if (computerMove == 1) {
            game = new Single5x5NormalMode();
        }


        game.setController(this);
        game.resetBoard();

        btn0.setOnClickListener(event -> game.genericButtonClick(0, 0));
        btn1.setOnClickListener(event -> game.genericButtonClick(1, 0));
        btn2.setOnClickListener(event -> game.genericButtonClick(2, 0));
        btn3.setOnClickListener(event -> game.genericButtonClick(3, 0));
        btn4.setOnClickListener(event -> game.genericButtonClick(4, 0));
        btn5.setOnClickListener(event -> game.genericButtonClick(0, 1));
        btn6.setOnClickListener(event -> game.genericButtonClick(1, 1));
        btn7.setOnClickListener(event -> game.genericButtonClick(2, 1));
        btn8.setOnClickListener(event -> game.genericButtonClick(3, 1));
        btn9.setOnClickListener(event -> game.genericButtonClick(4, 1));
        btn10.setOnClickListener(event -> game.genericButtonClick(0, 2));
        btn11.setOnClickListener(event -> game.genericButtonClick(1, 2));
        btn12.setOnClickListener(event -> game.genericButtonClick(2, 2));
        btn13.setOnClickListener(event -> game.genericButtonClick(3, 2));
        btn14.setOnClickListener(event -> game.genericButtonClick(4, 2));
        btn15.setOnClickListener(event -> game.genericButtonClick(0, 3));
        btn16.setOnClickListener(event -> game.genericButtonClick(1, 3));
        btn17.setOnClickListener(event -> game.genericButtonClick(2, 3));
        btn18.setOnClickListener(event -> game.genericButtonClick(3, 3));
        btn19.setOnClickListener(event -> game.genericButtonClick(4, 3));
        btn20.setOnClickListener(event -> game.genericButtonClick(0, 4));
        btn21.setOnClickListener(event -> game.genericButtonClick(1, 4));
        btn22.setOnClickListener(event -> game.genericButtonClick(2, 4));
        btn23.setOnClickListener(event -> game.genericButtonClick(3, 4));
        btn24.setOnClickListener(event -> game.genericButtonClick(4, 4));
    }

    public void createOverlay(String strMessage) {
    }

    public void resetButtons() {

        //lblStatus.setText(blank);
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        btn10.setText("");
        btn11.setText("");
        btn12.setText("");
        btn13.setText("");
        btn14.setText("");
        btn15.setText("");
        btn16.setText("");
        btn17.setText("");
        btn18.setText("");
        btn19.setText("");
        btn20.setText("");
        btn21.setText("");
        btn22.setText("");
        btn23.setText("");
        btn24.setText("");
    }

    public void setBtnText(int i, int j, String text) {
        if (i == 0 && j == 0) btn0.setText(text);
        else if (i == 1 && j == 0) btn1.setText(text);
        else if (i == 2 && j == 0) btn2.setText(text);
        else if (i == 3 && j == 0) btn3.setText(text);
        else if (i == 4 && j == 0) btn4.setText(text);
        else if (i == 0 && j == 1) btn5.setText(text);
        else if (i == 1 && j == 1) btn6.setText(text);
        else if (i == 2 && j == 1) btn7.setText(text);
        else if (i == 3 && j == 1) btn8.setText(text);
        else if (i == 4 && j == 1) btn9.setText(text);
        else if (i == 0 && j == 2) btn10.setText(text);
        else if (i == 1 && j == 2) btn11.setText(text);
        else if (i == 2 && j == 2) btn12.setText(text);
        else if (i == 3 && j == 2) btn13.setText(text);
        else if (i == 4 && j == 2) btn14.setText(text);
        else if (i == 0 && j == 3) btn15.setText(text);
        else if (i == 1 && j == 3) btn16.setText(text);
        else if (i == 2 && j == 3) btn17.setText(text);
        else if (i == 3 && j == 3) btn18.setText(text);
        else if (i == 4 && j == 3) btn19.setText(text);
        else if (i == 0 && j == 4) btn20.setText(text);
        else if (i == 1 && j == 4) btn21.setText(text);
        else if (i == 2 && j == 4) btn22.setText(text);
        else if (i == 3 && j == 4) btn23.setText(text);
        else if (i == 4 && j == 4) btn24.setText(text);
    }

    public void turnBoard(String text) {
        turnBoard.setText(text);
    }


    public void setBanner(String text) {
    }

    public void setHumanPlayerScoreBoard(int score) {
        humanPlayerScoreBoard.setText(String.valueOf(score));
        humanPlayerScoreBoard.setTextColor(GREEN);
    }

    public void setComputerScoreBoard(int score) {
        computerScoreBoard.setText(String.valueOf(score));
        computerScoreBoard.setTextColor(BLUE);
    }

    public int getComputerMove() {
        return computerMove;
    }

    public void setComputerMove(int x) {
        computerMove = x;
    }

    public void single_player_5_by_5_reset_clicked(View view) {
        resetButtons();
        setHumanPlayerScoreBoard(0);
        setComputerScoreBoard(0);
    }

    public void resetChecked(View view) {
        resetButtons();
        setHumanPlayerScoreBoard(0);
        setComputerScoreBoard(0);
    }
}