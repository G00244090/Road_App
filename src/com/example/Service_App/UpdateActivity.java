package com.example.Service_App;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateActivity extends Activity {


    TextView SelectCounty;
    TextView SelectType;
    TextView SelectArea;
    TextView SelectSpeed;
    BroadcastReceiver receiver;
    Spinner county;
    Spinner road;
    Spinner list;
    Spinner speed;
    Button  broadcast;

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
        broadcast = (Button) findViewById(R.id.button);
        Map listopts = new HashMap();

        String[] dummy = new String[]{"N/A"};
        String[] dublinNat = new String[]{"N58","N59","N60","N58"};
        String[] dublinMot = new String[]{"m58","m59","m60","m58"};
        String[] dublinReg = new String[]{"r58","r59","r60","r58"};

        String[] galwayNat = new String[]{"N58","N59","N60","N58"};
        String[] galwayMot = new String[]{"m58","m59","m60","m58"};
        String[] galwayReg = new String[]{"r58","r59","r60","r58"};

        String[] mayoNat = new String[]{"N58","N59","N60","N58"};
        String[] mayoMot = new String[]{"m58","m59","m60","m58"};
        String[] mayoReg = new String[]{"r58","r59","r60","r58"};

        String[] SpeedLimit = new String[]{"30Km/h","50Km/h","60Km/h","80Km/h","100Km/h","120Km/h"};
//        listopts.put("dublinNat",dublinNat);
        List<String> CountyArray =  new ArrayList<String>();
        List<String> RoadArray =  new ArrayList<String>();
        List<String> TypeArray =  new ArrayList<String>();
        List<String> SpeedArray =  new ArrayList<String>();
        ArrayAdapter<String> countyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CountyArray);
        ArrayAdapter<String> RoadAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, RoadArray);
        ArrayAdapter<String> TypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, TypeArray);
        ArrayAdapter<String> SpeedAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SpeedArray);
        CountyArray.add("Select County List");
        CountyArray.add("Dublin");
        CountyArray.add("Galway");
        CountyArray.add("Mayo");
        RoadArray.add("Select Road Type List");
        RoadArray.add("National Route");
        RoadArray.add("Motorway Regional");
        RoadArray.add("Regional Route");
        TypeArray.add("N/A");
        SpeedArray.add("N/A");
        for(int l = 0 ; l<SpeedLimit.length; l++)
            SpeedArray.add(""+SpeedLimit[l]);

        road.setClickable(false);
        list.setClickable(false);
        speed.setClickable(false);
        countyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RoadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpeedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        county.setAdapter(countyAdapter);
        road.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (county.getSelectedItem().toString() == "Select County List"){
                    road.setClickable(false);
                road.setSelection(0);
            }
            else {
                road.setClickable(true);
            }
                return false;
            }
        });
        road.setAdapter(RoadAdapter);
        list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (county.getSelectedItem().toString() == "Select County List" || road.getSelectedItem().toString() == "Select Road Type List" ){
                    list.setClickable(false);
                    list.setSelection(0);
                }
                else {
                    TypeArray.clear();
                    if (road.getSelectedItem().toString() == "National Route") {
                        if(county.getSelectedItem().toString() == "Dublin") {

                            for(int i =0; i<dublinNat.length;i++)
                            TypeArray.add(""+dublinNat[i]);

                        }
                        else if(county.getSelectedItem().toString() == "Galway") {
                            for (int i = 0; i < galwayNat.length; i++)
                                TypeArray.add("" + galwayNat[i]);
                        }
                        else if (county.getSelectedItem().toString() == "Mayo") {
                            for (int i = 0; i < mayoNat.length; i++)
                                TypeArray.add("" + mayoNat[i]);
                        }
                    }
                    if (road.getSelectedItem().toString() == "Motorway Regional") {
                        if(county.getSelectedItem().toString() == "Dublin") {

                            for(int i =0; i<dublinMot.length;i++)
                                TypeArray.add(""+dublinMot[i]);

                        }
                        else if(county.getSelectedItem().toString() == "Galway") {
                            for (int i = 0; i < galwayMot.length; i++)
                                TypeArray.add("" + galwayMot[i]);
                        }
                        else if (county.getSelectedItem().toString() == "Mayo") {
                            for (int i = 0; i < mayoMot.length; i++)
                                TypeArray.add("" + mayoMot[i]);
                        }
                    }
                    if (road.getSelectedItem().toString() == "Regional Route") {
                        if(county.getSelectedItem().toString() == "Dublin") {

                            for(int i =0; i<dublinReg.length;i++)
                                TypeArray.add(""+dublinReg[i]);

                        }
                        else if(county.getSelectedItem().toString() == "Galway") {
                            for (int i = 0; i < galwayReg.length; i++)
                                TypeArray.add("" + galwayReg[i]);
                        }
                        else if (county.getSelectedItem().toString() == "Mayo") {
                            for (int i = 0; i < mayoReg.length; i++)
                                TypeArray.add("" + mayoReg[i]);
                        }
                    }
                   // TypeArray.get(0); //gives 1.0
                    list.setClickable(true);
                }
                return false;
            }
        });
        list.setAdapter(TypeAdapter);
        speed.setAdapter(SpeedAdapter);
        speed.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (county.getSelectedItem().toString() == "Select County List" || road.getSelectedItem().toString() == "Select Road Type List" ||list.getSelectedItem().toString() == "N/A"){
                    speed.setClickable(false);
                    speed.setSelection(0);
                }
                else {
                    speed.setClickable(true);
                }
                return false;
            }
        });
        broadcast.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText(this, "Connecting to math server", Toast.LENGTH_LONG).show();
                String num1 = county.getSelectedItem().toString();
                String num2 = road.getSelectedItem().toString();
                String num3 = list.getSelectedItem().toString();
                String num4 = speed.getSelectedItem().toString();
                SharedPreferences shared = getSharedPreferences("Shared", Activity.MODE_PRIVATE);
                SharedPreferences.Editor sharededit = shared.edit();
                sharededit.putString("num1", num1);
                sharededit.putString("num2", num2);
                sharededit.putString("num3", num3);
                sharededit.putString("num4", num4);
                sharededit.commit();
                String baseUrl = "http://192.168.1.110:27";
                JSONObject inputsJson = new JSONObject();
                //jsonObject.accumulate("name", person.getName());
                try {
                    inputsJson.accumulate("num1", num1);
                    inputsJson.accumulate("num2", num2);
                    inputsJson.accumulate("num3", num3);
                    inputsJson.accumulate("num4", num4);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                new HttpAsyncTask().execute(baseUrl, inputsJson.toString());
                return false;
            }

        });
    }// onCreate
//    @Override
//    public void onClick(View v) {
//       if (v.getId() == R.id.button) {
//            Toast.makeText(this,"Connecting to math server",Toast.LENGTH_LONG).show();
//            String num1 = county.getSelectedItem().toString();
//            String num2 = road.getSelectedItem().toString();
//            String num3 = list.getSelectedItem().toString();
//            String num4 = speed.getSelectedItem().toString();
//            SharedPreferences shared = getSharedPreferences("Shared",Activity.MODE_PRIVATE);
//            SharedPreferences.Editor sharededit= shared.edit();
//            sharededit.putString("num1",num1);
//            sharededit.putString("num2",num2);
//            sharededit.putString("num3",num3);
//            sharededit.putString("num4",num4);
//            sharededit.commit();
//            String baseUrl = "http://192.168.1.110:8080/maths-server";
//            JSONObject inputsJson = new JSONObject();
//            //jsonObject.accumulate("name", person.getName());
//            try {
//                inputsJson.accumulate("num1", Integer.parseInt(num1));
//                inputsJson.accumulate("num2", Integer.parseInt(num2));
//                inputsJson.accumulate("num3", Integer.parseInt(num3));
//                inputsJson.accumulate("num4", Integer.parseInt(num4));
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            new HttpAsyncTask().execute(baseUrl, inputsJson.toString());
//        }
//    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            System.out.println("INSIDE DO IN BACK HERE");
            String jsonString = " ";
            try {
                jsonString = HttpUtils.urlContentPost(urls[0], "loanInputs", urls[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Returned from http");
            return jsonString;
        }
    }
//        // onPostExecute displays the results of the AsyncTask.
//        @Override
//        protected void onPostExecute(String result) {
//            JSONObject jsonResult = null;
//            try {
//                jsonResult = new JSONObject(result);
//                End.clearComposingText();
//                End.append("Sum: ");
//                End.append(jsonResult.getString("Sum"));
//                End.append("Max: ");
//                End.append(jsonResult.getString("Max"));
//                End.append("Min: ");
//                End.append(jsonResult.getString("Min"));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }



}// ActivityMain