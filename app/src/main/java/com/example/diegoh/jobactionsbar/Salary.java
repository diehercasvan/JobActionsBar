package com.example.diegoh.jobactionsbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DIEGOH on 7/02/2016.
 */
public class Salary extends Activity implements View.OnClickListener {
    private EditText[] editTexts;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salary_view);
        loadView();
    }

    public void loadView() {

        editTexts = new EditText[3];
        editTexts[0] = (EditText) findViewById(R.id.edit_name_employed);
        editTexts[1] = (EditText) findViewById(R.id.edit_salary_base);
        editTexts[2] = (EditText) findViewById(R.id.edit_hourse_worked);

        button = (Button) findViewById(R.id.btn_calculate);
        button.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.text_data_salary);

    }

    @Override
    public void onClick(View v) {

        if (validateBox(editTexts)) {

            textView.setText(calculateSalary());

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

    public String calculateSalary() {
        double dSalaryBase = Double.parseDouble(editTexts[1].getText().toString()) * Double.parseDouble(editTexts[2].getText().toString());
        double dBonus = dSalaryBase * 0.20;
        double dSalaryTotal = dBonus + dSalaryBase;
        double dDiscount = dSalaryTotal * 0.10;
        double dSalary = dSalaryTotal - dDiscount;
        String sSalaryGeneral = "Name employed :" +editTexts[0].getText().toString()+"\n" + dSalaryBase + "\n" + "Bonus:" + dBonus + "\n" + "Salary Total:" + dSalaryTotal + "\n" + "Salary Discount:" + dDiscount + "\n" + "Salary General:" + dSalary + "\n";
        return sSalaryGeneral;
    }
}
