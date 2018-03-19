package com.example.basto.quizee;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView scoretextview;
    Button truebutton;
    Button falsebutton;
    ProgressBar progressBar;
    TextView questionstextview;

    int index=0;

    int score=0;
    int count=0;
    int totalscore=20;

    final int PROGRESS_BAR_INCREMENT=1;


    private TrueFalse[] questionbank= new TrueFalse[] {
            new TrueFalse(R.string.question1, false), //1
            new TrueFalse(R.string.question2,false),  //2
            new TrueFalse(R.string.question3,true),  //3
            new TrueFalse(R.string.question4,false), //4
            new TrueFalse(R.string.question5,false),  //5
            new TrueFalse(R.string.question6,true),   //6
            new TrueFalse(R.string.question7,true),   //7
            new TrueFalse(R.string.question8,false),  //8
            new TrueFalse(R.string.question9,true),   //9
            new TrueFalse(R.string.question10,true),//10
            new TrueFalse(R.string.question11,false),  //11
            new TrueFalse(R.string.question12,true),   //12
            new TrueFalse(R.string.question13,false),   //13
            new TrueFalse(R.string.question14,true),   //14
            new TrueFalse(R.string.question15,false),   //15
            new TrueFalse(R.string.question16,true),    //16
            new TrueFalse(R.string.question17,true),   //17
            new TrueFalse(R.string.question18,false),  //18
            new TrueFalse(R.string.question19,true),   //19
            new TrueFalse(R.string.question20,false),   //20
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoretextview= findViewById(R.id.scoretextview2);
        truebutton=findViewById(R.id.btntrue);
        falsebutton=findViewById(R.id.btnfalse);
        progressBar=findViewById(R.id.progressBar2);
        questionstextview=findViewById(R.id.questionTextView);



        //choose question

        updateQuestion(index);

        progressBar.setMax(19);


        truebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkrightorwrong(true);
                updateQuestion(index);

            }
        });

        falsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkrightorwrong(false);
                updateQuestion(index);

            }
        });

    }

    private void updateQuestion(int randomnumber){


        final int questionid= questionbank[randomnumber].getQuestionid();
        questionstextview.setText(questionid);


    }
    private void checkrightorwrong(boolean userSelection){
        boolean correctAns= questionbank[index].isTrueanswer();
        count++;
        progressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);


        if(userSelection==correctAns){
            Toast.makeText(this,"Yeah you're right!",Toast.LENGTH_SHORT).show();
            score++;

            scoretextview.setText(score+"/"+totalscore);
        }else{
            Toast.makeText(this,"Noo, you're wrong!",Toast.LENGTH_SHORT).show();
            scoretextview.setText(score+"/"+totalscore);
        }
        index++;

        if(count>=19){
            alertDialog();}

    }

    public void alertDialog(){
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setTitle("Your Score");
        alertDialogBuilder.setMessage("Your score is: "+ score).setCancelable(false).setPositiveButton("Quit",
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });
        alertDialogBuilder.show();
    }
}