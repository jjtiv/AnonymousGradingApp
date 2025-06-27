package com.example.projectcmsc491;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class addNewExamPage extends AppCompatActivity implements View.OnClickListener{
    private Button saveBtn;
    private EditText examName;

    private SharedPreferences examSP;
    private SharedPreferences.Editor examSPeditor;
    public static String examPref = "ExamAuth";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_exam_page);
        saveBtn = (Button) findViewById(R.id.buttonSave);
        examName = (EditText) findViewById(R.id.editTextEnterExamName);


        examSP = getSharedPreferences(examPref, MODE_PRIVATE);
        examSPeditor = examSP.edit();

        saveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonSave){
            examSPeditor.putString(examName.getText().toString(), GlobalClass.className);
            examSPeditor.commit();
            Intent help = new Intent(addNewExamPage.this, class1Page.class);
            startActivity(help);
        }
    }
}