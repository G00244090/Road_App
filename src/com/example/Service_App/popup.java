package com.example.Service_App;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class popup extends Activity {

    ImageView Speed;
    String value = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        Speed = (ImageView) findViewById(R.id.Speedimage);
        //Speed.setVisibility(View.VISIBLE);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels+300;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getString("Speed");
        }
        if(value.contains("30 Km/h")) {
            Speed.setImageResource(R.drawable.thirty);
        }
        else if(value.contains("50 Km/h")) {
            Speed.setImageResource(R.drawable.fifty);
        }
        else if(value.contains("60 Km/h")) {
            Speed.setImageResource(R.drawable.sixty);
        }
        else if(value.contains("80 Km/h")) {
            Speed.setImageResource(R.drawable.eighty);
        }
        else if(value.contains("100 Km/h")) {
            Speed.setImageResource(R.drawable.onehun);
        }
        else if(value.contains("120 Km/h")) {
            Speed.setImageResource(R.drawable.onetwen);
        }

    }// onCreate


}// ActivityMain