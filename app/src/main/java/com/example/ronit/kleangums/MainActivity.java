package com.example.ronit.kleangums;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
//    private TextView currentStateOfGumsMessage, userStateOfGums, uselessBox, pinkBox, gumHistory;
//    private ScrollView scroll;
//    private GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Instantiate everything from Home Screen Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find, set listener for Floating Camera Button
        button = (Button)findViewById(R.id.floatingActionButton);
        button.setOnClickListener(this);
    }

    //Used to go from home screen to camera screen
    public void onClick(View v){
        Intent myIntent = new Intent(getBaseContext(),   CameraActivity.class);
        startActivity(myIntent);
    }
}
