package com.android.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HintsActivity extends AppCompatActivity {

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

    int imgPositionNumber = callRandom();


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

    String guessCar = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hints);


        getRandomCar();

        TextView textView = findViewById(R.id.textView);

            String car = carNamesAr[imgPositionNumber];
            guessCar = car.replaceAll("(?s).", "_");
            textView.setText(guessCar);

    }

    public void getRandomCar() {
        ImageView imageView = findViewById(R.id.hints_car_image_imageview);
        imageView.setImageResource(carList[imgPositionNumber]);
    }

    public void launchSubmitBtn(View view) {

        checkLetter();
    }

//    StringBuilder astonMartin = new StringBuilder("_____-______");

    public void checkLetter() {

        EditText editText = findViewById(R.id.answer_text);
        char[] charArray = carNamesAr[imgPositionNumber].toCharArray();
        List newCharArray = new ArrayList<Character>();

        if (editText != null) {

            String letter = String.valueOf(editText.getText());

            for (int i = 0; i < charArray.length; i++) {
//                    getting 0 th position of letter char
                if (charArray[i] == letter.charAt(0)) {
                    newCharArray.add(letter);

                    StringBuilder myName = new StringBuilder(guessCar);
                    myName.setCharAt(i, letter.charAt(0));
                    TextView textView = findViewById(R.id.textView);
                    textView.setText(myName);
                    guessCar = String.valueOf(myName);
                }
            }
        }

    }
}