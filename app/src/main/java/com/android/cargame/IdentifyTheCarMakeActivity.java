package com.android.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class IdentifyTheCarMakeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int[] carList ={R.drawable.aston_martin_one77,R.drawable.audi_e_tron,R.drawable.bentley,R.drawable.bmw_7_series,R.drawable.bugati_veyron,R.drawable.ferrari458,R.drawable.ferrari_enzo,R.drawable.ferrari_f60,R.drawable.ferrari_laferrari,R.drawable.ford_fiesta,R.drawable.jaguar_f_type,
            R.drawable.koenigsegg_one,R.drawable.koenigsegg_trevita,R.drawable.lamborghini_murcielago,R.drawable.lamborghini_veneno
            ,R.drawable.lexus_lfa,R.drawable.lotus_elise,R.drawable.lykan_hypersport,R.drawable.mc_laren,R.drawable.mercedes_benz,R.drawable.mini_cooper,R.drawable.mitsubishi_evo,R.drawable.mustang_gt,R.drawable.nissan_gtr,R.drawable.paganihuayra,R.drawable.paganizonda,
            R.drawable.porche,R.drawable.range_rover,R.drawable.rolls_royce_phantom,R.drawable.subaru,R.drawable.tesla_model_s,R.drawable.zenvo};

    Random randomImage = new Random();
    int imgPositionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_car_make);

        getRandomCar(0);

        // Create the spinner.
        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cars_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    public void getRandomCar(int except){
        ImageView imageView = findViewById(R.id.Identify_the_car_image_imageview);
        int randomNumber = 0;
//        int randomNumber = randomImage.nextInt(carList.length);
        imageView.setImageResource(carList[randomNumber]);

        imgPositionNumber = randomNumber;
    }

    public void onIdentifyBtnClicked(){

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int carPosition = parent.getSelectedItemPosition();
        TextView showTextView = findViewById(R.id.result_textView);

        if (carPosition == 0 && imgPositionNumber == 0) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 1 && imgPositionNumber == 1) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 2 && imgPositionNumber == 2) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 3 && imgPositionNumber == 3) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 4 && imgPositionNumber == 4) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 5 && imgPositionNumber == 5) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 6 && imgPositionNumber == 6) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 7 && imgPositionNumber == 7) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 8 && imgPositionNumber == 8) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 9 && imgPositionNumber == 9) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 10 && imgPositionNumber == 10) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 11 && imgPositionNumber == 11) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 12 && imgPositionNumber == 12) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 13 && imgPositionNumber == 13) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 14 && imgPositionNumber == 14) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 15 && imgPositionNumber == 15) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 16 && imgPositionNumber == 16) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 17 && imgPositionNumber == 17) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 18 && imgPositionNumber == 18) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 19 && imgPositionNumber == 19) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 20 && imgPositionNumber == 20) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 21 && imgPositionNumber == 21) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 22 && imgPositionNumber == 22) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 23 && imgPositionNumber == 23) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 24 && imgPositionNumber == 24) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 25 && imgPositionNumber == 25) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 26 && imgPositionNumber == 26) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 27 && imgPositionNumber == 27) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 28 && imgPositionNumber == 28) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 29 && imgPositionNumber == 29) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 30 && imgPositionNumber == 30) {
            showTextView.setText("CORRECT!");
        } else if (carPosition == 31 && imgPositionNumber == 31) {
            showTextView.setText("CORRECT!");
        } else {
            showTextView.setText("WRONG!");
            int image = carList[imgPositionNumber];
            String resourceName = getResources().getResourceName(image);
            TextView answer = findViewById(R.id.answer_textview);
            answer.setText(resourceName);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}