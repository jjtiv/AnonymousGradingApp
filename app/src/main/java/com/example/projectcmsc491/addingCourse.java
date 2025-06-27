package com.example.projectcmsc491;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.ClassRoster;
import com.opencsv.CSVReader;



public class addingCourse extends AppCompatActivity implements View.OnClickListener {

    private Button saveBtn;
    private Button backBtn;
    private Button uploadCSV;
    private EditText className;
    private ArrayList<String> studentIDs = new ArrayList<>();

    private EditText rosterFile;

    private SharedPreferences students;
    private SharedPreferences.Editor studentEdit;
    public static String studentPref = "StudentAuth";



    private SharedPreferences courseSP;
    private SharedPreferences.Editor courseSPeditor;
    public static String coursePref = "CourseAuth";

    private SharedPreferences enrollSP;
    private SharedPreferences.Editor enrollSPedit;
    public static String enrollPref = "EnrollAuth";


    private ListView studentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_course);
        saveBtn = (Button) findViewById(R.id.buttonSave);
        backBtn = (Button) findViewById(R.id.buttonBack);
        uploadCSV = (Button) findViewById(R.id.buttonUploadRoster);
        rosterFile = (EditText) findViewById(R.id.editTextRosterFileName);
        studentList = (ListView) findViewById(R.id.editTextCSVStudents);
        className = (EditText) findViewById(R.id.editTextClassName) ;

        students = getSharedPreferences(studentPref, MODE_PRIVATE);
        studentEdit = students.edit();

        courseSP = getSharedPreferences(coursePref, MODE_PRIVATE);
        courseSPeditor = courseSP.edit();

        enrollSP = getSharedPreferences(enrollPref, MODE_PRIVATE);
        enrollSPedit = enrollSP.edit();



        saveBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
        uploadCSV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonSave){
            Intent returnHome = new Intent(addingCourse.this, homepage.class);
            startActivity(returnHome);
        }
        if(v.getId() == R.id.buttonBack){
            Intent returnHome = new Intent(addingCourse.this, homepage.class);
            startActivity(returnHome);
        }
        if(v.getId() == R.id.buttonUploadRoster){
            try{
                String temp = rosterFile.getText().toString();
                CSVReader reader = new CSVReader(new InputStreamReader(getResources().openRawResource(R.raw.sheet1)));
                String[] nextLine;
                while((nextLine = reader.readNext()) != null){
                    studentEdit.putString(nextLine[1], nextLine[0]);
                    studentEdit.commit();
                    //studentIDs.add(nextLine[1]);

                    enrollSPedit.putString(nextLine[1],className.getText().toString());
                    enrollSPedit.commit();

                    ClassRoster item = ClassRoster.builder()
                            .studentId(nextLine[1])
                            .studentName(nextLine[0])
                            .build();
                    Amplify.DataStore.save(
                            item,
                            success -> {
                                Log.i("Amplify Test", "Saved Item: "+ success.item().toString());
                                studentIDs.add(item.getStudentId());
                            },
                            error -> Log.e("Amplify Test","Error saving item.", error)
                    );




                }
                Toast.makeText(this, "File Uploaded.", Toast.LENGTH_SHORT).show();
                Amplify.DataStore.query(ClassRoster.class,
                        items -> {
                            List<String> studentIDs = new ArrayList<>();
                            while (items.hasNext()) {
                                ClassRoster item = items.next();
                                //studentIDs.add(item.getStudentId());
                                Log.i("Amplify", "Id " + item.getStudentId() + " Name " + item.getStudentName());
                            }

                        },
                        failure -> Log.e("Amplify", "Could not query DataStore", failure)
                );
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        StudentAdapter adapter = new StudentAdapter(getApplicationContext(), studentIDs);
                        studentList.setAdapter(adapter);
                    }
                }, 5000);


                //StudentAdapter adapter = new StudentAdapter(getApplicationContext(), studentIDs);
                //studentList.setAdapter(adapter);

                courseSPeditor.putString(className.getText().toString(), rosterFile.getText().toString());
                courseSPeditor.commit();




            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this, "The file is not found.", Toast.LENGTH_SHORT).show();
            }


        }
    }
}