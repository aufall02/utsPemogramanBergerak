package com.aufal.utspemogramanbergerak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nama, nim, textArea;
    Button btn_save, btn_gas;

    Boolean isLogin = false;


    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.in_nama);
        nim = findViewById(R.id.in_Nim);
        textArea = findViewById(R.id.re_textArea);
        btn_save   = findViewById(R.id.btn_simpan);
        btn_gas = findViewById(R.id.btn_gas);


        btn_save.setOnClickListener(view -> {
           if (!(isEmpty(nama) || isEmpty(nim))){
               textArea.setText(
                       "\"Selamat Datang "+  nama.getText().toString() +"\nApakah Kamu siap Untuk \nMenghancurkan Dunia !!!\""
               );
               nama.getText().clear();
               nim.getText().clear();

               isLogin = true;
           }else {
               Toast.makeText(this,"masukkan data anda",Toast.LENGTH_SHORT).show();
           }

        });

       btn_gas.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              try {
                  if (!isLogin){
                      Toast.makeText(getBaseContext(), "Masukkan Nama Dan Nim Anda", Toast.LENGTH_LONG).show();
                  }else{
                      System.out.println("test");
                      Intent intent = new Intent(MainActivity.this, Calculator.class);
                      startActivity(intent);
                  }
              }catch (Exception err){
                  System.out.println(err);
              }
           }
       });

    }
}