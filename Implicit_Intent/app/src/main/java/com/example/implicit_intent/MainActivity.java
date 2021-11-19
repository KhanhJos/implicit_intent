package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button email, camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        camera = findViewById(R.id.camera);

        email.setOnClickListener(this);
        camera.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.email:
                Intent intentEmail = new Intent(Intent.ACTION_SEND);
                intentEmail.setType("text/plain");
                intentEmail.putExtra(Intent.EXTRA_SUBJECT,"Hello EveryOne!");
                intentEmail.putExtra(Intent.EXTRA_TEXT,"Dear Admin! xyz...");
                if (intentEmail.resolveActivity(getPackageManager()) != null){
                    startActivity(intentEmail);
                }
                break;
            case R.id.camera:
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intentCamera.putExtra(MediaStore.EXTRA_OUTPUT,"img");
                if (intentCamera.resolveActivity(getPackageManager()) != null){
                    startActivity(intentCamera);
                }
                break;
        }
    }
}