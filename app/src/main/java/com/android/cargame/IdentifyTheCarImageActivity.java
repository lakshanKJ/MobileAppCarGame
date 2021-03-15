package com.android.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdentifyTheCarImageActivity extends AppCompatActivity {

    int[] carList = {R.drawable.aston_martin_one77, R.drawable.audi_e_tron, R.drawable.bentley, R.drawable.bmw_7_series, R.drawable.bugati_veyron, R.drawable.ferrari458, R.drawable.ferrari_enzo, R.drawable.ferrari_f60, R.drawable.ferrari_laferrari, R.drawable.ford_fiesta, R.drawable.jaguar_f_type,
            R.drawable.koenigsegg_one, R.drawable.koenigsegg_trevita, R.drawable.lamborghini_murcielago, R.drawable.lamborghini_veneno
            , R.drawable.lexus_lfa, R.drawable.lotus_elise, R.drawable.lykan_hypersport, R.drawable.mc_laren, R.drawable.mercedes_benz, R.drawable.mini_cooper, R.drawable.mitsubishi_evo, R.drawable.mustang_gt, R.drawable.nissan_gtr, R.drawable.paganihuayra, R.drawable.paganizonda,
            R.drawable.porche, R.drawable.range_rover, R.drawable.rolls_royce_phantom, R.drawable.subaru, R.drawable.tesla_model_s, R.drawable.zenvo};
    String[] carNamesAr = {"AstonMartinOne77", "AudiETron", "Bentley", "BMW7Series", "BugatiVeyron", "Ferrari458", "FerrariEnzo", "FerrariF60", "FerrariLaFerrari",
            "FordFiesta", "Jaguar", "KoenigseggOne", "KoenigseggTrevita", "LamborghiniMurcielgo", "LamborghiniVeneno", "Lexus", "LotusElise", "LykenHypersopr",
            "McLaren", "MercedesBenz", "MiniCooper", "MitsubishiEvo", "MustangGT", "NissanGTR", "PaganiHuayra", "PaganiZonda", "Porche", "RangeRover", "RollsRoycePhantom",
            "Subaru", "Tesla", "Zenvo"};

    List randomList = new ArrayList<Integer>();

    Random randomImage = new Random();

    List randomImageList = new ArrayList<Image>();

    int imgPositionNumberOne = callRandom();
    int imgPositionNumberTwo = callRandom(); //This cars' name will appear
    int imgPositionNumberThree = callRandom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_car_image);

        getRandomCar();
        getTime();
    }
//      Checking if the random number did use earlier
    private int callRandom() {

        int randomNumber = getRandomNumber(carList.length);

        // check if exists in old random number list
        if (randomList.contains(randomNumber)) {
            callRandom();
        } else {
            randomList.add(randomNumber);
        }
        return randomNumber;
    }
//    Get a random number
    private int getRandomNumber(int length) {

        int randomNumber = randomImage.nextInt(length);
        return randomNumber;
    }
//      Assigning images to the imageviews according to the random number
//      Assigning manufacture name to the textview
    public void getRandomCar() {
        ImageView imageViewOne = findViewById(R.id.imageviewOne);
        imageViewOne.setImageResource(carList[imgPositionNumberOne]);

        ImageView imageViewTwo = findViewById(R.id.imageviewTwo);
        imageViewTwo.setImageResource(carList[imgPositionNumberTwo]);

        ImageView imageViewThree = findViewById(R.id.imageviewThree);
        imageViewThree.setImageResource(carList[imgPositionNumberThree]);

        TextView textView = findViewById(R.id.car_manufacture_textView);
        textView.setText(carNamesAr[imgPositionNumberTwo]);
    }

    //Check the answer on image one click
    public void checkAnswerOnClickOne(View view){
        TextView textView = findViewById(R.id.match_answer_textview);
        textView.setVisibility(View.VISIBLE);
        textView.setText("WRONG!");
    }

    //Check the answer on image two click
    public void checkAnswerOnClickTwo(View view){
        TextView textView = findViewById(R.id.match_answer_textview);
        textView.setVisibility(View.VISIBLE);
        textView.setText("CORRECT!");
        textView.setTextColor(Color.GREEN);
    }

    //Check the answer on image three click
    public void checkAnswerOnClickThree(View view){
        TextView textView = findViewById(R.id.match_answer_textview);
        textView.setVisibility(View.VISIBLE);
        textView.setText("WRONG!");
    }

    //on click next button
    public void nextOnClick(View view){
        TextView textViewTwo = findViewById(R.id.match_answer_textview);
        textViewTwo.setVisibility(View.INVISIBLE);
        textViewTwo.setText("");
        textViewTwo.setTextColor(Color.RED);

        imgPositionNumberOne = callRandom();
        imgPositionNumberTwo = callRandom(); //This cars' name will appear
        imgPositionNumberThree = callRandom();

        getRandomCar();
        getTime();
    }

    public void getTime(){
        CountDownTimer timer = new CountDownTimer(20000, 1000) {

            TextView timerTextview = findViewById(R.id.identify_timer_textView);

            public void onTick(long millisUntilFinished) {
                timerTextview.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerTextview.setText("Time's up!");

                TextView textViewTwo = findViewById(R.id.match_answer_textview);
                textViewTwo.setVisibility(View.INVISIBLE);
                textViewTwo.setText("");
                textViewTwo.setTextColor(Color.RED);

                imgPositionNumberOne = callRandom();
                imgPositionNumberTwo = callRandom(); //This cars' name will appear
                imgPositionNumberThree = callRandom();

                getRandomCar();
            }
        };

        Boolean isTimerOn = getIntent().getBooleanExtra("TIMER_VALUE", false);

        if (isTimerOn) {
            timer.start();
        }
    }
}

//swap images, randomly,always 2nd image is correct
//can click only one time