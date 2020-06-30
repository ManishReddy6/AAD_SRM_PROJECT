package com.example.implicittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

import static androidx.core.app.ShareCompat.IntentBuilder.from;

public class MainActivity extends AppCompatActivity {
    EditText t1;
    Button g1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.text);
        g1=findViewById(R.id.button);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=t1.getText().toString();
                String t="text/plain";
                from(MainActivity.this);
                ShareCompat.IntentBuilder from = from(MainActivity.this);
                from.setType(t);
                from.setText(s);
                from.startChooser();
            }
        });
    }
}