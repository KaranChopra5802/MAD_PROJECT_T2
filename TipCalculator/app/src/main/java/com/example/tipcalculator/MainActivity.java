package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {


    Double seekValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputValue = (EditText) findViewById(R.id.inputValue);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        Button calculate = (Button) findViewById(R.id.cal);
        Button allClear = (Button) findViewById(R.id.allClear);
        TextView progressAmount = (TextView) findViewById(R.id.progressAmount);



        progressAmount.setText("0");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekValue = Double.valueOf(progress);
                progressAmount.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                setProgress(0);

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        View.OnClickListener allC = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekValue = null;
                seekBar.setProgress(0);
                inputValue.setText("");
                progressAmount.setText("0");
            }
        };
        allClear.setOnClickListener(allC);
        View.OnClickListener calc = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1 = inputValue.getText().toString();
                if(p1.length() != 0 )
                {
                    String tipValue = performOperation(p1,seekValue);
                    Intent intent = new Intent(MainActivity.this, SecondPage.class);
                    intent.putExtra("tip", tipValue);
                    startActivity(intent);
                }

            }
        };
        calculate.setOnClickListener(calc);


    }

    String performOperation(String p1, Double progressAmount)
    {
        Double d = Double.valueOf(p1);
        Double res = d * (progressAmount/100);
        String result = res.toString();
        return result;
    }


}