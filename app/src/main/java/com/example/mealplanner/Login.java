package com.example.mealplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class Login extends AppCompatActivity {

    EditText email,password;

    private String stringUrl="https://eatup-mealplanner.000webhostapp.com/phpfiles/login.php";
    private RequestQueue requestQueue;
    private static final String TAG=SignUp.class.getSimpleName();
    int success;
    private String TAG_SUCCESS="success";
    private String TAG_MESSAGE="message";
    private String tag_json_obj="json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=(EditText)findViewById(R.id.uniqueid_et);
        password=(EditText)findViewById(R.id.password_et);

        TextView logtosigntext=(TextView)findViewById(R.id.logtosignintxt);
        TextView forgetpassword=(TextView)findViewById(R.id.forgetpassword);
        Button loginbtn=(Button)findViewById(R.id.login_btn);
        requestQueue= Volley.newRequestQueue(getApplicationContext());

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ForgetpasswordIntent=new Intent(Login.this,ForgetPassword.class);
                startActivity(ForgetpasswordIntent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            checkdata();


            }
        });

        logtosigntext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logtosigninintent=new Intent(Login.this,SignUp.class);
                startActivity(logtosigninintent);
            }
        });
    }

    private void checkdata(){

        StringRequest request=new StringRequest(Request.Method.POST, stringUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    success = jsonObject.getInt(TAG_SUCCESS);
                    if (success == 1)
                    {
                        Toasty.success(getApplicationContext(), jsonObject.getString(TAG_MESSAGE), Toast.LENGTH_SHORT).show();
                        Intent logtomain=new Intent(Login.this,Usersmain.class);
                        startActivity(logtomain);
                        finish();
                    }
                    else
                    {
                        Toasty.error(getApplicationContext(), jsonObject.getString(TAG_MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
                {
                    Toasty.error(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toasty.error(getApplicationContext(),error.getMessage().toString(),Toast.LENGTH_LONG).show();

            }
        }){
            public Map<String, String> getParams()
            {

                Map<String, String> params = new HashMap<String, String>();
                params.put("email",email.getText().toString().trim());
                params.put("password",password.getText().toString().trim());
                return params;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(10000,1,1.0f));
        requestQueue.add(request);

    }
}