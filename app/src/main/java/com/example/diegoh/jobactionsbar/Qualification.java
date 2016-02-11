package com.example.diegoh.jobactionsbar;

import android.app.Activity;
import android.content.DialogInterface;
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
public class Qualification  extends Activity implements View.OnClickListener{
    private EditText[] editTexts;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qualification);
        loadView();
    }
    public void loadView(){
        editTexts=new EditText[5];
        editTexts[0]=(EditText)findViewById(R.id.edit_note1);
        editTexts[1]=(EditText)findViewById(R.id.edit_note2);
        editTexts[2]=(EditText)findViewById(R.id.edit_note3);
        editTexts[3]=(EditText)findViewById(R.id.edit_note4);
        editTexts[4]=(EditText)findViewById(R.id.edit_note5);
        button=(Button)findViewById(R.id.btn_calculate);
        textView=(TextView)findViewById(R.id.text_data_note);
        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(validateBox(editTexts))
        {
            textView.setText(calculateNote());

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
    public String calculateNote() {
        String sNoteFinal;
        double dPercentageOne = (Double.parseDouble(editTexts[0].getText().toString())+Double.parseDouble(editTexts[1].getText().toString())+Double.parseDouble(editTexts[2].getText().toString()))/3*0.55;
        double dPercentageTwo = (Double.parseDouble(editTexts[3].getText().toString()))*0.30;
        double dPercentageThree = (Double.parseDouble(editTexts[4].getText().toString()))*0.15;
        sNoteFinal="Note fina: "+String.valueOf(dPercentageOne+dPercentageTwo+dPercentageThree).substring(0,3);
        return sNoteFinal;
    }

}
