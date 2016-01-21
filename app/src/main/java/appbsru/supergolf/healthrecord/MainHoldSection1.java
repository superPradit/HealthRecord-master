package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainHoldSection1 extends AppCompatActivity implements View.OnClickListener {

    //explicit
    private ImageView section1ImageView, section2ImageView;

    private TextView section11TextView, section12TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hold_section1);

        //Bind Widget
        bindwidget();

        //Image Controller
        imageController();
    } //Main method

    private void imageController() {
        section1ImageView.setOnClickListener(this);
        section2ImageView.setOnClickListener(this);
        section11TextView.setOnClickListener(this);
        section12TextView.setOnClickListener(this);
    }

    private void bindwidget() {

        section1ImageView = (ImageView) findViewById(R.id.imageView5);
        section2ImageView = (ImageView) findViewById(R.id.imageView6);
        section11TextView = (TextView) findViewById(R.id.textView7);
        section12TextView = (TextView) findViewById(R.id.textView8);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imageView5:
                startActivity(new Intent(MainHoldSection1.this, Section1Activity.class));
                break;
            case R.id.imageView6:
                startActivity(new Intent(MainHoldSection1.this, Section12Activity.class));
                break;
        }// switch

        switch (v.getId()) {
            case R.id.textView7:
                startActivity(new Intent(MainHoldSection1.this, Section1Activity.class));
                break;
            case R.id.textView8:
                startActivity(new Intent(MainHoldSection1.this, Section12Activity.class));
                break;
        }//switch

    } // onClick
} //Main Class
