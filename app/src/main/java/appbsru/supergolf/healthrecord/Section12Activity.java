package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Section12Activity extends AppCompatActivity {

    //Explicit
    private EditText ageEditText, weightEditText, heightEditText;
    private String ageString, weightString, heightString;
    private Double weightADouble, heightADouble;
    private int ageAnInt, pressureAnInt = 0;
    private RadioGroup pressureRadioGroup;
    private RadioButton pressureNoHaveRadioButton, pressureHaveRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section12);

        //bindwidget
        bindwidget();

        //PressureChoose
        pressureChoose();


    } //Main Method

    private void pressureChoose() {

        pressureRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButton7:
                        pressureAnInt = 0;
                        break;
                    case R.id.radioButton8:
                        pressureAnInt = 1;
                        break;
                }

            }
        });

    } //pressureChoose

    public void clickSection12(View view) {
        ageString = ageEditText.getText().toString().trim();
        heightString = heightEditText.getText().toString().trim();
        weightString = weightEditText.getText().toString().trim();

        if (ageString.equals("")||heightString.equals("")||weightString.equals("")) {
            //Have Space
            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.myDialog(Section12Activity.this, R.drawable.icon_question,
                    "มีช่องว่าง", "กรุณากรอกทุกช่อง คะ");

        } else {
            //no Space
            ageAnInt = Integer.parseInt(ageString);
            heightADouble = Double.parseDouble(heightString);
            weightADouble = Double.parseDouble(weightString);

            //Intent to Result
            myIntentToResult();

        }//if

        String tag = "section12";
        Log.d(tag, "age = " + ageAnInt);
        Log.d(tag, "height = " + heightADouble);
        Log.d(tag, "weight = " + weightADouble);
        Log.d(tag, "pressure = " + pressureAnInt);
    }

    private void myIntentToResult() {

        Intent objIntent = new Intent(Section12Activity.this, ResultOfSection12.class);
        objIntent.putExtra("Age", ageAnInt);
        objIntent.putExtra("Height", heightADouble);
        objIntent.putExtra("Weight", weightADouble);
        objIntent.putExtra("Pressure", pressureAnInt);
        startActivity(objIntent);
    }

    private void bindwidget() {

        ageEditText = (EditText) findViewById(R.id.editText4);
        weightEditText = (EditText) findViewById(R.id.editText5);
        heightEditText = (EditText) findViewById(R.id.editText6);
        pressureRadioGroup = (RadioGroup) findViewById(R.id.ragPressure2);
        pressureNoHaveRadioButton = (RadioButton) findViewById(R.id.radioButton7);
        pressureHaveRadioButton = (RadioButton) findViewById(R.id.radioButton8);

    } // bindwidget
} //Main Class
