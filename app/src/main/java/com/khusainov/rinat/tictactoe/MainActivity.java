package com.khusainov.rinat.tictactoe;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int clickCounter = 0;

    private Button mTopLeftButton;
    private Button mTopCenterButton;
    private Button mTopRightButton;
    private Button mLeftCenterButton;
    private Button mCenterButton;
    private Button mRightCenterButton;
    private Button mBottomLeftButton;
    private Button mBottomCenterButton;
    private Button mBottomRightButton;
    private List<View> mButtons;
    private TextView mCrossCount;
    private TextView mCircleCount;
    private View mResultLayout;
    private TextView mWinnerTextView;

    private static int crossWins = 0;
    private static int circleWins = 0;
    private boolean gameOver = false;
    private int gridSize = 3;
    private int[][] ticTacToe = new int[gridSize][gridSize];
    private int xo = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultLayout = findViewById(R.id.result_layout);
        mWinnerTextView = findViewById(R.id.tv_winner);
        mCrossCount = findViewById(R.id.tv_cross_count);
        mCircleCount = findViewById(R.id.tv_circle_count);

        initGrid();
        initButtons();
        setResult();
    }

    private void initGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                ticTacToe[i][j] = -1;
            }
        }
    }

    private void initButtons() {
        mButtons = new ArrayList<>();

        mTopLeftButton = findViewById(R.id.topLeftButton);
        mTopCenterButton = findViewById(R.id.topCenterButton);
        mTopRightButton = findViewById(R.id.topRightButton);
        mLeftCenterButton = findViewById(R.id.leftCenterButton);
        mCenterButton = findViewById(R.id.centerButton);
        mRightCenterButton = findViewById(R.id.rightCenterButton);
        mBottomLeftButton = findViewById(R.id.bottomLeftButton);
        mBottomCenterButton = findViewById(R.id.bottomCenterButton);
        mBottomRightButton = findViewById(R.id.bottomRightButton);

        mButtons.add(mTopLeftButton);
        mButtons.add(mTopCenterButton);
        mButtons.add(mTopRightButton);
        mButtons.add(mLeftCenterButton);
        mButtons.add(mCenterButton);
        mButtons.add(mRightCenterButton);
        mButtons.add(mBottomLeftButton);
        mButtons.add(mBottomCenterButton);
        mButtons.add(mBottomRightButton);
    }

    public void pushXO(View view) {
        if (!gameOver) {
            Button button = (Button) view;
            Drawable drawable = button.getBackground();

            // Проверка на второе нажатие по кнопке
            if (drawable.getConstantState() == getResources().getDrawable(R.drawable.circle).getConstantState() ||
                    drawable.getConstantState() == getResources().getDrawable(R.drawable.cross).getConstantState()) {
                Toast.makeText(this, "Выберите другую клетку!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Первый клик X, второй - 0
            if (clickCounter % 2 == 0) {
                button.setBackground(getResources().getDrawable(R.drawable.cross));
                xo = 1;
            } else {
                button.setBackground(getResources().getDrawable(R.drawable.circle));
                xo = 0;
            }

            int buttonId = 0;
            switch (button.getId()) {
                case R.id.topLeftButton:
                    ticTacToe[0][0] = xo;
                    buttonId = 1;
                    Log.i("Button click: ", "0 0");
                    break;
                case R.id.topCenterButton:
                    ticTacToe[1][0] = xo;
                    buttonId = 2;
                    Log.i("Button click: ", "1 0");
                    break;
                case R.id.topRightButton:
                    ticTacToe[2][0] = xo;
                    buttonId = 3;
                    Log.i("Button click: ", "2 0");
                    break;
                case R.id.leftCenterButton:
                    ticTacToe[0][1] = xo;
                    buttonId = 4;
                    Log.i("Button click: ", "0 1");
                    break;
                case R.id.centerButton:
                    ticTacToe[1][1] = xo;
                    buttonId = 5;
                    Log.i("Button click: ", "1 1");
                    break;
                case R.id.rightCenterButton:
                    ticTacToe[2][1] = xo;
                    buttonId = 6;
                    Log.i("Button click: ", "2 1");
                    break;
                case R.id.bottomLeftButton:
                    ticTacToe[0][2] = xo;
                    buttonId = 7;
                    Log.i("Button click: ", "0 2");
                    break;
                case R.id.bottomCenterButton:
                    ticTacToe[1][2] = xo;
                    buttonId = 8;
                    Log.i("Button click: ", "1 2");
                    break;
                case R.id.bottomRightButton:
                    ticTacToe[2][2] = xo;
                    buttonId = 9;
                    Log.i("Button click: ", "2 2");
                    break;
            }

            // Игра закончена
            if (gameOver(buttonId)) {
                gameOver = true;
                showGameResult();
                switch (xo) {
                    case 1:
                        mWinnerTextView.setText(getResources().getString(R.string.cross));
                        crossWins++;
                        break;
                    case 0:
                        mWinnerTextView.setText(getResources().getString(R.string.circle));
                        circleWins++;
                        break;
                }
                setResult();
            }

            if (++clickCounter == 9) {
                gameOver = true;
                mWinnerTextView.setText(getResources().getString(R.string.draw));
                showGameResult();
            }
        }
    }

    public void showGameResult() {
        mResultLayout.setVisibility(View.VISIBLE);
    }

    public boolean gameOver(int buttonId) {
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

    private void setResult() {
        mCrossCount.setText(String.valueOf(crossWins));
        mCircleCount.setText(String.valueOf(circleWins));
    }

    public void restartGame(View view) {
        initButtons();
        initGrid();
        clickCounter = 0;
        gameOver = false;
        mResultLayout.setVisibility(View.GONE);

        for (View btn : mButtons) {
            btn.setBackground(getResources().getDrawable(R.drawable.button_stroke));
        }
    }

    public void quitGame(View view) {
        this.finish();
    }
}
