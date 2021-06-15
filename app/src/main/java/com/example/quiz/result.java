package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.nio.Buffer;

public class result extends AppCompatActivity {
TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv1=(TextView)findViewById(R.id.correct_ans);
        tv2=(TextView)findViewById(R.id.wrong_ans);
        tv3=(TextView)findViewById(R.id.final_score);

        StringBuffer sb=new StringBuffer();
        sb.append("Correct Answers:"+questions.correct+"\n");
        StringBuffer sb1=new StringBuffer();
        sb1.append("Wrong Answers:"+questions.wrong+"\n");
        StringBuffer sb2=new StringBuffer();
        sb2.append("Final Score:"+questions.correct+"\n");

        tv1.setText(sb);
        tv2.setText(sb1);
        tv3.setText(sb2);

        questions.correct=0;
        questions.wrong=0;
    }
}
