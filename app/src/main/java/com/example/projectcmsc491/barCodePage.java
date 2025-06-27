package com.example.projectcmsc491;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class barCodePage extends AppCompatActivity implements View.OnClickListener{

    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_page);
        backBtn = (Button) findViewById(R.id.buttonBack);

        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent backInt = new Intent(barCodePage.this, class1Page.class);
        startActivity(backInt);
    }
}