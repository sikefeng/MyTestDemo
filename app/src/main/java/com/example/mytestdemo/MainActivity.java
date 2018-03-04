package com.example.mytestdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    private int mTotalProgress = 90;
    private int mCurrentProgress = 0;
    //进度条
    private CompletedView mTasksView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTasksView = (CompletedView) findViewById(R.id.tasks_view);
        new Thread(new ProgressRunable()).start();
        te();
    }

    class ProgressRunable implements Runnable {
        @Override
        public void run() {
            while (mCurrentProgress < mTotalProgress) {
                mCurrentProgress += 1;
                mTasksView.setProgress(mCurrentProgress);
                try {
                    Thread.sleep(90);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onClick(View view){
          switch (view.getId()){
              case R.id.govideoplayer:
                    startActivity(new Intent(MainActivity.this,VideoListActivity.class));
                    break;
                    case R.id.btnfood:
                    startActivity(new Intent(MainActivity.this,FoodListActivity.class));
                    break;
          }
    }

    private RoundProgress mTasksView2,roundProgress1,roundProgress2,roundProgress3,roundProgress4;
    private int mTotalProgress2;
    private int mCurrentProgress2;
    private void te(){
        initVariable();
        initView();
        new Thread(new ProgressRunable2()).start();
    }
    private void initVariable() {
        mTotalProgress2 = 100;
        mCurrentProgress2 = 0;
    }

    private void initView() {
        mTasksView2 = (RoundProgress) findViewById(R.id.rp);
        roundProgress1 = (RoundProgress) findViewById(R.id.roundProgress1);
        roundProgress2 = (RoundProgress) findViewById(R.id.roundProgress2);
        roundProgress3 = (RoundProgress) findViewById(R.id.roundProgress3);
        roundProgress4 = (RoundProgress) findViewById(R.id.roundProgress4);
    }

    class ProgressRunable2 implements Runnable {

        @Override
        public void run() {
            while (mCurrentProgress2 < mTotalProgress2) {
                mCurrentProgress2 += 1;
                mTasksView2.setProgress(mCurrentProgress2);
                roundProgress1.setProgress(mCurrentProgress2);
                roundProgress2.setProgress(mCurrentProgress2);
                roundProgress3.setProgress(mCurrentProgress2);
                roundProgress4.setProgress(mCurrentProgress2);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
