package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView1);

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Igra.class);
                i.putExtra("gameId", 1);
                startActivity(i);
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Igra.class);
                i.putExtra("gameId", 2);
                startActivity(i);
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView3);

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Igra.class);
                i.putExtra("gameId", 3);
                startActivity(i);
            }
        });


    }

    public void sendMail(View view) {

        String[] to =
                {"nemanja.vilic@gmail.com"};
        String[] cc = {"indijo542@gmail.com"};
        createEmail(to, cc, "DZ08 Mejl", "Download this cool new game");
    }

    public void createEmail(String[] emailAddresses, String[] carbonCopies,
                            String subject, String message) {

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        String[] to = emailAddresses;
        String[] cc = carbonCopies;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }
}