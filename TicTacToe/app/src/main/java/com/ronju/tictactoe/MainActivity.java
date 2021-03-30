package com.ronju.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    int activePlayer = 1;
    int count=1;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {{0, 1, 2,}, {3, 4, 5}, {5, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    //game play function
    public void playerTap(View view) {

        //reset condition
        if(!gameActive)
        {
            gameReset(view);

        }

        if(count==0)
        {
            count++;
            return;
        }
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        TextView status = findViewById(R.id.playerStatus);

        if (gameState[tappedImage] == 2) {
            img.setTranslationY(-1000f);
            gameState[tappedImage] = activePlayer;
            if (activePlayer == 1) {
                img.setImageResource(R.drawable.x);
                activePlayer = 0;
                status.setText("O's turn Tap To Play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 1;
                status.setText("X's turn Tap To Play");
            }
            img.animate().translationYBy(1000f);
        }


    for(int[] winPosition :winPositions)
    {
        if(gameState[winPosition[0]]!=2 && gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[0]]==gameState[winPosition[2]])
        {
            gameActive=false;
            if(gameState[winPosition[0]]==1)
            {
                status.setText("X has Won");
            }
            else
            {
                status.setText("O has Won");
            }
        }
    }
    boolean flag=false;
    if(gameActive==true)
    {
        for(int i=0; i<gameState.length; i++)
        {
            if(gameState[i]==2)
            {
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            status.setText("Ops! it's Draw");
            gameActive=false;
        }
    }

}


//reset function
public void gameReset(View view)
{
    gameActive=true;
    activePlayer=1;
    count=0;
    for(int i=0; i<gameState.length; i++)
    {
        gameState[i]=2;
    }
    ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
    TextView status = findViewById(R.id.playerStatus);
    status.setText("X's turn Tap To Play");

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}