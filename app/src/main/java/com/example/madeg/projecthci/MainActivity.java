package com.example.madeg.projecthci;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    String emailUser, passwordUser;
    AlertDialog.Builder alertBuilder;
    String mes ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailUser = email.getText().toString().trim();
                passwordUser = password.getText().toString().trim();
                mes = "";
                if (!emailUser.isEmpty() && !passwordUser.isEmpty()) {
                    if (emailUser.length() > 6) {
                        SharedPreferences sharedPreferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", emailUser);
                        editor.commit();

                        Intent i = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(i);
                    }else {
                        mes = "Username must more that 6";
                    }
                }else {
                    mes = "Username and Password must be field";
                }
                if (!mes.equals("")){
                    alertBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertBuilder.setMessage(mes);
                    alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertBuilder.show();
                }
            }
        });


    }
}
