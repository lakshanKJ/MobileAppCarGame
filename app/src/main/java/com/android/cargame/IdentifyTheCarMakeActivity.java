package com.android.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdentifyTheCarMakeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int[] carList ={R.drawable.aston_martin_one77,R.drawable.audi_e_tron,R.drawable.bentley,R.drawable.bmw_7_series,R.drawable.bugati_veyron,R.drawable.ferrari458,R.drawable.ferrari_enzo,R.drawable.ferrari_f60,R.drawable.ferrari_laferrari,R.drawable.ford_fiesta,R.drawable.jaguar_f_type,
            R.drawable.koenigsegg_one,R.drawable.koenigsegg_trevita,R.drawable.lamborghini_murcielago,R.drawable.lamborghini_veneno
            ,R.drawable.lexus_lfa,R.drawable.lotus_elise,R.drawable.lykan_hypersport,R.drawable.mc_laren,R.drawable.mercedes_benz,R.drawable.mini_cooper,R.drawable.mitsubishi_evo,R.drawable.mustang_gt,R.drawable.nissan_gtr,R.drawable.paganihuayra,R.drawable.paganizonda,
            R.drawable.porche,R.drawable.range_rover,R.drawable.rolls_royce_phantom,R.drawable.subaru,R.drawable.tesla_model_s,R.drawable.zenvo};

    String[] carNamesAr = {"AstonMartinOne77", "AudiETron", "Bentley", "BMW7Series", "BugatiVeyron", "Ferrari458", "FerrariEnzo", "FerrariF60", "FerrariLaFerrari",
            "FordFiesta", "Jaguar", "KoenigseggOne", "KoenigseggTrevita", "LamborghiniMurcielgo", "LamborghiniVeneno", "Lexus", "LotusElise", "LykenHypersopr",
            "McLaren", "MercedesBenz", "MiniCooper", "MitsubishiEvo", "MustangGT", "NissanGTR", "PaganiHuayra", "PaganiZonda", "Porche", "RangeRover", "RollsRoycePhantom",
            "Subaru", "Tesla", "Zenvo"};

    List randomList = new ArrayList<Integer>();

    Random randomImage = new Random();

    int imgPositionNumber = callRandom();
    int carPositionInDropDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_car_make);

        getRandomCar();
        getTime();

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


    private int getRandomNumber(int length) {

        int randomNumber = randomImage.nextInt(length);
        return randomNumber;
    }

    public void getRandomCar(){
        ImageView imageView = findViewById(R.id.imageviewTwo);
        imageView.setImageResource(carList[imgPositionNumber]);
    }

    public void onIdentifyBtnClicked(View view){
        processInIdentifyBtn();

    }

    public void launchNextBtn(View view){

        TextView textView = findViewById(R.id.right_result_textView);
        textView.setVisibility(View.INVISIBLE);
        textView.setText("");

        TextView answer = findViewById(R.id.answer_textview);
        answer.setText("");

        imgPositionNumber = callRandom();

        getRandomCar();
        getTime();

        Button identifyBtn = findViewById(R.id.identify_button);
        identifyBtn.setText("IDENTIFY");
        identifyBtn.setOnClickListener(this::onIdentifyBtnClicked);

    }

    public void getTime(){
        CountDownTimer timer = new CountDownTimer(20000, 1000) {

            TextView timerTextview = findViewById(R.id.carMake_timer_textView);

            public void onTick(long millisUntilFinished) {
                timerTextview.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerTextview.setText("Time's up!");

                processInIdentifyBtn();
            }
        };

        Boolean isTimerOn = getIntent().getBooleanExtra("TIMER_VALUE", false);

        if (isTimerOn) {
            timer.start();
        }
    }

    public void processInIdentifyBtn(){
        TextView showTextView = findViewById(R.id.right_result_textView);
        showTextView.setVisibility(View.VISIBLE);
        showTextView.setTextColor(Color.GREEN);


        if (carPositionInDropDown == 0 && imgPositionNumber == 0) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 1 && imgPositionNumber == 1) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 2 && imgPositionNumber == 2) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 3 && imgPositionNumber == 3) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 4 && imgPositionNumber == 4) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 5 && imgPositionNumber == 5) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 6 && imgPositionNumber == 6) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 7 && imgPositionNumber == 7) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 8 && imgPositionNumber == 8) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 9 && imgPositionNumber == 9) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 10 && imgPositionNumber == 10) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 11 && imgPositionNumber == 11) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 12 && imgPositionNumber == 12) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 13 && imgPositionNumber == 13) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 14 && imgPositionNumber == 14) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 15 && imgPositionNumber == 15) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 16 && imgPositionNumber == 16) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 17 && imgPositionNumber == 17) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 18 && imgPositionNumber == 18) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 19 && imgPositionNumber == 19) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 20 && imgPositionNumber == 20) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 21 && imgPositionNumber == 21) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 22 && imgPositionNumber == 22) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 23 && imgPositionNumber == 23) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 24 && imgPositionNumber == 24) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 25 && imgPositionNumber == 25) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 26 && imgPositionNumber == 26) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 27 && imgPositionNumber == 27) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 28 && imgPositionNumber == 28) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 29 && imgPositionNumber == 29) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 30 && imgPositionNumber == 30) {
            showTextView.setText("CORRECT!");
        } else if (carPositionInDropDown == 31 && imgPositionNumber == 31) {
            showTextView.setText("CORRECT!");
        } else {
            showTextView.setText("WRONG!");
            showTextView.setTextColor(Color.RED);
            int image = carList[imgPositionNumber];
            String resourceName = getResources().getResourceName(image);
            TextView answer = findViewById(R.id.answer_textview);
            answer.setText(resourceName);

        }

        Button button = findViewById(R.id.identify_button);
        button.setText("Next");
        button.setOnClickListener(this::launchNextBtn);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        carPositionInDropDown = parent.getSelectedItemPosition();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}