package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t1;
    Button g1,g2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g1=findViewById(R.id.button);
        g2=findViewById(R.id.button2);
        t1=findViewById(R.id.editText);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=t1.getText().toString();
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("myData",data);
                startActivity(i);
                Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
            }
        });
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(i);
            }
        });
    }
}