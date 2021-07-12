package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        TextView result = (TextView) findViewById(R.id.Result);
        Button back = (Button) findViewById(R.id.backButton);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            String tip = bundle.getString("tip");

            Double tipd = (Double.valueOf(tip));
            String q = String.format("%.2f",tipd);
            result.setText(q);

        }

        View.OnClickListener backListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondPage.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityIfNeeded(intent,0);
            }
        };
        back.setOnClickListener(backListener);
    }
}