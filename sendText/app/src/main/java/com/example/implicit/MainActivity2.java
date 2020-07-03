package com.example.implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.implicit.MainActivity.TEXT_REQUEST;

public class MainActivity2 extends AppCompatActivity {
    TextView t1,t2;
    EditText m;
    Button r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.text);
        t2=findViewById(R.id.t);
        m=findViewById(R.id.message);
        r=findViewById(R.id.reply);
        String s=getIntent().getStringExtra("myData");
        t2.setText("Message Received");
        t1.setText("  "+s);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q=m.getText().toString();
                Intent i=new Intent(MainActivity2.this,MainActivity.class);
                i.putExtra("k",q);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}