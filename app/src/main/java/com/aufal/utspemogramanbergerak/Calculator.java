package com.aufal.utspemogramanbergerak;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
    EditText _a,_b,_c;
    TextView re_x1, re_x2;
    Button btn_hitung;
    double determinant, a,b,c;


    public int  convertToInteger(EditText a){
        int result;
        result = Integer.parseInt(a.getText().toString());
        return result;
    }


    // Determinan = B2-4AC,
    public double countDeterminant(double a, double b, double c){
      return  Math.pow(b, 2) - 4 * a * c;
    }

//    D=0 maka x1 = x2 = - B/2A
    public void rootOfEquationsIfDet0(TextView x1, TextView x2,double b, double a){
        x1.setText(String.valueOf((-b / 2) * a));
        x2.setText(String.valueOf((-b / 2) * a));
    }

    public void rootOfEquationsIfDetbigger0(TextView x1, TextView x2,double b, double a){
        x1.setText(String.valueOf((-b+Math.sqrt(determinant))/(2*a)));
        x2.setText(String.valueOf((-b-Math.sqrt(determinant))/(2*a)));
    }
    public void rootOfEquationsIfDetsmaller0(TextView x1, TextView x2){
        x1.setText("Imajiner");
        x2.setText("Imajiner");
    }

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

//hitung
        btn_hitung.setOnClickListener(view -> {
//           convert edit text to integer
                a = convertToInteger(_a);
                b = convertToInteger(_b);
                c = convertToInteger(_c);

//              find determinan
                determinant = countDeterminant(a,b,c);
                Toast.makeText(this,"Determinan : "+determinant,Toast.LENGTH_LONG).show();

//              find root of equations
                if(determinant == 0){
                    rootOfEquationsIfDet0(re_x1,re_x2,b,a);
                }else if (determinant > 0) {
                    rootOfEquationsIfDetbigger0(re_x1,re_x2,b,a);
                }else{
                    rootOfEquationsIfDetsmaller0(re_x1,re_x2);
                }
        });

    }

}