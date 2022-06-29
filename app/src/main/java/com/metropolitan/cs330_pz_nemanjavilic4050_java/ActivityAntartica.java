package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.metropolitan.cs330_pz_nemanjavilic4050_java.database.RiddleDatabase;
import com.metropolitan.cs330_pz_nemanjavilic4050_java.entity.Riddle;

import java.util.List;

public class ActivityAntartica extends AppCompatActivity {

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
        quesList=db.getAllAntarticaQuestions();

        int tmp = getIntent().getIntExtra("qid", 0);
        qid = tmp;

        int gameId = getIntent().getIntExtra("gameId", 1);

        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textViewRiddle);

        btnNext =(Button)findViewById(R.id.buttonNextAn);
        btnNext.setText("Next");
        btnAnsw =(Button)findViewById(R.id.buttonOdgovor);
        setQuestionView();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qid<4){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{
                    Intent intent = new Intent(ActivityAntartica.this, ActivityWinner.class);

                    intent.putExtra("gameId", gameId);
                    intent.putExtra("qid", qid);
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