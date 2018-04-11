package a105590011.hw4_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpnSex;
    private RadioGroup mRadGrp;
    private RadioButton mradBtnMale;
    private RadioButton mradBtnFemale;
    private Button mBtnOK;
    private Spinner mSpnAge;
    private CheckBox mHobbies1;
    private CheckBox mHobbies2;
    private CheckBox mHobbies3;
    private CheckBox mHobbies4;
    private CheckBox mHobbies5;
    private CheckBox mHobbies6;
    private CheckBox mHobbies7;
    private CheckBox mHobbies8;
    private CheckBox mHobbies9;
    private CheckBox mHobbies10;
    private TextView mTxtHobbies;

    private TextView mTxtSug;
    private TextView mTxthobbies;

    private String selectedSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadGrp=(RadioGroup)findViewById(R.id.radGrp);
        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtSug = (TextView) findViewById(R.id.txtSug);
        mradBtnMale = (RadioButton)findViewById(R.id.radBtnMale);
        mradBtnFemale = (RadioButton)findViewById(R.id.radBtnFemale);
        mSpnAge=(Spinner)findViewById(R.id.spnAge);
        mHobbies1 = (CheckBox) findViewById(R.id.hobbies1);
        mHobbies2 = (CheckBox) findViewById(R.id.hobbies2);
        mHobbies3 = (CheckBox) findViewById(R.id.hobbies3);
        mHobbies4 = (CheckBox) findViewById(R.id.hobbies4);
        mHobbies5 = (CheckBox) findViewById(R.id.hobbies5);
        mHobbies6 = (CheckBox) findViewById(R.id.hobbies6);
        mHobbies7 = (CheckBox) findViewById(R.id.hobbies7);
        mHobbies8 = (CheckBox) findViewById(R.id.hobbies8);
        mHobbies9 = (CheckBox) findViewById(R.id.hobbies9);
        mHobbies10 = (CheckBox) findViewById(R.id.hobbies10);
        mTxtHobbies=(TextView)findViewById(R.id.txtHobbies);

        mBtnOK.setOnClickListener(btnOKOnClick);

    }

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MarriageSuggestion ms = new MarriageSuggestion();
            String ageRange=mSpnAge.getSelectedItem().toString();
            String hobby="你的興趣:";
            int sexType=0;
            switch (mRadGrp.getCheckedRadioButtonId()) {
                case R.id.radBtnMale:
                    sexType = 1;
                    break;
                case R.id.radBtnFemale:
                    sexType = 2;
                    break;
            }
            if(mHobbies1.isChecked())
                hobby+= mHobbies1.getText().toString()+" ";
            if(mHobbies2.isChecked())
                hobby+= mHobbies2.getText().toString()+" ";
            if(mHobbies3.isChecked())
                hobby+= mHobbies3.getText().toString()+" ";
            if(mHobbies4.isChecked())
                hobby+= mHobbies4.getText().toString()+" ";
            if(mHobbies5.isChecked())
                hobby+= mHobbies5.getText().toString()+" ";
            if(mHobbies6.isChecked())
                hobby+= mHobbies6.getText().toString()+" ";
            if(mHobbies7.isChecked())
                hobby+= mHobbies7.getText().toString()+" ";
            if(mHobbies8.isChecked())
                hobby+= mHobbies8.getText().toString()+" ";
            if(mHobbies9.isChecked())
                hobby+= mHobbies9.getText().toString()+" ";
            if(mHobbies10.isChecked())
                hobby+= mHobbies10.getText().toString()+" ";
            mTxtHobbies.setText(hobby);

        }
    };
}
