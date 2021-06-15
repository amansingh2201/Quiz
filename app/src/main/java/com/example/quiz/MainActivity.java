package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {
private String n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nameText=(EditText)findViewById(R.id.name);
        n=nameText.getText().toString();
        Button srt=(Button)findViewById(R.id.start);
        Button abt=(Button)findViewById(R.id.about);


        srt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, questions.class);
                    startActivity(intent);
            }
        });

        abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,developer.class);
                startActivity(intent);
            }
        });
    }





}
