package a105590011.hw7;

/**
 * Created by hjki3 on 5/7/2018.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    private EditText mEdtCountSet,  mEdtCountPlayerWin,  mEdtCountComWin,  mEdtCountDraw;
    private Button mBtnClose;
    private int miCountSet = 0,
            miCountPlayerWin = 0,
            miCountComWin = 0,
            miCountDraw = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle =this.getIntent().getExtras();
        miCountSet = bundle.getInt("CountSet");
        miCountPlayerWin = bundle.getInt("CountPlayerWin");
        miCountComWin = bundle.getInt("CountComWin");
        miCountDraw = bundle.getInt("CountDraw");

        mEdtCountSet = (EditText)findViewById(R.id.edtCountSet);
        mEdtCountPlayerWin = (EditText)findViewById(R.id.edtCountPlayerWin);
        mEdtCountComWin = (EditText)findViewById(R.id.edtCountComWin);
        mEdtCountDraw = (EditText)findViewById(R.id.edtCountDraw);
        mBtnClose=(Button)findViewById(R.id.btnClose);

        mEdtCountSet.setText(Integer.toString(miCountSet));
        mEdtCountPlayerWin.setText(Integer.toString(miCountPlayerWin));
        mEdtCountComWin.setText(Integer.toString(miCountComWin));
        mEdtCountDraw.setText(Integer.toString(miCountDraw));

        mBtnClose.setOnClickListener(mBtnCloseOnClick);
    }

    private View.OnClickListener mBtnCloseOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent();
            it.setClass(ResultActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("CountSet", miCountSet);
            bundle.putInt("CountPlayerWin", miCountPlayerWin);
            bundle.putInt("CountComWin", miCountComWin);
            bundle.putInt("CountDraw", miCountDraw);
            it.putExtras(bundle);
            startActivity(it);
            ResultActivity.this.finish();
        }
    };
}
