package com.example.implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mes;
    Button g1;
    TextView t3,t4;
    public static final int TEXT_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mes=findViewById(R.id.message);
        g1=findViewById(R.id.send);
        t3=findViewById(R.id.h);
        t4=findViewById(R.id.textview);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=mes.getText().toString();
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("myData",s);
                startActivityForResult(i, TEXT_REQUEST);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST)
        {
            if (resultCode == RESULT_OK)
            {
                String reply = data.getStringExtra("k");
                t3.setVisibility(View.VISIBLE);
                t3.setText("Reply Received");
                t4.setVisibility(View.VISIBLE);
                t4.setText("  "+reply);
            }
        }
    }
}