package com.example.android.tic_tac_toe.single3x3;

import java.util.Random;

/**
 * Created by Kingsley Onyekwele on 4/8/2018.
 */

public class Single3x3NormalMode extends Single3x3ComputerLogic {

    public Single3x3NormalMode() {
    }

    public void generateMove() {
        int middle = 1;
        if (playerHasACorner() && board[middle][middle] == 0) {
            moveX = moveY = middle;
        } else if (cornerIsAvailable()) {
            moveToACorner();
        } else if (board[middle][middle] == 0) {
            moveX = moveY = middle;
        } else if (sideIsAvailable()) {
            moveToASide();
        }
    }

    //Returns true if user has a corner
    private boolean playerHasACorner() {
        return (board[0][0] != 0 && board[0][0] != player) || (board[0][2] != 0 && board[0][2] != player)
                || (board[2][0] != 0 && board[2][0] != player) || (board[2][2] != 0 && board[2][2] != player);
    }

    private boolean cornerIsAvailable() {
        return (board[0][0] == 0 || board[2][0] == 0 || board[0][2] == 0 || board[2][2] == 0);
    }

    private boolean sideIsAvailable() {
        return (board[1][0] == 0 || board[0][1] == 0 || board[2][1] == 0 || board[1][2] == 0);
    }

    //This function enables the computer or AI move to the corners
    private void moveToACorner() {
        int cornerX = 0;
        int cornerY = 0;
        Random rnd = new Random();
        int randomCorner;
        do {
            randomCorner = rnd.nextInt(4);
            if (randomCorner == 0) {
                moveX = cornerX;
                moveY = cornerY;
            } else if (randomCorner == 1) {
                moveX = cornerX + 2;
                moveY = cornerY;
            } else if (randomCorner == 2) {
                moveX = cornerX + 2;
                moveY = cornerY + 2;
            } else {// if(randomCorner==3)
                moveX = cornerX;
                moveY = cornerY + 2;
            }
        } while (board[moveX][moveY] != 0);
    }

    //This function enables the computer or AI move to the sides
    private void moveToASide() {
        int cornerX = 0;
        int cornerY = 0;
        Random rnd = new Random();
        int randomSide;
        do {
            randomSide = rnd.nextInt(4);
            if (randomSide == 0) {
                moveX = cornerX + 1;
                moveY = cornerY;
            } else if (randomSide == 1) {
                moveX = cornerX;
                moveY = cornerY + 1;
            } else if (randomSide == 2) {
                moveX = cornerX + 2;
                moveY = cornerY + 1;
            } else {// if(randomSide==3)
                moveX = cornerX + 1;
                moveY = cornerY + 2;
            }
        } while (board[moveX][moveY] != 0);
    }
}