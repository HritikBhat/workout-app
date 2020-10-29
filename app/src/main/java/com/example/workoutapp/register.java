package com.example.workoutapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.navigation.NavigationView;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class register extends AppCompatActivity {
    MaterialEditText name,email,password,mobile;

    Button registerbtn;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mobile = findViewById(R.id.mobile);
        registerbtn=(Button) findViewById(R.id.register_main);
        radioGroup=findViewById(R.id.radiogp);



        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String txt_name = name.getText().toString();
                final String txt_email = email.getText().toString();
                final String txt_password = password.getText().toString();
                final String txt_mobile = mobile.getText().toString();
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selected_gender = radioGroup.findViewById(checkedId);
                if (selected_gender == null){
                    Toast.makeText(register.this, "Select gender please", Toast.LENGTH_SHORT).show();
                }
                else {
                    final String gender = selected_gender.getText().toString();
                    if(TextUtils.isEmpty(txt_name) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) ||
                            TextUtils.isEmpty(txt_mobile)){
                        Toast.makeText(register.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        register(txt_name,txt_email,txt_password,txt_mobile,gender);
                    }
                }


            }
        });



    }



    private void register(final String name, final String email, final String password, final String mobile, final String gender){
        final ProgressDialog progressDialog = new ProgressDialog(register.this);
        progressDialog.setTitle("Registering your account");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        String uRl = "http://10.0.2.2/register/usertbregister.php";
        StringRequest request = new StringRequest(Request.Method.POST, uRl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("You are registered successfully")){
                    Toast.makeText(register.this, response, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(register.this,home.class));
                    progressDialog.dismiss();
                    finish();
                }else {
                    Toast.makeText(register.this, response, Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(register.this, error.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<>();
                param.put("name",name);
                param.put("email",email);
                param.put("password",password);
                param.put("mobile",mobile);
                param.put("gender",gender);
                return param;

            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(register.this).addToRequestQueue(request);

    }


    public void register_main(View view) {

    }



}



