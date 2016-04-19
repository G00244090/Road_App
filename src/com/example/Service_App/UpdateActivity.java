package com.example.Service_App;

import android.app.Activity;
import android.content.BroadcastReceiver;
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
import java.io.PrintWriter;
import java.net.Socket;
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
     PrintWriter output; // output stream to client
//     BufferedReader input; // input stream from client
//     ServerSocket server; // server socket
     Socket connection; // connection to client

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
        String[] dublinNat = new String[]{"D", "N58", "N59", "N60", "N83","N84"};
        String[] dublinMot = new String[]{"D", "M1", "M2", "M3", "M4", "M50"};
        String[] dublinReg = new String[]{"D", "R125", "R126", "R130", "R145", "R150"};

        String[] galwayNat = new String[]{"G",  "N18", "N60", "N66","N67","N59"};
        String[] galwayMot = new String[]{"G", "M6", "M7", "M8", "M9"};
        String[] galwayReg = new String[]{"G", "R333", "R337", "R336", "R339", "R346"};

        String[] mayoNat = new String[]{"Mo", "N58", "N59", "N60", "N83", "N84"};
        String[] mayoMot = new String[]{"Mo", "M6", "M7", "M8", "M9"};
        String[] mayoReg = new String[]{"Mo", "R326", "R328", "R329", "R330","R320","R325"};

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
        CountyArray.add("dublin");
        CountyArray.add("galway");
        CountyArray.add("mayo");
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
        broadcast.setClickable(false);
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
                        if(county.getSelectedItem().toString() == "dublin") {

                            for(int i =0; i<dublinNat.length;i++)
                            TypeArray.add(""+dublinNat[i]);

                        }
                        else if(county.getSelectedItem().toString() == "galway") {
                            for (int i = 0; i < galwayNat.length; i++)
                                TypeArray.add("" + galwayNat[i]);
                        }
                        else if (county.getSelectedItem().toString() == "mayo") {
                            for (int i = 0; i < mayoNat.length; i++)
                                TypeArray.add("" + mayoNat[i]);
                        }
                    }
                    if (road.getSelectedItem().toString() == "Motorway Regional") {
                        if(county.getSelectedItem().toString() == "dublin") {

                            for(int i =0; i<dublinMot.length;i++)
                                TypeArray.add(""+dublinMot[i]);

                        }
                        else if(county.getSelectedItem().toString() == "galway") {
                            for (int i = 0; i < galwayMot.length; i++)
                                TypeArray.add("" + galwayMot[i]);
                        }
                        else if (county.getSelectedItem().toString() == "mayo") {
                            for (int i = 0; i < mayoMot.length; i++)
                                TypeArray.add("" + mayoMot[i]);
                        }
                    }
                    if (road.getSelectedItem().toString() == "Regional Route") {
                        if(county.getSelectedItem().toString() == "dublin") {

                            for(int i =0; i<dublinReg.length;i++)
                                TypeArray.add(""+dublinReg[i]);

                        }
                        else if(county.getSelectedItem().toString() == "galway") {
                            for (int i = 0; i < galwayReg.length; i++)
                                TypeArray.add("" + galwayReg[i]);
                        }
                        else if (county.getSelectedItem().toString() == "mayo") {
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
                if (county.getSelectedItem().toString() == "Select County List" || road.getSelectedItem().toString() == "Select Road Type List" ||list.getSelectedItem().toString() == "N/A"){
                    broadcast.setClickable(false);
                }
                else {
                    broadcast.setClickable(true);
                    ArrayList<String> pass = new ArrayList<String>();
                    pass.add(" "+county.getSelectedItem().toString());
                    pass.add("  "+road.getSelectedItem().toString());
                    pass.add(" "+list.getSelectedItem().toString());
                    pass.add(" "+speed.getSelectedItem().toString());
                    // Create socket connection
                    new HttpAsyncTask().execute(pass);

                }

                    return false;
                }
        });
    }// onCreate

    private class HttpAsyncTask extends AsyncTask<ArrayList<String>, Void, String> {

        @Override
        protected String doInBackground(ArrayList<String>... urls) {
            //ArrayList<String> result = new ArrayList<String>();
            ArrayList<String> passed = urls[0]; //get passed array

            System.out.println("INSIDE DO IN BACK HERE");
                String num1 = passed.get(0);// county.getSelectedItem().toString();
                String num2 = passed.get(1);;//road.getSelectedItem().toString();
                String num3 = passed.get(2);;//list.getSelectedItem().toString();
                String num4 = passed.get(3);;//speed.getSelectedItem().toString();

                JSONObject inputsJson = new JSONObject();
            String jsonString = " ";
            try {
                    inputsJson.accumulate("num1", num1);
                    inputsJson.accumulate("num2", num2);
                    inputsJson.accumulate("num3", num3);
                    inputsJson.accumulate("num4", num4);
                    connection = new Socket("192.168.1.100",27);
                    output = new PrintWriter(connection.getOutputStream());

                    output.println(""+inputsJson);
                    output.flush();
                    output.println(" ");
                    //output.println("CLIENT>>> TERMINATE");
//                    output.flush();
//                    output.close();
//                    output.println("CLIENT>>> TERMINATE");
//                    output.flush();
//                    connection.shutdownInput();
//                    connection.shutdownOutput();
//                    connection.close();
//                    output.close();
//                    connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
//            try {
//                connection.shutdownInput();
//                connection.shutdownOutput();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            return jsonString;
        }

    }
}// ActivityMain