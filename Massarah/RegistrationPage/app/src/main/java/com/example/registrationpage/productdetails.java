package com.example.registrationpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class productdetails extends AppCompatActivity {
    ImageView imageView;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);
        imageView = findViewById(R.id.imageView);
        button2 = findViewById(R.id.button2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(productdetails.this, SecondActivity.class);
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(productdetails.this, Payment.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menue1,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_Homepage: {
                Intent intent = new Intent(productdetails.this,SecondActivity.class);
                startActivity(intent);

                return true;
            }
            case R.id.menu_AboutUs: {
                Intent intent = new Intent(productdetails.this, AboutUs.class);
                startActivity(intent);
                return true;
            }
            case R.id.menu_Logout: {
                Intent intent = new Intent(productdetails.this, LoginPage.class);
                startActivity(intent);
                             return true;
            }
            default:
                return false;
        }
    }
}


