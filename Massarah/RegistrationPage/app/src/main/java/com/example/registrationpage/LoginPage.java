package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;



public class LoginPage extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    TextView signText;
    //private UserDOA userDOA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
        signText = findViewById(R.id.SignText);
        signText.setOnClickListener(new View.OnClickListener() {

                                        public void onClick(View v) {
                                            Intent intent = new Intent(LoginPage.this, MainActivity.class);
                                            startActivity(intent);
                                        }
                                    }


        );
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (usernameEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill the login form", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if the user exists in the database
                    DatabaseHelper databaseHelper = new DatabaseHelper(LoginPage.this);
                    boolean userExists = databaseHelper.checkUserExistsByUsername(usernameEditText.getText().toString());

                    if (userExists) {
                        // Validate login
                        boolean loginSuccess = databaseHelper.loginUserByUsername(
                                usernameEditText.getText().toString(),
                                passwordEditText.getText().toString()
                        );

                        if (loginSuccess) {
                            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginPage.this, SecondActivity.class);
                            intent.putExtra("user_name",usernameEditText.getText().toString());
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Incorrect username or password", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "User does not exist", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



}
}



