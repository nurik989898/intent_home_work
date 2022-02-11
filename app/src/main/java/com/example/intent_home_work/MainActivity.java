package com.example.intent_home_work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText to,subject,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to = findViewById(R.id.edit_to);
        subject = findViewById(R.id.edit_subject);
        message = findViewById(R.id.edit_message);
        Button send = findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail();
            }
        });
    }
    private void mail(){
        String list = to.getText().toString();
        String[] re = list.split(",");
        String su = subject.getText().toString();
        String me = message.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,re);
        intent.putExtra(Intent.EXTRA_SUBJECT,su);
        intent.putExtra(Intent.EXTRA_TEXT,me);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose email client:"));
    }
}