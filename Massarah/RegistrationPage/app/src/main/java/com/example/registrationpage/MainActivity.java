package com.example.registrationpage;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import adapter.ProductAdapter;
import model.Products;

public class MainActivity extends AppCompatActivity {
    TextView signTextt;
    EditText Username;
    EditText Phone;
    EditText Password;
    Button btn_signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signTextt = findViewById(R.id.loginB);
        Username = findViewById(R.id.username);
        Phone = findViewById(R.id.phone);
        Password = findViewById(R.id.password);
        btn_signUp = findViewById(R.id.signupbtn);

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Username.getText().toString().isEmpty() || Password.getText().toString().isEmpty()  || Phone.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill the sign-up form", Toast.LENGTH_SHORT).show();
                } else {
                    // Insert user data into the database
                    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                    boolean success = databaseHelper.insertUser(
                            Username.getText().toString(),
                            Password.getText().toString(),
                            Phone.getText().toString()
                    );
                    if (success) {
                        Toast.makeText(getApplicationContext(), "User registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error occurred while registering user", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signTextt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
                                         }
                                     }

        );


    }
}
