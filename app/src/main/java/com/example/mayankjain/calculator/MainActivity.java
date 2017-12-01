package com.example.mayankjain.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.ListIterator;

import static android.R.attr.button;
import static android.R.attr.process;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {
    private String display="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   public void onClick(View v) {
       Button button=(Button)v;
       display+=(String)button.getText();
       displayText(display);
   }

   public void displayText(String s) {
       TextView textView=(TextView)findViewById(R.id.screen);
       textView.setText(s);
   }

   public void onclickSpecial(View v) {
       Button button=(Button)v;
       char ch=display.charAt(display.length());

       if(ch=='+'||ch=='-'||ch=='/'||ch=='*')
       display+=((String)button.getText()+"(");

       else
           display+=("*"+(String)button.getText()+"(");
       displayText(display);
   }

   public void onclickPi(View v) {
       display+="(22/7)";
       displayText(display);
   }

   public void onclickBack(View v) {
       display=display.substring(0,display.length()-1);
       displayText(display);
   }

   public void onclickClear(View v){
       display="";
       displayText(display);

   }

   public void onClickEqual(View v)
   {
       displayText(""+calculation());
   }
    public int calculation(){
        ArrayList<Integer> numbers=new ArrayList<>();
        ArrayList<Character> operators=new ArrayList<>();

       // numbers=getNumbers();
        operators=getOperators();

        return numbers.get(0);
    }

   /* private ArrayList<Integer> getNumbers()
    {ArrayList<Integer> numbers=new ArrayList<>();
        int min=0,max=0;
        char[] ch=new char[display.length()];
        ch=display.toCharArray();
        for(int i=0;i< display.length();++i)
        {
            if (ch[i] == '/' || ch[i] == '-' || ch[i] == '+' || ch[i] == '-') {

            }
        }

        return numbers;
    }*/
    private ArrayList<Character> getOperators()
    {
        ArrayList<Character> operators=new ArrayList<>();
        char ch;
        for(int i=0;i<display.length();++i) {
            ch = display.charAt(display.length());

            if (ch == '+' || ch == '-' || ch == '/' || ch == '*')
                operators.add(ch);
        }
        return operators;
    }
}

