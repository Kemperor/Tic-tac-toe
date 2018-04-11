package com.example.android.tic_tac_toe.single3x3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.tic_tac_toe.R;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;

/**
 * Created by Kingsley Onyekwele on 4/8/2018.
 */

public class GameScreen extends AppCompatActivity {

    private Button btnTL, btnTM, btnTR;
    private Button btnML, btnMM, btnMR;
    private Button btnBL, btnBM, btnBR;
    private TextView humanPlayerScoreBoard, computerScoreBoard;
    private SinglePlayer3x3GameLogic game;
    public TextView turnBoard;

    private int aiOption = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_3_x_3);

        turnBoard = (TextView)findViewById(R.id.singlePlayer3x3Turn);

        Bundle bundle=getIntent().getExtras();
        aiOption=bundle.getInt("option");


        btnTL = (Button)findViewById(R.id.single_button_00);
        btnTM = (Button)findViewById(R.id.single_button_01);
        btnTR = (Button)findViewById(R.id.single_button_02);
        btnML = (Button)findViewById(R.id.single_button_10);
        btnMM = (Button)findViewById(R.id.single_button_11);
        btnMR = (Button)findViewById(R.id.single_button_12);
        btnBL = (Button)findViewById(R.id.single_button_20);
        btnBM = (Button)findViewById(R.id.single_button_21);
        btnBR = (Button)findViewById(R.id.single_button_22);

        humanPlayerScoreBoard = (TextView)findViewById(R.id.human_score_board);
        computerScoreBoard = (TextView)findViewById(R.id.computer_score_board);


        if (aiOption==1){
            game = new Single3x3EasyMode();
        }else if (aiOption==2){ //aiOption==3
            game = new Single3x3NormalMode();
        }else //aiOption==4
            game = new Single3x3HardModel();

        game.setController(this);
        game.resetBoard();

        btnTL.setOnClickListener(event -> game.genericButtonClick(0, 0));
        btnTM.setOnClickListener(event -> game.genericButtonClick(1, 0));
        btnTR.setOnClickListener(event -> game.genericButtonClick(2, 0));
        btnML.setOnClickListener(event -> game.genericButtonClick(0, 1));
        btnMM.setOnClickListener(event -> game.genericButtonClick(1, 1));
        btnMR.setOnClickListener(event -> game.genericButtonClick(2, 1));
        btnBL.setOnClickListener(event -> game.genericButtonClick(0, 2));
        btnBM.setOnClickListener(event -> game.genericButtonClick(1, 2));
        btnBR.setOnClickListener(event -> game.genericButtonClick(2, 2));
    }

    public void createOverlay(String strMessage){
    }

    public void resetButtons() {

        //lblStatus.setText(blank);
        btnTL.setText("");
        btnTM.setText("");
        btnTR.setText("");
        btnML.setText("");
        btnMM.setText("");
        btnMR.setText("");
        btnBL.setText("");
        btnBM.setText("");
        btnBR.setText("");

    }

    public void setBtnText(int i, int j,String text){
        if (i == 0 && j==0) btnTL.setText(text);
        else if (i == 1 && j==0) btnTM.setText(text);
        else if (i == 2 && j==0) btnTR.setText(text);
        else if (i == 0 && j==1) btnML.setText(text);
        else if (i == 1 && j==1) btnMM.setText(text);
        else if (i == 2 && j==1) btnMR.setText(text);
        else if (i == 0 && j==2) btnBL.setText(text);
        else if (i == 1 && j==2) btnBM.setText(text);
        else if (i == 2 && j==2) btnBR.setText(text);
    }

    public void turnBoard(String text) {turnBoard.setText(text);
    }


    public void setBanner(String text){

    }

    public void setHumanPlayerScoreBoard(int score){
        humanPlayerScoreBoard.setText(String.valueOf(score));
        humanPlayerScoreBoard.setTextColor(GREEN);
    }
    public void setComputerScoreBoard(int score){
        computerScoreBoard.setText(String.valueOf(score));
        computerScoreBoard.setTextColor(BLUE);
    }
    public void setAiOption(int x){aiOption=x;}

    public int getAiOption(){return aiOption;}

    public void single_player_3_by_3_reset_clicked(View view) {
        resetButtons();
        setHumanPlayerScoreBoard(0);
        setComputerScoreBoard(0);
    }
}