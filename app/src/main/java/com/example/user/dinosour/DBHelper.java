package com.example.user.dinosour;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "high.score";
    private static final int DATABASE_VERSION = 102;
    public static final String TABLE_NAME_HARD = "score";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_SCORE = "score";
    private static final String CREATE_TABLE_HARD = "CREATE TABLE " + TABLE_NAME_HARD + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT, "
            + COL_SCORE + " INTEGER)";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HARD);
        insertInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_HARD);
        onCreate(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "PETER");
        cv.put(COL_SCORE, 1);
        db.insert(TABLE_NAME_HARD, null, cv);
        cv = new ContentValues();
        cv.put(COL_NAME, "CHESTER");
        cv.put(COL_SCORE, 1);
        db.insert(TABLE_NAME_HARD, null, cv);
        cv = new ContentValues();
        cv.put(COL_NAME, "GRILL");
        cv.put(COL_SCORE, 1);
        db.insert(TABLE_NAME_HARD, null, cv);
        cv = new ContentValues();
        cv.put(COL_NAME, "CRYSTAL");
        cv.put(COL_SCORE, 2);
        db.insert(TABLE_NAME_HARD, null, cv);
        cv = new ContentValues();
        cv.put(COL_NAME, "DELL");
        cv.put(COL_SCORE, 2);
        db.insert(TABLE_NAME_HARD, null, cv);
  }

}
