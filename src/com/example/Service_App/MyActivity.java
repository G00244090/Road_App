package com.example.Service_App;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MyActivity extends Activity implements OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.Check).setOnClickListener(this);
        findViewById(R.id.Update).setOnClickListener(this);
        findViewById(R.id.Send).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Update) {
            Toast.makeText(this, "Make Selections to Update SpeedLimit", Toast.LENGTH_LONG).show();
            Button btn = (Button) findViewById(R.id.Check);
            btn.setEnabled(true);
            Intent id = new Intent(MyActivity.this, UpdateActivity.class);
            startActivity(id);


        } else if (v.getId() == R.id.Check) {

            Toast.makeText(this, "Make Selections to checkspeed SpeedLimit", Toast.LENGTH_LONG).show();
            Button btn2 = (Button) findViewById(R.id.Send);
            btn2.setEnabled(true);
            Intent id = new Intent(MyActivity.this, CheckActivity.class);
            startActivity(id);


        } else if (v.getId() == R.id.Send) {

        }
    }
}