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

public class AboutUs extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUs.this, Contactus.class);
                startActivity(intent);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menue1,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_Homepage: {
                Intent intent = new Intent(AboutUs.this,SecondActivity.class);
                startActivity(intent);

                return true;
            }
            case R.id.menu_AboutUs: {
                Intent intent = new Intent(AboutUs.this, AboutUs.class);
                startActivity(intent);
                return true;
            }
            case R.id.menu_Logout: {
                Intent intent = new Intent(AboutUs.this, LoginPage.class);
                startActivity(intent);
                return true;
            }
            default:
                return false;
        }
    }
}