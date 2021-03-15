package com.android.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.switchmaterial.SwitchMaterial;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {


//    SwitchMaterial tSwitch = findViewById(R.id.timer_switch);
//    Boolean switchVal = tSwitch.isChecked();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void launchIdentifyTheCarMakeActivity(View view){
        Intent intent = new Intent(this,IdentifyTheCarMakeActivity.class);

        SwitchMaterial tSwitch = findViewById(R.id.timer_switch);
        Boolean switchVal = tSwitch.isChecked();

        intent.putExtra("TIMER_VALUE",switchVal);
        startActivity(intent);
    }

    public void launchHintsActivity(View view){
        Intent intent = new Intent(this,HintsActivity.class);

        SwitchMaterial tSwitch = findViewById(R.id.timer_switch);
        Boolean switchVal = tSwitch.isChecked();

        intent.putExtra("TIMER_VALUE",switchVal);
        startActivity(intent);
    }

    public void launchIdentifyTheCarImageActivity(View view){
        Intent intent = new Intent(this,IdentifyTheCarImageActivity.class);

        SwitchMaterial tSwitch = findViewById(R.id.timer_switch);
        Boolean switchVal = tSwitch.isChecked();

        intent.putExtra("TIMER_VALUE",switchVal);
        startActivity(intent);
    }

    public void launchAdvancedLevelMainActivity(View view){
        Intent intent = new Intent(this,AdvancedLevelMainActivity.class);

        SwitchMaterial tSwitch = findViewById(R.id.timer_switch);
        Boolean switchVal = tSwitch.isChecked();

        intent.putExtra("TIMER_VALUE",switchVal);
        startActivity(intent);
    }
}