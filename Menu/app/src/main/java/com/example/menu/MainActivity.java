package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static androidx.core.app.ShareCompat.IntentBuilder.from;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.share:
                String s="Welcome";
                String t="text/plain";
                ShareCompat.IntentBuilder from=from(MainActivity.this);
                from.setText(s);
                from.setType(t);
                from.startChooser();
                break;
            case R.id.dail:
                Uri uri=Uri.parse("tel:1234556789");
                Intent i=new Intent(Intent.ACTION_DIAL,uri);
                startActivity(i);
                break;
            case R.id.gallery:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}