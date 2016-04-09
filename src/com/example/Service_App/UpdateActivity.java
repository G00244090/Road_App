package com.example.Service_App;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        List<String> CountyArray =  new ArrayList<String>();
        List<String> RoadArray =  new ArrayList<String>();
        List<String> TypeArray =  new ArrayList<String>();
        List<String> SpeedArray =  new ArrayList<String>();
        ArrayAdapter<String> countyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CountyArray);
        ArrayAdapter<String> RoadAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, RoadArray);
        ArrayAdapter<String> TypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, TypeArray);
        ArrayAdapter<String> SpeedAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SpeedArray);

        CountyArray.add("Dublin");
        CountyArray.add("Galway");
        CountyArray.add("Mayo");

        RoadArray.add("National Route");
        RoadArray.add("Motorway Regional");
        RoadArray.add("Regional Route");

        countyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RoadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        county.setAdapter(countyAdapter);
        road.setAdapter(RoadAdapter);

    }// onCreate

}// ActivityMain