package com.example.user.dinosour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button nPlay,nHigh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nPlay = (Button)findViewById(R.id.play_botton);
        nHigh = (Button)findViewById(R.id.HighScore_botton);

        nPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double score = 0;
                Intent intent = new Intent(MainActivity.this,OneDinosour.class);
                intent.putExtra("score_value",score);
                startActivity(intent);
            }
        });
        nHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToHighScore = new Intent(MainActivity.this, TwelveDinosour.class);
                startActivity(intentToHighScore);
            }
        });
    }
}
