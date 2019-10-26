package com.khusainov.rinat.tictactoe;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int gridSize = 3;
    private static int clickCounter = 0;
    private static int crossWins = 0;
    private static int circleWins = 0;

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

    private GameHelper mGameHelper;
    private boolean gameOver = false;
    private int xo = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultLayout = findViewById(R.id.result_layout);
        mWinnerTextView = findViewById(R.id.tv_winner);
        mCrossCount = findViewById(R.id.tv_cross_count);
        mCircleCount = findViewById(R.id.tv_circle_count);

        mGameHelper = new GameHelper(gridSize);
        mGameHelper.initGrid();

        initButtons();
        setResultCount();
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
                Toast.makeText(this, getResources().getString(R.string.change_another_box), Toast.LENGTH_SHORT).show();
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

            // Заполнение поля выбранным символом и получение Id нажатой кнопки
            int pushedButtonId = setFields(button);

            // Игра закончена, есть победитель
            gameOver(pushedButtonId);

            // Игра закончена, ничья
            gameOverDraw();
        }
    }

    private int setFields(Button button) {
        int buttonId = 0;
        switch (button.getId()) {
            case R.id.topLeftButton:
                mGameHelper.setXO(0, 0, xo);
                buttonId = 1;
                break;
            case R.id.topCenterButton:
                mGameHelper.setXO(1, 0, xo);
                buttonId = 2;
                break;
            case R.id.topRightButton:
                mGameHelper.setXO(2, 0, xo);
                buttonId = 3;
                break;
            case R.id.leftCenterButton:
                mGameHelper.setXO(0, 1, xo);
                buttonId = 4;
                break;
            case R.id.centerButton:
                mGameHelper.setXO(1, 1, xo);
                buttonId = 5;
                break;
            case R.id.rightCenterButton:
                mGameHelper.setXO(2, 1, xo);
                buttonId = 6;
                break;
            case R.id.bottomLeftButton:
                mGameHelper.setXO(0, 2, xo);
                buttonId = 7;
                break;
            case R.id.bottomCenterButton:
                mGameHelper.setXO(1, 2, xo);
                buttonId = 8;
                break;
            case R.id.bottomRightButton:
                mGameHelper.setXO(2, 2, xo);
                buttonId = 9;
                break;
        }
        return buttonId;
    }

    private void gameOver(int buttonId) {
        if (mGameHelper.gameOver(buttonId)) {
            gameOver = true;
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
            setResultCount();
            showGameResult();
        }
    }

    private void gameOverDraw() {
        if (++clickCounter == 9) {
            gameOver = true;
            mWinnerTextView.setText(getResources().getString(R.string.draw));
            showGameResult();
        }
    }

    private void setResultCount() {
        mCrossCount.setText(String.valueOf(crossWins));
        mCircleCount.setText(String.valueOf(circleWins));
    }

    public void showGameResult() {
        mResultLayout.setVisibility(View.VISIBLE);
    }

    public void restartGame(View view) {
        mGameHelper.initGrid();
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
