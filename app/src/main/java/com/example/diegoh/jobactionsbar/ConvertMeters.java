package com.example.diegoh.jobactionsbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DIEGOH on 7/02/2016.
 */
public class ConvertMeters extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private EditText editText;
    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private String[] sUnits;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert_meters);
        loadView();
    }

    public void loadView() {

        sUnits = getResources().getStringArray(R.array.units);
        spinner = (Spinner) findViewById(R.id.spinner);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sUnits);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
        editText = (EditText) findViewById(R.id.edit_meter);
        textView=(TextView)findViewById(R.id.text_data_meter);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        converter(position,parent.getItemAtPosition(position).toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void converter(int selection,String textSelection) {

        double dCentimeters = 0d;
        double dateResut = 0d;
        Pattern pat = Pattern.compile("^\\s.*");
        Matcher mat = mat = pat.matcher(editText.getText().toString());

        if (editText.getText().toString().length()<=0) {
            Toast.makeText(this, "Verify the data", Toast.LENGTH_LONG).show();
        } else {
            dCentimeters = Double.parseDouble(editText.getText().toString()) * 100;
            switch (selection) {

                case 0:
                    dateResut = dCentimeters;
                    break;
                case 1:
                    dateResut = (dCentimeters/2.54)/12;
                    break;
                case 2:
                    dateResut = (dCentimeters/2.54);
                    break;
                case 3:
                    dateResut = ((dCentimeters/2.54)/12)/3;
                    break;
            }
            textView.setText(textSelection + " to Meters :" + String.valueOf(dateResut).toString());
        }

    }
}
