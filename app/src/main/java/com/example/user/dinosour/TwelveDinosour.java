package com.example.user.dinosour;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.user.dinosour.DBHelper.COL_ID;
import static com.example.user.dinosour.DBHelper.COL_NAME;
import static com.example.user.dinosour.DBHelper.COL_SCORE;

public class TwelveDinosour extends AppCompatActivity {
    private DBHelper mHelper;
    private SQLiteDatabase mDb;
    private HighScoreListAdapter mAdapter;
    private ArrayList<DbScore> mHighScoreItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelve_dinosour);
        getSupportActionBar().setTitle("High Score");
        mHelper = new DBHelper(this);
        mDb = mHelper.getReadableDatabase();
        final Button buttonBack = (Button)findViewById(R.id.back_button);
        Cursor cursor = mDb.query(DBHelper.TABLE_NAME_HARD,null,null,null,null,null,COL_SCORE+ " DESC");
        int  i = 1;
        while (cursor.moveToNext()) {
            if(i>10) break;
            int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
            int score = cursor.getInt(cursor.getColumnIndex(COL_SCORE));
            DbScore item = new DbScore(id,  i+". "+name, score);
            mHighScoreItemList.add(item);
            i++;
        }
        mAdapter = new HighScoreListAdapter(
                this,
                R.layout.activity_item,
                mHighScoreItemList
        );
        ListView lv = (ListView) findViewById(R.id.list_score);
        lv.setAdapter(mAdapter);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwelveDinosour.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
