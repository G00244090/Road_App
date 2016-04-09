package com.example.Service_App;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class UpdateActivity extends Activity {


    TextView SelectCounty;
    TextView SelectType;
    TextView SelectArea;
    TextView SelectSpeed;
    Spinner county;
    Spinner road;
    Spinner list;
    Spinner speed;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatespeed);
        SelectCounty = (TextView) findViewById(R.id.selectcounty);
        SelectType = (TextView) findViewById(R.id.selectroad);
        SelectArea = (TextView) findViewById(R.id.selectlist);
        SelectSpeed = (TextView) findViewById(R.id.selectspeed);
        county = (Spinner) findViewById(R.id.county);
        road = (Spinner) findViewById(R.id.road);
        list = (Spinner) findViewById(R.id.list);
        speed = (Spinner) findViewById(R.id.speed);

    }// onCreate

}// ActivityMain