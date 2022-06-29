package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spyfall extends AppCompatActivity {

    List<String> listOfNames;
    List<String> listOfLocations;
    TextView textViewLocation, textViewSpy;
    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spyfall);

        textViewLocation = findViewById(R.id.textViewLocation);
        textViewSpy = findViewById(R.id.textViewSpy);
        btnMenu = findViewById(R.id.buttonMenu);

        int gameId = getIntent().getIntExtra("gameId", 1);
        ArrayList<Player> myList = (ArrayList<Player>) getIntent().getSerializableExtra("list");

        listOfNames = new ArrayList<>();
        listOfLocations = new ArrayList<>();

        for(int i = 0;i<myList.size();i++)
            listOfNames.add(myList.get(i).getPlayerName());

        Random randomizer = new Random();
        String randomListElement = listOfNames.get(randomizer.nextInt(listOfNames.size()));

        textViewSpy.setText(randomListElement);

        String[] array = getResources().getStringArray(R.array.location_names);
        String randomStr = array[new Random().nextInt(array.length)];

        textViewLocation.setText(randomStr);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Spyfall.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}