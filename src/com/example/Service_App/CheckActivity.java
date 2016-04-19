package com.example.Service_App;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
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
import java.util.List;

public class CheckActivity extends Activity {


    TextView SelectCounty;
    TextView SelectType;
    TextView SelectArea;
    TextView SelectSpeed;
    BroadcastReceiver receiver;
    Spinner county;
    Spinner road;
    Spinner list;
    Button broadcast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkspeed);
        SelectCounty = (TextView) findViewById(R.id.selectcounty);
        SelectType = (TextView) findViewById(R.id.selectroad);
        SelectArea = (TextView) findViewById(R.id.selectlist);
        SelectSpeed = (TextView) findViewById(R.id.selectspeed);
        county = (Spinner) findViewById(R.id.county);
        road = (Spinner) findViewById(R.id.road);
        list = (Spinner) findViewById(R.id.list);
        broadcast = (Button) findViewById(R.id.button);

        String[] dummy = new String[]{"N/A"};
        String[] dublinNat = new String[]{"D", "N58", "N59", "N60", "N83","N84"};
        String[] dublinMot = new String[]{"D", "M1", "M2", "M3", "M4", "M50"};
        String[] dublinReg = new String[]{"D", "R125", "R126", "R130", "R145", "R150"};

        String[] galwayNat = new String[]{"G",  "N18", "N60", "N66","N67","N59"};
        String[] galwayMot = new String[]{"G", "M6", "M7", "M8", "M9"};
        String[] galwayReg = new String[]{"G", "R333", "R337", "R336", "R339", "R346"};

        String[] mayoNat = new String[]{"Mo", "N58", "N59", "N60", "N83", "N84"};
        String[] mayoMot = new String[]{"Mo", "M6", "M7", "M8", "M9"};
        String[] mayoReg = new String[]{"Mo", "R326", "R328", "R329", "R330","R320","R325"};


        List<String> CountyArray = new ArrayList<String>();
        List<String> RoadArray = new ArrayList<String>();
        List<String> TypeArray = new ArrayList<String>();

        ArrayAdapter<String> countyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CountyArray);
        ArrayAdapter<String> RoadAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, RoadArray);
        ArrayAdapter<String> TypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, TypeArray);

        CountyArray.add("Select County List");
        CountyArray.add("dublin");
        CountyArray.add("galway");
        CountyArray.add("mayo");
        RoadArray.add("Select Road Type List");
        RoadArray.add("National Route");
        RoadArray.add("Motorway Regional");
        RoadArray.add("Regional Route");
        TypeArray.add("N/A");


        road.setClickable(false);
        list.setClickable(false);

        countyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RoadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        county.setAdapter(countyAdapter);
        road.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (county.getSelectedItem().toString() == "Select County List") {
                    road.setClickable(false);
                    road.setSelection(0);
                } else {
                    road.setClickable(true);
                }
                return false;
            }
        });
        road.setAdapter(RoadAdapter);
        list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (county.getSelectedItem().toString() == "Select County List" || road.getSelectedItem().toString() == "Select Road Type List") {
                    list.setClickable(false);
                    list.setSelection(0);
                } else {
                    TypeArray.clear();
                    if (road.getSelectedItem().toString() == "National Route") {
                        if (county.getSelectedItem().toString() == "dublin") {

                            for (int i = 0; i < dublinNat.length; i++)
                                TypeArray.add("" + dublinNat[i]);

                        } else if (county.getSelectedItem().toString() == "galway") {
                            for (int i = 0; i < galwayNat.length; i++)
                                TypeArray.add("" + galwayNat[i]);
                        } else if (county.getSelectedItem().toString() == "mayo") {
                            for (int i = 0; i < mayoNat.length; i++)
                                TypeArray.add("" + mayoNat[i]);
                        }
                    }
                    if (road.getSelectedItem().toString() == "Motorway Regional") {
                        if (county.getSelectedItem().toString() == "dublin") {

                            for (int i = 0; i < dublinMot.length; i++)
                                TypeArray.add("" + dublinMot[i]);

                        } else if (county.getSelectedItem().toString() == "galway") {
                            for (int i = 0; i < galwayMot.length; i++)
                                TypeArray.add("" + galwayMot[i]);
                        } else if (county.getSelectedItem().toString() == "mayo") {
                            for (int i = 0; i < mayoMot.length; i++)
                                TypeArray.add("" + mayoMot[i]);
                        }
                    }
                    if (road.getSelectedItem().toString() == "Regional Route") {
                        if (county.getSelectedItem().toString() == "dublin") {

                            for (int i = 0; i < dublinReg.length; i++)
                                TypeArray.add("" + dublinReg[i]);

                        } else if (county.getSelectedItem().toString() == "galway") {
                            for (int i = 0; i < galwayReg.length; i++)
                                TypeArray.add("" + galwayReg[i]);
                        } else if (county.getSelectedItem().toString() == "mayo") {
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

        broadcast.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText(this, "Connecting to math server", Toast.LENGTH_LONG).show();
                String num1 = county.getSelectedItem().toString();
                String num2 = road.getSelectedItem().toString();
                String num3 = list.getSelectedItem().toString();
                SharedPreferences shared = getSharedPreferences("Shared", Activity.MODE_PRIVATE);
                SharedPreferences.Editor sharededit = shared.edit();
                sharededit.putString("num1", num1);
                sharededit.putString("num2", num2);
                sharededit.putString("num3", num3);
                sharededit.commit();
                String baseUrl = "http://192.168.1.100:8080/maths-server";
                //String baseUrl = "http://178.167.152.3:8080/maths-server";
                JSONObject inputsJson = new JSONObject();
                //jsonObject.accumulate("name", person.getName());
                try {
                    inputsJson.accumulate("num1", num1);
                    inputsJson.accumulate("num2", num2);
                    inputsJson.accumulate("num3", num3);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                new HttpAsyncTask().execute(baseUrl, inputsJson.toString());
                return false;
            }

        });
    }// onCreate

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

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
           Intent id = new Intent(CheckActivity.this, popup.class);
            JSONObject jsonResult = null;
            try {
                jsonResult = new JSONObject(result);
                System.out.println("Returned: "+jsonResult.getString("Sum"));
                id.putExtra("Speed",jsonResult.getString("Sum"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
           startActivity(id);
        }
    }



}// ActivityMain