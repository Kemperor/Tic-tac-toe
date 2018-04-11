package com.example.android.tic_tac_toe.single5x5;

/**
 * Created by Kingsley Onyekwele on 4/8/2018.
 */

        /*
        This class will conduct the computer basics
        */

public class Single5x5ComputerLogic extends SinglePlayer5x5GameLogic {

    public int moveX, moveY;
    public int[][] testBoard = new int[5][5];
    public boolean computerTurn = false;

    public Single5x5ComputerLogic() {
    }

    public int genericButtonClick(int i, int j) {
        if (board[i][j] != 0) return 0;

        if (player == 1) {
            setBoard(i, j);
            controller.setBtnText(i, j, humanPlayer);
        } else { //(player==2)
            setBoard(i, j);
            controller.setBtnText(i, j, computer);
        }

        checkBoard();
        switchPlayer();

        computerTurn = !computerTurn;

        if (computerTurn) createMove();

        return 1; //move was successful
    }

    protected void createMove() {
        //return SinglePlayer5x35ameLogic.genericBtnClick(window.getScene().getClass(),btnTL,moveX,moveY);
        //If future move returns true, that means moveX and moveY are already configured.
        //if it returns false, then AI needs to create its own move
        if (!checkFutureMove())
            generateMove();
        genericButtonClick(moveX, moveY);
    }

    /*Method that reads the available places to move in SinglePlayer3x3GameLogic
     * and moves to it
    */

    public boolean checkFutureMove() {
        //Get a copy of the board
        //Systematically iterate through the board, putting in an move at each square
        //and then check to see if it would be a winning move. If it is, then put a place there.
        //This checks two things, if the user will win with that move, and if the computer will win with that move
        //generate a move (1-6, as long as it is not already occupied)
        //test move as player (if player will win, then move there)
        //then test move as computer (if computer will win, then move there)

        int computer = player;
        int user; //opposite of player

        if (player == 1)
            user = 2;
        else
            user = 1;

        stupidArrayCopy(board, testBoard);

        //Check if the computer can win first
        for (moveX = 0; moveX < 5; moveX++) {
            for (moveY = 0; moveY < 5; moveY++) {
                if (testBoard[moveX][moveY] == 0) {
                    testBoard[moveX][moveY] = computer;
                    if (checkBoardDirections(testBoard))
                        return true;
                }
                stupidArrayCopy(board, testBoard);
            }
        }

        for (moveX = 0; moveX < 5; moveX++) {
            for (moveY = 0; moveY < 5; moveY++) {
                if (testBoard[moveX][moveY] == 0) {
                    testBoard[moveX][moveY] = user;
                    if (checkBoardDirections(testBoard))
                        return true;
                }
                stupidArrayCopy(board, testBoard);
            }
        }
        return false;
    }

    protected void generateMove() {
    }

    public void stupidArrayCopy(int[][] arraySrc, int[][] arrayDest) {
        int x;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                x = arraySrc[i][j];
                arrayDest[i][j] = x;
            }
        }
    }
}