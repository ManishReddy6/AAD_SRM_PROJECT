package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String s=getIntent().getStringExtra("myRoll");
        String name=getIntent().getStringExtra("myName");
        String phone=getIntent().getStringExtra("myPhone");
        String email=getIntent().getStringExtra("myEmail");
        String pass=getIntent().getStringExtra("myPass");
        String gender=getIntent().getStringExtra("Gender");
        String branch=getIntent().getStringExtra("Branch");
        text=findViewById(R.id.det);
        text.setText("Roll no: "+s+"\nName: "+name+"\nPhone: "+phone+"\nEmail Id: "+email+"\nPassword: "+pass+"\nGender: "+gender+"\nBranch: "+branch);
    }
}