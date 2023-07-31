package com.example.alphabetcalculaornew;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


//inheriting the interface directly instead of creating object each time
public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{


//    declaring the views with variables
    TextView textResult;
    ImageView buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine,buttonDivide;
    ImageView buttonMultiply,buttonAdd,buttonSubtract,buttonResult,buttonClear,buttonZero,buttonDot;

    //to check the used operator type
    private int opr = 0;
    private String firstHalf="0";
    double res=0f;
    Database value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //calling the method initialize the variables with the views
        init();

        buttonsClickedNew(); //this is for the new implementation.
        value=Database.getDB(this);
        textResult.setText(value.valuesDAO().getValue());
    }

//    method initialize the variables with the views
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
        buttonClear=findViewById(R.id.button_clear);
        buttonDivide=findViewById(R.id.button_divide);
        buttonSubtract=findViewById(R.id.button_subtract);
        buttonMultiply=findViewById(R.id.button_multiply);
        buttonAdd=findViewById(R.id.button_add);
        buttonResult=findViewById(R.id.button_equals);


    }

//    ================================LISTENERS==============================================

    //method to set up the click listeners on buttons
    private void buttonsClickedNew(){
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonZero.setOnClickListener(this);
        buttonZero.setOnLongClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonResult.setOnClickListener(this);
    }

//    method to listen the click
    @Override
    public void onClick(View view) {
        //FOR INPUT BUTTONS
        if(view==buttonOne){
            String getInput=textResult.getText().toString();
            if(getInput.equals("0")) textResult.setText("1");
            else textResult.setText(getInput+1);
        }else if (view==buttonTwo){
            String getInput=textResult.getText().toString();
            if(getInput.equals("0")) textResult.setText("2");
            else textResult.setText(getInput+2);
        }else if (view==buttonThree){
            String getInput=textResult.getText().toString();
            if(getInput.equals("0")) textResult.setText("3");
            else textResult.setText(getInput+3);
        }else if (view==buttonFour){
            String getInput=textResult.getText().toString();
            if(getInput.equals("0")) textResult.setText("4");
            else textResult.setText(getInput+4);
        }else if (view==buttonFive){
            String getInput=textResult.getText().toString();
            if(getInput.equals("0")) textResult.setText("5");
            else textResult.setText(getInput+5);
        }else if (view==buttonSix){
            String getInput=textResult.getText().toString();
            if(getInput.equals("0")) textResult.setText("6");
            else textResult.setText(getInput+6);
        }else if (view==buttonSeven){
            String getInput=textResult.getText().toString();
            if(getInput.equals("0")) textResult.setText("7");
            else textResult.setText(getInput+7);
        }else if (view==buttonEight){
            String getInput=textResult.getText().toString();
            if(getInput.equals("0")) textResult.setText("8");
            else textResult.setText(getInput+8);
        }else if (view==buttonNine){
            String getInput=textResult.getText().toString();
            if(getInput.equals("0")) textResult.setText("9");
            else textResult.setText(getInput+9);
        }else if (view==buttonZero){
            String getInput=textResult.getText().toString();
            if(!getInput.equals("0")) textResult.setText(getInput+"0");
        }else if (view==buttonClear){
            String getInput=textResult.getText().toString();
            if(!getInput.equals("0")) textResult.setText("0");
            value.valuesDAO().updateValue(new ValuesDB(1,"0"));
            buttonZero.setLongClickable(true);
        }
        //FOR OPERATOR BUTTONS
        if(view==buttonAdd){
            buttonAdd.setClickable(false);
            buttonZero.setLongClickable(true);
            buttonSubtract.setClickable(false);
            buttonMultiply.setClickable(false);
            buttonDivide.setClickable(false);
            opr=1;
            firstHalf=textResult.getText().toString();
            textResult.setText("");
        }
        else if(view==buttonMultiply){
            buttonAdd.setClickable(false);
            buttonSubtract.setClickable(false);
            buttonZero.setLongClickable(true);
            buttonMultiply.setClickable(false);
            buttonDivide.setClickable(false);
            opr=2;
            firstHalf=textResult.getText().toString();
            textResult.setText("");
        }
        else if(view==buttonDivide){
            buttonAdd.setClickable(false);
            buttonZero.setLongClickable(true);
            buttonSubtract.setClickable(false);
            buttonMultiply.setClickable(false);
            buttonDivide.setClickable(false);
            opr=3;
            firstHalf=textResult.getText().toString();
            textResult.setText("");

        }
        else if(view==buttonSubtract){
            buttonZero.setLongClickable(true);
            buttonAdd.setClickable(false);
            buttonSubtract.setClickable(false);
            buttonMultiply.setClickable(false);
            buttonDivide.setClickable(false);
            opr=4;
            firstHalf=textResult.getText().toString();
            textResult.setText("");
        }
        //FOR RESULT
        if(view==buttonResult){
            buttonAdd.setClickable(true);
            buttonZero.setLongClickable(true);
            buttonSubtract.setClickable(true);
            buttonMultiply.setClickable(true);
            buttonDivide.setClickable(true);
            double a=Double.parseDouble(firstHalf);
            double b=Double.parseDouble(textResult.getText().toString());
            if(opr==1){
                res=a+b;
                String resString=res+"";
                textResult.setText(resString.replace(".0",""));
                value.valuesDAO().updateValue(new ValuesDB(1,resString.replace(".0","")));
            }else if(opr==2){
                res=a*b;
                String resString=res+"";
                textResult.setText(resString.replace(".0",""));
                value.valuesDAO().updateValue(new ValuesDB(1,resString.replace(".0","")));
            }else if(opr==3){
                if(b==0) textResult.setText("Infinity");
                else{res=a/b;
                String resString=res+"";
                textResult.setText(resString.replace(".0",""));
                    value.valuesDAO().updateValue(new ValuesDB(1,resString.replace(".0","")));}
            }else if(opr==4){
                res=a-b;
                String resString=res+"";
                textResult.setText(resString.replace(".0",""));
                value.valuesDAO().updateValue(new ValuesDB(1,resString.replace(".0","")));
            }


        }

    }

//    setting up the long click listener
    @Override
    public boolean onLongClick(View view) {
        if(view==buttonZero){
            String getInput=textResult.getText().toString();
            if(getInput.isEmpty()) textResult.setText("0.");
            else{textResult.setText(getInput+".");
            buttonZero.setLongClickable(false);}
        }
        return true;
    }


}