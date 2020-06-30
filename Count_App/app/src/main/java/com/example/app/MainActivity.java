package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button g1,g2,g3,g4;
    TextView t1;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g1=findViewById(R.id.button);
        g2=findViewById(R.id.button2);
        g3=findViewById(R.id.button3);
        g4=findViewById(R.id.button4);
        t1=findViewById(R.id.text);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                t1.setText(""+a);
            }
        });
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a!=0)
                {
                    a--;
                    t1.setText(""+a);
                }
            }
        });
        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=0;
                t1.setText(""+a);
            }
        });
        g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Your Count is: "+a, Toast.LENGTH_SHORT).show();
            }
        });
        if(savedInstanceState!=null)
        {
            String s=savedInstanceState.getString("m");
            a=Integer.parseInt(s);
            t1.setText(""+a);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("m", t1.getText().toString());
    }
    }