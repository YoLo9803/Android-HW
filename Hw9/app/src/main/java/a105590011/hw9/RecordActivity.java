package a105590011.hw9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by hjki3 on 5/14/2018.
 */

public class RecordActivity extends AppCompatActivity {
    private ArrayList year, month, day, type, money, record=new ArrayList();
    private ListView mlistView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        Bundle bundle =this.getIntent().getExtras();
        year= bundle.getStringArrayList("year");
        month= bundle.getStringArrayList("month");
        day= bundle.getStringArrayList("day");
        type= bundle.getStringArrayList("type");
        money= bundle.getStringArrayList("money");

        mlistView = (ListView) findViewById(R.id.listView);

        for(int i=0;i<year.size();i++)
            record.add("項目" + Integer.toString(i) + "   " + year.get(i) + "/" + month.get(i) + "/" + day.get(i) + "   " + type.get(i) + "   " + money.get(i));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, record );
        mlistView.setAdapter(arrayAdapter);
    }
}
