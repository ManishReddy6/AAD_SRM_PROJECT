package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e_Roll,e_Name,e_Phone,e_Email,e_Pass;
    RadioButton r_male,r_female;
    Spinner s_branch;
    String roll,name,phone,email,pass,selected_gender,selected_branch;
    Button g1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e_Roll=findViewById(R.id.roll);
        e_Name=findViewById(R.id.name);
        e_Email=findViewById(R.id.email);
        e_Phone=findViewById(R.id.phone);
        e_Pass=findViewById(R.id.pass);
        r_male=findViewById(R.id.male);
        r_female=findViewById(R.id.female);
        s_branch=findViewById(R.id.branch);
        g1=findViewById(R.id.sub);
        ArrayAdapter<CharSequence> branch_ad=
                ArrayAdapter.createFromResource(this,R.array.branches,android.R.layout.simple_spinner_item);
        s_branch.setAdapter(branch_ad);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll=e_Roll.getText().toString();
                name=e_Name.getText().toString();
                phone=e_Phone.getText().toString();
                email=e_Email.getText().toString();
                pass=e_Pass.getText().toString();
                if(r_male.isChecked())
                {
                    selected_gender=r_male.getText().toString();
                }
                if(r_female.isChecked())
                {
                    selected_gender=r_female.getText().toString();
                }
                selected_branch=s_branch.getSelectedItem().toString();
                if(roll.length()==0||name.length()==0||phone.length()==0||email.length()==0||pass.length()==0||selected_gender==null||selected_branch.equals("None"))
                {
                    Toast.makeText(MainActivity.this,"Please fill all Details",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(MainActivity.this, Details.class);
                    i.putExtra("myRoll", roll);
                    i.putExtra("myName", name);
                    i.putExtra("myPhone", phone);
                    i.putExtra("myEmail", email);
                    i.putExtra("myPass", pass);
                    i.putExtra("Gender", selected_gender);
                    i.putExtra("Branch", selected_branch);
                    startActivity(i);
                }
            }
        });
    }
}