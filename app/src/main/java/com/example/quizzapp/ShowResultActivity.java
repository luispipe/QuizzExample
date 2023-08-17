package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ShowResultActivity extends AppCompatActivity {

    TableLayout showResults;
    Button restart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        File quizz= new File(getFilesDir(),"quizz.txt");
        List<DataModel> scores= readFileQuizz(quizz);

        showResults= findViewById(R.id.TableResult);

        addDataTable(scores);


    }

    public List<DataModel> readFileQuizz(File file){
        List<DataModel> quizzList= new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader(file))){
            String data;
            while ((data= br.readLine())!=null){
                String[] answers= data.split(",");
                String asn1= answers[0];
                String asn2= answers[1];
                String asn3= answers[2];
                int score= 0;

                if (asn1.equals("true")) {
                    score += 3;
                }
                if (asn2.equals("true")) {
                    score += 3;
                }
                if (asn3.equals("true")) {
                    score += 4;
                }

                DataModel value= new DataModel(asn1,asn2,asn3,score);

                quizzList.add(value);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return quizzList;
    }

    public void addDataTable(List<DataModel> data){

        for (DataModel i: data){
            TableRow row= new TableRow(this);

            TextView cell1= new TextView(this);
            cell1.setText(i.getAnswer1());
            TextView cell2= new TextView(this);
            cell2.setText(i.getAnswer2());
            TextView cell3= new TextView(this);
            cell3.setText(i.getAnswer3());
            TextView cell4= new TextView(this);
            cell4.setText(i.getScore()+"");

            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            showResults.addView(row);

        }

    }
}

