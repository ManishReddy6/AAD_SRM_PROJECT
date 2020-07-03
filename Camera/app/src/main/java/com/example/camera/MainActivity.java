package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button cam,gal;
    ImageView iv;
    public static final int CAMERA_REQUEST_CODE=10;
    public static final int GALLERY_REQUEST_CODE=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cam=findViewById(R.id.Camera);
        gal=findViewById(R.id.Gallery);
        iv=findViewById(R.id.image);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }

            private void openCamera() {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CAMERA_REQUEST_CODE);
            }
        });
        gal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }

            private void openGallery() {
                Intent i=new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(i,GALLERY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST_CODE)
        {
            if(resultCode==RESULT_OK)
            {
                Bitmap b=(Bitmap)data.getExtras().get("data");
                iv.setImageBitmap(b);
            }
        }
        if(requestCode==GALLERY_REQUEST_CODE)
        {
            if (resultCode==RESULT_OK)
            {
                Uri u=data.getData();
                iv.setImageURI(u);
            }
        }
    }
}