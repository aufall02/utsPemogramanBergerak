package com.aufal.utspemogramanbergerak;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {


    EditText _a,_b,_c;
    TextView re_x1, re_x2;

    Button btn_hitung;

    double determinan, a,b,c;


    public int convertToInteger(EditText a){
       return Integer.parseInt(a.getText().toString());
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        _a = findViewById(R.id.in_a);
        _b = findViewById(R.id.in_b);
        _c = findViewById(R.id.in_c);
        re_x1 = findViewById(R.id.re_x1);
        re_x2 = findViewById(R.id.re_x2);
        btn_hitung = findViewById(R.id.btn_hitung);


        a = convertToInteger(_a);
        b = convertToInteger(_b);
        c = convertToInteger(_c);

        btn_hitung.setOnClickListener(view -> {

            determinan = Math.pow(b,2)-4*a*c;
            if(determinan==0){
                re_x1.setText(String.valueOf((-b / 2) * a));
                re_x2.setText(String.valueOf((-b / 2) * a));
            }else if (determinan>0) {
                double x1,x2;

//              hasil x1
                x1=(-b+Math.sqrt(determinan))/(2*a);
                re_x1.setText(String.valueOf(x1));

//              hasil x2
                x2=(-b-Math.sqrt(determinan))/(2*a);
                re_x2.setText(String.valueOf(x2));
            }
            else{
                re_x1.setText("imajiner");
                re_x2.setText("imajiner");
            }
        });

    }
}