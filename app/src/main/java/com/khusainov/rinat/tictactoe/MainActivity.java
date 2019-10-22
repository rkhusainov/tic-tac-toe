package com.khusainov.rinat.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();
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
                if (count % 2 == 0 && flag==0) {
                    mTopLeftButton.setBackground(getResources().getDrawable(R.drawable.circle));

                } else if(flag==0){
                    mTopLeftButton.setBackground(getResources().getDrawable(R.drawable.cross));
                }
                flag =1;
                count++;
            }
        });

        mTopCenterButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;
            @Override
            public void onClick(View view) {
                if (count % 2 == 0 && flag==0) {
                    mTopCenterButton.setBackground(getResources().getDrawable(R.drawable.circle));

                } else if(flag==0){
                    mTopCenterButton.setBackground(getResources().getDrawable(R.drawable.cross));

                }
                flag =1;
                count++;
            }
        });


        mTopRightButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;
            @Override
            public void onClick(View view) {
                if (count % 2 == 0 && flag==0) {
                    mTopRightButton.setBackground(getResources().getDrawable(R.drawable.circle));

                } else if(flag==0){
                    mTopRightButton.setBackground(getResources().getDrawable(R.drawable.cross));
                }
                flag =1;
                count++;
            }
        });


        mLeftCenterButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;
            @Override
            public void onClick(View view) {
                if (count % 2 == 0 && flag==0) {
                    mLeftCenterButton.setBackground(getResources().getDrawable(R.drawable.circle));

                } else if(flag==0){
                    mLeftCenterButton.setBackground(getResources().getDrawable(R.drawable.cross));
                }
                flag =1;
                count++;
            }
        });


        mCenterButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;
            @Override
            public void onClick(View view) {
                if (count % 2 == 0 && flag==0) {
                    mCenterButton.setBackground(getResources().getDrawable(R.drawable.circle));

                } else if(flag==0){
                    mCenterButton.setBackground(getResources().getDrawable(R.drawable.cross));
                }
                flag =1;
                count++;
            }
        });

        mRightCenterButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;
            @Override
            public void onClick(View view) {
                if (count % 2 == 0 && flag==0) {
                    mRightCenterButton.setBackground(getResources().getDrawable(R.drawable.circle));
                } else if(flag==0){
                    mRightCenterButton.setBackground(getResources().getDrawable(R.drawable.cross));
                }
                flag =1;
                count++;
            }
        });


        mBottomLeftButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;
            @Override
            public void onClick(View view) {
                if (count % 2 == 0 && flag==0) {
                    mBottomLeftButton.setBackground(getResources().getDrawable(R.drawable.circle));

                } else if(flag==0){
                    mBottomLeftButton.setBackground(getResources().getDrawable(R.drawable.cross));
                }
                flag =1;
                count++;
            }
        });


        mBottomCenterButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;
            @Override
            public void onClick(View view) {
                if (count % 2 == 0 && flag==0) {
                    mBottomCenterButton.setBackground(getResources().getDrawable(R.drawable.circle));

                } else if(flag==0){
                    mBottomCenterButton.setBackground(getResources().getDrawable(R.drawable.cross));
                }
                flag =1;
                count++;
            }
        });


        mBottomRightButton.setOnClickListener(new View.OnClickListener() {
            int flag = 0;
            @Override
            public void onClick(View view) {
                if (count % 2 == 0 && flag==0) {
                    mBottomRightButton.setBackground(getResources().getDrawable(R.drawable.circle));

                } else if(flag==0){
                    mBottomRightButton.setBackground(getResources().getDrawable(R.drawable.cross));
                }
                flag =1;
                count++;
            }
        });

    }
}
