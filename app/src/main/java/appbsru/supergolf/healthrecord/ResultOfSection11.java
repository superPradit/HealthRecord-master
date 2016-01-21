package appbsru.supergolf.healthrecord;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultOfSection11 extends AppCompatActivity {

    //Explicit
    private int ageAnInt, sexAnInt, pressureAnInt, diabetesAnInt,
                indexMassAnInt, widthAnInt ,summaryAnInt;

    private Double heightADouble, weightADouble, widthADouble, indexMassADouble;

    private TextView riskTextView, introTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_section11);

        //bind widget
        bindwidget();

        //Receive Value Intent
        receiveValueFormIntent();

        indexMassAnInt = findIndexMass();

        widthAnInt = findIndexWidth();

        summaryAnInt = summaryHealth();

        showIntro();

        showTxT();

        //show Log
        showLog();

    }// Main method



    private void showIntro() {
        if (summaryAnInt <= 2) {
            introTextView.setText("ออกกำลังกายสม่ำเสมอ\nควมคุมน้ำหนักตัวให้อยู่ในเกณฑ์ที่เหมาะสม\nตรวจวัดความดันโลหิต\nควรประเมินความเสี่ยงซ้ำทุก 3 ปี");
        } else if (summaryAnInt <= 5) {
            introTextView.setText("ออกกำลังกายสม่ำเสมอ\nควมคุมน้ำหนักตัวให้อยู่ในเกณฑ์ที่เหมาะสม\nตรวจวัดความดันโลหิต\nควรประเมินความเสี่ยงซ้ำทุก 1-3 ปี");
        } else if (summaryAnInt <= 8) {
            introTextView.setText("ออกกำลังกายสม่ำเสมอ\nควมคุมน้ำหนักตัวให้อยู่ในเกณฑ์ที่เหมาะสม\nตรวจวัดความดันโลหิต\nตรวจระดับน้ำตาลในเลือด\nควรประเมินความเสี่ยงซ้ำทุก 1-3 ปี\n");
        } else {
            introTextView.setText("ออกกำลังกายสม่ำเสมอ\nควมคุมน้ำหนักตัวให้อยู่ในเกณฑ์ที่เหมาะสม\nตรวจวัดความดันโลหิต\nตรวจระดับน้ำตาลในเลือด\nควรประเมินความเสี่ยงซ้ำทุก 1 ปี");
        }
    }

    private void showTxT() {
        if (summaryAnInt <= 2) {
            riskTextView.setText("น้อย");
            riskTextView.setTextColor(Color.parseColor("#70FF00"));
        } else if (summaryAnInt <= 5) {
            riskTextView.setText("ปานกลาง");
            riskTextView.setTextColor(Color.parseColor("#FFFF00"));
        } else if (summaryAnInt <= 8) {
            riskTextView.setText("สูง");
            riskTextView.setTextColor(Color.parseColor("#FF9900"));
        } else {
            riskTextView.setText("สูงมาก");
            riskTextView.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    private void bindwidget() {
        riskTextView = (TextView) findViewById(R.id.txtShowRisk);
        introTextView = (TextView) findViewById(R.id.txtShowIntro);

    }

    private int summaryHealth() {
        int intSummary = 0;

        intSummary = ageAnInt + sexAnInt + indexMassAnInt + widthAnInt + pressureAnInt + diabetesAnInt;

        return intSummary;
    }

    private int findIndexWidth() {

        int intIndex = 0;
        if (sexAnInt == 0) {
            //Male
            if (widthADouble < 90.0) {
                intIndex = 0;
            } else {
                intIndex = 2;
            }

        } else {
            //Female
            if (widthADouble < 80.0) {
                intIndex = 0;
            } else {
                intIndex = 2;
            }
        }

        return intIndex;
    }

    private void showLog() {

        String tag = "Result11";
        Log.d(tag, "indexDouble = " + indexMassADouble);
        Log.d(tag, "indexAnInt = " + indexMassAnInt);
        Log.d(tag, "indexWidth = " + widthAnInt);
        Log.d(tag, "indexHealth = " + summaryAnInt);

    } // showLog

    private int findIndexMass() {

        int intIndex = 0;
        indexMassADouble = weightADouble / Math.pow(heightADouble, 2);
        if (indexMassADouble < 23.0) {
            intIndex = 0;
        } else if (indexMassADouble < 27.5) {
            intIndex = 3;
        } else {
            intIndex = 5;
        }
        return intIndex;
    }

    private void receiveValueFormIntent() {

        ageAnInt = getIntent().getIntExtra("Age", 0);
        sexAnInt = getIntent().getIntExtra("Sex", 0);
        pressureAnInt = getIntent().getIntExtra("Pressue", 0);
        diabetesAnInt = getIntent().getIntExtra("Diabetes", 0);
        heightADouble = getIntent().getDoubleExtra("Height", 0);
        weightADouble = getIntent().getDoubleExtra("Weight", 0);
        widthADouble = getIntent().getDoubleExtra("Width", 0);

    } // receiviValueFormIntent

} //Main Class
