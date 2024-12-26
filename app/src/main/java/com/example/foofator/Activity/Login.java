package com.example.foofator.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foofator.R;

public class Login extends AppCompatActivity {
    EditText email,password;
    ImageButton open;
    TextView sign_up;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        open=findViewById(R.id.open);
        sign_up=findViewById(R.id.sign_up);
        DB=new DBHelper(this);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,SignUp.class));
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=email.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(Login.this, "Please Entre All The Fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true)
                    {
                        Toast.makeText(Login.this, "Sign In Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this,IntroActivity.class));
                    }
                    else {
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}