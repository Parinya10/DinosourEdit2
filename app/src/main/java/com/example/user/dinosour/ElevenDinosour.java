package com.example.user.dinosour;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.user.dinosour.DBHelper.COL_NAME;
import static com.example.user.dinosour.DBHelper.COL_SCORE;


public class ElevenDinosour extends AppCompatActivity {
    private String name;
    private DBHelper mHelper;
    private SQLiteDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new DBHelper(this);
        mDb = mHelper.getReadableDatabase();
        setContentView(R.layout.activity_eleven_dinosour);
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        final double score = bundle.getDouble("score_value");
        final EditText editText = (EditText)findViewById(R.id.name_EditText);
        TextView yourscore = (TextView)findViewById(R.id.score_textView);
        Button okbutton = (Button)findViewById(R.id.ok_button);
        yourscore.setText("Score : "+ score);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = String.valueOf(editText.getText().toString());
                if (name.length() == 0) {
                    editText.setError("ป้อนชื่อ");
                } else if(name.length()>=8){
                    editText.setError("ความยาวชื่อต้องน้อยกว่า 8 ตัวอักษร");
                }else{
                    ContentValues cv = new ContentValues();
                    cv.put(COL_NAME, name);
                    cv.put(COL_SCORE, score);
                    mDb.insert(DBHelper.TABLE_NAME_HARD,null,cv);
                    Intent intentToHighScore = new Intent(ElevenDinosour.this, TwelveDinosour.class);
                    startActivity(intentToHighScore);
                }
            }
        });
    }
}
