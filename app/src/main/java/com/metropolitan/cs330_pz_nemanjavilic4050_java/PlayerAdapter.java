package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerView> {

    ArrayList<com.metropolitan.cs330_pz_nemanjavilic4050_java.Player> playersList = new ArrayList<>();

    public PlayerAdapter(ArrayList<com.metropolitan.cs330_pz_nemanjavilic4050_java.Player> playersList) {
        this.playersList = playersList;
    }

    @NonNull
    @Override
    public PlayerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_player,parent,false);

        return new PlayerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerView holder, int position) {
        com.metropolitan.cs330_pz_nemanjavilic4050_java.Player player = playersList.get(position);
        holder.textPlayerName.setText(player.getPlayerName());
        holder.textPlayerScore.setText(""+player.getScore());
    }

    @Override
    public int getItemCount() {
        return playersList.size();
    }


    public class PlayerView extends RecyclerView.ViewHolder{

        TextView textPlayerName,textPlayerScore;
        ImageView imageViewPlus, imageViewMinus;
        int score;
        public PlayerView(@NonNull View itemView) {
            super(itemView);

            textPlayerName = (TextView)itemView.findViewById(R.id.text_player_name);
            textPlayerScore = (TextView)itemView.findViewById(R.id.text_player_score);

            imageViewMinus = (ImageView) itemView.findViewById(R.id.image_minus);
            imageViewPlus = (ImageView) itemView.findViewById(R.id.image_plus);

            imageViewPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    score = Integer.parseInt(textPlayerScore.getText().toString());
                    score++;
                    for(int i = 0;i<playersList.size();i++)
                        if(playersList.get(i).getPlayerName().equals(textPlayerName.getText().toString()))
                            playersList.get(i).setScore(score);
                    textPlayerScore.setText("" + score);
                }
            });

            imageViewMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                score = Integer.parseInt(textPlayerScore.getText().toString());
                score--;
                for(int i = 0;i<playersList.size();i++)
                    if(playersList.get(i).getPlayerName().equals(textPlayerName.getText().toString()))
                        playersList.get(i).setScore(score);
                textPlayerScore.setText("" + score);
            }
        });

        }
    }

}
