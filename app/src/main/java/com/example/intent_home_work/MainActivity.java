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
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to = findViewById(R.id.edit_to);
        subject = findViewById(R.id.edit_subject);
        message = findViewById(R.id.edit_message);
        send = findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("mailto:" + to.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
                startActivity(intent);
            }
        });
    }
}