package com.example.registrationpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.security.PrivateKey;


public class Contactus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        ImageView salla_link=(ImageView) findViewById(R.id.imageView);
        salla_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://salla.sa/masarah.box";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        ImageView email_link=(ImageView) findViewById(R.id.imageView2);
        email_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email=new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL,"masarah.box@gmail.com");
                email.putExtra(Intent.EXTRA_SUBJECT,"Title");
                email.putExtra(Intent.EXTRA_TEXT,"message subject");
                startActivity(email);

            }
        });

        ImageView insta_link=(ImageView) findViewById(R.id.imageView3);
        insta_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://instagram.com/masarah.box?igshid=MzRlODBiNWFlZA==";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        ImageView snap_link=(ImageView) findViewById(R.id.imageView4);
        snap_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://t.snapchat.com/zWQ7bBhG";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        ImageView tik_link=(ImageView) findViewById(R.id.imageView5);
        tik_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="https://www.tiktok.com/@masarah.box?_t=8cTmMnSDM3t&_r=1";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
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
                Intent intent = new Intent(Contactus.this,SecondActivity.class);
                startActivity(intent);

                return true;
            }
            case R.id.menu_AboutUs: {
                Intent intent = new Intent(Contactus.this, AboutUs.class);
                startActivity(intent);
                return true;
            }
            case R.id.menu_Logout: {
                Intent intent = new Intent(Contactus.this, LoginPage.class);
                startActivity(intent);
                return true;
            }
            default:
                return false;
        }
    }
}
