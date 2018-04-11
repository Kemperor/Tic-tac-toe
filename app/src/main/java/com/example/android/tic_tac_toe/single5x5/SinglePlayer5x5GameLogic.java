package com.example.android.tic_tac_toe.single5x5;

/**
 * Created by Kingsley Onyekwele on 4/8/2018.
 */

public class SinglePlayer5x5GameLogic {

    public final String humanPlayer = "X";
    public final String computer = "O";
    public int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
    public int player = 1;
    public int[] score = {0, 0};
    public GameScreen5x5 controller;


    public SinglePlayer5x5GameLogic() {
    }


    public void setController(GameScreen5x5 controller) {
        this.controller = controller;
    }

    public int genericButtonClick(int i, int j) {
        if (board[i][j] != 0) return 0;

        if (board[i][j] == 0 && player == 1) {
            setBoard(i, j);
            controller.setBtnText(i, j, humanPlayer);
        } else if (board[i][j] == 0 && player == 2) {
            setBoard(i, j);
            controller.setBtnText(i, j, computer);
        }

        checkBoard();
        switchPlayer();

        return 1; //move was successful
    }

    public void switchPlayer() {

        player = player ^ 5;
    }

    public void setBoard(int x, int y) {
        board[x][y] = player;
    }

    //If someone won, then display message and reset board
    public void checkBoard() {
        if (checkBoardDirections(board)) {
            setScore(1);
            resetBoard();
        } else if (checkFullBoard()) {

            setScore(2);
            resetBoard();
        }
    }

    public boolean checkFullBoard() {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (board[x][y] == 0) return false;
            }
        }

        return true;
    }

    public void resetBoard() {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                board[x][y] = 0;
            }
        }
        controller.resetButtons();
    }

    public boolean checkBoardDirections(int[][] testBoard) {

        //Check columns
        for (int x = 0; x < 5; x++) {
            if (testBoard[x][0] != 0 && testBoard[x][0] == testBoard[x][1] && testBoard[x][1] == testBoard[x][2]
                    && testBoard[x][2] == testBoard[x][3] && testBoard[x][3] == testBoard[x][4])
                return true;
        }

        //Check rows
        for (int y = 0; y < 5; y++) {
            if (testBoard[0][y] != 0 && testBoard[0][y] == testBoard[1][y] && testBoard[1][y] == testBoard[2][y]
                    && testBoard[2][y] == testBoard[3][y] && testBoard[3][y] == testBoard[4][y])
                return true;
        }

        //Diagonal from left top to right bottom
        if (testBoard[0][0] != 0 && testBoard[0][0] == testBoard[1][1] && testBoard[1][1] == testBoard[2][2]
                && testBoard[2][2] == testBoard[3][3] && testBoard[3][3] == testBoard[4][4]) {
            return true;
        }

        //Diagonal from right top to left bottom
        if (testBoard[0][4] != 0 && testBoard[0][4] == testBoard[1][3] && testBoard[1][3] == testBoard[2][2]
                && testBoard[2][2] == testBoard[3][1] && testBoard[3][1] == testBoard[4][0]) {
            return true;
        }
        return false;
    }

    public void setScore(int choice) {
        if (choice == 1) { //A single player won
            score[player - 1] += 1;
        } else {
            /*players tied
            score[0]+=1;
            score[1]+=1; */
        }
        controller.setHumanPlayerScoreBoard(score[0]);
        controller.setComputerScoreBoard(score[1]);
    }

}