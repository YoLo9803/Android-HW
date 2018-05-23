package a105590011.hw9;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner mSpnType;
    private EditText mEdtDate;
    private EditText mEdtMoney;
    private DatePicker mdatePicker;
    private Button mBtnInput;
    private Button mBtnRecord;
    private ArrayList year, month, day, type, money;
    private String selectType;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        year=new ArrayList();
        month=new ArrayList();
        day=new ArrayList();
        type=new ArrayList();
        money=new ArrayList();

        mSpnType=(Spinner)findViewById(R.id.spnType);
        mEdtDate=(EditText)findViewById(R.id.edtDate);
        mEdtMoney=(EditText)findViewById(R.id.edtMoney);
        mdatePicker=(DatePicker)findViewById(R.id.datePicker);
        mBtnInput=(Button)findViewById(R.id.btnInput);
        mBtnRecord=(Button)findViewById(R.id.btnRecord);
        mRelativeLayout=(RelativeLayout)findViewById(R.id.relativeLayout);

        registerForContextMenu(mRelativeLayout);

        mSpnType.setOnItemSelectedListener(spnTypeOnItemSelect);
        mdatePicker.init(2018,5,14, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                mEdtDate.setText(Integer.toString(year) + "/" + Integer.toString(month + 1) + "/" + Integer.toString(dayOfMonth));
            }
        });
        mBtnInput.setOnClickListener(btnInputOnClick);
        mBtnRecord.setOnClickListener(btnRecordOnClick);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemPlayBackgroundMusic:
                Intent it = new Intent(MainActivity.this, MediaPlayService.class);
                startService(it);
                return true;
            case R.id.menuItemStopBackgroundMusic:
                it = new Intent(MainActivity.this, MediaPlayService.class);
                stopService(it);
                return true;
            case R.id.menuItemAbout:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("關於這個程式")
                        .setMessage("選單範例程式")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.star_big_on)
                        .setPositiveButton("確定",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                        .show();
                return true;
            case R.id.menuItemExit:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        onOptionsItemSelected(item);
        return super.onContextItemSelected(item);
    }

    private AdapterView.OnItemSelectedListener spnTypeOnItemSelect = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            selectType=adapterView.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };

    private Button.OnClickListener btnInputOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            year.add(Integer.toString(mdatePicker.getYear()));
            month.add(Integer.toString(mdatePicker.getMonth()+1));
            day.add(Integer.toString(mdatePicker.getDayOfMonth()));
            type.add(selectType);
            money.add(mEdtMoney.getText().toString());

            Toast t=Toast.makeText(MainActivity.this, mEdtMoney.getText().toString(), Toast.LENGTH_LONG);
            t.show();
        }
    };

    private Button.OnClickListener btnRecordOnClick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent();
            it.setClass(MainActivity.this, RecordActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("year", year);
            bundle.putStringArrayList("month", month);
            bundle.putStringArrayList("day", day);
            bundle.putStringArrayList("type", type);
            bundle.putStringArrayList("money", money);
            it.putExtras(bundle);
            startActivity(it);
        }
    };
}
