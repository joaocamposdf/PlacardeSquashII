package com.example.android.placardesquashii;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.android.placardesquashii.R.string.sets;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int setTeamA = 0;
    int setTeamB = 0;
    int pointsPerSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This methods determine the number of points for each set .
     */

    public void increment(View view) {
        pointsPerSet += +1;
        displayPointsPerSet(pointsPerSet);
    }

    public void decrement(View view) {
        pointsPerSet += -1;
        displayPointsPerSet(pointsPerSet);
    }


    private void displayPointsPerSet(int number) {
        TextView setsTextView = (TextView) findViewById(R.id.points_per_set);
        setsTextView.setText("" + number);
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayScoreA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds 1 point for Team A untill the set is finished, then calls oneSetA method.
     */

    public int onePointA(View view) {
        if (scoreTeamA != pointsPerSet - 1) {
            scoreTeamA += 1;
            displayScoreA(scoreTeamA);
        } else {
            if (pointsPerSet - (scoreTeamA - scoreTeamB) == pointsPerSet) {
                pointsPerSet += 1;
                scoreTeamA += 1;
                displayScoreA(scoreTeamA);
                Toast.makeText(this, "Vai a dois!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Começando um novo set!", Toast.LENGTH_SHORT).show();
                TextView setsTextView = (TextView) findViewById(R.id.points_per_set);
                pointsPerSet = Integer.parseInt(setsTextView.getText().toString());
                return oneSetA();

            }
        }
        return scoreTeamA;
    }

    /**
     * Displays the set score for Team A.
     */
    public void displaySetA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_sets);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds 1 set for Team A.
     */
    public int oneSetA() {
        setTeamA += 1;
        displaySetA(setTeamA);
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreA(scoreTeamA);
        displayScoreB(scoreTeamB);
        return setTeamA;
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds 1 point for Team B untill the set is finished, then calls oneSetA method.
     */

    public int onePointB(View view) {
        if (scoreTeamB != pointsPerSet - 1) {
            scoreTeamB += 1;
            displayScoreB(scoreTeamB);
        } else {
            if (pointsPerSet - (scoreTeamB - scoreTeamA) == pointsPerSet) {
                pointsPerSet += 1;
                scoreTeamB += 1;
                displayScoreB(scoreTeamB);
                Toast.makeText(this, "Vai a dois!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Começando um novo set!", Toast.LENGTH_SHORT).show();
                TextView setsTextView = (TextView) findViewById(R.id.points_per_set);
                pointsPerSet = Integer.parseInt(setsTextView.getText().toString());
                return oneSetB();
            }
        }
        return scoreTeamB;
    }

    /**
     * Displays the set score for Team B.
     */
    public void displaySetB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_sets);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds 1 set for Team B.
     */
    public int oneSetB() {
        setTeamB += 1;
        displaySetB(setTeamB);
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreA(scoreTeamA);
        displayScoreB(scoreTeamB);
        return setTeamB;
    }

    /**
     * Reset points and sets to 0.
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreA(scoreTeamA);
        displayScoreB(scoreTeamB);
        setTeamA = 0;
        setTeamB = 0;
        displaySetA(setTeamA);
        displaySetB(setTeamB);
    }

}
