package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.metropolitan.cs330_pz_nemanjavilic4050_java.database.RiddleDatabase;
import com.metropolitan.cs330_pz_nemanjavilic4050_java.entity.Riddle;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    List<Riddle> quesList;
    int qid=0;
    Riddle currentQ;
    TextView txtQuestion;
    Button btnNext;
    Button btnAnsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        RiddleDatabase db=new RiddleDatabase(this);
        quesList=db.getAllRiddles();
        int tmp = getIntent().getIntExtra("qid", 0);
        qid = tmp;
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textViewRiddle);

        btnNext =(Button)findViewById(R.id.buttonNextAn);
        btnAnsw =(Button)findViewById(R.id.buttonOdgovor);
        setQuestionView();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qid<5){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                    Intent intent = new Intent(QuizActivity.this, PlayerScore.class);
                    ArrayList<Player> myList = (ArrayList<Player>) getIntent().getSerializableExtra("list");
                    intent.putExtra("list", myList);
                    intent.putExtra("qid", qid);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(QuizActivity.this, PlayerScore.class);
                    ArrayList<Player> myList = (ArrayList<Player>) getIntent().getSerializableExtra("list");
                    intent.putExtra("list", myList);
                    startActivity(intent);
                }
            }
        });

        btnAnsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAnsw.getText().toString().equals("Answer")) {
                    txtQuestion.setText(currentQ.getAnswer());
                    btnAnsw.setText("Question");
                }
                else if(btnAnsw.getText().toString().equals("Question")) {
                    txtQuestion.setText(currentQ.getQuestion());
                    btnAnsw.setText("Answer");
                }
            }
        });

    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQuestion());
        qid++;
    }
}