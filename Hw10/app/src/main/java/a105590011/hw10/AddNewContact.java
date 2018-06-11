package a105590011.hw10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class AddNewContact extends Fragment{

    public EditText mEdtName, mEdtNumber;
    private Spinner mSpnType;
    public String type;

    public AddNewContact(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addnewcontact, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mEdtName=(EditText)getView().findViewById(R.id.edtName);
        mEdtNumber=(EditText)getView().findViewById(R.id.edtNumber);
        mSpnType=(Spinner)getView().findViewById(R.id.spnType);

        mSpnType.setOnItemSelectedListener(spnTypeOnItemClick);
    }

    private AdapterView.OnItemSelectedListener spnTypeOnItemClick=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            type=parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
