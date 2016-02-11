package com.example.diegoh.jobactionsbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       int selection=0;
        switch (item.getItemId())
        {

            case R.id.action_settings :
                selection=0;
            break;
            case R.id.action_settings1 :
                selection=1;
                break;
            case R.id.action_settings2 :
                selection=2;
                break;
            case R.id.action_settings3 :
                selection=3;
                break;
            case R.id.action_settings4 :
                selection=4;
                break;
        }

        loadActivity(selection);
        return super.onOptionsItemSelected(item);
    }

    public void loadActivity(int selection){
        Intent intent=null;
        switch (selection)
        {

            case 0 :
                intent =new Intent(this,Salary.class);
                break;
            case 1 :
                intent =new Intent(this,ConvertMeters.class);
                break;
            case 2 :
                intent =new Intent(this,Qualification.class);
                break;
            case 3 :
                intent =new Intent(this,Capital_formed.class);
                break;
            case 4 :
                intent =new Intent(this,DistributeAmounts.class);
                break;
        }
        startActivity(intent);

    }
}
