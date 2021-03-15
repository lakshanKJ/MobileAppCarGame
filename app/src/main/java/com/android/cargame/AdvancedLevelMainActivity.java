package com.android.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdvancedLevelMainActivity extends AppCompatActivity {

    int[] carList = {R.drawable.aston_martin_one77, R.drawable.audi_e_tron, R.drawable.bentley, R.drawable.bmw_7_series, R.drawable.bugati_veyron, R.drawable.ferrari458, R.drawable.ferrari_enzo, R.drawable.ferrari_f60, R.drawable.ferrari_laferrari, R.drawable.ford_fiesta, R.drawable.jaguar_f_type,
            R.drawable.koenigsegg_one, R.drawable.koenigsegg_trevita, R.drawable.lamborghini_murcielago, R.drawable.lamborghini_veneno
            , R.drawable.lexus_lfa, R.drawable.lotus_elise, R.drawable.lykan_hypersport, R.drawable.mc_laren, R.drawable.mercedes_benz, R.drawable.mini_cooper, R.drawable.mitsubishi_evo, R.drawable.mustang_gt, R.drawable.nissan_gtr, R.drawable.paganihuayra, R.drawable.paganizonda,
            R.drawable.porche, R.drawable.range_rover, R.drawable.rolls_royce_phantom, R.drawable.subaru, R.drawable.tesla_model_s, R.drawable.zenvo};
    String[] carNamesAr = {"AstonMartinOne77", "AudiETron", "Bentley", "BMW7Series", "BugatiVeyron", "Ferrari458", "FerrariEnzo", "FerrariF60", "FerrariLaFerrari",
            "FordFiesta", "Jaguar", "KoenigseggOne", "KoenigseggTrevita", "LamborghiniMurcielgo", "LamborghiniVeneno", "Lexus", "LotusElise", "LykenHypersopr",
            "McLaren", "MercedesBenz", "MiniCooper", "MitsubishiEvo", "MustangGT", "NissanGTR", "PaganiHuayra", "PaganiZonda", "Porche", "RangeRover", "RollsRoycePhantom",
            "Subaru", "Tesla", "Zenvo"};

    int incorrectAttempts = 0; //Maximum incorrect attempts are 3
    List randomList = new ArrayList<Integer>();

    Random randomImage = new Random();

    int imgPositionNumberOne = callRandom();
    int imgPositionNumberTwo = callRandom();
    int imgPositionNumberThree = callRandom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level_main);

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
        ImageView imageViewOne = findViewById(R.id.first_imageview);
        imageViewOne.setImageResource(carList[imgPositionNumberOne]);

        ImageView imageViewTwo = findViewById(R.id.second_imageview);
        imageViewTwo.setImageResource(carList[imgPositionNumberTwo]);

        ImageView imageViewThree = findViewById(R.id.third_imageview);
        imageViewThree.setImageResource(carList[imgPositionNumberThree]);

//        TextView textView = findViewById(R.id.car_manufacture_textView);
//        textView.setText(carNamesAr[imgPositionNumberTwo]);
    }

    public void launchSubmitBtnAdvanced(View view) {
        processInAdvancedSubmitBtn();
    }

    public void launchNextBtn(View view){

        incorrectAttempts = 0;
        EditText editTextOne = findViewById(R.id.editText_one);
        EditText editTextTwo = findViewById(R.id.editText_two);
        EditText editTextThree = findViewById(R.id.editText_three);

        editTextOne.setEnabled(true);
        editTextTwo.setEnabled(true);
        editTextThree.setEnabled(true);

        editTextOne.setText(null);
        editTextTwo.setText(null);
        editTextThree.setText(null);

        editTextOne.setTextColor(Color.BLACK);
        editTextTwo.setTextColor(Color.BLACK);
        editTextThree.setTextColor(Color.BLACK);

        TextView textView = findViewById(R.id.finalresult_textView);
        textView.setVisibility(View.INVISIBLE);
        TextView marks = findViewById(R.id.mark_textView);
        marks.setVisibility(View.INVISIBLE);

        imgPositionNumberOne = callRandom();
        imgPositionNumberTwo = callRandom();
        imgPositionNumberThree = callRandom();

        getRandomCar();
        getTime();

        Button submitBtn = findViewById(R.id.submittexts_button);
        submitBtn.setText("SUBMIT");
        submitBtn.setOnClickListener(this::launchSubmitBtnAdvanced);

    }

    public void processInAdvancedSubmitBtn(){
        EditText editTextOne = findViewById(R.id.editText_one);
        EditText editTextTwo = findViewById(R.id.editText_two);
        EditText editTextThree = findViewById(R.id.editText_three);
        TextView textView = findViewById(R.id.finalresult_textView);
        textView.setVisibility(View.INVISIBLE);

        TextView marks = findViewById(R.id.mark_textView);
        marks.setVisibility(View.INVISIBLE);

        int answerOne = 0;
        int answerTwo = 0;
        int answerThree = 0;

        int markOne = 0;
        int markTwo = 0;
        int markThree = 0;

        if (incorrectAttempts < 3) {

            if (editTextOne != null && editTextTwo != null && editTextThree != null) {

                String textOne = editTextOne.getText().toString();
                String textTwo = editTextTwo.getText().toString();
                String textThree = editTextThree.getText().toString();

                if (!textOne.isEmpty() && !textTwo.isEmpty() && !textThree.isEmpty()) {

                    if (carNamesAr[imgPositionNumberOne].toUpperCase().equals(textOne.toUpperCase())) {
                        editTextOne.setTextColor(Color.GREEN);
                        editTextOne.setEnabled(false);
                        answerOne = 1;
                        markOne = 1;
                    } else {
                        editTextOne.setTextColor(Color.RED);
                    }

                    if (carNamesAr[imgPositionNumberTwo].toUpperCase().equals(textTwo.toUpperCase())) {
                        editTextTwo.setTextColor(Color.GREEN);
                        editTextTwo.setEnabled(false);
                        answerTwo = 1;
                        markTwo = 1;
                    } else {
                        editTextTwo.setTextColor(Color.RED);
                    }

                    if (carNamesAr[imgPositionNumberThree].toUpperCase().equals(textThree.toUpperCase())) {
                        editTextThree.setTextColor(Color.GREEN);
                        editTextThree.setEnabled(false);
                        answerThree = 1;
                        markThree = 1;
                    } else {
                        editTextThree.setTextColor(Color.RED);
                    }

                    if (answerOne == 1 && answerTwo == 1 && answerThree == 1) {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("CORRECT!");
                        textView.setTextColor(Color.GREEN);

                        Button submitBtn = findViewById(R.id.submittexts_button);
                        submitBtn.setText("NEXT");
                        submitBtn.setOnClickListener(this::launchNextBtn);
                    } else {
                        incorrectAttempts++;
                    }
                }else {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Fill all the text boxes!");
                }

            } else {
                textView.setVisibility(View.VISIBLE);
                textView.setText("Fill your answers in all three text boxes!");
            }
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText("You attempts are over, Try again");
            Button submitBtn = findViewById(R.id.submittexts_button);
            submitBtn.setText("NEXT");
            submitBtn.setOnClickListener(this::launchNextBtn);
        }

        int finalMark = markOne + markTwo + markThree;
        marks.setVisibility(View.VISIBLE);
        marks.setText("You got " + finalMark + " marks...");

    }

    public void getTime(){
        CountDownTimer timer = new CountDownTimer(20000, 1000) {

            TextView timerTextview = findViewById(R.id.advanced_timer_textView);

            public void onTick(long millisUntilFinished) {
                timerTextview.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerTextview.setText("Time's up!");

                processInAdvancedSubmitBtn();
            }
        };

        Boolean isTimerOn = getIntent().getBooleanExtra("TIMER_VALUE", false);

        if (isTimerOn) {
            timer.start();
        }
    }
}