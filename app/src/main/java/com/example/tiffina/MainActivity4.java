package com.example.tiffina;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView6 = findViewById(R.id.textView6);

        Intent intent = getIntent();
        String body = intent.getStringExtra("body");
        textView6.setText("Status: " + body);
        if (body.equals("{\"status\":true}")) {
            Toast.makeText(this, "Booking Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Booking failed", Toast.LENGTH_SHORT).show();
        }

    }
}