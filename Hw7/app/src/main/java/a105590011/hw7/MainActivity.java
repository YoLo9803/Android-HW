package a105590011.hw7;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private ImageView mImgRollingDice;
    private Button mBtnDice;
    private Button mBtnResult;
    private int miCountSet = 0,
            miCountPlayerWin = 0,
            miCountComWin = 0,
            miCountDraw = 0;
    public static Context sContext;

    private static class StaticHandler extends Handler {
        private final WeakReference<MainActivity> mActivity;

        public StaticHandler(MainActivity activity) {
            mActivity = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mActivity.get();
            if (activity == null) return;
            int iRand = (int)(Math.random()*6 + 1);
            switch (iRand) {
                case 1:
                    Toast.makeText(activity.sContext, "user win", Toast.LENGTH_LONG).show();
                    activity.miCountPlayerWin++;
                    activity.miCountSet++;
                    activity.mImgRollingDice.setImageResource(R.drawable.dice01);
                    break;
                case 2:
                    Toast.makeText(activity.sContext, "user win", Toast.LENGTH_LONG).show();
                    activity.miCountPlayerWin++;
                    activity.miCountSet++;
                    activity.mImgRollingDice.setImageResource(R.drawable.dice02);
                    break;
                case 3:
                    Toast.makeText(activity.sContext, "draw", Toast.LENGTH_LONG).show();
                    activity.miCountDraw++;
                    activity.miCountSet++;
                    activity.mImgRollingDice.setImageResource(R.drawable.dice03);
                    break;
                case 4:
                    Toast.makeText(activity.sContext, "draw", Toast.LENGTH_LONG).show();
                    activity.miCountDraw++;
                    activity.miCountSet++;
                    activity.mImgRollingDice.setImageResource(R.drawable.dice04);
                    break;
                case 5:
                    Toast.makeText(activity.sContext, "computer win", Toast.LENGTH_LONG).show();
                    activity.miCountComWin++;
                    activity.miCountSet++;
                    activity.mImgRollingDice.setImageResource(R.drawable.dice05);
                    break;
                case 6:
                    Toast.makeText(activity.sContext, "computer win", Toast.LENGTH_LONG).show();
                    activity.miCountComWin++;
                    activity.miCountSet++;
                    activity.mImgRollingDice.setImageResource(R.drawable.dice06);
                    break;
            }
        }
    }

    public final MainActivity.StaticHandler mHandler = new MainActivity.StaticHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle =this.getIntent().getExtras();
        if(bundle!=null)
        {
            miCountSet = bundle.getInt("CountSet");
            miCountPlayerWin = bundle.getInt("CountPlayerWin");
            miCountComWin = bundle.getInt("CountComWin");
            miCountDraw = bundle.getInt("CountDraw");
        }

        mImgRollingDice = (ImageView)findViewById(R.id.imgRollingDice);
        mBtnDice = (Button)findViewById(R.id.btnDice);
        mBtnResult = (Button)findViewById(R.id.btnResult);
        sContext = MainActivity.this;

        mBtnDice.setOnClickListener(btnDiceOnClick);
        mBtnResult.setOnClickListener(btnResultOnClick);
    }

    private View.OnClickListener btnDiceOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            // Decide computer play.
            Resources res = getResources();
            final AnimationDrawable animDraw =
                    (AnimationDrawable) res.getDrawable(R.drawable.anim_roll_dice);
            mImgRollingDice.setImageDrawable(animDraw);
            animDraw.start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    animDraw.stop();
                    mHandler.sendMessage(mHandler.obtainMessage());
                }
            }).start();
        }
    };

    private View.OnClickListener btnResultOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent();
            it.setClass(MainActivity.this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("CountSet", miCountSet);
            bundle.putInt("CountPlayerWin", miCountPlayerWin);
            bundle.putInt("CountComWin", miCountComWin);
            bundle.putInt("CountDraw", miCountDraw);
            it.putExtras(bundle);
            startActivity(it);
            MainActivity.this.finish();
        }
    };
}
