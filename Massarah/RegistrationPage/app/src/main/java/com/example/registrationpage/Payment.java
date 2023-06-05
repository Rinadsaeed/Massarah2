package com.example.registrationpage;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

import java.util.Calendar;


public class Payment extends AppCompatActivity {
    private EditText cardNumberEditText;
    private EditText expiryDateEditText;
    private EditText cvvEditText;
    Button payButton;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        cardNumberEditText = findViewById(R.id.cardNumberEditText);
        expiryDateEditText = findViewById(R.id.expiryDateEditText);
        cvvEditText = findViewById(R.id.cvvEditText);
        payButton = findViewById(R.id.payButton);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values
                String cardNumber = cardNumberEditText.getText().toString().trim();
                String expiryDate = expiryDateEditText.getText().toString().trim();
                String cvv = cvvEditText.getText().toString().trim();

                if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()) {
                    Toast.makeText(Payment.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    dialog = new Dialog(Payment.this);
                    dialog.setContentView(R.layout.custom_dialog);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
                    }
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.setCancelable(false); //Optional
                    dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                    Button Okay = dialog.findViewById(R.id.btn_okay);


                    Okay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Payment.this, SecondActivity.class);
                            startActivity(intent);
                        }
                    });



                    payButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            dialog.show(); // Showing the dialog here
                        }
                    });


                }
            }

        });
        expiryDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        Payment.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our edit text.
                                expiryDateEditText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
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
                Intent intent = new Intent(Payment.this,SecondActivity.class);
                startActivity(intent);

                return true;
            }
            case R.id.menu_AboutUs: {
                Intent intent = new Intent(Payment.this, AboutUs.class);
                startActivity(intent);
                return true;
            }
            case R.id.menu_Logout: {
                Intent intent = new Intent(Payment.this, LoginPage.class);
                startActivity(intent);
                return true;
            }
            default:
                return false;
        }
    }
}


