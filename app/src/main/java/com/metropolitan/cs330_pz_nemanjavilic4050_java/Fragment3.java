package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment3 extends Fragment {

    LinearLayout layoutList;
    Button buttonAdd;
    Button buttonSubmitList;

    ArrayList<Player> playersList = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState)
    {
        View view = inflater
                .inflate(
                        R.layout.fragment_3,
                        container, false);

        int gameId = getActivity().getIntent().getIntExtra("gameId", 1);

        layoutList = view.findViewById(R.id.layout_list);
        buttonAdd = view.findViewById(R.id.button_add);
        buttonSubmitList = view.findViewById(R.id.button_submit_list);

        buttonAdd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(layoutList.getChildCount() >= 7)
                    buttonAdd.setEnabled(false);
                else
                    buttonAdd.setEnabled(true);

                addView();
            }
        });

        buttonSubmitList.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(checkIfValidAndRead()){
                    if(gameId == 1) {
                        Intent intent = new Intent(getActivity(), QuizActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("list", playersList);
                        bundle.putSerializable("gameId", gameId);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else if(gameId == 2) {
                        Intent intent = new Intent(getActivity(), Spyfall.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("list", playersList);
                        bundle.putSerializable("gameId", gameId);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else if(gameId == 3) {
                        Intent intent = new Intent(getActivity(), ActivityAntartica.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("list", playersList);
                        bundle.putSerializable("gameId", gameId);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }
            }
        });

        return view;
    }

    private boolean checkIfValidAndRead() {
        playersList.clear();
        boolean result = true;

        for(int i=0;i<layoutList.getChildCount();i++){

            View playerView = layoutList.getChildAt(i);

            EditText editTextName = (EditText)playerView.findViewById(R.id.edit_player_name);

            Player player = new Player();

            if(!editTextName.getText().toString().equals("")){
                player.setPlayerName(editTextName.getText().toString());
            }else {
                result = false;
                break;
            }

            playersList.add(player);

        }

        if(playersList.size()==0){
            result = false;
            Toast.makeText(getActivity(), "Add at least 1 player first!", Toast.LENGTH_SHORT).show();
        }else if(!result){
            Toast.makeText(getActivity(), "Enter All Details Correctly!", Toast.LENGTH_SHORT).show();
        }

        return result;
    }

    private void addView() {

        final View playerView = getLayoutInflater().inflate(R.layout.row_add_player,null,false);

        EditText editText = (EditText)playerView.findViewById(R.id.edit_player_name);
        ImageView imageClose = (ImageView)playerView.findViewById(R.id.image_plus);

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(playerView);
            }
        });

        layoutList.addView(playerView);

    }

    private void removeView(View view){
        if(layoutList.getChildCount() >= 9)
            buttonAdd.setEnabled(false);
        else
            buttonAdd.setEnabled(true);
        layoutList.removeView(view);

    }

}