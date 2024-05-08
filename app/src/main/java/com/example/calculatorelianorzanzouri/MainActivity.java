package com.example.calculatorelianorzanzouri;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Spinner spinner;
    String userChoice;
    EditText number1, number2;
    Button button;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id
        result = findViewById(R.id.Result);//result
        number1 = findViewById(R.id.num1);//n1
        number2 = findViewById(R.id.num2);//n2
        button = findViewById(R.id.buttonCalculate);//button
        //operator
        spinner = findViewById(R.id.spinnerOperator);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.array_Operator,
                        android.R.layout.simple_spinner_item
                );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userChoice=(String) parent.getItemAtPosition(position);
                //Toast.makeText(context,userChoice,Toast.LENGTH_SHORT).show();
                //Log.d(TAG,"Correct");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.d(TAG,"Empty");
            }
        });

        //onClick
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                int num1=Integer.parseInt(number1.getText()+"");
                int num2=Integer.parseInt(number2.getText()+"");
                int res;

                switch (userChoice) {
                    case "+":
                        res=num1+num2;
                        result.setText(res+"");
                        break;
                    case "-":
                        res=num1-num2;
                        result.setText(res+"");
                        break;
                    case "x":
                        res=num1*num2;
                        result.setText(res+"");
                        break;
                    case "/":
                        if(num2==0){
                            result.setText("ERROR");
                            break;
                        }
                        res=num1/num2;
                        result.setText(res+"");
                        break;
                    case "^":
                        res= (int) Math.pow(num1,num2);
                        result.setText(res+"");
                        break;
                }}
                catch(Exception e){
                    Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
                    result.setText("0");
                }
            }
        });

    }
}
