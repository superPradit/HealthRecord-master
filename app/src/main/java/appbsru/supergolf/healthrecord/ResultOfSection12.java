package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class ResultOfSection12 extends AppCompatActivity {

    //Explicit
    private int ageAnInt, pressureAnInt, riskScoreAnInt, bmiAnInt, riskScoreAnInt2;
    private Double weightADouble, heightADouble, bmiADouble;
    private TextView result12TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_section12);

        //bind widget
        bindwidget();

        //Receive Value Intent
        receiveValueFormIntent();

        //riskScore
        riskScoreAnInt = riskScore1();

        //BMI
        bmiADouble = resultBMI();

        //BMI Int
        bmiAnInt = resultBMIInt();

        //riskScore
        riskScoreAnInt2 = riskScore2();

        //showTxt
        showResult12Text();

        //showLog
        showLog();

    } //Main Method

    private int riskScore2() {
        int intriskScore2;
        intriskScore2 = riskScoreAnInt + bmiAnInt;
        return intriskScore2;
    }

    private void showResult12Text() {
        if (riskScoreAnInt2 < 240) {
            result12TextView.setText("ผู้ใช้ไม่มีความเสี่ยงเป็นโรคเบาหวาน");
        } else {
            result12TextView.setText("ผู้ใช้มีความเสี่ยงเป็นโรคเบาหวานสูง\nควรพบแพทย์ตรวจวัดอย่างละเอียด");
        }

    } //showResult12Text

    private int resultBMIInt() {
        int intResultBMIInt = 0;
        intResultBMIInt = Integer.valueOf(bmiADouble.intValue());
        return intResultBMIInt;
    }


    private Double resultBMI() {
        Double DoubleResultBMI = 0.0;
        DoubleResultBMI = 5.0 * (weightADouble / Math.pow(heightADouble, 2));
        return DoubleResultBMI;
    } //resultBMI

    private int riskScore1() {
        int intRiskScore = 0;

        intRiskScore = (3 * ageAnInt)+(50 * pressureAnInt);

        return intRiskScore;

    } //riskScoreHealth


    private void showLog() {

        String tag = "result12";
        Log.d(tag, "age = " + ageAnInt);
        Log.d(tag, "height = " + heightADouble);
        Log.d(tag, "weight = " + weightADouble);
        Log.d(tag, "pressure = " + pressureAnInt);
        Log.d(tag, "BMIADouble = " + bmiADouble);
        Log.d(tag, "BMIAnInt = " + bmiAnInt);
        Log.d(tag, "RiskScore1 = " + riskScoreAnInt);
        Log.d(tag, "RiskScore2 = " + riskScoreAnInt2);

    }

    private void receiveValueFormIntent() {

        ageAnInt = getIntent().getIntExtra("Age", 0);
        weightADouble = getIntent().getDoubleExtra("Weight", 0);
        heightADouble = getIntent().getDoubleExtra("Height", 0);
        pressureAnInt = getIntent().getIntExtra("Pressure", 0);

    } //receiveValueFormIntent

    private void bindwidget() {

        result12TextView = (TextView) findViewById(R.id.txtSection12);

    }

} //Main Class
