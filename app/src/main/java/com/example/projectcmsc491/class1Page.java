package com.example.projectcmsc491;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class class1Page extends AppCompatActivity implements View.OnClickListener {

        private Button back;
    private Button newExamBtn;

    private TextView ClassName;
    private TextView ClassInstr;
    private ListView exams;

    private SharedPreferences examSP;
    private SharedPreferences.Editor examSPeditor;
    public static String examPref = "ExamAuth";

    private ArrayList<String> examIDs = new ArrayList<>();

    private ArrayList<String> courseIDs = new ArrayList<>();



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1_page);


        newExamBtn = (Button) findViewById(R.id.buttonAddExam);

        ClassName = (TextView) findViewById(R.id.textViewOverview);
        ClassInstr = (TextView) findViewById(R.id.textViewInstructor);
        back = (Button) findViewById(R.id.buttonBackClasspage);
        Intent it = getIntent();
        //ClassName.setText("Class: " + it.getStringExtra("CLASS"));
        //ClassInstr.setText("Instructor: " + it.getStringExtra("INSTRUCTOR"));


        ClassName.setText("Class: "+GlobalClass.className);
        ClassInstr.setText("Instructor: "+GlobalClass.instructorName);


        exams = (ListView) findViewById(R.id.listViewExamList);

        examSP = getSharedPreferences(examPref, MODE_PRIVATE);
        examSPeditor = examSP.edit();


        Map<String, ?> allCourses = examSP.getAll();
        for(Map.Entry<String, ?> entry: allCourses.entrySet()){
            //examIDs.add(entry.getKey());
            Log.d("hi",entry.getKey() + GlobalClass.className);
            if(examSP.getString(entry.getKey(), "Not Found").equals(GlobalClass.className)){
                examIDs.add(entry.getKey());
            }
        }
        ExamAdapter adapter = new ExamAdapter(getApplicationContext(), examIDs);
        exams.setAdapter(adapter);

        exams.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String examName = parent.getItemAtPosition(position).toString();
                GlobalClass.setExamName(examName);
                Intent i = new Intent(class1Page.this, ViewExam.class);
                startActivity(i);
            }
        });




        newExamBtn.setOnClickListener(this);

        back.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonBackClasspage){
            Intent backInt = new Intent(class1Page.this, homepage.class);
            startActivity(backInt);
        }
                if(v.getId() == R.id.buttonAddExam){
            Intent addExamInt = new Intent(class1Page.this, addNewExamPage.class);
            Intent i = getIntent();
            String className = i.getStringExtra("CLASS");
            addExamInt.putExtra("CLASS", className);
            startActivity(addExamInt);
        }
           }

}