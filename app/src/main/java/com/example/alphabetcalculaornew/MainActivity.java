package com.example.alphabetcalculaornew;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textResult;
    ImageView buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine,buttonDivide;
    ImageView buttonMultiply,buttonAdd,buttonSubtract,buttonResult,buttonClear,buttonZero,buttonDot;
    private int opr = 0;
    private String firstHalf="0";
    Database database;
    double res=0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonsClicked();
        database=new Database(MainActivity.this);
        textResult.setText("0");
    }

    private void buttonsClicked() {
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                String gettingInput= textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    textResult.setText(gettingInput+1);
                }else{
                    textResult.setText("1");
                }
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettingInput= textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    textResult.setText(gettingInput+2);
                }else{
                    textResult.setText("2");
                }
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettingInput= textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    textResult.setText(gettingInput+3);
                }else{
                    textResult.setText("3");
                }
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettingInput= textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    textResult.setText(gettingInput+4);
                }else{
                    textResult.setText("4");
                }
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettingInput= textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    textResult.setText(gettingInput+5);
                }else{
                    textResult.setText("5");
                }
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettingInput= textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    textResult.setText(gettingInput+6);
                }else{
                    textResult.setText("6");
                }
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettingInput= textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    textResult.setText(gettingInput+7);
                }else{
                    textResult.setText("7");
                }
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettingInput= textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    textResult.setText(gettingInput+8);
                }else{
                    textResult.setText("8");
                }
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettingInput= textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    textResult.setText(gettingInput+9);
                }else{
                    textResult.setText("9");
                }
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettingInput=textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    textResult.setText(gettingInput+0);
                }
            }
        });
        buttonZero.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String gettingInput= textResult.getText().toString();
                if(!gettingInput.contains(".")){
                    textResult.setText(gettingInput+".");
                }else if(gettingInput.equals("")){
                    textResult.setText("0.");
                }
                return true;
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettingInput=textResult.getText().toString();
                if(!gettingInput.equals("0")){
                    buttonAdd.setClickable(true);
                    buttonSubtract.setClickable(true);
                    buttonMultiply.setClickable(true);
                    buttonDivide.setClickable(true);
                    textResult.setText("0");
                }
            }
        });
        //==============================OPERATOR BUTTONS==========================
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
//                buttonAdd.setColorFilter(R.color.on_clicked);
//                buttonAdd.setBackgroundColor(R.color.on_clicked);
                buttonAdd.setClickable(false);
                buttonSubtract.setClickable(false);
                buttonMultiply.setClickable(false);
                buttonDivide.setClickable(false);
                opr=1;
                firstHalf=textResult.getText().toString();
                textResult.setText("");
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                buttonMultiply.setColorFilter(R.color.on_clicked);
                buttonAdd.setClickable(false);
                buttonSubtract.setClickable(false);
                buttonMultiply.setClickable(false);
                buttonDivide.setClickable(false);
                opr=2;
                firstHalf=textResult.getText().toString();
                textResult.setText("");
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAdd.setClickable(false);
                buttonSubtract.setClickable(false);
                buttonMultiply.setClickable(false);
                buttonDivide.setClickable(false);
//                buttonDivide.setColorFilter(R.color.on_clicked);
                opr=3;
                firstHalf=textResult.getText().toString();
                textResult.setText("");
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAdd.setClickable(false);
                buttonSubtract.setClickable(false);
                buttonMultiply.setClickable(false);
                buttonDivide.setClickable(false);
//                buttonSubtract.setColorFilter(R.color.on_clicked);
                opr=4;
                firstHalf=textResult.getText().toString();
                textResult.setText("");
            }
        });
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAdd.setClickable(true);
                buttonSubtract.setClickable(true);
                buttonMultiply.setClickable(true);
                buttonDivide.setClickable(true);
                double a=Double.parseDouble(firstHalf);
                double b=Double.parseDouble(textResult.getText().toString());
                if(opr==1){
                   res=a+b;
                   String resString=res+"";
                   textResult.setText(resString.replace(".0",""));
                }else if(opr==2){
                    res=a*b;
                    String resString=res+"";
                    textResult.setText(resString.replace(".0",""));
                }else if(opr==3){
                    res=a/b;
                    String resString=res+"";
                    textResult.setText(resString.replace(".0",""));
                }else if(opr==4){
                    res=a-b;
                    String resString=res+"";
                    textResult.setText(resString.replace(".0",""));
                }
            }
        });
//        database.updateValues(1,""+res);
    }

//    @Override
//    protected void onDestroy() {
//        database.updateValues(1,""+res);
//        super.onDestroy();
//    }

    private void init(){
        textResult=findViewById(R.id.text_result);
        buttonOne=findViewById(R.id.button_one);
        buttonTwo=findViewById(R.id.button_two);
        buttonThree=findViewById(R.id.button_three);
        buttonFour=findViewById(R.id.button_four);
        buttonFive=findViewById(R.id.button_five);
        buttonSix=findViewById(R.id.button_six);
        buttonSeven=findViewById(R.id.button_seven);
        buttonEight=findViewById(R.id.button_eight);
        buttonNine=findViewById(R.id.button_nine);
        buttonZero=findViewById(R.id.button_zero);
//        buttonDot=findViewById(R.id.button_dot);
        buttonClear=findViewById(R.id.button_clear);
        buttonDivide=findViewById(R.id.button_divide);
        buttonSubtract=findViewById(R.id.button_subtract);
        buttonMultiply=findViewById(R.id.button_multiply);
        buttonAdd=findViewById(R.id.button_add);
        buttonResult=findViewById(R.id.button_equals);




    }
}