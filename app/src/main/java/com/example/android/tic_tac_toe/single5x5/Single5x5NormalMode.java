package com.example.android.tic_tac_toe.single5x5;

import java.util.Random;

/**
 * Created by Kingsley Onyekwele on 4/8/2018.
 */

public class Single5x5NormalMode extends Single5x5ComputerLogic {

    public Single5x5NormalMode() {
    }

    protected void generateMove() {

        Random rngX = new Random();
        Random rngY = new Random();

        do {
            moveX = rngX.nextInt(5);
            moveY = rngY.nextInt(5);
        } while ((board[moveX][moveY] != 0));
    }
}
