package com.example.user.dinosour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SixDinosour extends AppCompatActivity {
    private Button one,two,three,four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_dinosour);
        Intent intent = getIntent();
        one = (Button)findViewById(R.id.triceratops_button6);
        two = (Button)findViewById(R.id.carnotaurus_button6);
        three = (Button)findViewById(R.id.apatosaurus_button6);
        four = (Button)findViewById(R.id.dimorphodon_button6);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SixDinosour.this,SevenDinosour.class);
                Bundle bundle = getIntent().getExtras();
                double score = bundle.getDouble("score_value");
                score = score+1;
                intent.putExtra("score_value",score);
                startActivity(intent);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SixDinosour.this,SevenDinosour.class);
                Bundle bundle = getIntent().getExtras();
                double score = bundle.getDouble("score_value");
                intent.putExtra("score_value",score);
                startActivity(intent);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SixDinosour.this,SevenDinosour.class);
                Bundle bundle = getIntent().getExtras();
                double score = bundle.getDouble("score_value");
                intent.putExtra("score_value",score);
                startActivity(intent);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SixDinosour.this,SevenDinosour.class);
                Bundle bundle = getIntent().getExtras();
                double score = bundle.getDouble("score_value");
                intent.putExtra("score_value",score);
                startActivity(intent);
            }
        });
    }
}
