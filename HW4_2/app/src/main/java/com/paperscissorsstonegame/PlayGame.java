package com.paperscissorsstonegame;

import android.view.View;
import android.widget.TextView;

/**
 * Created by YoLo on 2018/4/11.
 */

public class PlayGame {
    public void ScissorsOnClick(TextView mTxtComPlay,TextView mTxtResult,int iComPlay) {
        // 決定電腦出拳.

        // 1 – 剪刀, 2 – 石頭, 3 – 布.
        if (iComPlay == 1) {
            mTxtComPlay.setText(R.string.play_scissors);
            mTxtResult.setText("判定輸贏：雙方平手！");
        }
        else if (iComPlay == 2) {
            mTxtComPlay.setText(R.string.play_stone);
            mTxtResult.setText("判定輸贏：很可惜，你輸了！");
        }
        else {
            mTxtComPlay.setText(R.string.play_paper);
            mTxtResult.setText("判定輸贏：恭喜，你贏了！");
        }
    }

    public void StoneOnClick(TextView mTxtComPlay,TextView mTxtResult,int iComPlay) {
        // 決定電腦出拳.

        // 1 – 剪刀, 2 – 石頭, 3 – 布.
        if (iComPlay == 1) {
            mTxtComPlay.setText(R.string.play_scissors);
            mTxtResult.setText("判定輸贏：恭喜，你贏了！");
        }
        else if (iComPlay == 2) {
            mTxtComPlay.setText(R.string.play_stone);
            mTxtResult.setText("判定輸贏：雙方平手！");
        }
        else {
            mTxtComPlay.setText(R.string.play_paper);
            mTxtResult.setText("判定輸贏：很可惜，你輸了！");
        }
    }
    public void PaperOnClick(TextView mTxtComPlay,TextView mTxtResult,int iComPlay) {
        // 決定電腦出拳.

        // 1 – 剪刀, 2 – 石頭, 3 – 布.
        if (iComPlay == 1) {
            mTxtComPlay.setText(R.string.play_scissors);
            mTxtResult.setText("判定輸贏：很可惜，你輸了！");
        } else if (iComPlay == 2) {
            mTxtComPlay.setText(R.string.play_stone);
            mTxtResult.setText("判定輸贏：恭喜，你贏了！");
        } else {
            mTxtComPlay.setText(R.string.play_paper);
            mTxtResult.setText("判定輸贏：雙方平手！");
        }
    }
}
