package com.khusainov.rinat.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static int count = 0;

    private Button mTopLeftButton;
    private Button mTopCenterButton;
    private Button mTopRightButton;
    private Button mLeftCenterButton;
    private Button mCenterButton;
    private Button mRightCenterButton;
    private Button mBottomLeftButton;
    private Button mBottomCenterButton;
    private Button mBottomRightButton;


    boolean gameOver = false;
    int[][] ticTacToe = new int[3][3];
    int winner = -1;
    int xo = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();
//        TicTacToeField ticTacToeField = new TicTacToeField(3);
//        ticTacToeField.setFigure();


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = -1;
            }
        }
    }

    private void initButtons() {
        mTopLeftButton = findViewById(R.id.topLeftButton);
        mTopCenterButton = findViewById(R.id.topCenterButton);
        mTopRightButton = findViewById(R.id.topRightButton);
        mLeftCenterButton = findViewById(R.id.leftCenterButton);
        mCenterButton = findViewById(R.id.centerButton);
        mRightCenterButton = findViewById(R.id.rightCenterButton);
        mBottomLeftButton = findViewById(R.id.bottomLeftButton);
        mBottomCenterButton = findViewById(R.id.bottomCenterButton);
        mBottomRightButton = findViewById(R.id.bottomRightButton);

        mTopLeftButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;

            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (count % 2 == 0) {
                        mTopLeftButton.setBackground(getResources().getDrawable(R.drawable.circle));
                        xo = 0;

                    } else {
                        mTopLeftButton.setBackground(getResources().getDrawable(R.drawable.cross));
                        xo = 1;
                    }
                    ticTacToe[0][0] = xo;
                }
                flag = 1;
                count++;
            }
        });

        mTopCenterButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;

            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (count % 2 == 0) {
                        mTopCenterButton.setBackground(getResources().getDrawable(R.drawable.circle));
                        xo = 0;

                    } else {
                        mTopCenterButton.setBackground(getResources().getDrawable(R.drawable.cross));
                        xo = 1;

                    }
                    ticTacToe[1][0] = xo;
                }
                flag = 1;
                count++;
            }
        });


        mTopRightButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;

            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (count % 2 == 0) {
                        mTopRightButton.setBackground(getResources().getDrawable(R.drawable.circle));
                        xo = 0;

                    } else {
                        mTopRightButton.setBackground(getResources().getDrawable(R.drawable.cross));
                        xo = 1;
                    }
                    ticTacToe[2][0] = xo;
                }
                flag = 1;
                count++;
            }
        });


        mLeftCenterButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;

            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (count % 2 == 0) {
                        mLeftCenterButton.setBackground(getResources().getDrawable(R.drawable.circle));
                        xo = 0;

                    } else {
                        mLeftCenterButton.setBackground(getResources().getDrawable(R.drawable.cross));
                        xo = 1;
                    }
                    ticTacToe[0][1] = xo;
                }
                flag = 1;
                count++;
            }
        });


        mCenterButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;

            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (count % 2 == 0) {
                        mCenterButton.setBackground(getResources().getDrawable(R.drawable.circle));
                        xo = 0;

                    } else {
                        mCenterButton.setBackground(getResources().getDrawable(R.drawable.cross));
                        xo = 1;
                    }
                    ticTacToe[1][1] = xo;
                }
                flag = 1;
                count++;
            }
        });

        mRightCenterButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;

            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (count % 2 == 0) {
                        mRightCenterButton.setBackground(getResources().getDrawable(R.drawable.circle));
                        xo = 0;
                    } else {
                        mRightCenterButton.setBackground(getResources().getDrawable(R.drawable.cross));
                        xo = 1;
                    }
                    ticTacToe[1][1] = xo;
                }
                flag = 1;
                count++;
            }
        });


        mBottomLeftButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;

            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (count % 2 == 0) {
                        mBottomLeftButton.setBackground(getResources().getDrawable(R.drawable.circle));
                        xo = 0;

                    } else {
                        mBottomLeftButton.setBackground(getResources().getDrawable(R.drawable.cross));
                        xo = 1;
                    }
                    ticTacToe[0][2] = xo;

                }
                flag = 1;
                count++;
            }
        });


        mBottomCenterButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;

            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (count % 2 == 0) {
                        mBottomCenterButton.setBackground(getResources().getDrawable(R.drawable.circle));
                        xo = 0;

                    } else {
                        mBottomCenterButton.setBackground(getResources().getDrawable(R.drawable.cross));
                        xo = 1;
                    }
                    ticTacToe[1][2] = xo;

                }
                flag = 1;
                count++;
            }
        });


        mBottomRightButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;

            @Override
            public void onClick(View view) {
                if (flag == 0) {

                    if (count % 2 == 0) {
                        mBottomRightButton.setBackground(getResources().getDrawable(R.drawable.circle));
                        xo = 0;

                    } else {
                        mBottomRightButton.setBackground(getResources().getDrawable(R.drawable.cross));
                        xo = 1;
                    }
                    ticTacToe[2][2] = xo;
                }
                flag = 1;
                count++;

            }
        });

        if (count == 9) {
            Toast.makeText(this, "Game Over! No winner!", Toast.LENGTH_SHORT).show();
        }

    }
}
