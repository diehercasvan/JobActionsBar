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
public class DistributeAmounts extends Activity implements View.OnClickListener{

    private EditText[] editTexts;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.distribute_amounts);
        loadView();
    }
    public void loadView(){
        editTexts=new EditText[4];
        editTexts[0]=(EditText)findViewById(R.id.editText1);
        editTexts[1]=(EditText)findViewById(R.id.editText2);
        editTexts[2]=(EditText)findViewById(R.id.editText3);
        editTexts[3]=(EditText)findViewById(R.id.editText4);

        button=(Button)findViewById(R.id.btn_calculate);
        textView=(TextView)findViewById(R.id.text_data_note);
        button.setOnClickListener(this);
        textView=(TextView)findViewById(R.id.text_data_capital);

    }

    @Override
    public void onClick(View v) {
        if(validateBox(editTexts))
        {
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
        String sNoteFinal;
        double dGeneralAge=(Double.parseDouble(editTexts[0].getText().toString())+Double.parseDouble(editTexts[1].getText().toString())+Double.parseDouble(editTexts[2].getText().toString()));
        double dPercentageOne = (Double.parseDouble(editTexts[0].getText().toString()))*(Double.parseDouble(editTexts[3].getText().toString()))/dGeneralAge;
        double dPercentageTwo = (Double.parseDouble(editTexts[1].getText().toString()))*(Double.parseDouble(editTexts[3].getText().toString()))/dGeneralAge;
        double dPercentageThree = (Double.parseDouble(editTexts[2].getText().toString()))*(Double.parseDouble(editTexts[3].getText().toString()))/dGeneralAge;
        sNoteFinal="Person One $: "+dPercentageOne +"\n"+"Person One $: "+dPercentageTwo +"\n"+"Person One $: "+dPercentageThree +"\n";
        return sNoteFinal;
    }
}
