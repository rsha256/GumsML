package com.example.rahul.kleangums;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    //    private TextView currentStateOfGumsMessage, userStateOfGums, uselessBox, pinkBox, gumHistory;
    //    private ScrollView scroll;
    //    private GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find, set listener for Floating Camera Button
        button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(this);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    //Used to go from home screen to camera screen
    public void onClick(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}
