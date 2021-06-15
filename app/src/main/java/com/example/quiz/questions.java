package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class questions extends AppCompatActivity {

    TextView que;
    Button nextbtn,quitbtn;
    RadioGroup options;
    RadioButton op1,op2,op3,op4;

    String questions[] = {
            "Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
            "Which of the following package stores all the standard java classes?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to which of these?"
    };
    String answers[] = {"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};
    String opt[] = {
            "finalize method","main method","static method","private method",
            "&","&=","|=","<=",
            "import","this","catch","abstract",
            "Interface","interface","intf","Intf",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned",
            "lang","java","util","java.packages",
            "equals()","Equals()","isequal()","Isequal()",
            "int","long","byte","float"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        final TextView score = (TextView)findViewById(R.id.n_score);
        nextbtn=(Button)findViewById(R.id.nextQuestion);
        quitbtn=(Button)findViewById(R.id.quit);
        que=(TextView)findViewById(R.id.question);

        options=(RadioGroup)findViewById(R.id.radio_grp);
        op1=(RadioButton)findViewById(R.id.opt_a);
        op2=(RadioButton)findViewById(R.id.opt_b);
        op3=(RadioButton)findViewById(R.id.opt_c);
        op4=(RadioButton)findViewById(R.id.opt_d);
        que.setText(questions[flag]);
        op1.setText(opt[0]);
        op2.setText(opt[1]);
        op3.setText(opt[2]);
        op4.setText(opt[3]);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(options.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Please select one option", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton g_ans=(RadioButton)findViewById(options.getCheckedRadioButtonId());
                String ans= g_ans.getText().toString();

                if(ans.equals(answers[flag])){
                    correct++;
                    Toast.makeText(questions.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    wrong++;
                    Toast.makeText(questions.this, "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if(score!=null)
                    score.setText(""+correct);

                if(flag<questions.length){
                    que.setText(questions[flag]);
                    op1.setText(opt[flag*4]);
                    op2.setText(opt[flag*4+1]);
                    op3.setText(opt[flag*4+2]);
                    op4.setText(opt[flag*4+3]);
                }
                else{
                    marks=correct;
                    Intent intent=new Intent(questions.this,result.class);
                    startActivity(intent);
                }
                options.clearCheck();
            }
        });

        quitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(questions.this,result.class);
                startActivity(intent);
            }
        });
    }
}
