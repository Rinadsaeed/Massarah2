package com.example.registrationpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import model.Products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import adapter.ProductAdapter;
import model.Products;

public class SecondActivity extends AppCompatActivity {
    RecyclerView  prodItemRecycler;
    ProductAdapter productAdapter;
    TextView TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TV = findViewById(R.id.textView5);
        Intent i = getIntent();
        String name = i.getStringExtra("user_name");
        TV.setText(name);

            List<Products> productsList = new ArrayList<>();
            productsList.add(new Products(1, "Car pendant or medallion in the form of a cute bird", "66.00 SAR", R.drawable.p4));
            productsList.add(new Products(2, "A doll made with love", "204.00 SAR", R.drawable.p1));
            productsList.add(new Products(1, "Car pendant or medallion in the form of a cute bird", "66.00 SAR", R.drawable.p4));
            productsList.add(new Products(2, "A doll made with love", "204.00 SAR", R.drawable.p1));
            productsList.add(new Products(1, "Car pendant or medallion in the form of a cute bird", "66.00 SAR", R.drawable.p4));
            productsList.add(new Products(2, "A doll made with love", "204.00 SAR", R.drawable.p1));

            setProdItemRecycler(productsList);

        }

        private void setProdItemRecycler(List<Products> productsList){

            prodItemRecycler = findViewById(R.id.product_recycler);
            RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
            prodItemRecycler.setLayoutManager(layoutManager);
            productAdapter = new ProductAdapter(this, productsList);
            prodItemRecycler.setAdapter(productAdapter);

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
                Intent intent = new Intent(SecondActivity.this,SecondActivity.class);
                startActivity(intent);

                return true;
            }
            case R.id.menu_AboutUs: {
                Intent intent = new Intent(SecondActivity.this, AboutUs.class);
                startActivity(intent);
                return true;
            }
            case R.id.menu_Logout: {
                Intent intent = new Intent(SecondActivity.this, LoginPage.class);
                startActivity(intent);
                return true;
            }
            default:
                return false;
        }
    }

    }



