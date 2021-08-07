package com.example.mealplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        final EditText mailornumber=(EditText)findViewById(R.id.forgetpasswordedittext);
        Button submit=(Button)findViewById(R.id.submitbtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mailornumber.getText().toString().equals("sahilchudasama471@gmail.com")){
                    Toasty.success(getApplicationContext(),"We have sent your Account Password in mail.", Toast.LENGTH_LONG).show();
                }
                else if(mailornumber.getText().toString().equals("7016878751")){
                    Toasty.success(getApplicationContext(),"We have sent your Account Password in Text Message.", Toast.LENGTH_LONG).show();
                }
                else{
                    Toasty.error(getApplicationContext(),"Please Enter Correct mail id or the correct mobile numer which you linked with your account.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}