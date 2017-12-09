package com.example.user.dinosour;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 9/12/2560.
 */

public class HighScoreListAdapter extends ArrayAdapter<DbScore> {
    private Context mContext;
    private int mLayoutResId;
    private ArrayList<DbScore> mHighscoreList;
    public HighScoreListAdapter(Context mContext, int mLayoutResId, ArrayList<DbScore> mHighscoreList) {
        super(mContext,mLayoutResId,mHighscoreList);
        this.mContext = mContext;
        this.mLayoutResId = mLayoutResId;
        this.mHighscoreList = mHighscoreList;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        DbScore item = mHighscoreList.get(position);

        TextView playerName = (TextView) itemLayout.findViewById(R.id.textViewName);
        TextView playerScore = (TextView) itemLayout.findViewById(R.id.textViewScore);

        playerName.setText(item.name);
        playerScore.setText(String.valueOf(item.score));
        if(position == 0){
            playerName.setTextColor(Color.parseColor("#FFC125"));
            playerScore.setTextColor(Color.parseColor("#FFC125"));
            playerName.setTypeface(Typeface.DEFAULT_BOLD);
            playerScore.setTypeface(Typeface.DEFAULT_BOLD);
            playerName.setTextSize(20);
            playerScore.setTextSize(20);
        }


        return itemLayout;
    }
}
