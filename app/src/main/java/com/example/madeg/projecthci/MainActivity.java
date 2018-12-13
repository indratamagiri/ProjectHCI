package com.example.madeg.projecthci;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    String emailUser, passwordUser;
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
                emailUser = email.getText().toString();
                passwordUser = password.getText().toString();

                if (!emailUser.isEmpty() && !passwordUser.isEmpty()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", emailUser);
                    editor.commit();

                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(), "Email and Password must be input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
