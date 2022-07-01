package com.metropolitan.cs330_pz_nemanjavilic4050_java.database;

import android.provider.BaseColumns;

/**
 * Created by delaroy on 11/30/17.
 */

public class QuizContract {

    public static class Entry implements BaseColumns {
        public static final String TABLE_RIDDLE = "riddle";
        public static final String TABLE_ANTARTICA = "antarticaQuiz";
        // tasks Table Columns names
        public static final String KEY_ID = "id";
        public static final String KEY_RIDDLE = "question";
        public static final String KEY_ANSWER = "answer";
    }
}
