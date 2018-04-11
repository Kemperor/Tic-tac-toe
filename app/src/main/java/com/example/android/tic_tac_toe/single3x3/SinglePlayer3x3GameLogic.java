package com.example.android.tic_tac_toe.single3x3;

/**
 * Created by Kingsley Onyekwele on 4/8/2018.
 */

public class SinglePlayer3x3GameLogic {

    public final String humanPlayer = "X";
    public final String computer = "O";
    public int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    public int player = 1;
    public int[] score = {0, 0};
    public GameScreen controller;


    public SinglePlayer3x3GameLogic() {
    }


    public void setController(GameScreen controller) {
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

        player = player ^ 3;
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
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[x][y] == 0) return false;
            }
        }

        return true;
    }

    //This function reset the game immediate the board is full or if there is a winner
    public void resetBoard() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = 0;
            }
        }
        controller.resetButtons();
    }

    public boolean checkBoardDirections(int[][] testBoard) {

        //Check columns
        for (int x = 0; x < 3; x++) {
            if (testBoard[x][0] != 0 && testBoard[x][0] == testBoard[x][1] && testBoard[x][1] == testBoard[x][2])
                return true;
        }

        //Check rows
        for (int y = 0; y < 3; y++) {
            if (testBoard[0][y] != 0 && testBoard[0][y] == testBoard[1][y] && testBoard[1][y] == testBoard[2][y])
                return true;
        }

        //Diagonal right
        if (testBoard[0][0] != 0 && testBoard[0][0] == testBoard[1][1] && testBoard[1][1] == testBoard[2][2]) {
            return true;
        }

        //Diagonal Left
        if (testBoard[0][2] != 0 && testBoard[0][2] == testBoard[1][1] && testBoard[1][1] == testBoard[2][0]) {
            return true;
        }
        return false;
    }

    public void setScore(int choice) {
        if (choice == 1) { //A single player won
            score[player - 1] += 1;
        } else {
            //players tied
//            score[0]+=1;
//            score[1]+=1;
        }
        controller.setHumanPlayerScoreBoard(score[0]);
        controller.setComputerScoreBoard(score[1]);
    }
}