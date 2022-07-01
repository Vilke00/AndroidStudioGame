package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PlayerScore extends AppCompatActivity {

    Button btn;

    RecyclerView recyclerPlayers;
    ArrayList<Player> playersList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_score);

        recyclerPlayers = findViewById(R.id.recycler_players);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerPlayers.setLayoutManager(layoutManager);

        ArrayList<Player> myList = (ArrayList<Player>) getIntent().getSerializableExtra("list");
        int qid = getIntent().getIntExtra("qid", 0);

        recyclerPlayers.setAdapter(new PlayerAdapter(myList));

        btn = (Button) findViewById(R.id.buttonNextAn);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(qid<5) {
                    int tmp = qid - 1;
                    Intent intent = new Intent(PlayerScore.this, QuizActivity.class);
                    intent.putExtra("list", myList);
                    intent.putExtra("qid", tmp);
                    startActivity(intent);
                }
                else{
                    //Aktivnost pobeda
                    Intent intent = new Intent(PlayerScore.this, ActivityWinner.class);
                    intent.putExtra("list", myList);
                    startActivity(intent);
                }
            }
        });

    }
}