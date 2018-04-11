package com.example.android.tic_tac_toe.single3x3;

/**
 * Created by Kingsley Onyekwele on 4/8/2018.
 */

public class Single3x3HardModel extends Single3x3ComputerLogic {
    public int computerTestBoard[][] = new int[3][3];

    public Single3x3HardModel() {
    }

    @Override
    protected void generateMove() {
        /* This uses the minimax algorithm to generate a move
        */

        int score = -2;

        //now we have a copy of the game board
        stupidArrayCopy(board, computerTestBoard);
        int testPlayer;
        if (player == 2) testPlayer = 1;
        else testPlayer = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerTestBoard[i][j] != 0) break; //space is already occupied
                computerTestBoard[i][j] = testPlayer;
                int tempScore = -minimax(computerTestBoard, testPlayer);
                computerTestBoard[i][j] = 0;
                if (tempScore > score) {
                    moveX = i;
                    moveY = j;
                }
            }
        }
    }

    // The function declaration for minimax
    // This sets the behaviour of the computer
    private int minimax(int[][] computerTestBoard, int player) {
        boolean winner = checkBoardDirections(computerTestBoard);
        if (winner) return 10 * (player);

        int x = -1, y = -1;
        int score = -2;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerTestBoard[i][j] != 0) break; //space is already occupied
                computerTestBoard[i][j] = player;
                int thisScore = -minimax(computerTestBoard, player * (-1));
                if (thisScore > score) {
                    score = thisScore;
                    x = i;
                    y = j;
                }
                computerTestBoard[i][j] = 0;
            }
        }

        if (x == -1 || y == -1) {
            return 0;
        }
        return score;
    }

    //calculate if someone won or not
    private boolean noMoreMoves() {
        return false;
    }
}