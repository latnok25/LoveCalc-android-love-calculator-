package com.latnok.lovecalc;

//import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Random;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText et_female, et_male;
    Button calculate;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_female = (EditText) findViewById(R.id.et_female);
        et_male = (EditText) findViewById(R.id.et_male);
        calculate = (Button) findViewById(R.id.calculate);
        text = (TextView) findViewById(R.id.text);

        calculate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                if (!et_female.getText().toString().equals("") && !et_male.getText().toString().equals("")) {
                    String female = et_female.getText().toString();
                    String male = et_male.getText().toString();
                    Calendar c = Calendar.getInstance();
                    String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    String month = String.valueOf(c.get(Calendar.MONTH));
                    String year = String.valueOf(c.get(Calendar.YEAR));

                    String result_string = female + male + day + month + year;
                    result_string = result_string.toLowerCase();
                    result_string = result_string.trim();

                    int seed = result_string.hashCode();

                    Random r = new Random(seed);

                    text.setText((r.nextInt(100) + 1) + "%");


                }
            }
        });

    }
}