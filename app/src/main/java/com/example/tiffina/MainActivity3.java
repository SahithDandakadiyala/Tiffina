package com.example.tiffina;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity3 extends AppCompatActivity {
    EditText editText, editText2;
    TextView textV, textV2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textV = findViewById(R.id.textView3);
        textV2 = findViewById(R.id.textView4);
        editText = findViewById(R.id.editTextmobile);
        editText2 = findViewById(R.id.editTextNumberPassword);
        btn = findViewById(R.id.button2);


        String logintext = "LOGIN\nEnter Your Mobile Number";
        String passtext = "PASSWORD\nEnter Your Password";

        SpannableString lt = new SpannableString(logintext);
        lt.setSpan(new StyleSpan(Typeface.BOLD), 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        lt.setSpan(new RelativeSizeSpan(1.5f), 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        lt.setSpan(new StyleSpan(Typeface.ITALIC), 6, logintext.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        SpannableString lt2 = new SpannableString(passtext);
        lt2.setSpan(new StyleSpan(Typeface.BOLD), 0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        lt2.setSpan(new RelativeSizeSpan(1.5f), 0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        lt2.setSpan(new StyleSpan(Typeface.ITALIC), 9, passtext.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textV.setText(lt);
        textV2.setText(lt2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {

                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        try {

                            OkHttpClient client = new OkHttpClient().newBuilder()
                                    .build();
                            MediaType.parse("text/plain");
                            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                                    .addFormDataPart("mobile", editText.getText().toString())
                                    .addFormDataPart("password", editText2.getText().toString())
                                    .build();
                            Request request = new Request.Builder()
                                    .url("https://mekvahan.com/api/android_intern_task")
                                    .method("POST", body)
                                    .build();

                            Response response = client.newCall(request).execute();
                            Log.i("Done", String.valueOf(response));
                            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                            intent.putExtra("body", Objects.requireNonNull(response.body()).string());
                            startActivity(intent);

                            Log.i("Status", Objects.requireNonNull(response.body()).string());


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();


            }
        });


    }

}