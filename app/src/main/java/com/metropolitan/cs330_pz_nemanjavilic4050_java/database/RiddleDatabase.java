package com.metropolitan.cs330_pz_nemanjavilic4050_java.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.metropolitan.cs330_pz_nemanjavilic4050_java.R;
import com.metropolitan.cs330_pz_nemanjavilic4050_java.entity.Riddle;

import static com.metropolitan.cs330_pz_nemanjavilic4050_java.database.QuizContract.Entry.KEY_ANSWER;
import static com.metropolitan.cs330_pz_nemanjavilic4050_java.database.QuizContract.Entry.KEY_ID;
import static com.metropolitan.cs330_pz_nemanjavilic4050_java.database.QuizContract.Entry.KEY_RIDDLE;
import static com.metropolitan.cs330_pz_nemanjavilic4050_java.database.QuizContract.Entry.TABLE_RIDDLE;
import static com.metropolitan.cs330_pz_nemanjavilic4050_java.database.QuizContract.Entry.TABLE_ANTARTICA;

import java.util.ArrayList;
import java.util.List;

public class RiddleDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "riddleQuiz";

    private SQLiteDatabase dbase;

    public RiddleDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        dbase = sqLiteDatabase;
        String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_RIDDLE + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_RIDDLE
                + " TEXT, " + KEY_ANSWER+ " TEXT)";
        dbase.execSQL(sql1);

        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_ANTARTICA + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_RIDDLE
                + " TEXT, " + KEY_ANSWER+ " TEXT)";
        dbase.execSQL(sql2);

        addRiddles();
        addAntarticaQuestions();
    }

    private void addRiddles() {

        Riddle r1 = new Riddle("You are a girl and you're at your aunts' funeral and you are mourning and then you see, right next to you, a really handsome man" +
                "that you fall in love with instantly." +
                "The man is wearing all black and he has a black hair." +
                "The next night, you kill your sister," +
                "now, why did you kill her?", "So you can see him again at her funeral. A normal person says:" +
                "\"Oh, um, because that girl might be dating that handsome man\"\n" +
                "Or \"That handsome man might like the girl.\"" +
                "But the psychopath will say" +
                "\"I will kill the girl so that there'll be another funeral to see that man\"");
        this.addRiddle(r1);
        Riddle r2 = new Riddle("You're living in an apartment." +
                "You are on the 5th floor and you are just..." +
                "You're tired but you decide to look out the window." +
                "And... When you looked out the window, you witnessed a man being murdered by another man," +
                "but then that man saw you, too " +
                "and then instantly that man pointed a finger at you," +
                " and moved that finger" +
                "Up and down, up and down a couple of times." +
                "Now, what did that mean?", "The psychopath is actually counting the floors");
        this.addRiddle(r2);
        Riddle r3 = new Riddle("One night, a man goes out because he is thirsty and has to drink some water. " +
                "After he finishes drinking water, he looks to the right and he sees a robber. " +
                "Now, this man runs away and goes and hides in the closet. " +
                "Now, if you were the robber that saw this, " +
                "and you had a knife in your hand, " +
                "what would you do?", "So, normal person would say: " +
                "they would open the closet and kill them or they would just run away. " +
                "But a psychopath will say they will wait quietly or pretend to walk away, until the man comes out");
        this.addRiddle(r3);
        Riddle r4 = new Riddle("Close your eyes and imagine this. You're in this forest and it's super dark, all right? " +
                "And you're walking through the forest and you feel something's behing your back." +
                "And so you turn around as fast as you can," +
                "what do you see?\n" +
                "One: " +
                "The opposite sex\n" +
                "Two: " +
                "Nothing\n" +
                "Three: " +
                "A ghost\n" +
                "Four: " +
                "A wild animal\n" +
                "Five: " +
                "A dog", "The answer is: " +
                "A dog");
        this.addRiddle(r4);
        Riddle r5 = new Riddle("So this murderer decides to stab another man." +
                "And he stabbed him five times." +
                "And after stabbing him five times, he left the elevator." +
                "Since this elevator had windows everywhere, you can actually see inside the elevator." +
                "And this murderer just kept on watching the elevator," +
                "why?", "He did not flee the scene because it would've been awkward to find anyone walking away " +
                "from that kind of horrid scene");
        this.addRiddle(r5);
    }

    private void addAntarticaQuestions() {

        Riddle r1 = new Riddle("So while you set out to go embark on a journey in Antarctica there's an essential item that you absolutely need is it, " +
                "A:sunglasses, B: lotion, C: vitamin C, or D: Flowers?\n", "The answer is, sunglasses. You need sunglasses because of snow blindness! Basically\n" +
                "D: What happens is when the Sun reflects off the snow it constantly hits your eyes?\n" +
                "And you're more likely to lose vision and perhaps go blind");
        this.addAntQuestion(r1);
        Riddle r2 = new Riddle("So let's say you've been stuck there for a while now and the ice in which the ship was stuck on starts to creep into the ship. The captain says \"Abandon ship!\" now, would you say? A: \"Okay? Let's get the fudge out of here\" \nB:" +
                "\"No, we gotta gear up\" or C: \"No if we leave the ship\n" +
                "we're dead.\"", "So what the crew did is they actually left the ship and only a day after they left half to ship completely submerged into the ice.");
        this.addAntQuestion(r2);
        Riddle r3 = new Riddle("So you guys venture out in this freezing Tundra snow blizzards coming in every step is a torture as the captain?\n" +
                "You know times are getting desperate. You know food is becoming short. You are the captain and everybody's been trusting you until this point\n" +
                "but you yourself know that things are getting really really desperate\n" +
                "So what do you do?\n" +
                "A: do you tell your crew? How dire the situation is? or B: do you continue to keep it to yourself?", "So the captain decided to not tell anybody that he was desperate because he knew that the crew was desperate as well and the only\n" +
                "hope they had was the captain and if the captain lost hope then they would lose hope too.");
        this.addAntQuestion(r3);
        Riddle r4 = new Riddle("You venture out and you find land, it's a miracle one of the men says that he recognizes the land\n" +
                "and he knows where to get help.\n" +
                "He also says that it'd be best if we went alone with two other people because it'd be the fastest and then without a moment's\n" +
                "hesitation he leaves.\n" +
                "Now there is this\n" +
                "frustrating glimmer of hope you are forced to wait in one spot as long as you possibly can that glimmer of hope\n" +
                "can make men do crazy things and staying in this one spot is seemingly one of them. What would you do, how long would you wait? You know these people for 8 months now", "If you waited for a month, you got rescued" +
                "From that kind of horrid scene");
        this.addAntQuestion(r4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS riddle");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS antarticaQuiz");
        onCreate(sqLiteDatabase);
    }

    private void addRiddle(Riddle r) {
        ContentValues values = new ContentValues();
        values.put(KEY_RIDDLE, r.getQuestion());
        values.put(KEY_ANSWER, r.getAnswer());

        dbase.insert(TABLE_RIDDLE, null, values);
    }

    private void addAntQuestion(Riddle r) {
        ContentValues values = new ContentValues();
        values.put(KEY_RIDDLE, r.getQuestion());
        values.put(KEY_ANSWER, r.getAnswer());

        dbase.insert(TABLE_ANTARTICA, null, values);
    }


    public List<Riddle> getAllRiddles() {
        List<Riddle> quesList = new ArrayList<Riddle>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RIDDLE;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Riddle quest = new Riddle();
                quest.setId(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public List<Riddle> getAllAntarticaQuestions() {
        List<Riddle> quesList = new ArrayList<Riddle>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ANTARTICA;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Riddle quest = new Riddle();
                quest.setId(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_RIDDLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}