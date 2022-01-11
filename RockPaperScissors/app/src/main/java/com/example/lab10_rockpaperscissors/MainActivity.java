package com.example.lab10_rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRock, btnPaper, btnScissors;
    TextView txtHumanChoice, txtComputerChoice, txtWinner;
    TextView txtComputerScore, txtHumanScore, txtTie;

    enum Choice {ROCK, PAPER, SCISSORS} // capitalized to know it's a constant, meaning it has one number and never changed.
    enum Winner {HUMAN, COMPUTER, TIE}

    int ComputerScore = 0, HumanScore = 0, Tie = 0;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRock = findViewById(R.id.btnRock);
        btnPaper = findViewById(R.id.btnPaper);
        btnScissors = findViewById(R.id.btnScissors);

        txtHumanChoice = findViewById(R.id.txtHumanChoice);
        txtComputerChoice = findViewById(R.id.txtComputerChoice);
        txtWinner = findViewById(R.id.txtWinner);

        txtHumanScore = findViewById(R.id.txtHumanScore);
        txtComputerScore = findViewById(R.id.txtComputerScore);
        txtTie = findViewById(R.id.txtTie);

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyMsg", "Rock button pressed.");
                PlayGame(Choice.ROCK);
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyMsg", "Paper button pressed.");
                PlayGame(Choice.PAPER);
            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyMsg", "Scissors button pressed.");
                PlayGame(Choice.SCISSORS);
            }
        });
    }

    void PlayGame(Choice humanChoise){
        Log.d("MyMsg", "Play game. Human chose " + humanChoise);
        // Log.d("MyMsg", "Human chose value = " + humanChoise.ordinal());

        Choice computerChoise;

        Winner gameResult = Winner.TIE; // Has to be set to something

        String stringHumanChoise = "";
        String stringComputerChoice = "";
        String stringWinner = "";

        int number = random.nextInt(3); // 0-2, it never hits the upper bound
        Log.d("MyMsg", "Computer chose " + number);

        computerChoise = Choice.values()[number];
        Log.d("MyMsg", "Computer chose " + computerChoise);

        /*
        if(humanChoise == Choice.ROCK) stringComputerChoice = "rock";
        if(humanChoise == Choice.PAPER) stringComputerChoice = "paper";
        if(humanChoise == Choice.SCISSORS) stringComputerChoice = "scissors";
         */

        switch (humanChoise) { // switch need to evaluate to an integer or a character
            case ROCK: stringHumanChoise = "Rock"; break;
            case PAPER: stringHumanChoise = "Paper"; break;
            case SCISSORS: stringHumanChoise = "Scissors"; break;
            default: stringHumanChoise = "Error in humanChoice switch"; // should never arrive here
        }

        switch (computerChoise) {
            case ROCK: stringComputerChoice = "Rock"; break;
            case PAPER: stringComputerChoice = "Paper"; break;
            case SCISSORS: stringComputerChoice = "Scissors"; break;
            default: stringComputerChoice = "Error in computerChoice switch"; // should never arrive here
        }

        // Selections that result in human winning. //simplify this and erase this comments
        if(humanChoise == computerChoise) gameResult = Winner.TIE;

        if(humanChoise == Choice.ROCK && computerChoise == Choice.PAPER) gameResult = Winner.COMPUTER;
        if(humanChoise == Choice.ROCK && computerChoise == Choice.SCISSORS) gameResult = Winner.HUMAN;

        if(humanChoise == Choice.PAPER && computerChoise == Choice.SCISSORS) gameResult = Winner.COMPUTER;
        if(humanChoise == Choice.PAPER && computerChoise == Choice.ROCK) gameResult = Winner.HUMAN;

        if(humanChoise == Choice.SCISSORS && computerChoise == Choice.ROCK) gameResult = Winner.COMPUTER;
        if(humanChoise == Choice.SCISSORS && computerChoise == Choice.PAPER) gameResult = Winner.HUMAN;

        switch (gameResult) {
            case TIE:
                Tie++;
                stringWinner = "Tie game.";
                txtWinner.setTextColor(Color.parseColor("#808080"));
                break;
            case HUMAN:
                HumanScore++;
                stringWinner = "You win!!";
                txtWinner.setTextColor(Color.parseColor("#FF2196F3"));
                break;
            case COMPUTER:
                ComputerScore++;
                stringWinner = "Computer wins.";
                txtWinner.setTextColor(Color.parseColor("#E91E63"));
                break;
            default: stringWinner = "Error in gameResult switch";
        }

        txtHumanChoice.setText("You Chose " + stringHumanChoise);
        txtComputerChoice.setText("Computer chose " + stringComputerChoice);
        txtWinner.setText(stringWinner);
        txtHumanScore.setText("Your Score\n" + HumanScore);
        txtComputerScore.setText("Computer Score\n" + ComputerScore);
        txtTie.setText("Ties\n" + Tie);
    }
}
