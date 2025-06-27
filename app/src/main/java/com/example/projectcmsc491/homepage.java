package com.example.projectcmsc491;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.amplifyframework.auth.options.AuthSignOutOptions;
import com.amplifyframework.core.Amplify;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class homepage extends AppCompatActivity implements View.OnClickListener {

    private Button logOut;


    private Button addCourse;
    private ListView courses;

    private ArrayList<String> courseIDs = new ArrayList<>();

    private SharedPreferences courseSP;
    private SharedPreferences.Editor courseSPeditor;
    public static String coursePref = "CourseAuth";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        logOut = (Button) findViewById(R.id.buttonLogOut);

        addCourse = (Button) findViewById(R.id.addCourseButton);
        courses = (ListView) findViewById(R.id.listViewClass);

        courseSP = getSharedPreferences(coursePref, MODE_PRIVATE);
        courseSPeditor = courseSP.edit();


        Map<String, ?> allCourses = courseSP.getAll();
        for(Map.Entry<String, ?> entry: allCourses.entrySet()){
            courseIDs.add(entry.getKey());
        }
        CourseAdapter adapter = new CourseAdapter(getApplicationContext(), courseIDs);
        courses.setAdapter(adapter);

        logOut.setOnClickListener(this);

        addCourse.setOnClickListener(this);
        courses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(homepage.this, class1Page.class);
                String instructor = courseSP.getString(parent.getItemAtPosition(position).toString(), "Not found.");
                String className = parent.getItemAtPosition(position).toString();
                GlobalClass.setClassName(className);
                GlobalClass.setInstructorName(instructor);
                i.putExtra("INSTRUCTOR", instructor);
                i.putExtra("CLASS", className);
                startActivity(i);

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonLogOut){
            AuthSignOutOptions options = AuthSignOutOptions.builder()
                    .globalSignOut(true)
                    .build();

            Amplify.Auth.signOut(options, signOutResult -> {});
            Intent logout = new Intent(homepage.this, MainActivity.class);
            startActivity(logout);
        }

        if(v.getId() == R.id.addCourseButton){
            Intent newCourse = new Intent(homepage.this, addingCourse.class);
            startActivity(newCourse);
        }
    }
}