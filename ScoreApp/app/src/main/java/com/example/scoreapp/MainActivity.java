package com.example.scoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button g1,g2,g3,g4,g5,g6,g7;
    TextView t1,t2;
    int a,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g1 = findViewById(R.id.b1);
        g2 = findViewById(R.id.button2);
        g3 = findViewById(R.id.button3);
        g4 = findViewById(R.id.button4);
        g5 = findViewById(R.id.button5);
        g6 = findViewById(R.id.button6);
        g7 = findViewById(R.id.button7);
        t1 = findViewById(R.id.textView5);
        t2 = findViewById(R.id.textView6);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = a + 3;
                t1.setText("" + a);
            }
        });
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = a + 2;
                t1.setText("" + a);
            }
        });
        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = a + 1;
                t1.setText("" + a);
            }
        });
        g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = c + 3;
                t2.setText("" + c);
            }
        });
        g5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = c + 2;
                t2.setText("" + c);
            }
        });
        g6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = c + 1;
                t2.setText("" + c);
            }
        });
        g7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = 0;
                t1.setText("" + a);
                c = 0;
                t2.setText("" + c);
            }
        });
        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("m");
            a = Integer.parseInt(s);
            t1.setText("" + a);
            String k=savedInstanceState.getString("r");
            c=Integer.parseInt(k);
            t2.setText(""+c);

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("m", t1.getText().toString());
        outState.putString("r",t2.getText().toString());
    }
}