package com.example.dhanraj.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int hisActivePlayer = 0;
    // 0 is for cross & 1 is for circle
    // my GAME state
    int myGameState[] = {2,2,2,2,2,2,2,2,2,2};

    public void imgTapped(View view){
        ImageView myTapped = (ImageView) view;
        //Log.i("tag","Tagged number is " + myTapped.getTag().toString());
        int tTapped = Integer.parseInt(myTapped.getTag().toString());
        if(myGameState[tTapped] == 2)
        {
            myGameState[tTapped] =hisActivePlayer;

            if(hisActivePlayer == 0){
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(180).setDuration(1000);
                hisActivePlayer = 1;
            }else{
                myTapped.setImageResource(R.drawable.circle);
                //myTapped.animate().setDuration(1000);
                hisActivePlayer = 0;
            }

        }else{
            Toast toast=Toast.makeText(getApplicationContext(),"Place already filled",Toast.LENGTH_SHORT);
            toast.setMargin(80,80);
            toast.show();
        }
           }

    public void reset(View view){
        for(int i = 0;i< myGameState.length;i++){
            myGameState[i] = 2;
        }

        //game state to 2 to reset
        hisActivePlayer = 0;
        //changing img to X/O
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.line1);
        for(int i=0; i < linearLayout.getChildCount(); i++){
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayoutone = (LinearLayout)findViewById(R.id.line2);
        for(int i=0; i < linearLayoutone.getChildCount(); i++){
            ((ImageView) linearLayoutone.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayouttwo = (LinearLayout)findViewById(R.id.line3);
        for(int i=0; i < linearLayouttwo.getChildCount(); i++){
            ((ImageView) linearLayouttwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
