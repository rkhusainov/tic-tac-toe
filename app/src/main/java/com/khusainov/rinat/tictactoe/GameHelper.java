package com.khusainov.rinat.tictactoe;

public class GameHelper {
    private int[][] ticTacToe;
    private int mGridSize;

    public GameHelper(int gridSize) {
        ticTacToe = new int[gridSize][gridSize];
        mGridSize = gridSize;
    }

    void initGrid() {
        for (int i = 0; i < mGridSize; i++) {
            for (int j = 0; j < mGridSize; j++) {
                ticTacToe[i][j] = -1;
            }
        }
    }

    /**
     * @param row    номер строки
     * @param column номер столбца
     * @param xo     значение 0 - O или 1 - X
     */
    void setXO(int row, int column, int xo) {
        ticTacToe[row][column] = xo;
    }

    /**
     * @param buttonId ID нажатой кнопки
     * @return true - есть победитель, false - нет победителя
     */
    boolean gameOver(int buttonId) {
        switch (buttonId) {
            case 1:
                if (ticTacToe[0][0] == ticTacToe[0][1] && ticTacToe[0][0] == ticTacToe[0][2]) {
                    return true;
                }
                if (ticTacToe[0][0] == ticTacToe[1][0] && ticTacToe[0][0] == ticTacToe[2][0]) {
                    return true;
                }
                if (ticTacToe[0][0] == ticTacToe[1][1] && ticTacToe[0][0] == ticTacToe[2][2]) {
                    return true;
                }
                break;
            case 2:
                if (ticTacToe[1][0] == ticTacToe[0][0] && ticTacToe[1][0] == ticTacToe[2][0]) {
                    return true;
                }
                if (ticTacToe[1][0] == ticTacToe[1][1] && ticTacToe[1][0] == ticTacToe[1][2]) {
                    return true;
                }
                break;
            case 3:
                if (ticTacToe[2][0] == ticTacToe[0][0] && ticTacToe[2][0] == ticTacToe[1][0]) {
                    return true;
                }
                if (ticTacToe[2][0] == ticTacToe[1][1] && ticTacToe[2][0] == ticTacToe[0][2]) {
                    return true;
                }
                if (ticTacToe[2][0] == ticTacToe[2][1] && ticTacToe[2][0] == ticTacToe[2][2]) {
                    return true;
                }
                break;
            case 4:
                if (ticTacToe[0][1] == ticTacToe[0][0] && ticTacToe[0][1] == ticTacToe[0][2]) {
                    return true;
                }
                if (ticTacToe[0][1] == ticTacToe[1][1] && ticTacToe[0][1] == ticTacToe[2][1]) {
                    return true;
                }
                break;
            case 5:
                if (ticTacToe[1][1] == ticTacToe[0][0] && ticTacToe[1][1] == ticTacToe[2][2]) {
                    return true;
                }
                if (ticTacToe[1][1] == ticTacToe[2][0] && ticTacToe[1][1] == ticTacToe[0][2]) {
                    return true;
                }
                if (ticTacToe[1][1] == ticTacToe[1][0] && ticTacToe[1][1] == ticTacToe[1][2]) {
                    return true;
                }
                if (ticTacToe[1][1] == ticTacToe[0][1] && ticTacToe[1][1] == ticTacToe[2][1]) {
                    return true;
                }
                break;
            case 6:
                if (ticTacToe[2][1] == ticTacToe[2][0] && ticTacToe[2][1] == ticTacToe[2][2]) {
                    return true;
                }
                if (ticTacToe[2][1] == ticTacToe[0][1] && ticTacToe[2][1] == ticTacToe[1][1]) {
                    return true;
                }
                break;
            case 7:
                if (ticTacToe[0][2] == ticTacToe[1][2] && ticTacToe[0][2] == ticTacToe[2][2]) {
                    return true;
                }
                if (ticTacToe[0][2] == ticTacToe[1][1] && ticTacToe[0][2] == ticTacToe[2][0]) {
                    return true;
                }
                if (ticTacToe[0][2] == ticTacToe[0][0] && ticTacToe[0][2] == ticTacToe[0][1]) {
                    return true;
                }
                break;
            case 8:
                if (ticTacToe[1][2] == ticTacToe[0][2] && ticTacToe[1][2] == ticTacToe[2][2]) {
                    return true;
                }
                if (ticTacToe[1][2] == ticTacToe[1][1] && ticTacToe[1][2] == ticTacToe[1][0]) {
                    return true;
                }
                break;
            case 9:
                if (ticTacToe[2][2] == ticTacToe[1][2] && ticTacToe[2][2] == ticTacToe[0][2]) {
                    return true;
                }
                if (ticTacToe[2][2] == ticTacToe[1][1] && ticTacToe[2][2] == ticTacToe[0][0]) {
                    return true;
                }
                if (ticTacToe[2][2] == ticTacToe[2][1] && ticTacToe[2][2] == ticTacToe[2][0]) {
                    return true;
                }
                break;
        }
        return false;
    }
}
