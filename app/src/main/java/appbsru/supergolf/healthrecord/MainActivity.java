package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView section1ImageView, section2ImageView,
            section3ImageView, section4ImageView;

    private TextView section1TextView, section2TextView, section3TextView, section4TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindwidget();

        //Image Controller
        imageController();

        //TextView Controller
        textViewController();

    } //Main Method

    private void textViewController() {
        section1TextView.setOnClickListener(this);
        section2TextView.setOnClickListener(this);
        section3TextView.setOnClickListener(this);
        section4TextView.setOnClickListener(this);
    }

    private void imageController() {
        section1ImageView.setOnClickListener(this);
        section2ImageView.setOnClickListener(this);
        section3ImageView.setOnClickListener(this);
        section4ImageView.setOnClickListener(this);
    }

    private void bindwidget() {
        section1ImageView = (ImageView) findViewById(R.id.imageView);
        section2ImageView = (ImageView) findViewById(R.id.imageView2);
        section3ImageView = (ImageView) findViewById(R.id.imageView3);
        section4ImageView = (ImageView) findViewById(R.id.imageView4);
        section1TextView = (TextView) findViewById(R.id.textView);
        section2TextView = (TextView) findViewById(R.id.textView2);
        section3TextView = (TextView) findViewById(R.id.textView3);
        section4TextView = (TextView) findViewById(R.id.textView4);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageView:
                startActivity(new Intent(MainActivity.this, MainHoldSection1.class));
                break;
            case R.id.imageView2:
                startActivity(new Intent(MainActivity.this, Section2Activity.class));
                break;
            case R.id.imageView3:
                break;
            case R.id.imageView4:
                break;
        } //switch

        switch (v.getId()) {
            case R.id.textView:
                startActivity(new Intent(MainActivity.this, MainHoldSection1.class));
                break;
            case R.id.textView2:
                startActivity(new Intent(MainActivity.this, Section2Activity.class));
                break;
            case R.id.textView3:
                break;
            case R.id.textView4:
                break;
        }//switch TextView

    } // onClick

} //Main Class
