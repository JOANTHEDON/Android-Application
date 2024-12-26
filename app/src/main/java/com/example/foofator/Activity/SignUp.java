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

public class SignUp extends AppCompatActivity {
    EditText username,email1,password,repassword;
    ImageButton open;
    TextView back;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username=findViewById(R.id.user);
        email1=findViewById(R.id.email);
        password=findViewById(R.id.password);
        repassword =findViewById(R.id.repassword);
        open=findViewById(R.id.open);
        back=findViewById(R.id.login);
        DB=new DBHelper(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,Login.class));
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String email=email1.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if(user.equals("") || email.equals("") || pass.equals("")||repass.equals(""))
                {
                    Toast.makeText(SignUp.this, "Please Fill All The Content", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pass.equals(repass)){
                        Boolean checkuser=DB.checkusername(user);
                        if(checkuser==false){
                            Boolean checkemail=DB.checkemail(email);
                            if(checkemail==false){
                                Boolean insert = DB.insertData(user,email,pass);
                                if(insert==true){
                                    Toast.makeText(SignUp.this, "Regitered Successfully ", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SignUp.this,Login.class));
                                }else{
                                    Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(SignUp.this, "User Already Exits 'Please Sign in", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(SignUp.this, "User Already Exits 'Please Sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(SignUp.this, "Password not Matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this,Login.class));
            }
        });
    }
}