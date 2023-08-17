package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class QuestionThreeActivity extends AppCompatActivity {
    RadioButton opt1,opt2,opt3,opt4;
    Button save;

    boolean result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        opt1= findViewById(R.id.radioButtonQ3Opt1);
        opt2= findViewById(R.id.radioButtonQ3Opt2);
        opt3= findViewById(R.id.radioButtonQ3Opt3);
        opt4= findViewById(R.id.radioButtonQ3Opt4);

        save= findViewById(R.id.buttonQuestionThree);

        Intent score= new Intent(getApplicationContext(), ShowResultActivity.class);

        boolean optOne= opt1.isChecked();
        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optOne){
                    opt1.setChecked(false);
                    Toast.makeText(getApplicationContext(),"radio",Toast.LENGTH_LONG).show();
                }else{
                    opt2.setChecked(false);
                    opt3.setChecked(false);
                    opt4.setChecked(false);
                }
            }
        });

        boolean optTwo= opt2.isChecked();
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optTwo){
                    opt2.setChecked(false);
                }else{
                    opt1.setChecked(false);
                    opt3.setChecked(false);
                    opt4.setChecked(false);
                }
            }
        });

        boolean optThree= opt3.isChecked();

        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optThree){
                    opt3.setChecked(false);
                }else{
                    opt2.setChecked(false);
                    opt1.setChecked(false);
                    opt4.setChecked(false);
                }
            }
        });

        boolean optFour= opt4.isChecked();

        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optFour){
                    opt4.setChecked(false);
                }else{
                    opt2.setChecked(false);
                    opt3.setChecked(false);
                    opt1.setChecked(false);
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result=opt3.isChecked();
                File file= new File(getFilesDir(),"quizz.txt");
                try {
                    FileWriter writer= new FileWriter(file,true);
                    BufferedWriter bufferedWriter= new BufferedWriter(writer);
                    bufferedWriter.write(","+result);
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                    startActivity(score);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }
}