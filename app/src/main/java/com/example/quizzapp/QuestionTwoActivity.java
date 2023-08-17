package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class QuestionTwoActivity extends AppCompatActivity {

    CheckBox opt1,opt2,opt3,opt4;
    boolean result;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);
        opt1= findViewById(R.id.checkBoxQ2Opt1);
        opt2=findViewById(R.id.checkBoxQ2Opt2);
        opt3= findViewById(R.id.checkBoxQ2Opt3);
        opt4= findViewById(R.id.checkBoxQ2Opt4);

        save= findViewById(R.id.buttonQuestionTwo);

        Intent question3= new Intent(getApplicationContext(), QuestionThreeActivity.class);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt1.isChecked() && opt2.isChecked() && !opt3.isChecked() &&
                        opt4.isChecked()){
                    result=true;
                    Toast.makeText(getApplicationContext(),"Respuesta Correcta",Toast.LENGTH_LONG).show();
                }else{
                    result=false;
                    Toast.makeText(getApplicationContext(),"Respuesta Incorrecta",Toast.LENGTH_LONG).show();
                }
                File file= new File(getFilesDir(),"quizz.txt");
                try {
                    FileWriter writer= new FileWriter(file,true);
                    BufferedWriter bufferedWriter= new BufferedWriter(writer);
                    bufferedWriter.write(","+result);
                    bufferedWriter.close();
                    startActivity(question3);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}