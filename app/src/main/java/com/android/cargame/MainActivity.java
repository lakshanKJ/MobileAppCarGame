package com.android.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void launchIdentifyTheCarMakeActivity(View view){
        Intent intent = new Intent(this,IdentifyTheCarMakeActivity.class);
        startActivity(intent);
    }

    public void launchHintsActivity(View view){
        Intent intent = new Intent(this,HintsActivity.class);
        startActivity(intent);
    }
}