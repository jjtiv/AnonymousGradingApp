package com.example.projectcmsc491;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewExam extends AppCompatActivity implements View.OnClickListener {

    private Button backButton;
    private TextView examName;
    private ListView studentList;
    private Button scanIn;

    private SharedPreferences students;
    private SharedPreferences.Editor studentEdit;
    public static String studentPref = "StudentAuth";

    private ArrayList<String> studentIDs = new ArrayList<>();
    public static ArrayList<String> studentGrades = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exam);
        backButton = (Button) findViewById(R.id.buttonBackViewExam);
        examName = (TextView) findViewById(R.id.textViewExamName);
        examName.setText(GlobalClass.examName);
        scanIn = (Button) findViewById(R.id.buttonScanInGrade) ;
        studentList = (ListView) findViewById(R.id.listViewStudentss);
        students = getSharedPreferences(studentPref, MODE_PRIVATE);
        studentEdit = students.edit();

        Map<String, ?> allCourses = students.getAll();
        for(Map.Entry<String, ?> entry: allCourses.entrySet()){
            studentIDs.add(entry.getKey());
        }


        if(studentGrades.isEmpty()){
            for(int i = 0; i < studentIDs.size(); i++){
                Bitmap temp = getBarCode.getBar(20, 20, students.getString(studentIDs.get(i), "Not found"));
                GlobalClass.addBarcode(temp);
                studentGrades.add("-1");
            }
        }


        StudentExamAdapter adapter = new StudentExamAdapter(getApplicationContext(), studentIDs, studentGrades);
        studentList.setAdapter(adapter);

        Intent temp = getIntent();


        for(int i = 0; i < studentIDs.size(); i++){
            if(students.getString(studentIDs.get(i), "error").equals(temp.getStringExtra("VALUE"))){
                studentGrades.set(i, "50");
                adapter.notifyDataSetChanged();
            }
        }





        backButton.setOnClickListener(this);
        scanIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == backButton.getId()){
            Intent i = new Intent(ViewExam.this, class1Page.class);
            startActivity(i);
        }
        if(v.getId() == scanIn.getId()){
            Intent i = new Intent(ViewExam.this, ScanInExam.class);
            startActivity(i);
        }
    }



}
