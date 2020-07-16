package com.example.tiffina;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {

    Button button, button1, btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        btn = findViewById(R.id.button3);

        String buttontext = " GETTING STARTED\nAvail Best Offers&Discounts Only For You";
        SpannableString spannableString = new SpannableString(buttontext);
        spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(1.3f), 0, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.ITALIC), 17, buttontext.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        String button3text = "Already a Tiffina Member?LOGIN";
        SpannableString spannableString1 = new SpannableString(button3text);
        spannableString1.setSpan(new RelativeSizeSpan(1.2f), 25, button3text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD), 25, button3text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString1.setSpan(new ForegroundColorSpan(Color.rgb(255, 165, 0)), 25, button3text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        button.setTransformationMethod(null);
        button1.setTransformationMethod(null);
        btn.setTransformationMethod(null);
        button.setText(spannableString);
        button1.setText("Continue Without Login");
        btn.setText(spannableString1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });


    }
}