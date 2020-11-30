package com.example.splashes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

// This Activity doesn't do anything. It's just here to check that the redirects are okay.

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oldsplash);

        textView = findViewById(R.id.placeholder);


    }

}
