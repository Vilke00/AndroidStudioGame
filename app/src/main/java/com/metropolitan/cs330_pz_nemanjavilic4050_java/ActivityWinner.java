package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityWinner extends AppCompatActivity {

    TextView textView;
    Button btnMenu;
    int max;
    String name = "";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        int gameId = getIntent().getIntExtra("gameId", 1);


        textView = (TextView) findViewById(R.id.textViewWinner);
        btnMenu = (Button) findViewById(R.id.buttonMenu);


        if(gameId == 1){
            ArrayList<Player> myList = (ArrayList<Player>) getIntent().getSerializableExtra("list");
            max = myList.get(0).getScore();
            name = myList.get(0).getPlayerName();
            for(int i = 1;i<myList.size();i++)
                if(myList.get(i).getScore() > max){
                    max = myList.get(i).getScore();
                    name = myList.get(i).getPlayerName();
                }
            for(int i = 0;i<myList.size();i++)
                if(myList.get(i).getScore() == max && !myList.get(i).getPlayerName().equals(name)){
                    name = name + " and " + myList.get(i).getPlayerName();
                    count++;
                }
            if(count == 0)
                textView.setText("The winner is: " + name);
            else
                textView.setText("The winners are: " + name);

        }
        else if(gameId == 3){
            textView.setText("Congratulations if you made it to the end. Players with lives still left won");
        }

        btnMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityWinner.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}