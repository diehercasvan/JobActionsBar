package com.example.diegoh.jobactionsbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DIEGOH on 7/02/2016.
 */
public class Capital_formed extends Activity implements View.OnClickListener {
    private EditText[] editTexts;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capital_formed);
        loadView();
    }

    public void loadView() {

        editTexts = new EditText[3];
        editTexts[0] = (EditText) findViewById(R.id.editText1);
        editTexts[1] = (EditText) findViewById(R.id.editText2);
        editTexts[2] = (EditText) findViewById(R.id.editText3);

        button = (Button) findViewById(R.id.btn_calculate);
        button.setOnClickListener(this);
        textView=(TextView)findViewById(R.id.text_data_capital);

    }

    @Override
    public void onClick(View v) {

        if (validateBox(editTexts)) {
            textView.setText(calculateCapital());

        }
    }

    public boolean validateBox(EditText[] editTexts) {
        boolean validate = true;
        Pattern pat = Pattern.compile("^\\s.*");
        Matcher mat = null;
        for (int i = 0; i < editTexts.length; i++) {

            if (editTexts[i].equals("")) {
                mat = pat.matcher(editTexts[i].getText().toString());
                if (!mat.matches()) {
                    validate = false;
                }
            }

        }
        return validate;
    }
    public String calculateCapital() {
        double dCapital =Double.parseDouble(editTexts[0].getText().toString()) + Double.parseDouble(editTexts[1].getText().toString())+Double.parseDouble(editTexts[2].getText().toString());
        String sCapitalOne = String.valueOf((Double.parseDouble(editTexts[0].getText().toString()))*100/dCapital);
        String sCapitalTwo = String.valueOf((Double.parseDouble(editTexts[1].getText().toString()))*100/dCapital);
        String sCapitalThree = String.valueOf((Double.parseDouble(editTexts[2].getText().toString()))*100/dCapital);

        String sResult=
                getResources().getString(R.string.name1)+" is %:"+sCapitalOne.substring(0,3)+"\n is Capital:"+editTexts[0].getText().toString()+"\n"+
                getResources().getString(R.string.name2)+" is %:"+sCapitalTwo.substring(0,3)+"\n is Capital:"+editTexts[1].getText().toString()+"\n"+
                getResources().getString(R.string.name3)+" is % :"+sCapitalThree.substring(0,3)+"\n is Capital:"+editTexts[2].getText().toString()+"\n"+
                "Total Capital :"+dCapital
                ;

        return sResult;
    }
}
