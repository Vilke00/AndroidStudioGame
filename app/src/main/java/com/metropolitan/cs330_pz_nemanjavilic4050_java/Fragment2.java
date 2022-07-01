package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    TextView textView;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState)
    {
        View view = inflater
                .inflate(
                        R.layout.fragment_2,
                        container, false);


        int quizId = getActivity().getIntent().getIntExtra("gameId", 1);

        textView = (TextView) view.findViewById(R.id.textView4);
        if(quizId == 2)
            textView.setText(R.string.SpyfallGameRules);
        else if(quizId == 3)
            textView.setText(R.string.AntarticaGameRules);

        return view;
    }
}