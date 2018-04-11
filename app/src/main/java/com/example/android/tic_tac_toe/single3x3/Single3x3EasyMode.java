package com.example.android.tic_tac_toe.single3x3;

import java.util.Random;

/**
 * Created by Kingsley Onyekwele on 4/8/2018.
 */

public class Single3x3EasyMode extends Single3x3ComputerLogic {

    public Single3x3EasyMode() {
    }

    public void generateMove() {

        Random rngX = new Random();
        Random rngY = new Random();

        do {
            moveX = rngX.nextInt(3);
            moveY = rngY.nextInt(3);
        } while ((board[moveX][moveY] != 0));
    }
}
